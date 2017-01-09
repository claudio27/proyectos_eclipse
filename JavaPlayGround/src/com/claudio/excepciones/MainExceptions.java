package com.claudio.excepciones;

public class MainExceptions {

	
	public static void main(String[] args) {
		
		try {
			
			
			System.out.println("MainExceptions.loqueSea1()");
			throw new Exception();
//			return;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("Finally OK");
		}
		
	}
	
	public static void loqueSea() {
		System.out.println("MainExceptions.loqueSea()");
		
	}
	
}
