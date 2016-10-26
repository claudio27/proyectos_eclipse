package ws.ucm.pasarela;

import ws.ucm.cliente.subida.CheckInUniversal;
import ws.ucm.cliente.subida.CheckInUniversalResult;
import ws.ucm.cliente.subida.CheckinuniversalClientEp;
import ws.ucm.cliente.subida.Process;

public class ServicioSubidaUCM {
	
		
	public CheckInUniversalResult subirArchivo(Process archivo){
		CheckinuniversalClientEp obj1 = new CheckinuniversalClientEp();
		CheckInUniversal interfaz = obj1.getCheckInUniversalPt();
		
		CheckInUniversalResult resultado = 
				interfaz.process(archivo.getDDocName(),
						archivo.getDDocTitle(),
						archivo.getDDocType(),
						archivo.getDDocAuthor(),
						archivo.getDSecurityGroup(),
						archivo.getDDocAccount(),
						archivo.getCustomDocMetaData(),
						archivo.getPrimaryFile(),
						null,null);
		return resultado;
	}

}
