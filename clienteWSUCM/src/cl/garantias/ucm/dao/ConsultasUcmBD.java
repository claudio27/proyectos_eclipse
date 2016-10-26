package cl.garantias.ucm.dao;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.turbine.om.peer.BasePeer;
import org.apache.turbine.util.Log;
import org.apache.turbine.util.db.pool.DBConnection;

import com.FHTServlet.modules.util.Constants;

import cl.garantias.ucm.dto.ArchivoVO;
import oracle.jdbc.driver.OracleResultSet;
import oracle.sql.BLOB;



public class ConsultasUcmBD {
	
	public List<Integer> consultaFoliosGarantias(int nroGarantia, int nroEvento) {
		Log.debug("ConsultasUcmBD.consultaFoliosGarantias("+ nroGarantia +", "+ nroEvento + ")");
		
		DBConnection dbConnGrt = null;
		ResultSet result = null;		
		List<Integer> foliosDocumentos = new ArrayList<Integer>();
		
		try {

			dbConnGrt = BasePeer.beginTransaction(Constants.BASE_GAR);			
			String query = "select i.ixi_fol folio "
					+ "from tt_evt e join tt_ixi i "
					+ "on (e.evt_cnr_ncn = i.ixi_ncn) "
					+ "where e.evt_nev = ? and e.evt_cnr_ncn = ? "
					+ "and e.evt_fpr <= i.ixi_fch";
			
			PreparedStatement stmt = dbConnGrt.prepareStatement(query);
			stmt.setString(1, String.valueOf(nroEvento));
			stmt.setString(2, String.valueOf(nroGarantia));
			result = stmt.executeQuery();

			Log.debug("Folios : " );
			while (result.next()) {				
				Log.debug("folio : " + result.getInt(1) );
				 foliosDocumentos.add( new Integer(result.getString("folio")) );				
			}		

			BasePeer.commitTransaction(dbConnGrt);
			
		} catch (SQLException e) {
			Log.error("ConsultasBaseDatos.consultaFoliosGarantias",e);			
		} catch (Exception e) {
			Log.error("ConsultasBaseDatos.consultaFoliosGarantias",e);
		} finally {
			if (dbConnGrt != null) {
				try {
					dbConnGrt.close();
				} catch (SQLException e) {
					Log.error("ConsultasBaseDatos.consultaFoliosGarantias", e);
				}
			}
		}

		return foliosDocumentos;
	}
	
	public ArchivoVO consultaArchivoPorFolio(int folio, int numEvento) {
		Log.debug("ConsultasUcmBD.consultaArchivoPorFolio("+ folio +", "+ numEvento +")");
		
		DBConnection dbConnGrt = null;
		OracleResultSet result = null;		
		ArchivoVO archivo = null;
		
		try {

			dbConnGrt = BasePeer.beginTransaction(Constants.BASE_GAR);

			String sql = "SELECT "
					+ "b.blb_blb bin, "
					+ "REPLACE(i.ixi_dsg, ' ', '_') nombre_archivo, "
					+ "i.ixi_tpi tipo, "
					+ "upper(ltrim(e.evt_cli,'0')) rut, "
					+ "e.evt_ncl nombre_cliente, "
					+ "TO_CHAR(i.ixi_fch, 'YYYY-MM-DD HH24:MI:SS')  fecha_documento, "
					+ "e.evt_cnr_ncn num_garantia, "
					+ "e.evt_dir direccion, i.IXI_SEQ cod_abogado_tasador, "
					+ "i.ixi_fol folio_documento, "
					+ "E.EVT_NEJ nombre_ejecutivo, "
					+ "GRT_PAC_FUNCIONES_UCM.GRT_FUN_GET_RUTS_RELACIONADOS(e.evt_nev) ruts_relacionados, "
					+ "GRT_PAC_FUNCIONES_UCM.GRT_FUN_GET_ABOGADO(e.evt_nev) nombre_abogado, "
					+ "GRT_PAC_FUNCIONES_UCM.GRT_FUN_GET_TASADOR(e.evt_nev) nombre_tasador "
					+ "FROM tt_blb b "
					+ "JOIN tt_ixi i "
					+ "ON (b.blb_fol = i.ixi_fol) "
					+ "JOIN tt_evt e "
					+ "ON (e.evt_cnr_ncn = i.ixi_ncn) "
					+ "WHERE i.ixi_fol = ? "
					+ "and e.evt_nev = ? "
					;
	
//			Log.debug("query : " + sql );
			
			PreparedStatement stmt = dbConnGrt.prepareStatement(sql);
			stmt.setInt(1, folio);
			stmt.setInt(2, numEvento);
			result = (OracleResultSet) stmt.executeQuery();

			Log.debug("Resultado : " );
			
			while (result.next()) {				
				Log.debug("blob length : " + result.getBlob("bin").length() );
				Log.debug("nombre_archivo : " + result.getString("nombre_archivo") );
				Log.debug("tipo : " + result.getString("tipo") );

				byte[] bits = null;
				BLOB blb = BLOB.createTemporary(dbConnGrt.getConnection(), false, 1);

				blb.open(0);
				bits = dumpBlob(result.getBLOB("bin"));
				blb.close();
				
				archivo = new ArchivoVO(
						bits,
						result.getString("nombre_archivo"),
						result.getString("tipo"),
						result.getString("rut"),
						result.getString("nombre_cliente"),
						result.getString("fecha_documento"),
						result.getInt("num_garantia"),
						result.getString("direccion"),
						result.getInt("cod_abogado_tasador"),						
						result.getString("ruts_relacionados"),
						result.getInt("folio_documento"),
						result.getString("nombre_ejecutivo"),
						result.getString("nombre_abogado"),
						result.getString("nombre_tasador")
						);

				Log.debug("Nuevo archivoVO creado bytes : " + bits.length );
				
			}
			
			BasePeer.commitTransaction(dbConnGrt);
			
		} catch (SQLException e) {
			Log.error("ConsultasBaseDatos.consultaArchivoPorFolio",e);			
		} catch (Exception e) {
			Log.error("ConsultasBaseDatos.consultaArchivoPorFolio",e);
		} finally {
			if (dbConnGrt != null) {
				try {
					dbConnGrt.close();
				} catch (SQLException e) {
					Log.error("ConsultasBaseDatos.consultaArchivoPorFolio", e);
				}
			}
		}

		return archivo;
	}

