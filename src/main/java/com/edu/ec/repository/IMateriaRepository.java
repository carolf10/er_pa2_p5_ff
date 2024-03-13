package com.edu.ec.repository;

import java.util.List;

import com.edu.ec.repository.modelo.Materia;

public interface IMateriaRepository {
	public void insertar(Materia materia);
	public void actualizar(Materia materia);
	public Materia seleccionarPorCodigo(String codigo);
	public List<Materia> seleccionarTodo();
}
