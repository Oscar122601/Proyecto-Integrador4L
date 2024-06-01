package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * Controlador para la vista del panel de control de un vendedor.
 */
public class LoginVendedorController {
    @FXML
    private Button ConsultarProductoBtn;
    @FXML
    private Button GenerarClienteBtn;
    @FXML
    private Button GenerarVentaBtn;
    @FXML
    private Button ConsultarClienteBtn;
    @FXML
    private Button ConsultarVentaBtn;

    // Event Listener on Button[#ConsultarProductoBtn].onMouseClicked
    /**
     * Maneja el evento de clic en el botón "Consultar Producto".
     * @param event El evento del ratón.
     */
    @FXML
    public void ClickConsultarProducto(MouseEvent event) {
        // TODO Autogenerated
        CargarBuscadorProducto CBPR = new CargarBuscadorProducto((Stage)this.ConsultarProductoBtn.getScene().getWindow());
    }

    // Event Listener on Button[#GenerarClienteBtn].onMouseClicked
    /**
     * Maneja el evento de clic en el botón "Generar Cliente".
     * @param event El evento del ratón.
     */
    @FXML
    public void ClickGenerarCliente(MouseEvent event) {
        // TODO Autogenerated
        CargarGenerarCliente CGC = new CargarGenerarCliente((Stage)this.GenerarClienteBtn.getScene().getWindow());
    }

    // Event Listener on Button[#GenerarVentaBtn].onMouseClicked
    /**
     * Maneja el evento de clic en el botón "Generar Venta".
     * @param event El evento del ratón.
     */
    @FXML
    public void ClickGenerarVenta(MouseEvent event) {
        // TODO Autogenerated
        CargarGenerarVenta CGV = new CargarGenerarVenta((Stage)this.GenerarVentaBtn.getScene().getWindow());
    }

    // Event Listener on Button[#ConsultarClienteBtn].onMouseClicked
    /**
     * Maneja el evento de clic en el botón "Consultar Cliente".
     * @param event El evento del ratón.
     */
    @FXML
    public void ClickConsultarCliente(MouseEvent event) {
        // TODO Autogenerated
        CargarBuscadorCliente CBC = new CargarBuscadorCliente((Stage)this.ConsultarClienteBtn.getScene().getWindow());
    }

    // Event Listener on Button[#ConsultarVentaBtn].onMouseClicked
    /**
     * Maneja el evento de clic en el botón "Consultar Venta".
     * @param event El evento del ratón.
     */
    @FXML
    public void ClickConsultarVenta(MouseEvent event) {
        // TODO Autogenerated
        CargarBuscadorVenta CBV = new CargarBuscadorVenta((Stage)this.ConsultarVentaBtn.getScene().getWindow());
    }
}
