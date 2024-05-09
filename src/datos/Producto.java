package datos;

public class Producto {
	private String id;
	private String nombre;
	private String stock;
	private String descripcion;
	private String precio;
	private boolean editado;
	public Producto(String id, String nombre, String stock, String descripcion, String precio) {
		this.id = id;
		this.nombre = nombre;
		this.stock = stock;
		this.descripcion = descripcion;
		this.precio =precio ;
		this.editado = false;	
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public boolean isEditado() {
		return editado;
	}
	public void setEditado(boolean editado) {
		this.editado = editado;
	}
}
