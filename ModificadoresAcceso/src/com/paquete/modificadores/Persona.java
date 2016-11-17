package com.paquete.modificadores;

public class Persona {
	
	private String nombre;
	protected int numero = 1;
	String defecto = "String por defecto";

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
	
	protected String getProtectedMessage() {
		return  "Protected Message";
	}
	
	String getDefaultMessage() {
		return "Default modificator message";
	}
	

}
