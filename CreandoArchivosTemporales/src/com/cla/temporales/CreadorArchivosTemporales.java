package com.cla.temporales;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class CreadorArchivosTemporales {
	
	public static void main(String[] args) throws IOException {		

//		creaArchivos();
//		creaArchivoHDA();
		contenidoArchivo();		
		
		System.out.println("\n\nHecho " + new Date());
	}
	
	public static void creaArchivoHDA() throws IOException{
		String tempDir = System.getProperty("java.io.tmpdir");
		File f = new File(tempDir+"metadata.hda");
		
		FileOutputStream fos = new FileOutputStream(f);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		bw.write("hola mundo");
		bw.close();	
		
	}
	
	
	
	public static void creaArchivos() throws IOException{
		File f1 = File.createTempFile("nuevo1_", ".txt");
		File f2 = new File("Hola.txt");	
		String tempDir = System.getProperty("java.io.tmpdir");
		// Solamente crea la isntancia, no crea el archivo en el disco
		File f3 = new File(tempDir + "holaTemp.java");
		// Crea fisicamente el archivo en el disco
		boolean isOK = f3.createNewFile(); 
		
		
		if(isOK == false){
			if(f3.exists()){
				f3.delete();
			}else{// Como borro el archivo
				isOK = f3.createNewFile();
			}
		}
		FileOutputStream fos = new FileOutputStream(f2);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		bw.write("data data data");
		bw.newLine();
		bw.close();
		
		System.out.println(f1.getAbsolutePath());
		System.out.println(f2.getAbsolutePath());
		System.out.println(tempDir);
		System.out.println(f3.getAbsolutePath());
		System.out.println(isOK);
		System.out.println(f3.getName());		
	}
	
	public static void contenidoArchivo(){
		
		String[] seccion1 = {"dDocAccount", "dDocAuthor", "dDocName",
				"dDocTitle", "dDocType", "dSecurityGroup",
				"primaryFile", "xIdcProfile"};
		String[] seccion2 = {"IdcService", "dDocName", "fParentGUID",
				"fFileType"};
		String[] localData1 = {"IdcService", "dDocAccount", "dDocType",
				"xDireccion", "xFecha", "xFechaExpiracion", "xNombreSolicitante",
				"xNotaria", "xNroCaja", "xNroCuentaAP", "xNumeroComite",
				"xNumeroCursatura", "xNumeroGarantia", "xNumeroOperacion",
				"xRutRelacionado", "xRutSolicitante", "xTasador"
				};
		
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("dDocAccount", "BICE");
		map.put("dDocAuthor", "codigo que identifique el proceso");
		map.put("dDocName", "codigo....");
		map.put("dDoctitle", "titulo de documento");
		
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()){
			String key = it.next();
			System.out.println(key + "=" + map.get(key));
		}
	}

}
