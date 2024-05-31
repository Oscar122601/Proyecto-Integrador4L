package application;

import datos.Security;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class InformeController {
	@FXML
	private TextField ComisionTxt;
	@FXML
	private TextField VentaTotalTxt;
	@FXML
	private TextField ProductoMasTxt;
	@FXML
	private Button VolverBtn;
	@FXML
	private TextField ProductoMenosTxt;
	@FXML
	private TextField VendedorMasTxt;
	@FXML
	private TextField VendedorMenosTxt;

	// Event Listener on Button[#VolverBtn].onMouseClicked
	@FXML
	public void ClickVolver(MouseEvent event) {
		String puesto = Security.ComprobarPuesto().toUpperCase();
		if (puesto.equals("ADMIN")) {
			CargarLoginAdmin LA = new CargarLoginAdmin((Stage)this.VolverBtn.getScene().getWindow());}
		else if (puesto.equals("GERENTE")) {
			CargarLoginGerente LG = new CargarLoginGerente((Stage)this.VolverBtn.getScene().getWindow());}
		else if (puesto.equals("VENDEDOR")) {
			CargarLoginVendedor LV = new CargarLoginVendedor((Stage)this.VolverBtn.getScene().getWindow());}}
}
