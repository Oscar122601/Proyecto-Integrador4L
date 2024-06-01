package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Clase que maneja las operaciones CRUD para la entidad Producto.
 */
public class CRUDProducto extends ConeccionBD {
    
    /**
     * Crea un nuevo registro en la tabla producto.
     *
     * @param id ID del producto.
     * @param nombre Nombre del producto.
     * @param stock Stock del producto.
     * @param descripcion Descripción del producto.
     * @param precio Precio del producto.
     * @return true si el registro fue creado exitosamente, false en caso contrario.
     */
    public boolean Crear(String id, String nombre, String stock, String descripcion, String precio) {
        CRUDProducto conn = new CRUDProducto();
        Connection connection = conn.getConnection();
        boolean estado = false;
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
                    e.printStackTrace();
                }
            }
        }
        return estado;
    }

    /**
     * Muestra los registros de la tabla producto que coinciden con el ID o nombre.
     *
     * @param id ID del producto a buscar.
     * @param nombre Nombre del producto a buscar.
     * @return Lista de productos que coinciden con los criterios de búsqueda.
     */
    public LinkedList<Producto> Mostrar(String id, String nombre) {
        CRUDProducto conn = new CRUDProducto();
        Connection con = conn.getConnection();
        LinkedList<Producto> producto = new LinkedList<>();
        if (con != null) {
            try {
                String Consulta = "SELECT * FROM producto WHERE (upper(id) LIKE upper('%'|| ? ||'%')) OR (upper(nombre) LIKE upper('%'|| ? ||'%'))";
                PreparedStatement st = con.prepareStatement(Consulta);
                st.setString(1, id);
                st.setString(2, nombre);
                ResultSet result = st.executeQuery();
                while (result.next()) {
                    Producto a = new Producto(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5));
                    producto.add(a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return producto;
    }

    /**
     * Modifica un registro existente en la tabla producto.
     *
     * @param producto Objeto Producto con los datos actualizados.
     * @return true si el registro fue actualizado exitosamente, false en caso contrario.
     */
    public boolean Modificar(Producto producto) {
        CRUDProducto conn = new CRUDProducto();
        Connection connection = conn.getConnection();
        if (connection != null) {
            try {
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
                }
            }
        }
        return true;
    }

    /**
     * Elimina un registro de la tabla producto.
     *
     * @param id ID del producto a eliminar.
     * @return true si el registro fue eliminado exitosamente, false en caso contrario.
     */
    public boolean Eliminar(String id) {
        CRUDProducto conn = new CRUDProducto();
        Connection connection = conn.getConnection();
        if (connection != null) {
            try {
                String Eliminar = "DELETE FROM producto WHERE id = ?";
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
                }
            }
        }
        return false;
    }
}
