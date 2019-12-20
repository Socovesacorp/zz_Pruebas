package mantenedorCategoria
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.ResultSetMetaData
import java.sql.Statement

import com.kms.katalon.core.annotation.Keyword

import internal.GlobalVariable

public class corroborarInsersion {
	private static Connection connectionRepositorioPI = null;
	private static Connection connection = null;


	//KeywordLogger log = new KeywordLogger()
	/**
	 * Open and return a connection to database
	 * @param dataFile absolute file path
	 * @return an instance of java.sql.Connection
	 */

	//Establishing a connection to the DataBase

	@Keyword
	def connectDB(String url, String dbname, String port, String username, String password){

		//Load driver class for your specific database type
		String conn = "jdbc:sqlserver://" + url + ":" + port + ";databaseName=" + dbname +";encrypt=false;trustServerCertificate=False"
		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		connection = DriverManager.getConnection(conn, username, password)
		return connection
	}

	/**
	 * GetCategoriaID
	 * @param to Katalon test object
	 */
	@Keyword

	def GetCategoriaID() {
		String queryString = "select CategoriaSolicitudId from CategoriaSolicitud where Descr = 'categoria prueba katalon'";
		Statement stm = connection.createStatement()

		ResultSet rs = stm.executeQuery(queryString)

		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		String columnValue = "";
		String fila = '';
		while (rs.next()) {
			fila = '';
			for (int i = 1; i <= columnsNumber; i++) {
				columnValue = rs.getInt(i);
				if (i > 1) fila = fila + " | ";
				fila = fila + rsmd.getColumnName(i) + " " + columnValue ;
			}

		}
		GlobalVariable.idCategoria = columnValue ;
	}


	/**
	 * GetNombreCategoria
	 * @param to Katalon test object
	 */
	@Keyword

	def GetNombreCategoria() {
		int idCategoria = GlobalVariable.idCategoria;
		String queryString = "select Descr from CategoriaSolicitud where CategoriaSolicitudId = "+idCategoria;
		Statement stm = connection.createStatement()

		ResultSet rs = stm.executeQuery(queryString)

		ResultSetMetaData rsmd = rs.getMetaData();
		int columnsNumber = rsmd.getColumnCount();
		String columnValue = "";
		String fila = '';
		while (rs.next()) {
			fila = '';
			for (int i = 1; i <= columnsNumber; i++) {
				columnValue = rs.getString(i);
				if (i > 1) fila = fila + " | ";
				fila = fila + rsmd.getColumnName(i) + " " + columnValue ;
			}

		}
		GlobalVariable.nombreCategoria = columnValue.toString() ;
	}
}