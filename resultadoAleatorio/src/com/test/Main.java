package com.test;

public class Main {
	
	public static void main(String[] args) throws InterruptedException  {
		
		System.out.println("Iniciando ... ");
		
		int num =(int) (Math.random() * 100)+ 1;
		int tiempoEspera = 0;
		
		System.out.println(num);
		System.out.println(args.length);
		
		if(args.length > 0)
			if(Integer.parseInt(args[0]) > 0)
				tiempoEspera = Integer.parseInt(args[0]); 

		if(num <= 50) {
			System.out.println("Exit:0, durmiendo : " + tiempoEspera + "s");
			while(true) {
				System.out.println(tiempoEspera-- + " ");
				if(tiempoEspera == 0) {
					System.out.println("Despierta y termina!");
					System.exit(0);
				}
				Thread.sleep(1000);
				if(tiempoEspera < 0)
					System.exit(0);
			}
		}
		else {
			System.out.println("Exit:999, durmiendo : " + tiempoEspera + "s");
			while(true) {
				System.out.println(tiempoEspera-- + " ");
				if(tiempoEspera == 0) {
					System.out.println("Despierta y termina!");
					System.exit(999);
				}
				Thread.sleep(1000);
				if(tiempoEspera < 0)
					System.exit(999);

			}
		}
		
		
	}

}
