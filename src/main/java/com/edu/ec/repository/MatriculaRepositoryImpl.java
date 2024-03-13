package com.edu.ec.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.ec.repository.modelo.Matricula;
import com.edu.ec.repository.modelo.dto.MatriculaDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MatriculaRepositoryImpl implements IMatriculaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.entityManager.persist(matricula);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<MatriculaDTO> seleccionarTodo() {
		// TODO Auto-generated method stub
		TypedQuery<MatriculaDTO> query = this.entityManager.createQuery(
				"SELECT NEW com.edu.ec.repository.modelo.dto.MatriculaDTO("
				+ "m.estudiante.cedula, m.estudiante.apellido, "
				+ "m.materia.nombre, m.materia.codigo, "
				+ "m.fecha) FROM Matricula m", MatriculaDTO.class);
		return query.getResultList();
	}

}
