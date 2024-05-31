package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class CRUDEmpleado extends ConeccionBD{
	
	public boolean Crear(String cedula, String puesto, String nombre, String apellido, String telefono, String direccion) {
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
	public LinkedList<Empleado> Mostrar(String cedula, String nombre) {
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
		return true;}
	public boolean Eliminar(String cedula) {
		CRUDProducto conn = new CRUDProducto();
	    Connection connection = conn.getConnection();
	    if (connection != null) {
	        try {
	            String Eliminar = "DELETE FROM empleado WHERE cedula = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(Eliminar);
	            preparedStatement.setString(1, cedula);
	            int FilasEliminadas = preparedStatement.executeUpdate();
	            return FilasEliminadas > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                connection.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }}}
	    return false;}}
