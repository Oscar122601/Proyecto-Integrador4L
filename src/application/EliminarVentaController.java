package application;

import datos.CRUDVenta;
import datos.Security;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Controlador para la vista de eliminación de ventas.
 */
public class EliminarVentaController {
    @FXML
    private Button EliminarBtn;
    @FXML
    private TextField IdTxt;
    @FXML
    private Button VolverBtn;
    private CRUDVenta CRUDVenta;
    
    /**
     * Constructor de la clase.
     */
    public EliminarVentaController() {
        this.CRUDVenta = new CRUDVenta();
    }
    
    /**
     * Método para manejar el evento de clic en el botón de eliminar venta.
     * @param event El evento del ratón.
     */
    @FXML
    void ClickEliminar(MouseEvent event) {
        String id = IdTxt.getText();
        boolean data1 = CRUDVenta.Eliminar(id);
        IdTxt.clear();
    }
    
    /**
     * Método para manejar el evento de clic en el botón de volver.
     * @param event El evento del ratón.
     */
    @FXML
    public void ClickVolver(MouseEvent event) {
        String puesto = Security.ComprobarPuesto().toUpperCase();
        if (puesto.equals("ADMIN")) {
            CargarLoginAdmin LA = new CargarLoginAdmin((Stage)this.VolverBtn.getScene().getWindow());
        } else if (puesto.equals("GERENTE")) {
            CargarLoginGerente LG = new CargarLoginGerente((Stage)this.VolverBtn.getScene().getWindow());
        } else if (puesto.equals("VENDEDOR")) {
            CargarLoginVendedor LV = new CargarLoginVendedor((Stage)this.VolverBtn.getScene().getWindow());
        }
    }
}
