package inicializador;

public class Inicializador {

	// instance variable initializer
	String s = "abc";

	// constructor
	public Inicializador() {
		System.out.println("\tconstructor called");
	}

	// static initializer
	static {
		System.out.println("static initializer called");
	}

	// instance initializer
	{
		System.out.println("\tinstance initializer called");
	}
	
	static void method() {
		System.out.println("static method called");
	}

	public static void main(String[] args) {
		new Inicializador();
		new Inicializador();
//		Inicializador.method();
	}
	
	/*
	 * Inicializador estatico, solamente se llama una vez, aunque se hagan 
	 * varias llamadas a new()
	 * 
	 * */
}
