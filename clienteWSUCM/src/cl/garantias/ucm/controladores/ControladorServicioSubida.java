package cl.garantias.ucm.controladores;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.turbine.util.Log;

import cl.garantias.ucm.dao.ConsultasUcmBD;
import cl.garantias.ucm.dto.ArchivoVO;
import cl.garantias.ucm.excepciones.NoSePudoActualizarIdUCM;
import cl.garantias.ucm.excepciones.NoSePudoGuardarArchivoEnUCM;
import ws.ucm.cliente.subida.CheckInUniversalResult;
import ws.ucm.pasarela.ServicioSubidaUCM;
import ws.ucm.utiles.ProcessFactory;

public class ControladorServicioSubida {
	

	/**
	 *  Sube un archivo usando web service a UCM (Universal Content Management)
	 * 
	 * @param processFactory
	 * @return
	 * @throws NoSePudoGuardarArchivoEnUCM
	 * @throws NoSePudoActualizarIdUCM
	 */
	public CheckInUniversalResult guardarArchivoEnUCM(ProcessFactory processFactory) throws NoSePudoGuardarArchivoEnUCM, NoSePudoActualizarIdUCM{
//		  System.out.println("ControladorServicioSubida.guardarArchivoEnUCM()");
//		  System.out.println("processFactory() : " + processFactory.toString());
		  Log.debug("ControladorServicioSubida.guardarArchivoEnUCM()");
		  Log.debug("processFactory() : " + processFactory.toString());
		  
		  
		  ServicioSubidaUCM servicioSubida = new ServicioSubidaUCM();
		  
		  CheckInUniversalResult resultado = servicioSubida.subirArchivo(processFactory.generateProcess());
		  
//		  System.out.println("id : " + resultado.getDID());
//		  System.out.println("resultado status code : " + resultado.getStatusInfo().getStatusCode());
//		  System.out.println("Mensaje : " + resultado.getStatusInfo().getStatusMessage());
		  Log.debug("id : " + resultado.getDID());
		  Log.debug("resultado status code : " + resultado.getStatusInfo().getStatusCode());
		  Log.debug("Mensaje : " + resultado.getStatusInfo().getStatusMessage());

		  		  	  
		  if( resultado.getStatusInfo().getStatusCode().intValue() != 0 ){
			  throw new NoSePudoGuardarArchivoEnUCM("Ocurrio un error al subir el archivo, codigo estado : " +  
					  resultado.getStatusInfo().getStatusCode() + ", " +
					  resultado.getStatusInfo().getStatusMessage()
					  );
		  }
		  
		  return resultado;		  
	  }
	
	public void subeArchivosAUcm(int nroGarantia, int nroEvento, String autor){
		  Log.debug("ControladorServicioSubida.subeArchivosAUcm(" + nroGarantia +", "+ nroEvento + ")");
		  
	      ConsultasUcmBD con = new ConsultasUcmBD();
	      List<Integer> folios = new ArrayList<Integer>();
	      folios = con.consultaFoliosGarantias(nroGarantia, nroEvento);
	      int numFolio = 0;
	      
	      Log.debug("folios.size() " + folios.size());
	      
	      
	      if(folios.size() >= 1){
	     	 Iterator<Integer> it = folios.iterator();
	     	 while(it.hasNext()){
	     		 
	     		 try{
	     			 numFolio = it.next().intValue();
	     			 ArchivoVO arch = con.consultaArchivoPorFolio(numFolio, nroEvento) ;
	     			 arch.setAutor(autor); // Los demas datos se setean consultaArchivoPorFolio	     			 
	     			Log.debug("Datos ArchivoVO recuperados : " + arch.toString() );
	     			 
	     			 String tempDir = System.getProperty("java.io.tmpdir");
	     			 File archivoTemporal = new File(tempDir + arch.getNombreArchivoBd() +"."+ arch.getTipoArchivoBd().toLowerCase());
	     			 archivoTemporal.deleteOnExit();
	     			 
	     			 InputStream in = new ByteArrayInputStream(arch.getBits());
	     			 FileOutputStream out = new FileOutputStream(archivoTemporal);

	     			 Log.debug("OK archivo grabado");
	     			 
	     			 int BUFFER_SIZE = 1024;
	     			 byte[] buffer = new byte[BUFFER_SIZE];
	     			 int sizeRead = 0;
	     			 while ((sizeRead = in.read(buffer)) >= 0) {
	     				 out.write(buffer, 0, sizeRead); 
	     			 }
	     			 in.close(); 
	     			 out.close();

//	     			 ProcessFactory proc = new ProcessFactory(autor, archivoTemporal, nroGarantia, numFolio);
	     			ProcessFactory proc = new ProcessFactory(archivoTemporal, arch);


	     			CheckInUniversalResult resultado = this.guardarArchivoEnUCM(proc);
	     			int okUpdate = con.actualizaIdUCM(resultado.getDID(), numFolio);

	     			if(okUpdate < 1){
	     				throw new NoSePudoActualizarIdUCM("Fallo la actulizacion de id, folio : " + numFolio);
	     			}

	     			Log.debug("temp " + archivoTemporal.getAbsolutePath());
	     			Log.debug("Fin ciclo subida archivos : OK");
	     		 
	     		 }catch(NoSePudoGuardarArchivoEnUCM e){
     				 Log.error("Fallo ucm", e);  
     				
     			 }catch(NoSePudoActualizarIdUCM ex){
     				 Log.error("Fallo bd", ex);      				 					
     			 }catch(Exception e){
	     			 Log.error("Fallo recuperacion de archivo con folio : " + numFolio, e);
	     		 }
	     	 }
	      }

	  }

}
