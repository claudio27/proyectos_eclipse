package com.claudio.buscar.en.string;

public class Main {

	
	public static void main(String[] args) {
		
		String str = "este es text un TEXTO cualquiera para buscar";
		String textoBuscar = "texto";
		System.out.println(str.toLowerCase().indexOf(textoBuscar));
		
		/***
		 * 	    
		 * 
		 * // Texto
	    String sTexto = "palabra o palabra y palabra";
	    // Texto que vamos a buscar
	    String sTextoBuscado = "palabra";
	    // Contador de ocurrencias 
	    int contador = 0;

	    while (sTexto.indexOf(sTextoBuscado) > -1) {
	      sTexto = sTexto.substring(sTexto.indexOf(
	        sTextoBuscado)+sTextoBuscado.length(),sTexto.length());
	      contador++; 
	    }

	    System.out.println (contador);
		 * 
		 * **/
		
	}
}
