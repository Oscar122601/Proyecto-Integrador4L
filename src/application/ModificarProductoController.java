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

import datos.CRUDProducto;
import datos.Producto;
import datos.Security;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ModificarProductoController implements Initializable {

    // Elementos de la interfaz de usuario
    @FXML
    private TextField IdTxt;
    @FXML
    private TextField NombreTxt;
    @FXML
    private Button ModificarBtn;
    @FXML
    private Button BuscarBtn;
    @FXML
    private TableView<Producto> ProductoTable;
    @FXML
    private TableColumn<Producto, String> IdColumn;
    @FXML
    private TableColumn<Producto, String> NombreColumn;
    @FXML
    private TableColumn<Producto, String> StockColumn;
    @FXML
    private TableColumn<Producto, String> DescripcionColumn;
    @FXML
    private TableColumn<Producto, String> PrecioColumn;
    @FXML
    private Button VolverBtn;

    // Lista observable para almacenar productos
    private ObservableList<Producto> producto = FXCollections.observableArrayList();
    private CRUDProducto CRUDProducto;

    // Constructor
    public ModificarProductoController() {
        this.CRUDProducto = new CRUDProducto();
    }

    // Método que se ejecuta al iniciar el controlador
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Hace que la tabla sea editable
        ProductoTable.setEditable(true);
        // Configura las celdas de la tabla para ser editables
        IdColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        NombreColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        StockColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        DescripcionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        PrecioColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        // Configura las columnas de la tabla
        this.IdColumn.setCellValueFactory(new PropertyValueFactory<Producto, String>("id"));
        this.NombreColumn.setCellValueFactory(new PropertyValueFactory<Producto, String>("nombre"));
        this.StockColumn.setCellValueFactory(new PropertyValueFactory<Producto, String>("stock"));
        this.DescripcionColumn.setCellValueFactory(new PropertyValueFactory<Producto, String>("descripcion"));
        this.PrecioColumn.setCellValueFactory(new PropertyValueFactory<Producto, String>("precio"));

        // Establece la lista observable en la tabla
        ProductoTable.setItems(this.producto);

        // Maneja los eventos de edición en las columnas
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

    // Método que se ejecuta al hacer clic en el botón "Buscar"
    @FXML
    public void ClickBuscar(MouseEvent event) {
        // Obtiene los valores de los campos de búsqueda
        String id = IdTxt.getText();
        String nombre = NombreTxt.getText();
        // Limpia la tabla
        this.ProductoTable.getItems().clear();
        // Realiza una búsqueda y actualiza la tabla con los resultados
        ObservableList<Producto> info = FXCollections.observableArrayList(CRUDProducto.Mostrar(id, nombre));
        this.ProductoTable.setItems(info);
    }

    // Método que se ejecuta al hacer clic en el botón "Modificar"
    @FXML
    public void ClickModificar(MouseEvent event) {
        // Obtiene el producto seleccionado en la tabla
        Producto producto = ProductoTable.getSelectionModel().getSelectedItem();
        if (producto != null) {
            // Si el producto ha sido editado, lo modifica en la base de datos
            if (producto.isEditado()) {
                boolean modificar = CRUDProducto.Modificar(producto);
                // Si la modificación es exitosa, marca el producto como no editado
                if (modificar) {
                    producto.setEditado(false);
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
