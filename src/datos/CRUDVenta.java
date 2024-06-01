package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Clase que maneja las operaciones CRUD para la entidad Venta.
 */
public class CRUDVenta extends ConeccionBD {

    /**
     * Crea un nuevo registro en la tabla venta.
     *
     * @param id ID de la venta.
     * @param fecha Fecha de la venta.
     * @param cedempleado Cédula del empleado.
     * @param docnumcliente Número de documento del cliente.
     * @return true si el registro fue creado exitosamente, false en caso contrario.
     */
    public boolean Crear(String id, String fecha, String cedempleado, String docnumcliente) {
        CRUDVenta conn = new CRUDVenta();
        Connection connection = conn.getConnection();
        boolean estado = false;
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
                    e.printStackTrace();
                }
            }
        }
        return estado;
    }

    /**
     * Muestra los registros de la tabla venta que coinciden con el ID o número de documento del cliente.
     *
     * @param id ID de la venta a buscar.
     * @param cedclienteo Número de documento del cliente a buscar.
     * @return Lista de ventas que coinciden con los criterios de búsqueda.
     */
    public LinkedList<Venta> Mostrar(String id, String cedclienteo) {
        CRUDVenta conn = new CRUDVenta();
        Connection con = conn.getConnection();
        LinkedList<Venta> venta = new LinkedList<>();
        if (con != null) {
            try {
                String Consulta = "SELECT * FROM venta WHERE (upper(id) LIKE upper('%'|| ? ||'%')) OR (upper(DOC_NUM_CLIENTE) LIKE upper('%'|| ? ||'%'))";
                PreparedStatement st = con.prepareStatement(Consulta);
                st.setString(1, id);
                st.setString(2, cedclienteo);
                ResultSet result = st.executeQuery();
                while (result.next()) {
                    Venta a = new Venta(result.getString(1), result.getString(2), result.getString(3), result.getString(4));
                    venta.add(a);
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
        return venta;
    }

    /**
     * Modifica un registro existente en la tabla venta.
     *
     * @param venta Objeto Venta con los datos actualizados.
     * @return true si el registro fue actualizado exitosamente, false en caso contrario.
     */
    public boolean Modificar(Venta venta) {
        CRUDVenta conn = new CRUDVenta();
        Connection connection = conn.getConnection();
        if (connection != null) {
            try {
                String Modificar = "UPDATE venta SET fecha = ?, CED_EMPLEADO = ?, DOC_NUM_CLIENTE = ? WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(Modificar);
                preparedStatement.setString(4, venta.getId());
                preparedStatement.setString(1, venta.getFecha());
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
                }
            }
        }
        return true;
    }

    /**
     * Elimina un registro de la tabla venta.
     *
     * @param id ID de la venta a eliminar.
     * @return true si el registro fue eliminado exitosamente, false en caso contrario.
     */
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
                }
            }
        }
        return false;
    }
}
