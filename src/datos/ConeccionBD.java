package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConeccionBD {
	private String conectionstr = "jdbc:oracle:thin:@//localhost:1521";
	private String username = "PROYECTINT";
	private String password = "PROYECTINT";
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(this.conectionstr, this.username, this.password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		return conn;}}
