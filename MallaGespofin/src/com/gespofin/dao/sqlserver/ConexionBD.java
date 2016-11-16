package com.gespofin.dao.sqlserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.gespofin.cargaprops.CargadorPropiedades;

public class ConexionBD {

	private Connection con;
	private String usuario;
	private String pass;
	private String baseDeDatos =";databaseName=";
	private String servidor = "jdbc:sqlserver://";
	private CargadorPropiedades props;
	
	public ConexionBD() {
				
		try {

			props = new CargadorPropiedades();
			this.usuario = props.getPropiedad("usr");
			this.pass = props.getPropiedad("pass");
			this.baseDeDatos = this.baseDeDatos + props.getPropiedad("basededatos");
			this.servidor = this.servidor + props.getPropiedad("servidor") + this.baseDeDatos;	
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(servidor, usuario, pass);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public void desconectar() {
		try {
			this.con.close();
		} catch (SQLException e) {
			System.err.println("Fallo la desconexion de la bd");
			e.printStackTrace();
		}
	}
	
	
}
