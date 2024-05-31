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

public class BuscadorClienteController implements Initializable {
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
	private ObservableList<Cliente> cliente = FXCollections.observableArrayList();
	private CRUDCliente CRUDCliente;
	public BuscadorClienteController() {
        this.CRUDCliente = new CRUDCliente();}
	// Event Listener on Button[#BuscarBtn].onMouseClicked
	@FXML
	public void ClickBuscar(MouseEvent event) {
		// TODO Autogenerated
// TODO Autogenerated
		String numero = NumeroTxt.getText();
		String nombre = NombreTxt.getText();	
		this.ClienteTable.getItems().clear();
		ObservableList<Cliente> info = FXCollections.observableArrayList(CRUDCliente.Mostrar(numero, nombre));
		this.ClienteTable.setItems(info);}
	public void ClickVolver(MouseEvent event) {
		// TODO Autogenerated
		String puesto = Security.ComprobarPuesto().toUpperCase();
		if (puesto.equals("ADMIN")) {
			CargarLoginAdmin LA = new CargarLoginAdmin((Stage)this.VolverBtn.getScene().getWindow());}
		else if (puesto.equals("GERENTE")) {
			CargarLoginGerente LG = new CargarLoginGerente((Stage)this.VolverBtn.getScene().getWindow());}
		else if (puesto.equals("VENDEDOR")) {
			CargarLoginVendedor LV = new CargarLoginVendedor((Stage)this.VolverBtn.getScene().getWindow());}}
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		ClienteTable.setEditable(true);
        TipoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        NumeroColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        NombreColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ApellidoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        TelefonoColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        DireccionColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		this.CRUDCliente = new CRUDCliente();
		this.TipoColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("doc_tipo"));
		this.NumeroColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("doc_numero"));
		this.NombreColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));
		this.ApellidoColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("apellido"));
		this.TelefonoColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefono"));
		this.DireccionColumn.setCellValueFactory(new PropertyValueFactory<Cliente, String>("direccion"));
		ClienteTable.setItems(this.cliente);						
		NumeroColumn.setOnEditCommit(event -> {
			Cliente e = event.getRowValue();
            e.setdocumentonumero(event.getNewValue());
            e.setEditado(true);});
		TipoColumn.setOnEditCommit(event -> {
			Cliente e = event.getRowValue();
        	e.setdocumentotipo(event.getNewValue());
        	e.setEditado(true);});
        NombreColumn.setOnEditCommit(event -> {
        	Cliente e = event.getRowValue();
        	e.setNombre(event.getNewValue());
        	e.setEditado(true);});
        ApellidoColumn.setOnEditCommit(event -> {
        	Cliente e = event.getRowValue();
        	e.setApellido(event.getNewValue());
        	e.setEditado(true);});
        TelefonoColumn.setOnEditCommit(event -> {
        	Cliente e = event.getRowValue();
        	e.setTelefono(event.getNewValue());
        	e.setEditado(true);});  
        DireccionColumn.setOnEditCommit(event -> {
        	Cliente e = event.getRowValue();
        	e.setDireccion(event.getNewValue());
        	e.setEditado(true);});}}