package com.edu.ec.service;

import java.util.List;

import com.edu.ec.repository.modelo.Materia;
import com.edu.ec.service.to.MateriaTO;

public interface IMateriaService {
	public void guardar(MateriaTO materiaTO);
	public void actualizar(Materia materia);
	public List<Materia> reportarTodo();
}
