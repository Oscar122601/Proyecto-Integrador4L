package application;

import datos.CRUDProveedor;
import datos.Security;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Controlador para la vista de generación de proveedores.
 */
public class GenerarProveedorController {
    @FXML
    private TextField DescripcionTxt;
    @FXML
    private Button GenerarBtn;
    @FXML
    private TextField IdTxt;
    @FXML
    private TextField NombreTxt;
    @FXML
    private TextField TelefonoTxt;
    @FXML
    private Button VolverBtn;
    private CRUDProveedor CRUDProveedor;

    /**
     * Constructor de la clase.
     */
    public GenerarProveedorController() {
        this.CRUDProveedor = new CRUDProveedor();
    }

    /**
     * Método para manejar el evento de clic en el botón de generar proveedor.
     * @param event El evento del ratón.
     */
    @FXML
    void ClickGenerar(MouseEvent event) {
        String id = IdTxt.getText();
        String nombre = NombreTxt.getText();
        String telefono = TelefonoTxt.getText();
        String descripcion = DescripcionTxt.getText();
        boolean data1 = CRUDProveedor.Crear(id,nombre,telefono, descripcion);
        IdTxt.clear();
        NombreTxt.clear();
        TelefonoTxt.clear();
        DescripcionTxt.clear();
    }

    /**
     * Método para manejar el evento de clic en el botón de volver.
     * @param event El evento del ratón.
     */
    @FXML
    void ClickVolver(MouseEvent event) {
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
