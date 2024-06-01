package application;

import datos.CRUDCliente;
import datos.Security;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Controlador para la vista de generación de clientes.
 */
public class GenerarClienteController {
    @FXML
    private TextField NumeroTxt;
    @FXML
    private TextField TipoTxt;
    @FXML
    private TextField NombreTxt;
    @FXML
    private TextField ApellidoTxt;
    @FXML
    private TextField TelefonoTxt;
    @FXML
    private TextField DireccionTxt;
    @FXML
    private Button GenerarBtn;
    @FXML
    private Button VolverBtn;
    private CRUDCliente CRUDCliente;

    /**
     * Constructor de la clase.
     */
    public GenerarClienteController() {
        this.CRUDCliente = new CRUDCliente();
    }

    /**
     * Método para manejar el evento de clic en el botón de generar.
     * @param event El evento del ratón.
     */
    @FXML
    public void ClickGenerar(MouseEvent event) {
        String numero = NumeroTxt.getText();
        String tipo = TipoTxt.getText();
        String nombre = NombreTxt.getText();
        String apellido = ApellidoTxt.getText();
        String telefono = TelefonoTxt.getText();
        String direccion = DireccionTxt.getText();
        boolean data1 = CRUDCliente.Crear(numero, tipo, nombre, direccion, telefono, apellido);
        NumeroTxt.clear();
        TipoTxt.clear();
        NombreTxt.clear();
        ApellidoTxt.clear();
        TelefonoTxt.clear();
        DireccionTxt.clear();
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
