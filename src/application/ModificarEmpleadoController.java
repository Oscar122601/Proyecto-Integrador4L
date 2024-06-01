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

public class ModificarEmpleadoController implements Initializable {
    // Elementos de la interfaz de usuario
    @FXML
    private Button ModificarBtn;
    @FXML
    private TextField NombreTxt;
    @FXML
    private TextField ApellidoTxt;
    @FXML
    private TextField CedulaTxt;
    @FXML
    private Button BuscarBtn;
    @FXML
    private TableView<Empleado> EmpleadoTable;
    @FXML
    private TableColumn<Empleado, String> CedulaColumn;
    @FXML
    private TableColumn<Empleado, String> PuestoColumn;
    @FXML
    private TableColumn<Empleado, String> NombreColumn;
    @FXML
    private TableColumn<Empleado, String> ApellidoColumn;
    @FXML
    private TableColumn<Empleado, String> TelefonoColumn;
    @FXML
    private TableColumn<Empleado, String> DireccionColumn;
    @FXML
    private Button VolverBtn;

    // Lista observable para almacenar empleados
    private ObservableList<Empleado> empleado = FXCollections.observableArrayList();
    private CRUDEmpleado CRUDEmpleado;

    // Constructor
    public ModificarEmpleadoController() {
        this.CRUDEmpleado = new CRUDEmpleado();
    }

    // Método que se ejecuta al iniciar el controlador
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // Hace que la tabla sea editable
        EmpleadoTable.setEditable(true);
        // Configura las celdas de la tabla para ser editables
        CedulaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        PuestoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        NombreColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ApellidoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        TelefonoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        DireccionColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        // Configura las columnas de la tabla
        this.CedulaColumn.setCellValueFactory(new PropertyValueFactory<Empleado, String>("cedula"));
        this.PuestoColumn.setCellValueFactory(new PropertyValueFactory<Empleado, String>("puesto"));
        this.NombreColumn.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nombre"));
        this.ApellidoColumn.setCellValueFactory(new PropertyValueFactory<Empleado, String>("apellido"));
        this.TelefonoColumn.setCellValueFactory(new PropertyValueFactory<Empleado, String>("telefono"));
        this.DireccionColumn.setCellValueFactory(new PropertyValueFactory<Empleado, String>("direccion"));

        // Establece la lista observable en la tabla
        EmpleadoTable.setItems(this.empleado);

        // Maneja los eventos de edición en las columnas
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

    // Método que se ejecuta al hacer clic en el botón "Buscar"
    @FXML
    public void ClickBuscar(MouseEvent event) {
        // Obtiene los valores de los campos de búsqueda
        String cedula = CedulaTxt.getText();
        String nombre = NombreTxt.getText();
        // Limpia la tabla
        this.EmpleadoTable.getItems().clear();
        // Realiza una búsqueda y actualiza la tabla con los resultados
        ObservableList<Empleado> info = FXCollections.observableArrayList(CRUDEmpleado.Mostrar(cedula, nombre));
        this.EmpleadoTable.setItems(info);
    }

    // Método que se ejecuta al hacer clic en el botón "Modificar"
    @FXML
    public void ClickModificar(MouseEvent event) {
        // Obtiene el empleado seleccionado en la tabla
        Empleado empleado = EmpleadoTable.getSelectionModel().getSelectedItem();
        if (empleado != null) {
            // Si el empleado ha sido editado, lo modifica en la base de datos
            if (empleado.isEditado()) {
                boolean modificar = CRUDEmpleado.Modificar(empleado);
                // Si la modificación es exitosa, marca el empleado como no editado
                if (modificar) {
                    empleado.setEditado(false);
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
