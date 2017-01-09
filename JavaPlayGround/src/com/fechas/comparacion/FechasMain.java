package com.fechas.comparacion;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FechasMain {
	
	public static void main(String[] args) {
		
		Calendar cal = new GregorianCalendar();
		cal.set(2017, 0, 1);
		
		Date fechaFin57bis = cal.getTime();
		Date fechaHoy = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		System.out.println(fechaFin57bis);
		System.out.println(fechaHoy);
		System.out.println("fechaFin : " + sdf.format(fechaFin57bis));
		System.out.println("fechaHoy : " + sdf.format(fechaHoy));

		

		if(fechaHoy.compareTo(fechaFin57bis) >= 0)
			System.out.println("mayor o iguales");
		else if (fechaHoy.compareTo(fechaFin57bis) > 0)
			System.out.println("fecha mayor");
		else if (fechaHoy.compareTo(fechaFin57bis) < 0)
			System.out.println("fecha menor");

		
//		if(fechaFin57bis.compareTo(fechaHoy) >= 0)
//			System.out.println("mayor o iguales");
//		else if (fechaFin57bis.compareTo(fechaHoy) > 0)
//			System.out.println("fecha mayor");
//		else if (fechaFin57bis.compareTo(fechaHoy) < 0)
//			System.out.println("fecha menor");

		/**
		 * 
		 * int java.util.Date.compareTo(Date anotherDate)
		 * 
		 * the value 0 if the argument Date is equal to this Date;
		 *  a value less than 0 if this Date is before the Date argument;
		 *   and a value greater than 0 if this Date is after the Date argument.

		 * */
		
	}

}
