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

public class ModificarClienteController implements Initializable {
    // Elementos de la interfaz de usuario
    @FXML
    private Button ModificarBtn;
    @FXML
    private Button BuscarBtn;
    @FXML
    private TextField NumeroTxt;
    @FXML
    private TextField NombreTxt;
    @FXML
    private TableView<Cliente> ClienteTable;
    @FXML
    private TableColumn<Cliente, String> TipoColumn;
    @FXML
    private TableColumn<Cliente, String> NumeroColumn;
    @FXML
    private TableColumn<Cliente, String> NombreColumn;
    @FXML
    private TableColumn<Cliente, String> ApellidoColumn;
    @FXML
    private TableColumn<Cliente, String> DireccionColumn;
    @FXML
    private TableColumn<Cliente, String> TelefonoColumn;
    @FXML
    private Button VolverBtn;

    // Lista observable para almacenar clientes
    private ObservableList<Cliente> cliente = FXCollections.observableArrayList();
    private CRUDCliente CRUDCliente;

    // Constructor
    public ModificarClienteController() {
        this.CRUDCliente = new CRUDCliente();
    }

    // Método que se ejecuta al iniciar el controlador
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Hace que la tabla sea editable
        ClienteTable.setEditable(true);
        // Configura las celdas de la tabla para ser editables
        TipoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        NumeroColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        NombreColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ApellidoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        TelefonoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        DireccionColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        // Configura las columnas de la tabla
        this.TipoColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("doc_tipo"));
        this.NumeroColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("doc_numero"));
        this.NombreColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));
        this.ApellidoColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("apellido"));
        this.TelefonoColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefono"));
        this.DireccionColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("direccion"));

        // Establece la lista observable en la tabla
        ClienteTable.setItems(this.cliente);

        // Maneja los eventos de edición en las columnas
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
            e.setEditado(true);
        });
        TelefonoColumn.setOnEditCommit(event -> {
            Cliente e = event.getRowValue();
            e.setTelefono(event.getNewValue());
            e.setEditado(true);
        });
        DireccionColumn.setOnEditCommit(event -> {
            Cliente e = event.getRowValue();
            e.setDireccion(event.getNewValue());
            e.setEditado(true);
        });
    }

    // Método que se ejecuta al hacer clic en el botón "Buscar"
    @FXML
    public void ClickBuscar(MouseEvent event) {
        String numero = NumeroTxt.getText();
        String nombre = NombreTxt.getText();
        // Limpia la tabla
        this.ClienteTable.getItems().clear();
        // Realiza una búsqueda y actualiza la tabla con los resultados
        ObservableList<Cliente> info = FXCollections.observableArrayList(CRUDCliente.Mostrar(numero, nombre));
        this.ClienteTable.setItems(info);
    }

    // Método que se ejecuta al hacer clic en el botón "Modificar"
    @FXML
    public void ClickModificar(MouseEvent event) {
        // Obtiene el cliente seleccionado en la tabla
        Cliente cliente = ClienteTable.getSelectionModel().getSelectedItem();
        if (cliente != null) {
            // Si el cliente ha sido editado, lo modifica en la base de datos
            if (cliente.isEditado()) {
                boolean modificar = CRUDCliente.Modificar(cliente);
                // Si la modificación es exitosa, marca el cliente como no editado
                if (modificar) {
                    cliente.setEditado(false);
                }
            }
        }
    }

    // Método que se ejecuta al hacer clic en el botón "Volver"
    @FXML
    public void ClickVolver(MouseEvent event) {
        // Obtiene el puesto del usuario actual
        String puesto = Security.ComprobarPuesto().toUpperCase();
        // Abre la ventana correspondiente al puesto del usuario
        if (puesto.equals("ADMIN")) {
            CargarLoginAdmin LA = new CargarLoginAdmin((Stage)this.VolverBtn.getScene().getWindow());
        } else if (puesto.equals("GERENTE")) {
            CargarLoginGerente LG = new CargarLoginGerente((Stage)this.VolverBtn.getScene().getWindow());
        } else if (puesto.equals("VENDEDOR")) {
            CargarLoginVendedor LV = new CargarLoginVendedor((Stage)this.VolverBtn.getScene().getWindow());
        }
    }
}
