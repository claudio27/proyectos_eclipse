package com.claudio.programdor;

import java.util.Date;

public class Temporizador {

	public static void main(String[] args) throws InterruptedException {
		
		int contador = 0;
		
		while(true) {
			
			if(new Date().getMinutes() == 26)
				if(contador == 0)
				{
					System.out.println("pum!!!");
					contador++;
					
				}
			
			Thread.sleep(1000);
			System.out.println("durmiendozzzz ...");
			
		}
	}
}
