package com.huso.horario;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class FechayHora {
	
	
//	-Duser.timezone=America/Santiago
	public static void main(String[] args) throws InterruptedException {

		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.S");
		sdf.setTimeZone(TimeZone.getTimeZone("America/Santiago"));
		
		while(true) {
			
//			System.out.println(new Date());
			System.out.println(sdf.format(new Date()));
			
			Thread.sleep(1);
		}
	}

}
