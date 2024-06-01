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

import datos.CRUDProveedor;
import datos.Proveedor;
import datos.Security;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModificarProveedorController implements Initializable {

    // Elementos de la interfaz de usuario
    @FXML
    private Button BuscarBtn;
    @FXML
    private TextField IdTxt;
    @FXML
    private Button ModificarBtn;
    @FXML
    private TextField NombreTxt;
    @FXML
    private TableView<Proveedor> ProveedorTable;
    @FXML
    private TableColumn<Proveedor, String> IdColumn;
    @FXML
    private TableColumn<Proveedor, String> NombreColumn;
    @FXML
    private TableColumn<Proveedor, String> TelefonoColumn;
    @FXML
    private TableColumn<Proveedor, String> DescripcionColumn;
    @FXML
    private Button VolverBtn;

    // Lista observable para almacenar proveedores
    private ObservableList<Proveedor> proveedor = FXCollections.observableArrayList();
    private CRUDProveedor CRUDProveedor;

    // Constructor
    public ModificarProveedorController() {
        this.CRUDProveedor = new CRUDProveedor();
    }

    // Método que se ejecuta al iniciar el controlador
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Hace que la tabla sea editable
        ProveedorTable.setEditable(true);
        // Configura las celdas de la tabla para ser editables
        IdColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        NombreColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        TelefonoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        DescripcionColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        // Configura las columnas de la tabla
        this.IdColumn.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("id"));
        this.NombreColumn.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("nombre"));
        this.TelefonoColumn.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("telefono"));
        this.DescripcionColumn.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("descripcion"));

        // Establece la lista observable en la tabla
        ProveedorTable.setItems(this.proveedor);

        // Maneja los eventos de edición en las columnas
        IdColumn.setOnEditCommit(event -> {
            Proveedor e = event.getRowValue();
            e.setId(event.getNewValue());
            e.setEditado(true);
        });
        NombreColumn.setOnEditCommit(event -> {
            Proveedor e = event.getRowValue();
            e.setNombre(event.getNewValue());
            e.setEditado(true);
        });
        TelefonoColumn.setOnEditCommit(event -> {
            Proveedor e = event.getRowValue();
            e.setTelefono(event.getNewValue());
            e.setEditado(true);
        });
        DescripcionColumn.setOnEditCommit(event -> {
            Proveedor e = event.getRowValue();
            e.setDescripcion(event.getNewValue());
            e.setEditado(true);
        });
    }

    // Método que se ejecuta al hacer clic en el botón "Buscar"
    @FXML
    public void ClickBuscar(MouseEvent event) {
        // Obtiene los valores de los campos de búsqueda
        String id = IdTxt.getText();
        String nombre = NombreTxt.getText();
        // Limpia la tabla
        this.ProveedorTable.getItems().clear();
        // Realiza una búsqueda y actualiza la tabla con los resultados
        ObservableList<Proveedor> info = FXCollections.observableArrayList(CRUDProveedor.Mostrar(id, nombre));
        this.ProveedorTable.setItems(info);
    }

    // Método que se ejecuta al hacer clic en el botón "Modificar"
    @FXML
    public void ClickModificar(MouseEvent event) {
        // Obtiene el proveedor seleccionado en la tabla
        Proveedor proveedor = ProveedorTable.getSelectionModel().getSelectedItem();
        if (proveedor != null) {
            // Si el proveedor ha sido editado, lo modifica en la base de datos
            if (proveedor.isEditado()) {
                boolean modificar = CRUDProveedor.Modificar(proveedor);
                // Si la modificación es exitosa, marca el proveedor como no editado
                if (modificar) {
                    proveedor.setEditado(false);
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

