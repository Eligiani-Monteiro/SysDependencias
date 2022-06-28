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

import com.ifms.dto.DisciplinaDTO;
import com.ifms.entities.Disciplina;
import com.ifms.repositories.DisciplinaRepository;
import com.ifms.services.exceptions.DataBaseException;
import com.ifms.services.exceptions.ResourceNotFoundException;

@Service
public class DisciplinaService {
	@Autowired
	private DisciplinaRepository repository;

	@Transactional(readOnly = true)
	public Page<DisciplinaDTO> findAllPaged(PageRequest pageRequest) {
		Page<Disciplina> list = repository.findAll(pageRequest);
		return list.map(x -> new DisciplinaDTO(x));
	}

	@Transactional(readOnly = true)
	public DisciplinaDTO findById(Long id) {
		Optional<Disciplina> obj = repository.findById(id);
		Disciplina entity = obj
				.orElseThrow(() -> new ResourceNotFoundException("A entidade consultada não foi localizada"));
		return new DisciplinaDTO(entity);
	}

	@Transactional
	public DisciplinaDTO insert(DisciplinaDTO dto) {
		Disciplina entity = new Disciplina();
		entity.setNomeDisciplina(dto.getNomeDisciplina());
		entity.setCargaHoraria(dto.getCargaHoraria());
		entity = repository.save(entity);
		return new DisciplinaDTO(entity);
	}

	@Transactional
	public DisciplinaDTO update(Long id, DisciplinaDTO dto) {
		try {
			Disciplina entity = repository.getById(id);
			entity.setNomeDisciplina(dto.getNomeDisciplina());
			entity.setCargaHoraria(dto.getCargaHoraria());
			return new DisciplinaDTO(entity);
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
