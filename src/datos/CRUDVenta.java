package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class CRUDVenta extends ConeccionBD{
	public boolean Crear(String id, String fecha, String cedempleado, String docnumcliente) {
	    CRUDVenta conn = new CRUDVenta();
	    Connection connection = conn.getConnection();
	    boolean estado =false;
	    if (connection != null) {
	        try {
	            String Insertar = "INSERT INTO venta VALUES (?, ?, ?, ?)";
	            PreparedStatement preparedStatement = connection.prepareStatement(Insertar);
	            preparedStatement.setString(1, id);
	            preparedStatement.setString(2, fecha);
	            preparedStatement.setString(3, cedempleado);
	            preparedStatement.setString(4, docnumcliente);
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
	public LinkedList<Venta> Mostrar(String id, String cedclienteo) {
		CRUDVenta conn = new CRUDVenta();
		Connection con = conn.getConnection();
		LinkedList<Venta> venta = new LinkedList<>();
		if (con!=null) {
			try {
				String Consulta = "select * from venta WHERE (upper(id) like upper('%'|| ? ||'%')) or (upper(DOC_NUM_CLIENTE) like upper('%'|| ? ||'%'))";
				PreparedStatement st = con.prepareStatement(Consulta);
				st.setString(1, id);
				st.setString(2, cedclienteo);
				ResultSet result = st.executeQuery();
				while(result.next()) {
					Venta a = new Venta(result.getString(1),result.getString(2), result.getString(3), result.getString(4));
					venta.add(a);}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();}finally {
		            try {
		                con.close();
		            } catch (SQLException e) {
		                e.printStackTrace();}}}
		return venta;}
	public boolean Modificar(Venta venta) {
		CRUDVenta conn = new CRUDVenta();
	    Connection connection = conn.getConnection();
	    if (connection != null) {
	        try {//Editar Consulta
	            String Modificar = "UPDATE proveedor SET fecha = ?, CED_EMPLEADO = ?, DOC_NUM_CLIENTE = ? WHERE id = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(Modificar);
	            preparedStatement.setString(4, venta.getId());
	            preparedStatement.setString(1, venta.getFecha());;
	            preparedStatement.setString(2, venta.getCedulaEmpleado());
	            preparedStatement.setString(3, venta.getDocNumCliente());        
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
	public boolean Eliminar(String id) {
		CRUDVenta conn = new CRUDVenta();
	    Connection connection = conn.getConnection();
	    if (connection != null) {
	        try {
	            String Eliminar = "DELETE FROM venta WHERE id = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(Eliminar);
	            preparedStatement.setString(1, id);
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
