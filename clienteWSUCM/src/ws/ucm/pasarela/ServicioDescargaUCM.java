package ws.ucm.pasarela;

import ws.ucm.cliente.descarga.GetFileByID;
import ws.ucm.cliente.descarga.GetFileByIDResult;
import ws.ucm.cliente.descarga.GetfilebyidClientEp;

public class ServicioDescargaUCM {	

//	int idDocumento, 73332, 73927, 73928, 74118, 73928

	public GetFileByIDResult bajarArchivoTest(int idDocumento){
		
		GetfilebyidClientEp cli = new GetfilebyidClientEp();
		GetFileByID interfaz = cli.getGetFileByIDPt();

		GetFileByIDResult result =  interfaz.process(idDocumento, null, null);
		
		String nombreArchivo = result.getDownloadFile().getFileName();

		
		System.err.println("-------------------------------------------");
		System.err.println("-------------------------------------------");
		System.out.println("result.getStatusInfo() : " + result.getStatusInfo().getStatusCode());
		System.out.println("result.getStatusInfo() : " + result.getStatusInfo().getStatusMessage());
		System.out.println("nombreArchivo : " + nombreArchivo);
		System.err.println("-------------------------------------------");
		System.err.println("-------------------------------------------");
		
		return result;
	}
	

	public GetFileByIDResult bajarArchivo(int idDocumento){
		
		GetfilebyidClientEp cli = new GetfilebyidClientEp();
		GetFileByID interfaz = cli.getGetFileByIDPt();

		GetFileByIDResult result =  interfaz.process(idDocumento, null, null);	
		
		return result;
	}


}
