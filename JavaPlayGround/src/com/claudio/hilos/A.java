package com.claudio.hilos;

public class A extends Alfa{
	
	Tareal a;
	
	public A(String jobName) {
		a = new Tareal(jobName);
	}
	
	public void ejecuta() {
		a.start();
	}
	
	public static void main(String[] args) {
		A obj1 = new A("j1");
		A obj2 = new A("j2");
		
		
		obj1.ejecuta();
		obj2.ejecuta();
		
		System.out.println("fin main");
	}

}
