package com.gespofin.main;

import com.gespofin.dao.Dao;
import com.gespofin.dao.sqlserver.DaoImpSqlServer;
import com.gespofin.vo.ResultadoSpGespofin;

public class Principal {
	
	
	/**
	 * <h1>Llamar sp de gespofin </h1>
	 * <strong>args[0] : Numero sp gespofin</strong> <br>
	 * <strong>args[1] : parametro nombre de archivo</strong> <br>
	 * <ol>
	 * <li>actualizaCif()</li> 
	 * <li>cargaArchivo(String nombreArchivo)</li> 
	 * <li>cargaLetrasyBonos()</li> 
	 * <li>copiaArchivosFilialInicioDia()</li> 
	 * <li>copiaArchivosFilialInicioDiaAGV()</li> 
	 * <li>correoInicioProcesoInicioDia()</li> 
	 * <li>creaConversores()</li> 
	 * <li>creaParaFecInicioDia()</li> 
	 * <li>descargaPatrimonioEfectivo()</li> 
	 * </ol>
	 * @param args
	 *
	 */
	public static void main2(String[] args) {
		
		Dao obj = new DaoImpSqlServer();
		ResultadoSpGespofin res = null;
		
		if(args.length == 1) {
			
			int numSp = Integer.valueOf(args[0]);
			switch (numSp) {
			case 1:
				res = obj.actualizaCif();
				break;
			case 2:
				System.out.println("Tambien debe indicar el nombre del archivo a procesar");
				res = new ResultadoSpGespofin();
				res.setResultado(999);
				break;
			case 3:
				res = obj.cargaLetrasyBonos();
				break;
			case 4:
				res = obj.copiaArchivosFilialInicioDia();
				break;
			case 5:
				res = obj.copiaArchivosFilialInicioDiaAGV();
				break;
			case 6:
				res = obj.correoInicioProcesoInicioDia();
				break;
			case 7:
				res = obj.creaConversores();
				break;
			case 8:
				res = obj.creaParaFecInicioDia();
				break;
			case 9:
				res = obj.descargaPatrimonioEfectivo();
				break;
			default:	
				System.out.println("Opcion invalida defecto");
				res = new ResultadoSpGespofin();
				res.setResultado(999);
				break;
			}
			
			if(res != null) {
				System.out.println("Salida " + res.getResultado());
				System.exit(res.getResultado());
			}else {
				System.out.println("Ups");
				System.exit(999);
			}
			
		}else if(args.length > 1) { 
			
			int numSp = Integer.valueOf(args[0]);
			String nombreArchivo = args[1];
			
			if(numSp == 2) // FIXME que pasa si el nombre no corresponde.
				res = obj.cargaArchivo(nombreArchivo);
			else {
				System.out.println("Opcion invalida");
				res = new ResultadoSpGespofin();
				res.setResultado(999);
			}
			
			if(res != null) {
				System.out.println("Salida " + res.getResultado());
				System.exit(res.getResultado());
			}else{
				System.out.println("Ups");
				System.exit(999);
			}
			
		}else {
			System.out.println("Debe ingresar el numero_sp, o numero_sp y nombre_archivo a procesar.");
		}

		


	}
	
	public static void main(String[] args) {
		Dao obj = new DaoImpSqlServer();
		obj.actualizaCif();
	}
	
	

}
