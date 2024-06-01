package application;

import java.net.URL;
import java.util.ResourceBundle;

import datos.Cliente;
import datos.Security;
import datos.CRUDCliente;
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
 * Controlador para la vista del buscador de clientes.
 */
public class BuscadorClienteController implements Initializable {
    
    // Componentes de la interfaz gráfica
    @FXML private Button BuscarBtn;
    @FXML private TextField NumeroTxt;
    @FXML private TextField NombreTxt;
    @FXML private TableView<Cliente> ClienteTable;
    @FXML private TableColumn<Cliente, String> TipoColumn;
    @FXML private TableColumn<Cliente, String> NumeroColumn;
    @FXML private TableColumn<Cliente, String> NombreColumn;
    @FXML private TableColumn<Cliente, String> ApellidoColumn;
    @FXML private TableColumn<Cliente, String> DireccionColumn;
    @FXML private TableColumn<Cliente, String> TelefonoColumn;
    @FXML private Button VolverBtn;
    
    // Lista observable para los clientes
    private ObservableList<Cliente> cliente = FXCollections.observableArrayList();
    
    // Objeto para realizar operaciones CRUD en la base de datos de clientes
    private CRUDCliente CRUDCliente;
    
    /**
     * Constructor de la clase.
     */
    public BuscadorClienteController() {
        this.CRUDCliente = new CRUDCliente();
    }
    
    /**
     * Método que se ejecuta al hacer clic en el botón "Buscar".
     */
    @FXML
    public void ClickBuscar(MouseEvent event) {
        String numero = NumeroTxt.getText();
        String nombre = NombreTxt.getText();
        
        // Borra los elementos existentes en la tabla
        this.ClienteTable.getItems().clear();
        
        // Realiza la búsqueda y actualiza la tabla con los resultados
        ObservableList<Cliente> info = FXCollections.observableArrayList(CRUDCliente.Mostrar(numero, nombre));
        this.ClienteTable.setItems(info);
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
    public void initialize(URL arg0, ResourceBundle arg1) {
        ClienteTable.setEditable(true);
        TipoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        NumeroColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        NombreColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ApellidoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        TelefonoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        DireccionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        this.CRUDCliente = new CRUDCliente();
        
        // Configura las columnas de la tabla
        this.TipoColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("doc_tipo"));
        this.NumeroColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("doc_numero"));
        this.NombreColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));
        this.ApellidoColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("apellido"));
        this.TelefonoColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefono"));
        this.DireccionColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("direccion"));
        
        ClienteTable.setItems(this.cliente);
        
        // Configura los eventos de edición para permitir la edición de los detalles del cliente en la tabla
        NumeroColumn.setOnEditCommit(event -> {
            Cliente e = event.getRowValue();
            e.setdocumentonumero(event.getNewValue());
            e.setEditado(true);
        });
        TipoColumn.setOnEditCommit(event -> {
            Cliente e = event.getRowValue();
            e.setdocumentotipo(event.getNewValue());
            e.setEditado(true);
        });
        NombreColumn.setOnEditCommit(event -> {
            Cliente e = event.getRowValue();
            e.setNombre(event.getNewValue());
            e.setEditado(true);
        });
        ApellidoColumn.setOnEditCommit(event -> {
            Cliente e = event.getRowValue();
            e.setApellido(event.getNewValue());
            e
