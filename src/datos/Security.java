package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que gestiona la seguridad de acceso a la aplicación.
 */
public class Security extends ConeccionBD {
    private static String puesto;

    /**
     * Método para obtener el puesto de un empleado basado en su cédula.
     *
     * @param cedula Cédula del empleado.
     * @return Puesto del empleado.
     */
    public static String Seguridad(String cedula) {
        Security conn = new Security();
        Connection con = conn.getConnection();
        if (con != null) {
            try {
                String Consulta = "select puesto from empleado WHERE (upper(cedula) like upper('%'|| ? ||'%'))";
                PreparedStatement st = con.prepareStatement(Consulta);
                st.setString(1, cedula);
                ResultSet result = st.executeQuery();
                while (result.next()) {
                    puesto = result.getString(1);
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
        return puesto;
    }

    /**
     * Método para obtener el puesto actual.
     *
     * @return Puesto actual.
     */
    public static String ComprobarPuesto() {
        return puesto;
    }
}
