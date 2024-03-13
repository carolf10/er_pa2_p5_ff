package com.edu.ec.service;

import java.util.List;

import com.edu.ec.repository.modelo.Matricula;
import com.edu.ec.repository.modelo.dto.MatriculaDTO;
import com.edu.ec.service.to.MatriculaTO;

public interface IMatriculaService {
	public void guardar(Matricula matricula);
	public List<MatriculaDTO> reportarTodo();
	public void matricularEstudiante(MatriculaTO matriculaTO);
}
