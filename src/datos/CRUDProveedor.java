package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class CRUDProveedor {
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
	public boolean Crear(String id, String nombre, String telefono, String descripcion) {
	    CRUDProveedor conn = new CRUDProveedor();
	    Connection connection = conn.getConnection();
	    boolean estado =false;
	    if (connection != null) {
	        try {
	            String Insertar = "INSERT INTO proveedor VALUES (?, ?, ?, ?)";
	            PreparedStatement preparedStatement = connection.prepareStatement(Insertar);
	            preparedStatement.setString(1, id);
	            preparedStatement.setString(2, nombre);
	            preparedStatement.setString(3, telefono);
	            preparedStatement.setString(4, descripcion);
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
	public LinkedList<Proveedor> Mostrar(String id, String nombre) {
		CRUDProveedor conn = new CRUDProveedor();
		Connection con = conn.getConnection();
		LinkedList<Proveedor> proveedor = new LinkedList<>();
		if (con!=null) {
			try {
				String Consulta = "select * from proveedor WHERE (upper(id) like upper('%'|| ? ||'%')) or (upper(nombre) like upper('%'|| ? ||'%'))";
				PreparedStatement st = con.prepareStatement(Consulta);
				st.setString(1, id);
				st.setString(2, nombre);
				ResultSet result = st.executeQuery();
				while(result.next()) {
					Proveedor a = new Proveedor(result.getString(1),result.getString(2), result.getString(3), result.getString(4));
					proveedor.add(a);}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();}finally {
		            try {
		                con.close();
		            } catch (SQLException e) {
		                e.printStackTrace();}}}
		return proveedor;}
	public boolean Modificar(Proveedor proveedor) {
		CRUDProveedor conn = new CRUDProveedor();
	    Connection connection = conn.getConnection();
	    if (connection != null) {
	        try {//Editar Consulta
	            String Modificar = "UPDATE proveedor SET nombre = ?, telefono = ?, descripcion = ? WHERE id = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(Modificar);
	            preparedStatement.setString(4, proveedor.getId());
	            preparedStatement.setString(1, proveedor.getNombre());;
	            preparedStatement.setString(2, proveedor.getTelefono());
	            preparedStatement.setString(3, proveedor.getDescripcion());        
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