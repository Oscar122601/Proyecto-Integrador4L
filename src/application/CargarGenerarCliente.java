package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CargarGenerarCliente {
	public CargarGenerarCliente(Stage st) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/vista/GenerarCliente.fxml"));
			Scene sc = new Scene(root);
			st.setScene(sc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
