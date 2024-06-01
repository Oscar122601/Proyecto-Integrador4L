package application;

import datos.CRUDProducto;
import datos.Security;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Controlador para la vista de generación de productos.
 */
public class GenerarProductoController {
    @FXML
    private TextField IdTxt;
    @FXML
    private TextField StockTxt;
    @FXML
    private TextField DescripcionTxt;
    @FXML
    private TextField NombreTxt;
    @FXML
    private TextField ValorTxt;
    @FXML
    private Button GenerarProductoBtn;
    @FXML
    private Button VolverBtn;
    private CRUDProducto CRUDProducto;

    /**
     * Constructor de la clase.
     */
    public GenerarProductoController() {
        this.CRUDProducto = new CRUDProducto();
    }

    /**
     * Método para manejar el evento de clic en el botón de generar producto.
     * @param event El evento del ratón.
     */
    @FXML
    public void ClickGenerarProducto(MouseEvent event) {
        String id = IdTxt.getText();
        String stock = StockTxt.getText();
        String descripcion = DescripcionTxt.getText();
        String nombre = NombreTxt.getText();
        String valor = ValorTxt.getText();
        boolean data1 = CRUDProducto.Crear(id, nombre, stock, descripcion, valor);
        IdTxt.clear();
        StockTxt.clear();
        DescripcionTxt.clear();
        NombreTxt.clear();
        ValorTxt.clear();
    }

    /**
     * Método para manejar el evento de clic en el botón de volver.
     * @param event El evento del ratón.
     */
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
