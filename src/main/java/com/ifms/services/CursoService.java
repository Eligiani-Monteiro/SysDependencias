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
import com.ifms.dto.CursoDTO;
import com.ifms.entities.Aluno;
import com.ifms.entities.Curso;
import com.ifms.repositories.CursoRepository;
import com.ifms.services.exceptions.DataBaseException;
import com.ifms.services.exceptions.ResourceNotFoundException;

@Service
public class CursoService {
	@Autowired
	private CursoRepository repository;

	@Transactional(readOnly = true)
	public Page<CursoDTO> findAllPaged(PageRequest pageRequest) {
		Page<Curso> list = repository.findAll(pageRequest);
		return list.map(x -> new CursoDTO(x));
	}

	@Transactional(readOnly = true)
	public CursoDTO findById(Long id) {
		Optional<Curso> obj = repository.findById(id);
		Curso entity = obj.orElseThrow(() -> new ResourceNotFoundException("A entidade consultada não foi localizada"));
		return new CursoDTO(entity);
	}
	@Transactional
	public CursoDTO insert(CursoDTO dto) {
		Curso entity = new Curso();
		entity.setNomeCurso(dto.getNomeCurso());
		entity.setTurno(dto.getTurno());
		entity = repository.save(entity);
		return new CursoDTO(entity);
	}

	@Transactional
	public CursoDTO update(Long id, CursoDTO dto) {
		try {
			Curso entity = repository.getById(id);
			entity.setNomeCurso(dto.getNomeCurso());
			entity.setTurno(dto.getTurno());
			entity = repository.save(entity);
			return new CursoDTO(entity);
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
