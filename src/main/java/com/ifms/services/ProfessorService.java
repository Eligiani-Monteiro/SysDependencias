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

import com.ifms.dto.ProfessorDTO;
import com.ifms.entities.Professor;
import com.ifms.repositories.ProfessorRepository;
import com.ifms.services.exceptions.DataBaseException;
import com.ifms.services.exceptions.ResourceNotFoundException;

@Service
public class ProfessorService {
	@Autowired
	private ProfessorRepository repository;

	@Transactional(readOnly = true)
	public Page<ProfessorDTO> findAllPaged(PageRequest pageRequest) {
		Page<Professor> list = repository.findAll(pageRequest);
		return list.map(x -> new ProfessorDTO(x));
	}

	@Transactional(readOnly = true)
	public ProfessorDTO findById(Long id) {
		Optional<Professor> obj = repository.findById(id);
		Professor entity = obj
				.orElseThrow(() -> new ResourceNotFoundException("A entidade consultada não foi localizada"));
		return new ProfessorDTO(entity);
	}

	@Transactional
	public ProfessorDTO insert(ProfessorDTO dto) {
		Professor entity = new Professor();
		entity.setNomeProfessor(dto.getNomeProfessor());
		entity.setTitulo(dto.getTitulo());
		entity = repository.save(entity);
		return new ProfessorDTO(entity);
	}

	@Transactional
	public ProfessorDTO update(Long id, ProfessorDTO dto) {
		try {
			Professor entity = repository.getById(id);
			entity.setNomeProfessor(dto.getNomeProfessor());
			entity.setTitulo(dto.getTitulo());

			entity = repository.save(entity);
			return new ProfessorDTO(entity);
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
