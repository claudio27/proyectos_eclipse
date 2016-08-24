package com.claudio.test;

import static org.junit.Assert.assertTrue;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;



public class FormatUtilTest {

	public Date d1;
	public Date d2;
	
	
	@Before
	public void antesDelTest(){
		/*
		FechaDesde :Thu Oct 01 15:32:48 GMT 2015
 		FechaHasta :Tue Oct 06 15:32:41 GMT 2015
		 */
		SimpleDateFormat sdf = new SimpleDateFormat(
				"EEE MMM dd HH:mm:ss zzz yyyy");
		try {
			d1 = sdf.parse("Thu Oct 01 15:32:48 GMT 2015");
			d2 = sdf.parse("Tue Oct 06 15:32:41 GMT 2015");			
		} catch (Exception e) {
			System.out.println("Error en el formateo de fechas");
		}
	}
	
	@Test
	public void testDifEntreFechas2(){
		long resultado = DifEntreFechas2(d1, d2);
//		System.out.println(resultado);
		assertTrue(resultado == 5);		
	}
	
	private static long DifEntreFechas2( Date FechaDesde, Date FechaHasta){
		System.out.println("Inicio, DifEntreFechas2( Date, Date)");
        GregorianCalendar IniCalendar = new GregorianCalendar();
        GregorianCalendar FinCalendar = new GregorianCalendar();            
        
		IniCalendar.setTime(FechaDesde);
		FinCalendar.setTime(FechaHasta);
		
		System.out.println("------------------------");
		System.out.println("FechaDesde :" + FechaDesde);
		System.out.println("FechaHasta :" + FechaHasta);
		System.out.println("-----------------------");
		System.out.println("IniCalendar.getTime() : " + IniCalendar.getTime());
		System.out.println("FinCalendar.getTime() : " + FinCalendar.getTime());

		
		IniCalendar.set(Calendar.HOUR_OF_DAY, 0);
		IniCalendar.set(Calendar.MINUTE, 0);
		IniCalendar.set(Calendar.SECOND, 0);

		FinCalendar.set(Calendar.HOUR_OF_DAY, 0);
		FinCalendar.set(Calendar.MINUTE, 0);
		FinCalendar.set(Calendar.SECOND, 0);
		
		System.out.println("IniCalendar.set(Calendar.HOUR_OF_DAY, 0) : " + IniCalendar.getTime());
		System.out.println("FinCalendar.set(Calendar.HOUR_OF_DAY, 0) : " + FinCalendar.getTime());
		
	
		int nTotal=0;    		    		
		long milis1 = FinCalendar.getTimeInMillis();
		long milis2 = IniCalendar.getTimeInMillis();
		// calcular la diferencia en milisengundos
		long diff = milis1 - milis2; // estaban al reves --> -1
		
		System.out.println("milis1 : " + milis1);
		System.out.println("milis2 : " + milis2);
		System.out.println("diff : " +  diff);
		long a = (24 * 60 * 60 * 1000);
		
		int diaInicio = Integer.parseInt(String.valueOf(milis2/a));
		int diaFinal = Integer.parseInt(String.valueOf(milis1/a));
		int resultado = diaFinal - diaInicio;
		System.out.println(" dia final : " + diaFinal +" dia inicial " + diaInicio);
		
		// calcular la diferencia en dias
		System.out.println(" milis1 / a : " + milis1/a);
		System.out.println(" milis2 / a : " + milis2/a);
		System.out.println(" ----- : " + diff / (24 * 60 * 60 * 1000));
		System.out.println(" (24 * 60 * 60 * 1000) " +  (24 * 60 * 60 * 1000));
		
	 
		long diffDays = Math.abs(diff / (24 * 60 * 60 * 1000)); //dias
		
		nTotal = Long.valueOf(diffDays).intValue();
		
		System.out.println("diffDays : " + diffDays);
		System.out.println("nTotal : " + nTotal);
		System.out.println("Fin, DifEntreFechas2(Date, Date)");

		return resultado;      
		

		
	}

}
