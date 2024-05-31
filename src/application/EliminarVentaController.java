package application;

import datos.CRUDVenta;
import datos.Security;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EliminarVentaController {
    @FXML
    private Button EliminarBtn;
    @FXML
    private TextField IdTxt;
    @FXML
    private Button VolverBtn;
	private CRUDVenta CRUDVenta;
    public EliminarVentaController() {
        this.CRUDVenta = new CRUDVenta();}
    @FXML
    void ClickEliminar(MouseEvent event) {
    	String id = IdTxt.getText();
		boolean data1 = CRUDVenta.Eliminar(id);
		IdTxt.clear();}
    @FXML
    public void ClickVolver(MouseEvent event) {
		// TODO Autogenerated
		String puesto = Security.ComprobarPuesto().toUpperCase();
		if (puesto.equals("ADMIN")) {
			CargarLoginAdmin LA = new CargarLoginAdmin((Stage)this.VolverBtn.getScene().getWindow());}
		else if (puesto.equals("GERENTE")) {
			CargarLoginGerente LG = new CargarLoginGerente((Stage)this.VolverBtn.getScene().getWindow());}
		else if (puesto.equals("VENDEDOR")) {
			CargarLoginVendedor LV = new CargarLoginVendedor((Stage)this.VolverBtn.getScene().getWindow());}}}
