package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Clase que maneja las operaciones CRUD para la entidad Empleado.
 */
public class CRUDEmpleado extends ConeccionBD {

    /**
     * Crea un nuevo registro en la tabla empleado.
     *
     * @param cedula Número de cédula del empleado.
     * @param puesto Puesto del empleado.
     * @param nombre Nombre del empleado.
     * @param apellido Apellido del empleado.
     * @param telefono Teléfono del empleado.
     * @param direccion Dirección del empleado.
     * @return true si el registro fue creado exitosamente, false en caso contrario.
     */
    public boolean Crear(String cedula, String puesto, String nombre, String apellido, String telefono, String direccion) {
        CRUDEmpleado conn = new CRUDEmpleado();
        Connection connection = conn.getConnection();
        boolean estado = false;
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
                    e.printStackTrace();
                }
            }
        }
        return estado;
    }

    /**
     * Muestra los registros de la tabla empleado que coinciden con el número de cédula o nombre.
     *
     * @param cedula Número de cédula a buscar.
     * @param nombre Nombre a buscar.
     * @return Lista de empleados que coinciden con los criterios de búsqueda.
     */
    public LinkedList<Empleado> Mostrar(String cedula, String nombre) {
        CRUDEmpleado conn = new CRUDEmpleado();
        Connection con = conn.getConnection();
        LinkedList<Empleado> empleado = new LinkedList<>();
        if (con != null) {
            try {
                String Consulta = "SELECT * FROM empleado WHERE (upper(cedula) LIKE upper('%'|| ? ||'%')) OR (upper(nombre) LIKE upper('%'|| ? ||'%'))";
                PreparedStatement st = con.prepareStatement(Consulta);
                st.setString(1, cedula);
                st.setString(2, nombre);
                ResultSet result = st.executeQuery();
                while (result.next()) {
                    Empleado a = new Empleado(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getString(5), result.getString(6));
                    empleado.add(a);
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
        return empleado;
    }

    /**
     * Modifica un registro existente en la tabla empleado.
     *
     * @param empleado Objeto Empleado con los datos actualizados.
     * @return true si el registro fue actualizado exitosamente, false en caso contrario.
     */
    public boolean Modificar(Empleado empleado) {
        CRUDEmpleado conn = new CRUDEmpleado();
        Connection connection = conn.getConnection();
        if (connection != null) {
            try {
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
                }
            }
        }
        return true;
    }

    /**
     * Elimina un registro de la tabla empleado.
     *
     * @param cedula Número de cédula del empleado a eliminar.
     * @return true si el registro fue eliminado exitosamente, false en caso contrario.
     */
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
                }
            }
        }
        return false;
    }
}
