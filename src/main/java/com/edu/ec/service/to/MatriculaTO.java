package com.edu.ec.service.to;

public class MatriculaTO {
	
	private String cedula;
	private String codigo;

	public MatriculaTO() {
		// TODO Auto-generated constructor stub
	}

	public MatriculaTO(String cedula, String codigo) {
		super();
		this.cedula = cedula;
		this.codigo = codigo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	

}
