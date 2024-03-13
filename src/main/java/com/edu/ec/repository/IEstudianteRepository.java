package com.edu.ec.repository;

import com.edu.ec.repository.modelo.Estudiante;

public interface IEstudianteRepository {
	public void insertar(Estudiante estudiante);
	public Estudiante seleccionarPorCedula(String cedula);
}
