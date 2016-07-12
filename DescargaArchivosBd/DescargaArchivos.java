package com.claudio.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jdbc.driver.OracleResultSet;

/**
 * A servlet that retrieves a file from MySQL database and lets the client
 * downloads the file.
 * 
 * @author www.codejava.net
 */
@WebServlet("/downloadFileServlet")
public class DescargaArchivos extends HttpServlet {

	// size of byte buffer to send file
	private static final int BUFFER_SIZE = 4096;

	// database connection settings
//	private String dbURL = "jdbc:mysql://localhost:3306/FileDB";
//	private String dbUser = "root";
//	private String dbPass = "secret";

//	private String dbURL = "jdbc:oracle:thin:@10.110.1.54:1523:ORALAPD1";
//	private String dbUser = "GRT_ADMIN";
//	private String dbPass = "GRT_ADMIN";
	
	private String dbURL = "jdbc:oracle:thin:@10.110.1.54:1523:ORALAPD1";
	private String dbUser = "GRT_EXP";
	private String dbPass = "GRT_EXP";
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get upload id from URL's parameters
	//	int uploadId = Integer.parseInt(request.getParameter("id"));

		Connection conn = null; // connection to the database

		try {
			// connects to the database
//			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

			// queries the database  ;
			//String sql = "SELECT * FROM files_upload WHERE upload_id = ?";
			String sql = "SELECT * FROM  TT_BLB where blb_fol  = 7473"; // xls 7473
			PreparedStatement statement = conn.prepareStatement(sql);
//			statement.setInt(1, uploadId);
 
			OracleResultSet result = (OracleResultSet)statement.executeQuery();
			if (result.next()) {
				// gets file name and file blob data
				String fileName = result.getString("blb_tpi");
				Blob blob = result.getBlob("blb_blb");
				
				
				InputStream inputStream = blob.getBinaryStream();
//				int fileLength = inputStream.available(); //0 when it reaches the end of the input stream
				int fileLength = (int) blob.length(); //0 when it reaches the end of the input stream
				// parte prueba
				File archivo = new File("D:\\descargado.xls");
				FileOutputStream fos = new FileOutputStream(archivo);
				
				byte[] bufer = new byte[1];
				while(inputStream.read(bufer) > 0){
					fos.write(bufer);
				}
				fos.close();
				
				// fin parte prueba
				
				// inicia descarga
				File fileDownload = new File("D:\\descargado.xls");
				FileInputStream fileIn = new FileInputStream(fileDownload);
				ServletOutputStream outStream = response.getOutputStream();
				
				byte[] outputByte = new byte[fileLength];
				
				while(fileIn.read(outputByte, 0, fileLength) != 1){
					outStream.write(outputByte, 0, fileLength);
				}
				fileIn.close();
				
				// fin descarga
				
				
				
				System.out.println("fileLength = " + fileLength);
				System.out.println("blob.length :: " + blob.length());

				ServletContext context = getServletContext();

				// sets MIME type for the file download
				String mimeType = context.getMimeType(fileName);
				if (mimeType == null) {
					mimeType = "application/octet-stream";
				}

				// set content properties and header attributes for the response
				response.setContentType(mimeType);
				response.setContentLength(fileLength);
				String headerKey = "Content-Disposition";
				String headerValue = String.format("attachment; filename=\"%s\"", fileName + new Date() + ".xls");
				response.setHeader(headerKey, headerValue);

				// writes the file to the client
//				OutputStream outStream = response.getOutputStream();

				byte[] buffer = new byte[BUFFER_SIZE];
				byte[] buffer1 = new byte[1];
				int bytesRead = -1;

//				while ((bytesRead = inputStream.read(buffer)) != -1) {
//					outStream.write(buffer, 0, bytesRead);
//				}

//				while(inputStream.read(buffer,0,4096) != -1){
//					outStream.write(buffer,0,4096);
//				}				
				
//				while(inputStream.read(buffer1) > 0){
//					outStream.write(buffer1);
//					outStream.flush();
//				}
				
				inputStream.close();
				outStream.flush();
				outStream.close();
			} else {
				// no file found
//				response.getWriter().print("File not found for the id: " + "id mula");
				System.out.println("no se encontro el archivo");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
//			response.getWriter().print("SQL Error: " + ex.getMessage());
		} catch (IOException ex) {
			ex.printStackTrace();
//			response.getWriter().print("IO Error: " + ex.getMessage());
		} finally {
			if (conn != null) {
				// closes the database connection
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
		
//		response.setContentType("text/html");
//		PrintWriter pw = response.getWriter();
//		pw.println("<HTML><HEAD><TITLE>Leyendo parámetros</TITLE></HEAD>");
//		pw.println("<BODY BGCOLOR=\"#CCBBAA\">");
//		pw.println("<H2>Leyendo parámetros desde un formulario html</H2><P>");
//		pw.println("<UL>\n");
//		pw.println("Te llamas " + request.getParameter("NOM") + "<BR>");
//		pw.println("y tienes "  + request.getParameter("EDA") + " años<BR>");
//		pw.println("</BODY></HTML>");
//		pw.close();
	}
	
//	  public static void main(String[] args) throws Exception {
//		    Class.forName("oracle.jdbc.driver.OracleDriver");
//		    Connection conn = DriverManager.getConnection(url, username, password);
//
//		    String sql = "SELECT name, description, image FROM pictures ";
//		    PreparedStatement stmt = conn.prepareStatement(sql);
//		    ResultSet resultSet = stmt.executeQuery();
//		    while (resultSet.next()) {
//		      String name = resultSet.getString(1);
//		      String description = resultSet.getString(2);
//		      File image = new File("D:\\java.gif");
//		      FileOutputStream fos = new FileOutputStream(image);
//
//		      byte[] buffer = new byte[1];
//		      InputStream is = resultSet.getBinaryStream(3);
//		      while (is.read(buffer) > 0) {
//		        fos.write(buffer);
//		      }
//		      fos.close();
//		    }
//		    conn.close();
//		  }
	
	
}