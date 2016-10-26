package cl.garantias.ucm.codificadores;

import org.apache.commons.codec.binary.Base64;
import org.apache.turbine.util.Log;

public class DecodificadorBase64 {
	

	/** Usar con cuidado los archivos que no so de texto quedan corruptos
	 * @param datosCodificados
	 * @return
	 */
	@Deprecated
	public String decodificaBase64(String datosCodificados){
		Log.debug("DecodificadorBase64.decodificaBase64()");
		
		String decodificado = null;
		
		decodificado = new String( Base64.decodeBase64(datosCodificados) );
		
//		Log.debug("decodificado :  " + decodificado);
		return decodificado;
	}
	
	public static byte[] decodifica(String datosCodificados){
		//Log.debug("DecodificadorBase64.decodifica()");
		
		return Base64.decodeBase64(datosCodificados);
	}


}
