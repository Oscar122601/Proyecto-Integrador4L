package application;

import java.net.URL;
import java.util.ResourceBundle;

import datos.CRUDProducto;
import datos.Producto;
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
 * Controlador para la vista del buscador de productos.
 */
public class BuscadorProductoController implements Initializable {
    
    // Componentes de la interfaz gráfica
    @FXML private Button BuscarBtn;
    @FXML private TextField IdTxt;
    @FXML private TextField NombreTxt;
    @FXML private TableView<Producto> ProductoTable;
    @FXML private TableColumn<Producto, String> IdColumn;
    @FXML private TableColumn<Producto, String> NombreColumn;
    @FXML private TableColumn<Producto, String> StockColumn;
    @FXML private TableColumn<Producto, String> DescripcionColumn;
    @FXML private TableColumn<Producto, String> PrecioColumn;
    @FXML private Button VolverBtn;
    
    // Lista observable para los productos
    private ObservableList<Producto> producto = FXCollections.observableArrayList();
    
    // Objeto para realizar operaciones CRUD en la base de datos de productos
    private CRUDProducto CRUDProducto;
    
    /**
     * Constructor de la clase.
     */
    public BuscadorProductoController() {
        this.CRUDProducto = new CRUDProducto();
    }
    
    /**
     * Método que se ejecuta al hacer clic en el botón "Buscar".
     */
    @FXML
    public void ClickBuscar(MouseEvent event) {
        String id = IdTxt.getText();
        String nombre = NombreTxt.getText();
        
        // Borra los elementos existentes en la tabla
        this.ProductoTable.getItems().clear();
        
        // Realiza la búsqueda y actualiza la tabla con los resultados
        ObservableList<Producto> info = FXCollections.observableArrayList(CRUDProducto.Mostrar(id, nombre));
        this.ProductoTable.setItems(info);
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
        ProductoTable.setEditable(true);
        NombreColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        StockColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        DescripcionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        PrecioColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        this.CRUDProducto = new CRUDProducto();
        
        // Configura las columnas de la tabla
        this.IdColumn.setCellValueFactory(new PropertyValueFactory<Producto, String>("id"));
        this.NombreColumn.setCellValueFactory(new PropertyValueFactory<Producto, String>("nombre"));
        this.StockColumn.setCellValueFactory(new PropertyValueFactory<Producto, String>("stock"));
        this.DescripcionColumn.setCellValueFactory(new PropertyValueFactory<Producto, String>("descripcion"));
        this.PrecioColumn.setCellValueFactory(new PropertyValueFactory<Producto, String>("precio"));
        
        ProductoTable.setItems(this.producto);
        
        // Configura los eventos de edición para permitir la edición de los detalles del producto en la tabla
        IdColumn.setOnEditCommit(event -> {
            Producto e = event.getRowValue();
            e.setId(event.getNewValue());
            e.setEditado(true);
        });
        NombreColumn.setOnEditCommit(event -> {
            Producto e = event.getRowValue();
            e.setNombre(event.getNewValue());
            e.setEditado(true);
        });
        StockColumn.setOnEditCommit(event -> {
            Producto e = event.getRowValue();
            e.setStock(event.getNewValue());
            e.setEditado(true);
        });
        DescripcionColumn.setOnEditCommit(event -> {
            Producto e = event.getRowValue();
            e.setDescripcion(event.getNewValue());
            e.setEditado(true);
        });
        PrecioColumn.setOnEditCommit(event -> {
            Producto e = event.getRowValue();
            e.setPrecio(event.getNewValue());
            e.setEditado(true);
        });
    }
}
