package com.ifms.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ifms.dto.AlunoDTO;
import com.ifms.entities.Aluno;
import com.ifms.repositories.AlunoRepository;
import com.ifms.services.exceptions.DataBaseException;
import com.ifms.services.exceptions.ResourceNotFoundException;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;

	@Transactional(readOnly = true)
	public Page<AlunoDTO> findAllPaged(PageRequest pageRequest) {
		Page<Aluno> list = repository.findAll(pageRequest);

		return list.map(x -> new AlunoDTO(x));
	}

	@Transactional(readOnly = true)
	public AlunoDTO findById(Long id) {
		Optional<Aluno> obj = repository.findById(id);
		Aluno entity = obj.orElseThrow(() -> new ResourceNotFoundException("A entidade consultada não foi localizada"));
		return new AlunoDTO(entity);
	}

	@Transactional
	public AlunoDTO insert(AlunoDTO dto) {
		Aluno entity = new Aluno();
		entity.setNomeAluno(dto.getNomeAluno());
		entity.setIdade(dto.getIdade());
		entity.setRaAluno(dto.getRaAluno());
		entity.setMatricula(dto.getMatricula());
		entity = repository.save(entity);
		return new AlunoDTO(entity);
	}

	@Transactional
	public AlunoDTO update(Long id, AlunoDTO dto) {
		try {
			Aluno entity = repository.getById(id);
			entity.setNomeAluno(dto.getNomeAluno());
			entity.setIdade(dto.getIdade());
			entity.setRaAluno(dto.getRaAluno());
			entity.setMatricula(dto.getMatricula());
			entity = repository.save(entity);
			return new AlunoDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("O recurso com o ID = " + id + " não foi localizado");
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("O recurso com o ID = " + id + " não foi localizado");
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Não é possível excluir o registro, pois o mesmo está em uso");
		}
	}
}
