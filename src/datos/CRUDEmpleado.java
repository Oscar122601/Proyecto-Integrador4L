package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class CRUDEmpleado {
	private String conectionstr = "jdbc:oracle:thin:@//localhost:1521";
	private String username = "proyectointegrador2";
	private String password = "proyectointegrador2";
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(this.conectionstr, this.username, this.password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		return conn;}
	public boolean CrearEmpleado(String cedula, String puesto, String nombre, String apellido, String telefono, String direccion) {
	    CRUDEmpleado conn = new CRUDEmpleado();
	    Connection connection = conn.getConnection();
	    boolean estado =false;
	    if (connection != null) {
	        try {
	            String Insertar = "INSERT INTO empleado VALUES (?, ?, ?, ?, ?, ?)";
	            PreparedStatement preparedStatement = connection.prepareStatement(Insertar);
	            preparedStatement.setString(1, cedula);
	            preparedStatement.setString(2, puesto);
	            preparedStatement.setString(3, nombre);
	            preparedStatement.setString(4, apellido);
	            preparedStatement.setString(5, telefono);
	            preparedStatement.setString(6, direccion);
	            int resultado = preparedStatement.executeUpdate();
                estado = true;         
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();}}}
	    return estado;}	
	public LinkedList<Empleado> MostrarEmpleado(String cedula, String nombre) {
		CRUDEmpleado conn = new CRUDEmpleado();
		Connection con = conn.getConnection();
		LinkedList<Empleado> empleado = new LinkedList<>();
		if (con!=null) {
			try {
				String Consulta = "select * from empleado WHERE (upper(cedula) like upper('%'|| ? ||'%')) or (upper(nombre) like upper('%'|| ? ||'%'))";
				PreparedStatement st = con.prepareStatement(Consulta);
				st.setString(1, cedula);
				st.setString(2, nombre);
				ResultSet result = st.executeQuery();
				while(result.next()) {
					Empleado a = new Empleado(result.getString(1),result.getString(2), result.getString(3), result.getString(4),result.getString(5),result.getString(6));
					empleado.add(a);}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();}finally {
		            try {
		                con.close();
		            } catch (SQLException e) {
		                e.printStackTrace();}}}
		return empleado;}
	public boolean Modificar(Empleado empleado) {
	    CRUDEmpleado conn = new CRUDEmpleado();
	    Connection connection = conn.getConnection();
	    if (connection != null) {
	        try {//Editar Consulta
	            String Modificar = "UPDATE empleado SET puesto = ?, nombre = ?, apellido = ?, telefono = ?, direccion = ? WHERE cedula = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(Modificar);
	            preparedStatement.setString(6, empleado.getCedula());
	            preparedStatement.setString(1, empleado.getPuesto());
	            preparedStatement.setString(2, empleado.getNombre());
	            preparedStatement.setString(3, empleado.getApellido());
	            preparedStatement.setString(4, empleado.getTelefono());
	            preparedStatement.setString(5, empleado.getDireccion());        
	            int rowsUpdated = preparedStatement.executeUpdate();
	            return rowsUpdated > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }}}
		return true;}}