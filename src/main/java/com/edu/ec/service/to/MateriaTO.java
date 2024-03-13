package com.edu.ec.service.to;

public class MateriaTO {

	private String nombre;
	private String codigo;
	private String descripcion;
	private String numeroCreditos;

	public MateriaTO() {
		// TODO Auto-generated constructor stub
	}

	public MateriaTO(String nombre, String codigo, String descripcion, String numeroCreditos) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.numeroCreditos = numeroCreditos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNumeroCreditos() {
		return numeroCreditos;
	}

	public void setNumeroCreditos(String numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}
	
	

}
