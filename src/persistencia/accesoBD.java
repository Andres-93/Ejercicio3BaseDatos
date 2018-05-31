package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class accesoBD {

	private String driver;
	private String url;
	
	public accesoBD() {
		this.driver = "org.sqlite.JDBC";
		this.url = "jdbc:sqlite:dbSQLite/Pilotos.db";
	}
	
	public Connection getConexion() 
			throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url);
		System.out.println("Conexión establecida");
		return con;
	}
	
	public void desconectar(Connection con) throws SQLException {
        con.close();
   
	}
	
}
