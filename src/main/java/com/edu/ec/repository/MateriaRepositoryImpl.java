package com.edu.ec.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.edu.ec.repository.modelo.Materia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Repository
@Transactional
public class MateriaRepositoryImpl implements IMateriaRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(materia);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(materia);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Materia seleccionarPorCodigo(String codigo) {
		// TODO Auto-generated method stub
		TypedQuery<Materia> query = this.entityManager.createQuery(""
				+ "SELECT m FROM Materia m WHERE m.codigo =:codigo", Materia.class);
		query.setParameter("codigo", codigo);
		return query.getSingleResult();	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Materia> seleccionarTodo() {
		// TODO Auto-generated method stub
		TypedQuery<Materia> query = this.entityManager.createQuery("SELECT m FROM Materia m", Materia.class);
		return query.getResultList();
	}

}
