package application;

import datos.CRUDCliente;
import datos.Security;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Controlador para la vista de eliminación de clientes.
 */
public class EliminarClienteController {
    @FXML
    private Button EliminarBtn;
    @FXML
    private TextField NumeroTxt;
    @FXML
    private Button VolverBtn;
    private CRUDCliente CRUDCliente;
    
    /**
     * Constructor de la clase.
     */
    public EliminarClienteController() {
        this.CRUDCliente = new CRUDCliente();
    }
    
    /**
     * Método para manejar el evento de clic en el botón de eliminar cliente.
     * @param event El evento del ratón.
     */
    @FXML
    void ClickEliminar(MouseEvent event) {
        String numero = NumeroTxt.getText();
        boolean data1 = CRUDCliente.Eliminar(numero);
        NumeroTxt.clear();
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
