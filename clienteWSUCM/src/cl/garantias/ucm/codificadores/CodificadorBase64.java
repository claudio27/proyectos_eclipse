package cl.garantias.ucm.codificadores;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;
import org.apache.turbine.util.Log;
import org.apache.turbine.util.upload.FileItem;

public class CodificadorBase64 {

	@Deprecated
	public String codificaBase64(FileItem archivo) throws IOException{
		Log.debug("CodificadorBase64.codificaBase64()");
		
		String codificado = null;
		InputStream inputStream = archivo.getStream();
		
		byte[] fileArray = new byte[(int) archivo.getSize()];
		int bytesLeidos = inputStream.read(fileArray);
				
		Log.debug("archivo.getFileName() :  " + archivo.getFileName());
		Log.debug("archivo.getName() :  " + archivo.getName());
		Log.debug("archivo.getSize() :  " + archivo.getSize());		
		Log.debug("bytesLeidos :  " + bytesLeidos);
		
		codificado = Base64.encodeBase64String(fileArray);
		inputStream.close();
		
//		Log.debug("codificado :  " + codificado);
		
		return codificado;
	}
	
	public static String codificaBase64(File archivo) throws IOException{
//		Log.debug("CodificadorBase64.codificaBase64("+archivo.getName()+")");
		
		String codificado = null;
		InputStream inputStream = new FileInputStream(archivo);
		
		byte[] fileArray = new byte[(int) archivo.length()];
		inputStream.read(fileArray);
				
//		Log.debug("archivo.getFileName() :  " + archivo.getName());
//		Log.debug("archivo.getName() :  " + archivo.getName());
//		Log.debug("archivo.getSize() :  " + archivo.length());		
//		Log.debug("bytesLeidos :  " + bytesLeidos);
		
		codificado = Base64.encodeBase64String(fileArray);
		inputStream.close();
		
//		Log.debug("codificado :  " + codificado);
		
		return codificado;
	}
	

}
