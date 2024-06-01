package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Controlador para la vista de administrador.
 */
public class LoginAdminController {
    @FXML
    private Button GenerarVentaBtn;
    @FXML
    private Button ConsultarVentaBtn;
    @FXML
    private Button ModificarVentaBtn;
    @FXML
    private Button GenerarProductoBtn;
    @FXML
    private Button ConsultarProductoBtn;
    @FXML
    private Button ModificarProductoBtn;
    @FXML
    private Button GenerarEmpleadoBtn;
    @FXML
    private Button InformeBtn;
    @FXML
    private Button ConsultarEmpleadoBtn;
    @FXML
    private Button ModificarEmpleadoBtn;
    @FXML
    private Button GenerarProveedorBtn;
    @FXML
    private Button ConsultarProveedorBtn;
    @FXML
    private Button ModificarProveedorBtn;
    @FXML
    private Button GenerarClienteBtn;
    @FXML
    private Button ConsultarClienteBtn;
    @FXML
    private Button EliminarClienteBtn;
    @FXML
    private Button EliminarEmpleadoBtn;
    @FXML
    private Button EliminarProductoBtn;
    @FXML
    private Button EliminarProveedorBtn;
    @FXML
    private Button EliminarVentaBtn;
    @FXML
    private Button ModificarClienteBtn;

    // Event Listener on Button[#GenerarVentaBtn].onMouseClicked
    /**
     * Maneja el evento de clic en el botón "Generar Venta".
     * @param event El evento del ratón.
     */
    @FXML
    public void ClickGenerarVenta(MouseEvent event) {
        CargarGenerarVenta CGV = new CargarGenerarVenta((Stage)this.GenerarVentaBtn.getScene().getWindow());
    }

    // Event Listener on Button[#ConsultarVentaBtn].onMouseClicked
    // Otros métodos similares para manejar eventos de clic en diferentes botones...

    // Event Listener on Button[#ModificarEliminarVentaBtn].onMouseClicked
    // Otros métodos similares para manejar eventos de clic en diferentes botones...
}
