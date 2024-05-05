package application;

import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

import datos.CRUDEmpleado;
import datos.Empleado;
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

public class BuscadorEmpleadoController implements Initializable {
	@FXML
	private Button BuscarBtn;
	@FXML
	private TextField CedulaTxt;
	@FXML
	private TextField NombreTxt;
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
	private ObservableList<Empleado> empleado = FXCollections.observableArrayList();
	private CRUDEmpleado CRUDEmpleado;
	public BuscadorEmpleadoController() {
        this.CRUDEmpleado = new CRUDEmpleado();}
	// Event Listener on Button[#BuscarBtn].onMouseClicked
	@FXML
	public void ClickBuscar(MouseEvent event) {
		// TODO Autogenerated
		String cedula = CedulaTxt.getText();
		String nombre = NombreTxt.getText();	
		this.EmpleadoTable.getItems().clear();
		ObservableList<Empleado> info = FXCollections.observableArrayList(CRUDEmpleado.MostrarEmpleado(cedula, nombre));
		this.EmpleadoTable.setItems(info);}
	public void ClickVolver(MouseEvent event) {
		// TODO Autogenerated
		CargarLoginAdmin LG = new CargarLoginAdmin((Stage)this.VolverBtn.getScene().getWindow());}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		EmpleadoTable.setEditable(true);
        CedulaColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        PuestoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        NombreColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ApellidoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        TelefonoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        DireccionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		this.CRUDEmpleado = new CRUDEmpleado();
		this.CedulaColumn.setCellValueFactory(new PropertyValueFactory<Empleado, String>("cedula"));
		this.PuestoColumn.setCellValueFactory(new PropertyValueFactory<Empleado, String>("puesto"));
		this.NombreColumn.setCellValueFactory(new PropertyValueFactory<Empleado, String>("nombre"));
		this.ApellidoColumn.setCellValueFactory(new PropertyValueFactory<Empleado, String>("apellido"));
		this.TelefonoColumn.setCellValueFactory(new PropertyValueFactory<Empleado, String>("telefono"));
		this.DireccionColumn.setCellValueFactory(new PropertyValueFactory<Empleado, String>("direccion"));
		EmpleadoTable.setItems(this.empleado);						
        CedulaColumn.setOnEditCommit(event -> {
            Empleado e = event.getRowValue();
            e.setCedula(event.getNewValue());
            e.setEditado(true);});
        PuestoColumn.setOnEditCommit(event -> {
        	Empleado e = event.getRowValue();
        	e.setPuesto(event.getNewValue());
        	e.setEditado(true);});
        NombreColumn.setOnEditCommit(event -> {
        	Empleado e = event.getRowValue();
        	e.setNombre(event.getNewValue());
        	e.setEditado(true);});
        ApellidoColumn.setOnEditCommit(event -> {
        	Empleado e = event.getRowValue();
        	e.setApellido(event.getNewValue());
        	e.setEditado(true);});
        TelefonoColumn.setOnEditCommit(event -> {
        	Empleado e = event.getRowValue();
        	e.setTelefono(event.getNewValue());
        	e.setEditado(true);});  
        DireccionColumn.setOnEditCommit(event -> {
        	Empleado e = event.getRowValue();
        	e.setDireccion(event.getNewValue());
        	e.setEditado(true);});}}
