package com.gespofin.dao.sqlserver;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.gespofin.dao.Dao;
import com.gespofin.vo.ResultadoSpGespofin;


public class DaoImpSqlServer implements Dao {

	public ResultadoSpGespofin actualizaCif() {
		System.out.println("DaoImpSqlServer.actualizaCif()");
		
		ConexionBD con = new ConexionBD();
		CallableStatement cs = null;
		ResultSet rs = null;
		ResultadoSpGespofin res = new ResultadoSpGespofin();
		
		try {
			
			
			cs = con.getCon().prepareCall("{ call sp_WKL_ActualizaCIF }");
			rs = cs.executeQuery();
			
			if(rs.next()) {
				res.setResultado(rs.getInt(1));
				res.setMensaje(rs.getString("mensaje"));
				System.out.println(rs.getInt(1));
				imprimeLogSp(res.getMensaje());
				
			}else {
				System.out.println("Ningun dato");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			res.setResultado(999);
		} finally {			
			liberaRecursos(cs, rs, con);
		}
		
		return res;
		
	}

	public ResultadoSpGespofin cargaArchivo(String nombreArchivo) {
		System.out.println("DaoImpSqlServer.cargaArchivo("+nombreArchivo+")");
		
		ConexionBD con = new ConexionBD();
		CallableStatement cs = null;
		ResultSet rs = null;
		ResultadoSpGespofin res = new ResultadoSpGespofin();
		
		try {
			
			
			cs = con.getCon().prepareCall("{ call sp_WKL_Carga_Archivo(?) }");
			cs.setString(1, nombreArchivo);
			rs = cs.executeQuery();
			
			if(rs.next()) {
				res.setResultado(rs.getInt(1));
				System.out.println(rs.getInt(1));
				
			}else {
				System.out.println("Ningun dato");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			res.setResultado(999);
		} finally {			
			liberaRecursos(cs, rs, con);
		}
		
		return res;
		
	}

	public ResultadoSpGespofin cargaLetrasyBonos() {
		System.out.println("DaoImpSqlServer.cargaLetrasyBonos()");
		
		ConexionBD con = new ConexionBD();
		CallableStatement cs = null;
		ResultSet rs = null;
		ResultadoSpGespofin res = new ResultadoSpGespofin();
		
		try {
			
			
			cs = con.getCon().prepareCall("{ call sp_WKL_Carga_Letras_y_Bonos }");
			rs = cs.executeQuery();
			
			if(rs.next()) {
				res.setResultado(rs.getInt(1));
				System.out.println(rs.getInt(1));
				
			}else {
				System.out.println("Ningun dato");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			res.setResultado(999);
		} finally {			
			liberaRecursos(cs, rs, con);
		}
		
		return res;
		
	}

	public ResultadoSpGespofin copiaArchivosFilialInicioDia() {
		System.out.println("DaoImpSqlServer.copiaArchivosFilialInicioDia()");
		
		ConexionBD con = new ConexionBD();
		CallableStatement cs = null;
		ResultSet rs = null;
		ResultadoSpGespofin res = new ResultadoSpGespofin();
		
		try {
			
			
			cs = con.getCon().prepareCall("{ call sp_WKL_CopiaArchivosFilial_inicioDia }");
			rs = cs.executeQuery();
			
			if(rs.next()) {
				res.setResultado(rs.getInt(1));
				System.out.println(rs.getInt(1));
				
			}else {
				System.out.println("Ningun dato");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			res.setResultado(999);
		} finally {			
			liberaRecursos(cs, rs, con);
		}
		
		return res;
		
	}

	public ResultadoSpGespofin copiaArchivosFilialInicioDiaAGV() {
		System.out.println("DaoImpSqlServer.copiaArchivosFilialInicioDiaAGV()");
		
		ConexionBD con = new ConexionBD();
		CallableStatement cs = null;
		ResultSet rs = null;
		ResultadoSpGespofin res = new ResultadoSpGespofin();
		
		try {
			
			
			cs = con.getCon().prepareCall("{ call sp_WKL_CopiaArchivosFilialAGV }");
			rs = cs.executeQuery();
			
			if(rs.next()) {
				res.setResultado(rs.getInt(1));
				System.out.println(rs.getInt(1));
				
			}else {
				System.out.println("Ningun dato");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			res.setResultado(999);
		} finally {			
			liberaRecursos(cs, rs, con);
		}
		
		return res;
		
	}

	public ResultadoSpGespofin correoInicioProcesoInicioDia() {
		System.out.println("DaoImpSqlServer.correoInicioProcesoInicioDia()");
		
		ConexionBD con = new ConexionBD();
		CallableStatement cs = null;
		ResultSet rs = null;
		ResultadoSpGespofin res = new ResultadoSpGespofin();
		
		try {
			
			
			cs = con.getCon().prepareCall("{ call sp_WKL_Correo_Inicio_Proc_Ini_Dia }");
			rs = cs.executeQuery();
			
			if(rs.next()) {
				res.setResultado(rs.getInt(1));
				System.out.println(rs.getInt(1));
				
			}else {
				System.out.println("Ningun dato");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			res.setResultado(999);
		} finally {			
			liberaRecursos(cs, rs, con);
		}
		
		return res;
		
	}

	public ResultadoSpGespofin creaConversores() {
		System.out.println("DaoImpSqlServer.creaConversores()");
		
		ConexionBD con = new ConexionBD();
		CallableStatement cs = null;
		ResultSet rs = null;
		ResultadoSpGespofin res = new ResultadoSpGespofin();
		
		try {
			
			
			cs = con.getCon().prepareCall("{ call sp_WKL_CREA_CONVERSORES }");
			rs = cs.executeQuery();
			
			if(rs.next()) {
				res.setResultado(rs.getInt(1));
				System.out.println(rs.getInt(1));
				
			}else {
				System.out.println("Ningun dato");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			res.setResultado(999);
		} finally {			
			liberaRecursos(cs, rs, con);
		}
		
		return res;
		
	}

	public ResultadoSpGespofin creaParaFecInicioDia() {
		System.out.println("DaoImpSqlServer.creaParaFecInicioDia()");
		
		ConexionBD con = new ConexionBD();
		CallableStatement cs = null;
		ResultSet rs = null;
		ResultadoSpGespofin res = new ResultadoSpGespofin();
		
		try {
			
			
			cs = con.getCon().prepareCall("{ call sp_WKL_Crea_Para_Fec_Inicio_Dia }");
			rs = cs.executeQuery();
			
			if(rs.next()) {
				res.setResultado(rs.getInt(1));
				System.out.println(rs.getInt(1));
				
			}else {
				System.out.println("Ningun dato");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			res.setResultado(999);
		} finally {			
			liberaRecursos(cs, rs, con);
		}
		
		return res;
		
	}

	public ResultadoSpGespofin descargaPatrimonioEfectivo() {
		System.out.println("DaoImpSqlServer.descargaPatrimonioEfectivo()");
		
		ConexionBD con = new ConexionBD();
		CallableStatement cs = null;
		ResultSet rs = null;
		ResultadoSpGespofin res = new ResultadoSpGespofin();
		
		try {
			
			
			cs = con.getCon().prepareCall("{ call sp_WKL_Descarga_Patrim_Efectivo }");
			rs = cs.executeQuery();
			
			if(rs.next()) {
				res.setResultado(rs.getInt(1));
				System.out.println(rs.getInt(1));
				
			}else {
				System.out.println("Ningun dato");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			res.setResultado(999);
		} finally {			
			liberaRecursos(cs, rs, con);
		}
		
		return res;
		
	}
	
	public void liberaRecursos(CallableStatement cs, ResultSet rs,
			ConexionBD con) {
		try {
			if(cs != null)
				cs.close();
			if(rs != null)
				rs.close();
			con.desconectar();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		
	}

	public void imprimeLogSp(String mensajes) {
		String[] mensaje = mensajes.split(";");
		
		for (String element : mensaje) {
			System.out.println(element);
			
		}
	}
	

}
