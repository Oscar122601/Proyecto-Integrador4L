package application;

import java.sql.SQLException;

import datos.CRUDEmpleado;
import datos.Security;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Controlador para la vista de generación de empleados.
 */
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

    /**
     * Constructor de la clase.
     */
    public GenerarEmpleadoController() {
        this.CRUDEmpleado = new CRUDEmpleado();
    }

    /**
     * Método para manejar el evento de clic en el botón de generar empleado.
     * @param event El evento del ratón.
     * @throws SQLException Si hay un error en la ejecución de la consulta SQL.
     */
    @FXML
    public void ClickGenerarEmpleado(MouseEvent event) throws SQLException {
        String cedula = CedulaTxt.getText();
        String puesto = PuestoTxt.getText();
        String nombre = NombreTxt.getText();
        String apellido = ApellidoTxt.getText();
        String telefono = TelefonoTxt.getText();
        String direccion = DireccionTxt.getText();
        boolean data1 = CRUDEmpleado.Crear(cedula, puesto, nombre, apellido, telefono, direccion);
        CedulaTxt.clear();
        PuestoTxt.clear();
        NombreTxt.clear();
        ApellidoTxt.clear();
        TelefonoTxt.clear();
        DireccionTxt.clear();
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
