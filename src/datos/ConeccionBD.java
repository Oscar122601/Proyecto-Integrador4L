package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que maneja la conexión a la base de datos.
 */
public class ConeccionBD {
    private String conectionstr = "jdbc:oracle:thin:@//localhost:1521";
    private String username = "proyectointegrador2";
    private String password = "proyectointegrador2";

    /**
     * Obtiene una conexión a la base de datos.
     * 
     * @return Un objeto {@link Connection} si la conexión es exitosa, de lo contrario, null.
     */
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(this.conectionstr, this.username, this.password);
        } catch (SQLException e) {
            // Maneja la excepción e imprime el stack trace.
            e.printStackTrace();
        }
        return conn;
    }
}