	public void consultaBasica() {
		Log.debug("ConsultasUcmBD.consultaBasica");
		
		DBConnection dbConnGrt = null;
		ResultSet result = null;

		try {

			dbConnGrt = BasePeer.beginTransaction(Constants.BASE_GAR);
			String sql = "SELECT * FROM tt_ixi WHERE ixi_fol = ?";
			PreparedStatement stmt = dbConnGrt.prepareStatement(sql);
			stmt.setString(1, "97999");
			result = stmt.executeQuery();

			while (result.next()) {
				Log.debug("resultado : " + result.getString(1) + ", " + result.getString(2));
			}

			BasePeer.commitTransaction(dbConnGrt);
		} catch (SQLException e) {
			Log.error("",e);
			
		} catch (Exception e) {
			Log.error("",e);
		} finally {
			if (dbConnGrt != null) {
				try {
					dbConnGrt.close();
				} catch (SQLException e) {
					Log.error("", e);
				}
			}
		}

	}
	
	
	public int actualizaIdUCM(int idDocUCM, int folio) {
		Log.debug("ConsultasUcmBD.actulizaIdUCM(" + idDocUCM + ", " + folio + ")");

		DBConnection dbConnGrt = null;
		int result = 0;
		PreparedStatement preStmt = null;

		try {

			dbConnGrt = BasePeer.beginTransaction(Constants.BASE_GAR);

			String query = "UPDATE TT_IXI SET ID_UCM = ? WHERE IXI_FOL = ?";
			Log.debug("query : "  + query );
			
			preStmt = dbConnGrt.prepareStatement(query);
			preStmt.setInt(1, idDocUCM);
			preStmt.setInt(2, folio);
			result = preStmt.executeUpdate();
			preStmt.close();
			

			Log.debug("result update : "  + result );
			
			if(result == 1) {
				Log.debug("update folio "+ folio +" [ok] ");
			}
			
			BasePeer.commitTransaction(dbConnGrt);
			return result;
			
		} catch (SQLException e) {
			Log.error("actulizaIdUCM 1",e);
			return result;
		} catch (Exception e) {
			Log.error("actulizaIdUCM 2",e);
			return result;
		} finally {
			if (dbConnGrt != null) {
				try {
					dbConnGrt.close();
				} catch (SQLException e) {
					Log.error("No se pudo cerrar conexion", e);
				}
			}
		}
		
		
	}
	
	
	public boolean consultaSiExisteEnUCM(int folio) {
		Log.debug("ConsultasUcmBD.consultaSiExisteEnUCM("+ folio +")");		
		
		DBConnection dbConnGrt = null;
		ResultSet result = null;
		boolean existe = false;

		try {

			dbConnGrt = BasePeer.beginTransaction(Constants.BASE_GAR);
			String sql = "SELECT count(*) FROM tt_ixi WHERE ixi_fol = ? AND id_ucm IS NOT NULL";
			PreparedStatement stmt = dbConnGrt.prepareStatement(sql);
			stmt.setString(1, String.valueOf(folio));
			result = stmt.executeQuery();

			while (result.next()) {
				
				Log.debug("resultado : " + result.getInt(1) );				
				if(result.getInt(1) == 1){
					existe = true;
				}
			}		

			BasePeer.commitTransaction(dbConnGrt);
			
		} catch (SQLException e) {
			Log.error("",e);			
		} catch (Exception e) {
			Log.error("",e);
		} finally {
			if (dbConnGrt != null) {
				try {
					dbConnGrt.close();
				} catch (SQLException e) {
					Log.error("", e);
				}
			}
		}

		return existe;
	}
	
	public int consultaIdDocumento(int folio) {
		Log.debug("ConsultasUcmBD.consultaIdDocumento("+ folio +")");
		
		DBConnection dbConnGrt = null;
		ResultSet result = null;
		int idDocumento = 0;

		try {

			dbConnGrt = BasePeer.beginTransaction(Constants.BASE_GAR);
			String sql = "SELECT id_ucm FROM tt_ixi WHERE ixi_fol = ? AND ROWNUM = 1";
			PreparedStatement stmt = dbConnGrt.prepareStatement(sql);
			stmt.setString(1, String.valueOf(folio));
			result = stmt.executeQuery();

			while (result.next()) {				
				Log.debug("resultado : " + result.getInt(1) );
				idDocumento = result.getInt(1);				
			}		

			BasePeer.commitTransaction(dbConnGrt);
			
		} catch (SQLException e) {
			Log.error("",e);			
		} catch (Exception e) {
			Log.error("",e);
		} finally {
			if (dbConnGrt != null) {
				try {
					dbConnGrt.close();
				} catch (SQLException e) {
					Log.error("", e);
				}
			}
		}

		return idDocumento;
	}
	
	private static byte[] dumpBlob(BLOB blob) throws Exception {
		InputStream isRead = blob.getBinaryStream();
		int lenBuf = (int) blob.length();
		byte[] buffer = new byte[lenBuf];
		isRead.read(buffer);
		isRead.close();
		return buffer;
	}
	
}
