package cl.garantias.ucm.dto;

import java.io.InputStream;

import org.apache.turbine.services.resources.TurbineResources;

public class ArchivoVO {
	
	private String nombreArchivoBd;
	private String tipoArchivoBd;
	private InputStream stream;
	private byte[] bits;
	private String rutCliente;
	private String nombreCliente;
	private String fechaDocumento; 
	private int numGarantia;
	private String direccion;
	private int codigoAbogadoTasador; // Si es cero es abogado, >= 1 tasacion	
	private String rutsRelacionados;
	private String nombreAbogado;
	private String nombreTasador;
	private int folioDocumento;
	private String autor;
 
	
	public ArchivoVO() {}
	
	public ArchivoVO(InputStream stream, String nombre, String tipo) {
		this.stream = stream;
		this.nombreArchivoBd = nombre;
		this.tipoArchivoBd = tipo;
	}
	
	public ArchivoVO(byte[] bits, String nombre, String tipo) {
		this.bits = bits;
		this.nombreArchivoBd = nombre;
		this.tipoArchivoBd = tipo;
	}
	
	public ArchivoVO(
				byte[] bits, String nombre, String tipo, String rutCliente, 
				String nombreCliente, String fechaDocumento, int numGarantia, String direccion,
				int codigoAbogadoTasador, String rutsRelacionados, int folioDocumento,
				String autor, String nombreAbogado, String nombreTasador
				) {
		this.bits = bits;
		this.nombreArchivoBd = nombre;
		this.tipoArchivoBd = tipo;
		this.rutCliente = rutCliente;
		this.nombreCliente = nombreCliente;
		this.fechaDocumento = fechaDocumento;
		this.numGarantia = numGarantia;
		this.direccion = direccion;
		this.codigoAbogadoTasador = codigoAbogadoTasador;		
		this.rutsRelacionados = rutsRelacionados;
		this.folioDocumento = folioDocumento;
		this.autor = autor;
		this.nombreAbogado = nombreAbogado;
		this.nombreTasador = nombreTasador;
	}
	
	public String getNombreArchivoBd() {
		return nombreArchivoBd;
	}

	public void setNombreArchivoBd(String nombreArchivoBd) {
		this.nombreArchivoBd = nombreArchivoBd;
	}

	public String getTipoArchivoBd() {
		return tipoArchivoBd;
	}

	public void setTipoArchivoBd(String tipoArchivoBd) {
		this.tipoArchivoBd = tipoArchivoBd;
	}

	public InputStream getStream() {
		return stream;
	}

	public void setStream(InputStream stream) {
		this.stream = stream;
	}

	public byte[] getBits() {
		return bits;
	}

	public void setBits(byte[] bits) {
		this.bits = bits;
	}

	public String getRutCliente() {
		return rutCliente;
	}

	public void setRutCliente(String rutCliente) {
		this.rutCliente = rutCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getFechaDocumento() { //{ts '2016-09-07 16:24:41.000'}
		return "{ts '" + fechaDocumento + ".000'}";
	}

	public void setFechaDocumento(String fechaDocumento) {
		this.fechaDocumento = fechaDocumento;
	}

	public int getNumGarantia() {
		return numGarantia;
	}

	public void setNumGarantia(int numGarantia) {
		this.numGarantia = numGarantia;
	}

	public String getDireccion() {
		if(this.codigoAbogadoTasador == 0)
			return " ";
		else
			return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getCodigoAbogadoTasador() {
		return codigoAbogadoTasador;
	}

	public void setCodigoAbogadoTasador(int codigoAbogadoTasador) {
		this.codigoAbogadoTasador = codigoAbogadoTasador;
	}
	
	public String getMetaDocName() {
		
		if(this.codigoAbogadoTasador == 0)
			return TurbineResources.getString("semillaDocNameLegal") + ((int) (Math.random() * 10000 + 1)); //((int) (Math.random() * 10000 + 1))  
		else
			return TurbineResources.getString("semillaDocNameTasacion") + ((int) (Math.random() * 10000 + 1)); // ((int) (Math.random() * 10000 + 1))
	}


	public String getMetaDocTitle() {
		
		if(this.codigoAbogadoTasador == 0)
			return TurbineResources.getString("tituloInformeLegal");
		else
			return TurbineResources.getString("tituloInformeTasacion");		
	}
	
	public String getMetaTipoDocumental(){
		
		if(this.codigoAbogadoTasador == 0)
			return TurbineResources.getString("tipoDocumentalLegal");
		else
			return TurbineResources.getString("tipoDocumentalTasacion");
	}

	public String getMetaDocAccount(){
		return TurbineResources.getString("docAccount");
	}
	
	public String getMetaDocType(){
		return TurbineResources.getString("docType");
	}
	
	public String getMetaSecurityGroup(){
		return TurbineResources.getString("securityGroup");
	}
	
	public String getMetaIdcService1(){
		return TurbineResources.getString("IdcService1");
	}

	public String getMetaFileType(){
		return TurbineResources.getString("fFileType");
	}

	public String getMetaIdcService2(){
		return TurbineResources.getString("IdcService2");
	}

	public String getRutsRelacionados() {
		return rutsRelacionados;
	}

	public void setRutsRelacionados(String rutsRelacionados) {
		this.rutsRelacionados = rutsRelacionados;
	}

	public String getNombreAbogado() {
		return nombreAbogado;
	}

	public void setNombreAbogado(String nombreAbogado) {
		this.nombreAbogado = nombreAbogado;
	}

	public String getNombreTasador() {
		return nombreTasador;
	}

	public void setNombreTasador(String nombreTasador) {
		this.nombreTasador = nombreTasador;
	}

	public int getFolioDocumento() {
		return folioDocumento;
	}

	public void setFolioDocumento(int folioDocumento) {
		this.folioDocumento = folioDocumento;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public String toString() {	
		return "( " +
				"nombreArchivoBD : " + this.nombreArchivoBd + ", " + 
				"tipo : " + this.tipoArchivoBd + ", " + 
				"rut : " + this.rutCliente + ", " + 
				"nombre : " + this.nombreCliente + ", " + 
				"fechaDoc : " + this.fechaDocumento + ", " + 
				"garantia : " + this.numGarantia +	", " + 
				"direccion : " + this.direccion + ", " +
				"codAbogadoTasador : " + this.codigoAbogadoTasador + ", " +
				"docName : " + this.getMetaDocName() + ", " + 
				"docTitle : " + this.getMetaDocTitle() + ", " +
				"tipoDocumental : " + this.getMetaTipoDocumental() + ", " +
				"rutsRelacionados : " + this.getRutsRelacionados() + ", " +
				"folioDocumento : " + this.folioDocumento + ", " +
				"autor : " + this.autor + ", " +
				"nombreAbogado : " + this.nombreAbogado + ", " +
				"nombreTasador : " + nombreTasador + 
				") ";
	}
	
}
