package com.captaciones.persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;

public class ConsultasDAO {

	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@10.110.1.54:1522:orawpor";
	private static final String DB_CONNECTION_APD2 = "jdbc:oracle:thin:@10.110.1.54:1522:orawapd2";
	private static final String DB_CONNECTION_QA = "jdbc:oracle:thin:@10.110.1.128:1521:orawqa";
	
	private static final String DB_USER = "CAP_ADMIN";
	private static final String DB_PASSWORD = "CAP_ADMIN";
	private static final String DB_USER_APD2 = "CAP_EXP";
	private static final String DB_PASSWORD_APD2 = "CAP_EXP";
	private static final String DB_USER_QA = "POR_EXP";
	private static final String DB_PASSWORD_QA = "POREXP";

	
	private static Connection getDBConnection(String baseDatos) throws Exception {
		System.err.println("Consultando : " + baseDatos + "\n");
		
		Connection dbConnection = null;

		try {

			Class.forName(DB_DRIVER); // Create to the heap, Oracle driver on D:\10g\jdbc\lib\classes12.jar

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

		try {
			if("APD2".equals(baseDatos)){
				
				dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
			}else if("ORAW".equals(baseDatos)){
			
				dbConnection = DriverManager.getConnection(DB_CONNECTION_APD2, DB_USER_APD2, DB_PASSWORD_APD2);
			
			}else if("QA".equals(baseDatos)){
			
				dbConnection = DriverManager.getConnection(DB_CONNECTION_QA, DB_USER_QA, DB_PASSWORD_QA);
			
			}else{
				throw new Exception("Debe mencionar que base de datos consultar");
			}
			
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		return dbConnection;

	}
	
	public static void consultaTasas()
			throws Exception {

		Connection dbConnection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		String getDBUSERCursorSql = "{call CAP_SP_CON_TASAS_DEPOSITO(?,?,?,?,?,?,?)}";
		//CAP_SP_CON_TASAS_DEPOSITO('20160509',0,10,0.0,'MSD,0')
		//CAP_SP_CON_TASAS_DEPOSITO('20160819',13,32,0.0,'MSD,0')
//		CAP_SP_CON_TASAS_DEPOSITO('20161014',13, 7, 0.0, 'EJ1, 0')
		
		
		try {

			dbConnection = getDBConnection("APD2"); 
			callableStatement = dbConnection.prepareCall(getDBUSERCursorSql);

			callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
			callableStatement.setString(2, "20161014");
			callableStatement.setLong(3, 13);
			callableStatement.setInt(4, 7);
			callableStatement.setFloat(5, 0.0f);
			callableStatement.setString(6, "EJ1");
			callableStatement.setInt(7, 0);

			// execute getDBUSERCursor store procedure
			callableStatement.executeQuery();

			// get cursor and cast it to ResultSet
			rs = (ResultSet) callableStatement.getObject(1);

			while (rs.next()) {
				String idTramo = rs.getString("ID_TRAMO");
				String status = rs.getString("STATUS");
				String glosaStatus = rs.getString("GLOSA_STATUS");
				String tasaMinima = rs.getString("tasaMinima");
				String tasaMaxima = rs.getString("tasaMaxima");
				String tasaSugerida = rs.getString("tasaSugerida");
				String tasaPizarra = rs.getString("tasaPizarra");
				String tasaCampana = rs.getString("tasaCampana");
				String tasaMensualMinima = rs.getString("tasaMensualMinima");
				String tasaMensualMaxima = rs.getString("tasaMensualMaxima");
				String tasaMensualSugerida = rs.getString("tasaMensualSugerida");
				String tasaMensualPizarra = rs.getString("tasaMensualPizarra");
				String tasaMensualCampana = rs.getString("tasaMensualCampana");

				System.out.println("ID_TRAMO : " + idTramo);
				System.out.println("STATUS : " + status);
				System.out.println("GLOSA_STATUS : " + glosaStatus);				
				System.out.println("tasaMinima : " + tasaMinima );
				System.out.println("tasaMaxima : " + tasaMaxima );
				System.out.println("tasaSugerida : " + tasaSugerida );
				System.out.println("tasaPizarra : " + tasaPizarra );
				System.out.println("tasaCampana : " + tasaCampana );
				System.out.println("tasaMensualMinima : " + tasaMensualMinima );
				System.out.println("tasaMensualMaxima : " + tasaMensualMaxima );
				System.out.println("tasaMensualSugerida : " + tasaMensualSugerida );
				System.out.println("tasaMensualPizarra : " + tasaMensualPizarra );
				System.out.println("tasaMensualCampana : " + tasaMensualCampana );
				
				System.out.println();
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (rs != null) {
				rs.close();
			}

			if (callableStatement != null) {
				callableStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}

	}
	
	
}
