package application;

import datos.Factura;
import datos.Security;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controlador para la vista de facturas.
 */
public class FacturaController implements Initializable{

    @FXML
    private TableColumn<Factura, String> CantidadColumn;

    @FXML
    private TableColumn<Factura, String> CedClienteColumn;

    @FXML
    private TableColumn<Factura, String> CedEmpleadoColumn;

    @FXML
    private TableColumn<Factura, String> FechaColumn;

    @FXML
    private TableColumn<Factura, String> IdColumn;

    @FXML
    private TableColumn<Factura, String> ProductoColumn;

    @FXML
    private TableView<Factura> FacturaTable;

    @FXML
    private Button VolverBtn;

    @FXML
    private Button MostrarBtn;

    @FXML
    private String id;
    private String cantidad;
    private String producto;
    private String fecha;
    private String cedempleado;
    private String cedcliente;
    private Factura Factura;

    /**
     * Constructor de la clase.
     */
    public FacturaController(String id, String cantidad, String producto, String fecha, String cedempleado, String cedcliente) {
        this.id = id;
        this.cantidad = cantidad;
        this.producto = producto;
        this.fecha = fecha;
        this.cedempleado = cedempleado;
        this.cedcliente = cedcliente;
    }

    /**
     * Método para mostrar la factura.
     * @param event El evento del ratón.
     */
    void ClickMostrar(MouseEvent event) {    
        this.FacturaTable.getItems().clear();
        Factura nuevafactura = new Factura(id, cantidad, producto, fecha, cedempleado, cedcliente);
        ObservableList<Factura> info = FXCollections.observableArrayList(Factura.Mostrar(nuevafactura));
        this.FacturaTable.setItems(info);
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

    /**
     * Método de inicialización.
     * @param arg0 La URL inicializable.
     * @param arg1 Los recursos inicializables.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        FacturaTable.setEditable(true);
        IdColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        CantidadColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ProductoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        CedClienteColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        FechaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        CedEmpleadoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.Factura = new Factura(id, cantidad, producto, fecha, cedempleado, cedcliente);
        this.IdColumn.setCellValueFactory(new PropertyValueFactory<Factura, String>("id"));
        this.CantidadColumn.setCellValueFactory(new PropertyValueFactory<Factura, String>("cantidad"));
        this.ProductoColumn.setCellValueFactory(new PropertyValueFactory<Factura, String>("producto"));
        this.FechaColumn.setCellValueFactory(new PropertyValueFactory<Factura, String>("fecha"));
        this.CedEmpleadoColumn.setCellValueFactory(new PropertyValueFactory<Factura, String>("cedempleado"));
        this.CedClienteColumn.setCellValueFactory(new PropertyValueFactory<Factura, String>("cedcliente"));
        FacturaTable.setItems((ObservableList<datos.Factura>) this.Factura);
    }
}
