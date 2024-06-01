package application;

import datos.CRUDEmpleado;
import datos.Security;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Controlador para la vista de eliminación de empleados.
 */
public class EliminarEmpleadoController {
    @FXML
    private Button EliminarBtn;
    @FXML
    private TextField CedulaTxt;
    @FXML
    private Button VolverBtn;
    private CRUDEmpleado CRUDEmpleado;
    
    /**
     * Constructor de la clase.
     */
    public EliminarEmpleadoController() {
        this.CRUDEmpleado = new CRUDEmpleado();
    }
    
    /**
     * Método para manejar el evento de clic en el botón de eliminar empleado.
     * @param event El evento del ratón.
     */
    @FXML
    void ClickEliminar(MouseEvent event) {
        String cedula = CedulaTxt.getText();
        boolean data1 = CRUDEmpleado.Eliminar(cedula);
        CedulaTxt.clear();
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
