package ws.ucm.utiles;

import org.apache.turbine.services.resources.TurbineResources;

public class Propiedad {
		
	
	public  static String getProp(String propiedad){
		return TurbineResources.getString(propiedad);
	}
	

}
