package cl.garantias.ucm.excepciones;

public class NoSePudoActualizarIdUCM extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NoSePudoActualizarIdUCM(String msg) {
		super(msg);
	}
}
