package com.gespofin.dao;

import com.gespofin.vo.ResultadoSpGespofin;

public interface Dao{
	
	public ResultadoSpGespofin actualizaCif();
	
	public ResultadoSpGespofin cargaArchivo(String nombreArchivo);
	
	public ResultadoSpGespofin cargaLetrasyBonos();
	
	public ResultadoSpGespofin copiaArchivosFilialInicioDia();
	
	public ResultadoSpGespofin copiaArchivosFilialInicioDiaAGV();
	
	public ResultadoSpGespofin correoInicioProcesoInicioDia();
	
	public ResultadoSpGespofin creaConversores();
	
	public ResultadoSpGespofin creaParaFecInicioDia();
	
	public ResultadoSpGespofin descargaPatrimonioEfectivo();
}

