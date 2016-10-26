package com.captaciones.main;

import com.captaciones.persistencia.ConsultasDAO;

public class Principal {

	public static void main(String[] args) throws Exception {
		
		System.out.println("Iniciando...");
		System.out.println();
		
		ConsultasDAO.consultaTasas();

	}

}
