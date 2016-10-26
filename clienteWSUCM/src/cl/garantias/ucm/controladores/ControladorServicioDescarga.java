package cl.garantias.ucm.controladores;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.turbine.util.Log;
import org.apache.turbine.util.RunData;

import cl.garantias.ucm.codificadores.DecodificadorBase64;
import cl.garantias.ucm.excepciones.NoSePudoDecodificarElArchivo;
import ws.ucm.cliente.descarga.GetFileByIDResult;
import ws.ucm.pasarela.ServicioDescargaUCM;

public class ControladorServicioDescarga {
	
	GetFileByIDResult resultado;
	
	public GetFileByIDResult descargaArchivoDesdeUcm(int idDocumento) throws IOException{
		Log.debug("ControladorServicioDescarga.descargaArchivoDesdeUcm()");
		
		ServicioDescargaUCM servicio = new ServicioDescargaUCM();
		GetFileByIDResult archivoResponse = servicio.bajarArchivo(idDocumento);
		resultado = archivoResponse; //Para entregar archivo con getArchivoDecodificado
		return archivoResponse;
	}
	
	
	/** Como recordatorio para generar el archivo de salida 
	 * 	y descargarlo desde el navegador
	 * @param data
	 * @param idDocumento
	 * @throws IOException
	 * 
	 */
	@Deprecated
	public void descargaArchivoDesdeUcm(RunData data, int idDocumento) throws IOException{
		Log.debug("ControladorServicioDescarga.descargaArchivoDesdeUcm()");
		ServicioDescargaUCM servicio = new ServicioDescargaUCM();
		GetFileByIDResult archivoResponse = servicio.bajarArchivo(idDocumento);
		String nombreArchivo = archivoResponse.getDownloadFile().getFileName();
		String data64 = new String( archivoResponse.getDownloadFile().getFileContent() ) ;

		data.getResponse().setContentType("application/octet-stream");
//		data.getResponse().setContentType("application/pdf");
//		data.getResponse().setHeader("Author", "FHTServlet");
//		data.getResponse().setHeader("Cache-Control", "no-cache");
//		data.getResponse().setHeader("Pragma", "no-cache");
//		data.getResponse().setHeader("Expires", "0");
		data.getResponse().setHeader("Content-Disposition", "attachment; filename=\""+ nombreArchivo +"\"");


//		String decodificado = codificador.decodificaBase64(data64);
	//
//		DataOutputStream out = new DataOutputStream(data.getResponse().getOutputStream());
//		out.write(decodificado.getBytes());
//		out.close();
		
		OutputStream out = data.getResponse().getOutputStream();
		out.write(DecodificadorBase64.decodifica(data64));
		out.close();		
	}

	/**Siempre debe usarse despues que se descargue un archivo
	 * con {@link #descargaArchivoDesdeUcm(int)} para que el objeto este en memoria
	 * @return Array de bytes del archivo en base64 decodificado
	 * @throws NoSePudoDecodificarElArchivo
	 */
	public byte[] getArchivoDecodifcado() throws NoSePudoDecodificarElArchivo{
		Log.debug("ControladorServicioDescarga.getArchivoDecodifcado()");
		if(resultado == null){
			throw new NoSePudoDecodificarElArchivo("No hay archivo que decodificar");
		}
		String datosCodificados = new String(resultado.getDownloadFile().getFileContent());		
		return DecodificadorBase64.decodifica(datosCodificados);		
	}
}
