package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Security extends ConeccionBD{
	private static String puesto;
	
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
		return puesto;}
	public static String ComprobarPuesto(){
		return puesto;}}
	
