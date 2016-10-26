package ws.ucm.utiles;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.turbine.util.Log;

import cl.garantias.ucm.codificadores.CodificadorBase64;
import cl.garantias.ucm.dto.ArchivoVO;
import ws.ucm.cliente.subida.IdcFile;
import ws.ucm.cliente.subida.IdcProperty;
import ws.ucm.cliente.subida.IdcPropertyList;
import ws.ucm.cliente.subida.ObjectFactory;
import ws.ucm.cliente.subida.Process;

public class ProcessFactory {

	private String fileName; 
	private String fileContent; 
	private Process proceso;
	private ArchivoVO archivoMetadata; 
	
	
	
	public ProcessFactory(File archivo, ArchivoVO metadata) throws IOException{
		try{

		this.archivoMetadata = metadata; 
		this.fileName = archivo.getAbsolutePath();
		this.fileContent = CodificadorBase64.codificaBase64(archivo);
		proceso = new Process();
		
		}catch(Exception e){
			Log.error("Fallo la creacion de processFactory " , e);
		}
	}

	
	public Process generateProcess(){
		
		IdcFile file = new IdcFile();
		file.setFileName(fileName);		
		file.setFileContent(fileContent);
		
		IdcProperty numGarantiaProp = new IdcProperty(); 
		numGarantiaProp.setName("xNumeroGarantia");
		numGarantiaProp.setValue( String.valueOf(archivoMetadata.getNumGarantia()) );
		
		IdcProperty tipoDocumentalProp = new IdcProperty(); 
		tipoDocumentalProp.setName("xIdcProfile");
		tipoDocumentalProp.setValue(archivoMetadata.getMetaTipoDocumental()); 
		
		IdcProperty rutProp = new IdcProperty(); 
		rutProp.setName("xRutSolicitante");
		rutProp.setValue(archivoMetadata.getRutCliente());
		
		IdcProperty rutAsociadosProp = new IdcProperty(); 
		rutAsociadosProp.setName("xRutRelacionado");
		rutAsociadosProp.setValue(archivoMetadata.getRutsRelacionados()); 
		
		IdcProperty nombreCliProp = new IdcProperty(); 
		nombreCliProp.setName("xNombreSolicitante");
		nombreCliProp.setValue(archivoMetadata.getNombreCliente());

		IdcProperty fechaDocProp = new IdcProperty(); 
		fechaDocProp.setName("xFecha");
		fechaDocProp.setValue(archivoMetadata.getFechaDocumento()); 
		
		IdcProperty idcServiceProp = new IdcProperty(); 
		idcServiceProp.setName("IdcService");
		idcServiceProp.setValue(archivoMetadata.getMetaIdcService1());

		IdcProperty fileTypeProp = new IdcProperty(); 
		fileTypeProp.setName("fFileType");
		fileTypeProp.setValue(archivoMetadata.getMetaFileType()); 
		
		IdcProperty nombreAbogadoProp = new IdcProperty(); 
		nombreAbogadoProp.setName("xNombreAbogado");
		nombreAbogadoProp.setValue(archivoMetadata.getNombreAbogado());
		
		IdcProperty nombreTasadorProp = new IdcProperty(); 
		nombreTasadorProp.setName("xTasador");
		nombreTasadorProp.setValue(archivoMetadata.getNombreTasador());
		
		IdcProperty direccionProp = new IdcProperty(); 
		direccionProp.setName("xDireccion");
		direccionProp.setValue(archivoMetadata.getDireccion());

		
		////////////////////////////////////////
		
		/**
		 * Propiedades extra
		 * */
		IdcProperty extraIdcServiceProp = new IdcProperty(); 
		extraIdcServiceProp.setName("IdcService");
		extraIdcServiceProp.setValue(archivoMetadata.getMetaIdcService2());
		
		IdcProperty extraFileTypeProp = new IdcProperty(); 
		extraFileTypeProp.setName("fFileType");
		extraFileTypeProp.setValue(archivoMetadata.getMetaFileType());
		
		IdcProperty extraDocNameProp = new IdcProperty(); 
		extraDocNameProp.setName("dDocName");
		extraDocNameProp.setValue(archivoMetadata.getMetaDocName());

		ObjectFactory objFactory = new ObjectFactory();		
		IdcPropertyList listExtraProps = objFactory.createIdcPropertyList();
		listExtraProps.getProperty().add(extraIdcServiceProp);
		listExtraProps.getProperty().add(extraDocNameProp);
		listExtraProps.getProperty().add(extraFileTypeProp);
		
//		Rut, nombre cliente, fecha documento,  nro garantía,
//		mas los metadatos obligatorios. 
		
		IdcPropertyList listProps = objFactory.createIdcPropertyList();

		if(archivoMetadata.getCodigoAbogadoTasador() == 0){ // Setea propiedades para el abogado
			
			listProps.getProperty().add(numGarantiaProp);
			listProps.getProperty().add(tipoDocumentalProp);
			listProps.getProperty().add(rutProp);
			listProps.getProperty().add(nombreCliProp);
			listProps.getProperty().add(fechaDocProp);
			listProps.getProperty().add(idcServiceProp);
			listProps.getProperty().add(fileTypeProp);
			listProps.getProperty().add(rutAsociadosProp);
			listProps.getProperty().add(nombreAbogadoProp);
			
		}else{ 	// Setea Propiedades para el tasador
			
			listProps.getProperty().add(numGarantiaProp);
			listProps.getProperty().add(tipoDocumentalProp);
			listProps.getProperty().add(rutProp);
			listProps.getProperty().add(nombreCliProp);
			listProps.getProperty().add(fechaDocProp);
			listProps.getProperty().add(idcServiceProp);
			listProps.getProperty().add(fileTypeProp);
			listProps.getProperty().add(rutAsociadosProp); 
			listProps.getProperty().add(nombreTasadorProp);
			listProps.getProperty().add(direccionProp);
		}
		
			
			proceso.setAlternateFile(null);  
			proceso.setCustomDocMetaData(listProps);
			proceso.setDDocAccount(archivoMetadata.getMetaDocAccount()); 
			proceso.setDDocAuthor(archivoMetadata.getAutor());
			proceso.setDDocName(archivoMetadata.getMetaDocName());
			proceso.setDDocTitle(archivoMetadata.getMetaDocTitle());
			proceso.setDDocType(archivoMetadata.getMetaDocType()); 
			proceso.setDSecurityGroup(archivoMetadata.getMetaSecurityGroup());
			proceso.setExtraProps(listExtraProps);
			proceso.setPrimaryFile(file);
		
		return proceso;
	}
	
	@Override
	public String toString() {
		
		return "[" +
				"docAccount : " + archivoMetadata.getMetaDocAccount() + ", " +
				"docAuthor : " + archivoMetadata.getAutor() + ", " + 
				"docName : " + archivoMetadata.getMetaDocName() + ", " + 
				"docTitle : " + archivoMetadata.getMetaDocTitle() + ", " + 
				"docType : " + archivoMetadata.getMetaDocType() + ", " +
				"securityGroup : " + archivoMetadata.getMetaSecurityGroup() + ", " +
				"fileName : " + fileName + ", " +				
				 "]";
	}
	
    public String generaClaveUnica(){

    	String id = UUID.randomUUID().toString();
    	return id;

    }
	
	

}
