package application;
import datos.BD;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CRUDEmpleado {
    private Connection connection;

    @SuppressWarnings("null")
	public CRUDEmpleado(TextField cedulaTxt, TextField nombreTxt, TextField apellidoTxt, TextField telefonoTxt, TextField direccionTxt) throws SQLException {
        BD OracleConnection = null;
		this.connection = OracleConnection.getConnection();
    }

    public void Create(String CedulaTxt,String NombreTxt,String ApellidoTxt,int TelefonoTxt,String DireccionTxt, String PuestoTxt) throws SQLException {
    	String sql = "INSERT INTO Person (name, age) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, CedulaTxt);
        statement.setString(2, PuestoTxt);
        statement.setString(3, NombreTxt);
        statement.setString(4, ApellidoTxt);
        statement.setInt(5, TelefonoTxt);
        statement.setString(6, DireccionTxt);
        statement.executeUpdate();
    }
}