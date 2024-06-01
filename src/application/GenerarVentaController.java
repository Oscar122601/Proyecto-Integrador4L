package application;

import java.sql.SQLException;

import datos.CRUDVenta;
import datos.Factura;
import datos.Security;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Controlador para la vista de generación de ventas.
 */
public class GenerarVentaController {
    @FXML
    private TextField ProductoTxt;
    @FXML
    private TextField CedEmpleadoTxt;
    @FXML
    private TextField CedClienteTxt;
    @FXML
    private TextField CantidadTxt;
    @FXML
    private TextField IdTxt;
    @FXML
    private Button GenerarBtn;
    @FXML
    private Button VolverBtn;
    @FXML
    private TextField FechaTxt;
    private CRUDVenta CRUDVenta;

    /**
     * Constructor de la clase.
     */
    public GenerarVentaController() {
        this.CRUDVenta = new CRUDVenta();
    }

    /**
     * Método para manejar el evento de clic en el botón de generar venta.
     * @param event El evento del ratón.
     * @throws SQLException Si ocurre un error durante la operación con la base de datos.
     */
    @FXML
    public void ClickGenerar(MouseEvent event) throws SQLException {
        String producto = ProductoTxt.getText();
        String cedempleado = CedEmpleadoTxt.getText();
        String docnumcliente = CedClienteTxt.getText();
        String cantidad = CantidadTxt.getText();
        String id = IdTxt.getText();
        String fecha = FechaTxt.getText();
        boolean data1 = CRUDVenta.Crear(id, fecha, cedempleado, docnumcliente);
        FacturaController nuevafactura = new FacturaController(id, cantidad, producto, fecha, cedempleado, docnumcliente);
        CargarFactura CF = new CargarFactura((Stage)this.GenerarBtn.getScene().getWindow());
        ProductoTxt.clear();
        CedEmpleadoTxt.clear();
        CedClienteTxt.clear();
        CantidadTxt.clear();
        IdTxt.clear();
        FechaTxt.clear();
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
