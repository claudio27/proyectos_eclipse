package cl.garantias.ucm.excepciones;

public class NoSePudoGuardarArchivoEnUCM extends Exception {


	private static final long serialVersionUID = 1L;
	
	public NoSePudoGuardarArchivoEnUCM(String msg) {
		super(msg);
	}
	
	public NoSePudoGuardarArchivoEnUCM(String msg, Throwable t) {
		super(msg, t);
	}
	

}
