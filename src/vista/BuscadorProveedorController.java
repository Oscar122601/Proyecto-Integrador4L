package vista;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class BuscadorProveedorController {
	@FXML
	private Button BuscarBtn;
	@FXML
	private TextField IdTxt;
	@FXML
	private TextField NombreTxt;
	@FXML
	private TableView ProveedorTable;
	@FXML
	private TableColumn IdColumn;
	@FXML
	private TableColumn NombreColumn;
	@FXML
	private TableColumn TelefonoColumn;
	@FXML
	private TableColumn DescripcionColumn;
	private Button VolverBtn;

	// Event Listener on Button[#BucarBtn].onMouseClicked
	@FXML
	public void ClickBuscar(MouseEvent event) {
		// TODO Autogenerated
	}
	public void ClickVolver(MouseEvent event) {
		// TODO Autogenerated
		CargarLoginAdmin LG = new CargarLoginAdmin((Stage)this.VolverBtn.getScene().getWindow());
	}
}
