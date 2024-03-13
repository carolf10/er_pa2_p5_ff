package com.edu.ec.repository.modelo.dto;

import java.time.LocalDateTime;

public class MatriculaDTO {
	private String cedula;
	private String apellido;
	
	private String nombre;
	private String codigo;
	
	private LocalDateTime fecha;

	public MatriculaDTO() {
		// TODO Auto-generated constructor stub
	}

	public MatriculaDTO(String cedula, String apellido, String nombreMateria, String codigo, LocalDateTime fecha) {
		super();
		this.cedula = cedula;
		this.apellido = apellido;
		this.nombre = nombreMateria;
		this.codigo = codigo;
		this.fecha = fecha;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
