package application;

import java.net.URL;
import java.util.ResourceBundle;

import datos.CRUDVenta;
import datos.Security;
import datos.Venta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

/**
 * Controlador para la vista del buscador de ventas.
 */
public class BuscadorVentaController implements Initializable {

    // Componentes de la interfaz gráfica
    @FXML private Button BuscarBtn;
    @FXML private TextField IdTxt;
    @FXML private TextField CedClienteTxt;
    @FXML private TableView<Venta> VentaTable;
    @FXML private TableColumn<Venta, String> IdColumn;
    @FXML private TableColumn<Venta, String> FechaColumn;
    @FXML private TableColumn<Venta, String> CedVendedorColumn;
    @FXML private TableColumn<Venta, String> CedClienteColumn1;
    @FXML private Button VolverBtn;

    // Lista observable para las ventas
    private ObservableList<Venta> venta = FXCollections.observableArrayList();

    // Objeto para realizar operaciones CRUD en la base de datos de ventas
    private CRUDVenta CRUDVenta;

    /**
     * Constructor de la clase.
     */
    public BuscadorVentaController() {
        this.CRUDVenta = new CRUDVenta();
    }

    /**
     * Método que se ejecuta al hacer clic en el botón "Buscar".
     */
    @FXML
    public void ClickBuscar(MouseEvent event) {
        String id = IdTxt.getText();
        String cedcliente = CedClienteTxt.getText();

        // Borra los elementos existentes en la tabla
        this.VentaTable.getItems().clear();

        // Realiza la búsqueda y actualiza la tabla con los resultados
        ObservableList<Venta> info = FXCollections.observableArrayList(CRUDVenta.Mostrar(id, cedcliente));
        this.VentaTable.setItems(info);
    }

    /**
     * Método que se ejecuta al hacer clic en el botón "Volver".
     */
    @FXML
    public void ClickVolver(MouseEvent event) {
        String puesto = Security.ComprobarPuesto().toUpperCase();

        // Carga la pantalla de inicio correspondiente según el puesto del usuario
        if (puesto.equals("ADMIN")) {
            CargarLoginAdmin LA = new CargarLoginAdmin((Stage)this.VolverBtn.getScene().getWindow());
        } else if (puesto.equals("GERENTE")) {
            CargarLoginGerente LG = new CargarLoginGerente((Stage)this.VolverBtn.getScene().getWindow());
        } else if (puesto.equals("VENDEDOR")) {
            CargarLoginVendedor LV = new CargarLoginVendedor((Stage)this.VolverBtn.getScene().getWindow());
        }
    }

    /**
     * Método de inicialización de la interfaz gráfica.
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        VentaTable.setEditable(true);
        IdColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        FechaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        CedVendedorColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        CedClienteColumn1.setCellFactory(TextFieldTableCell.forTableColumn());

        this.CRUDVenta = new CRUDVenta();

        // Configura las columnas de la tabla
        this.IdColumn.setCellValueFactory(new PropertyValueFactory<Venta, String>("id"));
        this.FechaColumn.setCellValueFactory(new PropertyValueFactory<Venta, String>("fecha"));
        this.CedVendedorColumn.setCellValueFactory(new PropertyValueFactory<Venta, String>("CED_EMPLEADO"));
        this.CedClienteColumn1.setCellValueFactory(new PropertyValueFactory<Venta, String>("DOC_NUM_CLIENTE"));

        VentaTable.setItems(this.venta);

        // Configura los eventos de edición para permitir la edición de los detalles de la venta en la tabla
        IdColumn.setOnEditCommit(event -> {
            Venta e = event.getRowValue();
            e.setId(event.getNewValue());
            e.setEditado(true);
        });
        FechaColumn.setOnEditCommit(event -> {
            Venta e = event.getRowValue();
            e.setFecha(event.getNewValue());
            e.setEditado(true);
        });
        CedVendedorColumn.setOnEditCommit(event -> {
            Venta e = event.getRowValue();
            e.setCedulaEmpleado(event.getNewValue());
            e.setEditado(true);
        });
        CedClienteColumn1.setOnEditCommit(event -> {
            Venta e = event.getRowValue();
            e.setDocNumCliente(event.getNewValue());
            e.setEditado(true);
        });
    }
}
