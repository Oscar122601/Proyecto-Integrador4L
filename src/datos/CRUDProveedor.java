package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Clase que maneja las operaciones CRUD para la entidad Proveedor.
 */
public class CRUDProveedor extends ConeccionBD {
    
    /**
     * Crea un nuevo registro en la tabla proveedor.
     *
     * @param id ID del proveedor.
     * @param nombre Nombre del proveedor.
     * @param telefono Teléfono del proveedor.
     * @param descripcion Descripción del proveedor.
     * @return true si el registro fue creado exitosamente, false en caso contrario.
     */
    public boolean Crear(String id, String nombre, String telefono, String descripcion) {
        CRUDProveedor conn = new CRUDProveedor();
        Connection connection = conn.getConnection();
        boolean estado = false;
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
                    e.printStackTrace();
                }
            }
        }
        return estado;
    }

    /**
     * Muestra los registros de la tabla proveedor que coinciden con el ID o nombre.
     *
     * @param id ID del proveedor a buscar.
     * @param nombre Nombre del proveedor a buscar.
     * @return Lista de proveedores que coinciden con los criterios de búsqueda.
     */
    public LinkedList<Proveedor> Mostrar(String id, String nombre) {
        CRUDProveedor conn = new CRUDProveedor();
        Connection con = conn.getConnection();
        LinkedList<Proveedor> proveedor = new LinkedList<>();
        if (con != null) {
            try {
                String Consulta = "SELECT * FROM proveedor WHERE (upper(id) LIKE upper('%'|| ? ||'%')) OR (upper(nombre) LIKE upper('%'|| ? ||'%'))";
                PreparedStatement st = con.prepareStatement(Consulta);
                st.setString(1, id);
                st.setString(2, nombre);
                ResultSet result = st.executeQuery();
                while (result.next()) {
                    Proveedor a = new Proveedor(result.getString(1), result.getString(2), result.getString(3), result.getString(4));
                    proveedor.add(a);
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
        return proveedor;
    }

    /**
     * Modifica un registro existente en la tabla proveedor.
     *
     * @param proveedor Objeto Proveedor con los datos actualizados.
     * @return true si el registro fue actualizado exitosamente, false en caso contrario.
     */
    public boolean Modificar(Proveedor proveedor) {
        CRUDProveedor conn = new CRUDProveedor();
        Connection connection = conn.getConnection();
        if (connection != null) {
            try {
                String Modificar = "UPDATE proveedor SET nombre = ?, telefono = ?, descripcion = ? WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(Modificar);
                preparedStatement.setString(4, proveedor.getId());
                preparedStatement.setString(1, proveedor.getNombre());
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
                }
            }
        }
        return true;
    }

    /**
     * Elimina un registro de la tabla proveedor.
     *
     * @param id ID del proveedor a eliminar.
     * @return true si el registro fue eliminado exitosamente, false en caso contrario.
     */
    public boolean Eliminar(String id) {
        CRUDProveedor conn = new CRUDProveedor();
        Connection connection = conn.getConnection();
        if (connection != null) {
            try {
                String Eliminar = "DELETE FROM proveedor WHERE id = ?";
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
