package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Security {
	private String conectionstr = "jdbc:oracle:thin:@//localhost:1521";
	private String username = "proyectointegrador2";
	private String password = "proyectointegrador2";
	private static String puesto;
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(this.conectionstr, this.username, this.password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		return conn;}
	public static String Seguridad(String cedula) {
		Security conn = new Security();
		Connection con = conn.getConnection();
		if (con!=null) {
			try {
				String Consulta = "select puesto from empleado WHERE (upper(cedula) like upper('%'|| ? ||'%'))";
				PreparedStatement st = con.prepareStatement(Consulta);
				st.setString(1, cedula);
				ResultSet result = st.executeQuery();
				while(result.next()) {
				puesto = result.getString(1);}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();}finally {
		            try {
		                con.close();
		            } catch (SQLException e) {
		                e.printStackTrace();}}}
		return puesto;}}
