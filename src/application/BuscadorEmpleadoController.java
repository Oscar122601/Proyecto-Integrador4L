package application;

import java.net.URL;
import java.util.ResourceBundle;

import datos.CRUDEmpleado;
import datos.Empleado;
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
 * Controlador para la vista del buscador de empleados.
 */
public class BuscadorEmpleadoController implements Initializable {
    
    // Componentes de la interfaz gráfica
    @FXML private Button BuscarBtn;
    @FXML private TextField CedulaTxt;
    @FXML private TextField NombreTxt;
    @FXML private TableView<Empleado> EmpleadoTable;
    @FXML private TableColumn<Empleado, String> CedulaColumn;
    @FXML private TableColumn<Empleado, String> PuestoColumn;
    @FXML private TableColumn<Empleado, String> NombreColumn;
    @FXML private TableColumn<Empleado, String> ApellidoColumn;
    @FXML private TableColumn<Empleado, String> TelefonoColumn;
    @FXML private TableColumn<Empleado, String> DireccionColumn;
    @FXML private Button VolverBtn;
    
    // Lista observable para los empleados
    private ObservableList<Empleado> empleado = FXCollections.observableArrayList();
    
    // Objeto para realizar operaciones CRUD en la base de datos de empleados
    private CRUDEmpleado CRUDEmpleado;
    
    /**
     * Constructor de la clase.
     */
    public BuscadorEmpleadoController() {
        this.CRUDEmpleado = new CRUDEmpleado();
    }
    
    /**
     * Método que se ejecuta al hacer clic en el botón "Buscar".
     */
    @FXML
    public void ClickBuscar(MouseEvent event) {
        String cedula = CedulaTxt.getText();
        String nombre = NombreTxt.getText();
        
        // Borra los elementos existentes en la tabla
        this.EmpleadoTable.getItems().clear();
        
        // Realiza la búsqueda y actualiza la tabla con los resultados
        ObservableList<Empleado> info = FXCollections.observableArrayList(CRUDEmpleado.Mostrar(cedula, nombre));
        this.EmpleadoTable.setItems(info);
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
        EmpleadoTable.setEditable(true);
        CedulaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        PuestoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        NombreColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ApellidoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        TelefonoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        DireccionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        
        this.CRUDEmpleado = new CRUDEmpleado();
        
        // Configura las columnas de la tabla
        this.CedulaColumn.setCellValueFactory(new PropertyValueFactory<Empleado, String>("cedula"));
        this.PuestoColumn.setCellValueFactory(new PropertyValueFactory<Empleado, String>("puesto"));
        this.NombreColumn.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nombre"));
        this.ApellidoColumn.setCellValueFactory(new PropertyValueFactory<Empleado, String>("apellido"));
        this.TelefonoColumn.setCellValueFactory(new PropertyValueFactory<Empleado, String>("telefono"));
        this.DireccionColumn.setCellValueFactory(new PropertyValueFactory<Empleado, String>("direccion"));
        
        EmpleadoTable.setItems(this.empleado);
        
        // Configura los eventos de edición para permitir la edición de los detalles del empleado en la tabla
        CedulaColumn.setOnEditCommit(event -> {
            Empleado e = event.getRowValue();
            e.setCedula(event.getNewValue());
            e.setEditado(true);
        });
        PuestoColumn.setOnEditCommit(event -> {
            Empleado e = event.getRowValue();
            e.setPuesto(event.getNewValue());
            e.setEditado(true);
        });
        NombreColumn.setOnEditCommit(event -> {
            Empleado e = event.getRowValue();
            e.setNombre(event.getNewValue());
            e.setEditado(true);
        });
        ApellidoColumn.setOnEditCommit(event -> {
            Empleado e = event.getRowValue();
            e.setApellido(event.getNewValue());
            e.setEditado(true);
        });
        TelefonoColumn.setOnEditCommit(event -> {
            Empleado e = event.getRowValue();
            e.setTelefono(event.getNewValue());
            e.setEditado(true);
        });
        DireccionColumn.setOnEditCommit(event -> {
            Empleado e = event.getRowValue();
            e.setDireccion(event.getNewValue());
            e.setEditado(true);
        });
    }
}
