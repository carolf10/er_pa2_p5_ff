package com.edu.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.ec.repository.IMateriaRepository;
import com.edu.ec.repository.modelo.Materia;
import com.edu.ec.service.to.MateriaTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MateriaServiceImpl implements IMateriaService {
	@Autowired
	private IMateriaRepository materiaRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardar(MateriaTO materiaTO) {
		// TODO Auto-generated method stub
		Materia materia= new Materia();
		materia.setCodigo(materiaTO.getCodigo());
		materia.setDescripcion(materiaTO.getDescripcion());
		materia.setNombre(materiaTO.getNombre());
		materia.setNumeroCreditos(materiaTO.getNumeroCreditos());
		materia.setNumeroEstudiante(0);
		this.materiaRepository.insertar(materia);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void actualizar(Materia materia) {
		// TODO Auto-generated method stub
		this.materiaRepository.actualizar(materia);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public List<Materia> reportarTodo() {
		// TODO Auto-generated method stub
		return this.materiaRepository.seleccionarTodo();
	}

}
