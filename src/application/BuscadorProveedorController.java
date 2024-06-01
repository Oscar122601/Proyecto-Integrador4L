package application;

import java.net.URL;
import java.util.ResourceBundle;

import datos.CRUDProveedor;
import datos.Proveedor;
import datos.Security;
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
 * Controlador para la vista del buscador de proveedores.
 */
public class BuscadorProveedorController implements Initializable {
    
    // Componentes de la interfaz gráfica
    @FXML private Button BuscarBtn;
    @FXML private TextField IdTxt;
    @FXML private TextField NombreTxt;
    @FXML private TableView<Proveedor> ProveedorTable;
    @FXML private TableColumn<Proveedor, String> IdColumn;
    @FXML private TableColumn<Proveedor, String> NombreColumn;
    @FXML private TableColumn<Proveedor, String> TelefonoColumn;
    @FXML private TableColumn<Proveedor, String> DescripcionColumn;
    @FXML private Button VolverBtn;
    
    // Lista observable para los proveedores
    private ObservableList<Proveedor> proveedor = FXCollections.observableArrayList();
    
    // Objeto para realizar operaciones CRUD en la base de datos de proveedores
    private CRUDProveedor CRUDProveedor;
    
    /**
     * Constructor de la clase.
     */
    public BuscadorProveedorController() {
        this.CRUDProveedor = new CRUDProveedor();
    }
    
    /**
     * Método que se ejecuta al hacer clic en el botón "Buscar".
     */
    @FXML
    public void ClickBuscar(MouseEvent event) {
        String id = IdTxt.getText();
        String nombre = NombreTxt.getText();
        
        // Borra los elementos existentes en la tabla
        this.ProveedorTable.getItems().clear();
        
        // Realiza la búsqueda y actualiza la tabla con los resultados
        ObservableList<Proveedor> info = FXCollections.observableArrayList(CRUDProveedor.Mostrar(id, nombre));
        this.ProveedorTable.setItems(info);
    }
    
    /**
     * Método que se ejecuta al hacer clic en el botón "Volver".
     */
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
        ProveedorTable.setEditable(true);
        IdColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        NombreColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        TelefonoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        DescripcionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        this.CRUDProveedor = new CRUDProveedor();
        
        // Configura las columnas de la tabla
        this.IdColumn.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("id"));
        this.NombreColumn.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("nombre"));
        this.TelefonoColumn.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("telefono"));
        this.DescripcionColumn.setCellValueFactory(new PropertyValueFactory<Proveedor, String>("descripcion"));
        
        ProveedorTable.setItems(this.proveedor);
        
        // Configura los eventos de edición para permitir la edición de los detalles del proveedor en la tabla
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
}
