package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

public class CRUDProducto {
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
	public boolean Crear(String id, String nombre, String stock, String descripcion, String precio) {
	    CRUDProducto conn = new CRUDProducto();
	    Connection connection = conn.getConnection();
	    boolean estado =false;
	    if (connection != null) {
	        try {
	            String Insertar = "INSERT INTO producto VALUES (?, ?, ?, ?, ?)";
	            PreparedStatement preparedStatement = connection.prepareStatement(Insertar);
	            preparedStatement.setString(1, id);
	            preparedStatement.setString(2, nombre);
	            preparedStatement.setString(3, stock);
	            preparedStatement.setString(4, descripcion);
	            preparedStatement.setString(5, precio);
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
	public LinkedList<Producto> Mostrar(String id, String nombre) {
		CRUDProducto conn = new CRUDProducto();
		Connection con = conn.getConnection();
		LinkedList<Producto> producto = new LinkedList<>();
		if (con!=null) {
			try {
				String Consulta = "select * from producto WHERE (upper(id) like upper('%'|| ? ||'%')) or (upper(nombre) like upper('%'|| ? ||'%'))";
				PreparedStatement st = con.prepareStatement(Consulta);
				st.setString(1, id);
				st.setString(2, nombre);
				ResultSet result = st.executeQuery();
				while(result.next()) {
					Producto a = new Producto(result.getString(1),result.getString(2), result.getString(3), result.getString(4),result.getString(5));
					producto.add(a);}
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();}finally {
		            try {
		                con.close();
		            } catch (SQLException e) {
		                e.printStackTrace();}}}
		return producto;}
	public boolean Modificar(Producto producto) {
	    CRUDProducto conn = new CRUDProducto();
	    Connection connection = conn.getConnection();
	    if (connection != null) {
	        try {//Editar Consulta
	            String Modificar = "UPDATE producto SET nombre = ?, stock = ?, descripcion = ?, precio = ? WHERE id = ?";
	            PreparedStatement preparedStatement = connection.prepareStatement(Modificar);
	            preparedStatement.setString(5, producto.getId());
	            preparedStatement.setString(1, producto.getNombre());
	            preparedStatement.setString(2, producto.getStock());
	            preparedStatement.setString(3, producto.getDescripcion());
	            preparedStatement.setString(4, producto.getPrecio());        
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
