package application;

import java.sql.SQLException;

import datos.CRUDEmpleado;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GenerarEmpleadoController {
	@FXML
	private TextField CedulaTxt;
	@FXML
	private TextField NombreTxt;
	@FXML
	private TextField ApellidoTxt;
	@FXML
	private TextField TelefonoTxt;
	@FXML
	private TextField DireccionTxt;
	@FXML
	private Button GenerarEmpleadoBtn;
	@FXML
	private TextField PuestoTxt;
	@FXML
	private Button VolverBtn;
	private CRUDEmpleado CRUDEmpleado;
	public GenerarEmpleadoController() {
        this.CRUDEmpleado = new CRUDEmpleado();}
	// Event Listener on Button[#GenerarEmpleadoBtn].onMouseClicked
	@FXML
	public void ClickGenerarEmpleado(MouseEvent event) throws SQLException {
		// TODO Autogenerated
		String cedula = CedulaTxt.getText();
		String puesto = PuestoTxt.getText();
		String nombre = NombreTxt.getText();
		String apellido = ApellidoTxt.getText();
		String telefono = TelefonoTxt.getText();
		String direccion = DireccionTxt.getText();
		boolean data1 = CRUDEmpleado.CrearEmpleado(cedula, puesto, nombre, apellido, telefono, direccion);
        CedulaTxt.clear();
        PuestoTxt.clear();
        NombreTxt.clear();
        ApellidoTxt.clear();
        TelefonoTxt.clear();
        DireccionTxt.clear();}
	public void ClickVolver(MouseEvent event) {
		// TODO Autogenerated
		CargarLoginAdmin LG = new CargarLoginAdmin((Stage)this.VolverBtn.getScene().getWindow());}}
