package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class BuscadorVentaController {
	@FXML
	private Button BuscarBtn;
	@FXML
	private TextField FechaTxt;
	@FXML
	private TextField CedClienteTxt;
	@FXML
	private TableView ProductoTable;
	@FXML
	private TableColumn IdColumn;
	@FXML
	private TableColumn FechaColumn;
	@FXML
	private TableColumn ProductoColumn;
	@FXML
	private TableColumn CantidadColumn;
	@FXML
	private TableColumn CedVendedorColumn;
	@FXML
	private TableColumn CedClienteColumn1;
	@FXML
	private Button VolverBtn;

	// Event Listener on Button[#BuscarBtn].onMouseClicked
	@FXML
	public void ClickBuscar(MouseEvent event) {
		// TODO Autogenerated
	}
	// Event Listener on Button[#VolverBtn].onMouseClicked
	@FXML
	public void ClickVolver(MouseEvent event) {
		// TODO Autogenerated
		CargarLoginAdmin LG = new CargarLoginAdmin((Stage)this.VolverBtn.getScene().getWindow());
	}
}