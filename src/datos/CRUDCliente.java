package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class CRUDCliente extends ConeccionBD{
	
	public boolean Crear(String documentonumero, String documentotipo, String nombre, String direccion, String telefono, String apellido) {
	    CRUDCliente conn = new CRUDCliente();
	    Connection connection = conn.getConnection();
	    boolean estado =false;
	    if (connection != null) {
	        try {
	            String Insertar = "INSERT INTO cliente VALUES (?, ?, ?, ?, ?, ?)";
	            PreparedStatement preparedStatement = connection.prepareStatement(Insertar);
	            preparedStatement.setString(1, documentonumero);
	            preparedStatement.setString(2, documentotipo);
	            preparedStatement.setString(3, nombre);
	            preparedStatement.setString(6, apellido);
	            preparedStatement.setString(5, telefono);
	            preparedStatement.setString(4, direccion);
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
	public LinkedList<Cliente> Mostrar(String doc_numero, String nombre) {
		CRUDCliente conn = new CRUDCliente();
		Connection con = conn.getConnection();
		LinkedList<Cliente> cliente = new LinkedList<>();
		if (con!=null) {
			try {
				String Consulta = "select * from cliente WHERE (upper(doc_numero) like upper('%'|| ? ||'%')) or (upper(nombre) like upper('%'|| ? ||'%'))";
				PreparedStatement st = con.prepareStatement(Consulta);
				st.setString(1, doc_numero);
				st.setString(2, nombre);
				ResultSet result = st.executeQuery();
				while(result.next()) {
					Cliente a = new Cliente(result.getString(1),result.getString(2), result.getString(3), result.getString(4),result.getString(5),result.getString(6));
					cliente.add(a);}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();}finally {
		            try {
		                con.close();
		            } catch (SQLException e) {
		                e.printStackTrace();}}}
		return cliente;}
	public boolean Modificar(Cliente cliente) {
	    CRUDCliente conn = new CRUDCliente();
	    Connection connection = conn.getConnection();
	    if (connection != null) {
	        try {//Editar Consulta
	            String Modificar = "UPDATE cliente SET doc_tipo = ?, nombre = ?, direccion = ?, telefono = ?, apellido = ? WHERE doc_numero = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(Modificar);
	            preparedStatement.setString(6, cliente.getdocumentonumero());
	            preparedStatement.setString(1, cliente.getdocumentotipo());
	            preparedStatement.setString(2, cliente.getNombre());
	            preparedStatement.setString(5, cliente.getApellido());
	            preparedStatement.setString(4, cliente.getTelefono());
	            preparedStatement.setString(3, cliente.getDireccion());        
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
	public boolean Eliminar(String documentonumero) {
			CRUDProducto conn = new CRUDProducto();
		    Connection connection = conn.getConnection();
		    if (connection != null) {
		        try {
		            String Eliminar = "DELETE FROM cliente WHERE documentonumero = ?";
		            PreparedStatement preparedStatement = connection.prepareStatement(Eliminar);
		            preparedStatement.setString(1, documentonumero);
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