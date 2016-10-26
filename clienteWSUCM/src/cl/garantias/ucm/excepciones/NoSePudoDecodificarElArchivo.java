package cl.garantias.ucm.excepciones;

public class NoSePudoDecodificarElArchivo extends Exception {

	private static final long serialVersionUID = 1L;
	
	
	public NoSePudoDecodificarElArchivo(String msg) {
		super(msg);
	}

}
