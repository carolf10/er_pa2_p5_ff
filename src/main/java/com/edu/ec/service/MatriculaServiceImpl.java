package com.edu.ec.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.ec.repository.IEstudianteRepository;
import com.edu.ec.repository.IMateriaRepository;
import com.edu.ec.repository.IMatriculaRepository;
import com.edu.ec.repository.modelo.Estudiante;
import com.edu.ec.repository.modelo.Materia;
import com.edu.ec.repository.modelo.Matricula;
import com.edu.ec.repository.modelo.dto.MatriculaDTO;
import com.edu.ec.service.to.MatriculaTO;

import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@Service
public class MatriculaServiceImpl implements IMatriculaService {
	
	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	@Autowired
	private IMateriaRepository materiaRepository;
	
	@Autowired
	private IMatriculaRepository matriculaRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void guardar(Matricula matricula) {
		// TODO Auto-generated method stub
		this.matriculaRepository.insertar(matricula);
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public List<MatriculaDTO> reportarTodo() {
		// TODO Auto-generated method stub
		return this.matriculaRepository.seleccionarTodo();
	}

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void matricularEstudiante(MatriculaTO matriculaTO) {
		// TODO Auto-generated method stub
		String cedula = matriculaTO.getCedula();
		String codigo = matriculaTO.getCodigo();
		
		Estudiante estudiante= null;
		Materia materia= null;
		
		Integer nuevoNumero=null;
		
		if (!cedula.isEmpty() && !codigo.isEmpty() && cedula != null && codigo != null) {
			estudiante= this.estudianteRepository.seleccionarPorCedula(cedula);
			materia= this.materiaRepository.seleccionarPorCodigo(codigo);
		}else {
			System.out.println("No se encontraron resultados de la busqueda");
		}
		
		if (estudiante != null && materia != null) {
			nuevoNumero= materia.getNumeroEstudiante();
			materia.setNumeroEstudiante(nuevoNumero + 1);
			this.materiaRepository.actualizar(materia);
			
		}else {
			System.out.println("No se pudo actualizar");
		}
		
		Matricula matricula = new Matricula();
		matricula.setEstudiante(estudiante);
		matricula.setMateria(materia);
		matricula.setFecha(LocalDateTime.now());
		this.guardar(matricula);
		
	}

}
