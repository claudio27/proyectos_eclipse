package com.claudio.comun;

/**
 * Spring bean
 *
 */
public class HelloWorld {

		private String name;
		private int edad;

		public void setName(String name) {
			this.name = name;
		}

		public void printHello() {
			System.out.println("Hello ! " + name);
		}

		public int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}
		
		@Override
	public String toString() {
		return "[" + this.name + "," + this.edad + "]";
	}

}
