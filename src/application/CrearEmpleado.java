package application;
import datos.BD;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrearEmpleado {
    private Connection connection;

    @SuppressWarnings("null")
	public CrearEmpleado(TextField cedulaTxt, TextField puestoTxt, TextField nombreTxt, TextField apellidoTxt, TextField telefonoTxt, TextField direccionTxt){
        BD OracleConnection = null;
		this.connection = OracleConnection.getConnection();
		String cedula = cedulaTxt.getText();
		String puesto = puestoTxt.getText();
		String nombre = nombreTxt.getText();
		String apellido = apellidoTxt.getText();
		String telefono = telefonoTxt.getText();
		String direccion = direccionTxt.getText();

        try {
            String sql = "INSERT INTO empleado (cedula, puesto, nombre, apellido, telefono, direccion) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cedula);
            statement.setString(2, puesto);
            statement.setString(3, nombre);
            statement.setString(4, apellido);
            statement.setString(5, telefono);
            statement.setString(6, direccion);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar errores de la base de datos
        }
    }
}