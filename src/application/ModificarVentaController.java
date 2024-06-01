package application;

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

import java.net.URL;
import java.util.ResourceBundle;

import datos.CRUDVenta;
import datos.Security;
import datos.Venta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModificarVentaController implements Initializable {

    // Elementos de la interfaz de usuario
    @FXML
    private Button BuscarBtn;
    @FXML
    private TextField IdTxt;
    @FXML
    private TextField CedClienteTxt;
    @FXML
    private TableView<Venta> VentaTable;
    @FXML
    private TableColumn<Venta, String> IdColumn;
    @FXML
    private TableColumn<Venta, String> FechaColumn;
    @FXML
    private TableColumn<Venta, String> CedVendedorColumn;
    @FXML
    private TableColumn<Venta, String> CedClienteColumn;
    @FXML
    private Button VolverBtn;

    // Lista observable para almacenar ventas
    private ObservableList<Venta> venta = FXCollections.observableArrayList();
    private CRUDVenta CRUDVenta;

    // Constructor
    public ModificarVentaController() {
        this.CRUDVenta = new CRUDVenta();
    }

    // Método que se ejecuta al iniciar el controlador
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Hace que la tabla sea editable
        VentaTable.setEditable(true);
        // Configura las celdas de la tabla para ser editables
        IdColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        FechaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        CedVendedorColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        CedClienteColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        // Configura las columnas de la tabla
        this.IdColumn.setCellValueFactory(new PropertyValueFactory<Venta, String>("id"));
        this.FechaColumn.setCellValueFactory(new PropertyValueFactory<Venta, String>("fecha"));
        this.CedVendedorColumn.setCellValueFactory(new PropertyValueFactory<Venta, String>("CED_EMPLEADO"));
        this.CedClienteColumn.setCellValueFactory(new PropertyValueFactory<Venta, String>("DOC_NUM_CLIENTE"));

        // Establece la lista observable en la tabla
        VentaTable.setItems(this.venta);

        // Maneja los eventos de edición en las columnas
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
        CedClienteColumn.setOnEditCommit(event -> {
            Venta e = event.getRowValue();
            e.setDocNumCliente(event.getNewValue());
            e.setEditado(true);
        });
    }

    // Método que se ejecuta al hacer clic en el botón "Buscar"
    @FXML
    public void ClickBuscar(MouseEvent event) {
        // Obtiene los valores de los campos de búsqueda
        String id = IdTxt.getText();
        String cedcliente = CedClienteTxt.getText();
        // Limpia la tabla
        this.VentaTable.getItems().clear();
        // Realiza una búsqueda y actualiza la tabla con los resultados
        ObservableList<Venta> info = FXCollections.observableArrayList(CRUDVenta.Mostrar(id, cedcliente));
        this.VentaTable.setItems(info);
    }

    // Método que se ejecuta al hacer clic en el botón "Modificar"
    @FXML
    public void ClickModificar(MouseEvent event) {
        // Obtiene la venta seleccionada en la tabla
        Venta venta = VentaTable.getSelectionModel().getSelectedItem();
        if (venta != null) {
            // Si la venta ha sido editada, la modifica en la base de datos
            if (venta.isEditado()) {
                boolean modificar = CRUDVenta.Modificar(venta);
                // Si la modificación es exitosa, marca la venta como no editada
                if (modificar) {
                    venta.setEditado(false);
                }
            }
        }
    }

    // Método que se ejecuta al hacer clic en el botón "Volver"
    @FXML
    public void ClickVolver(MouseEvent event) {
        // Obtiene el puesto del usuario actual
        String puesto = Security.ComprobarPuesto().toUpperCase();
        // Carga la interfaz de inicio correspondiente según el puesto del usuario
        if (puesto.equals("ADMIN")) {
            CargarLoginAdmin LA = new CargarLoginAdmin((Stage)this.VolverBtn.getScene().getWindow());
        } else if (puesto.equals("GERENTE")) {
            CargarLoginGerente LG = new CargarLoginGerente((Stage)this.VolverBtn.getScene().getWindow());
        } else if (puesto.equals("VENDEDOR")) {
            CargarLoginVendedor LV = new CargarLoginVendedor((Stage)this.VolverBtn.getScene().getWindow());
        }
    }
}
