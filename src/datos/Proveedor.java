package datos;

public class Proveedor {
	private String Id;
	private String Nombre;
	private String Telefono;
	private String Descripcion;
	private boolean editado;
	public Proveedor(String id, String nombre, String telefono, String descripcion) {
		this.Id = id;
		this.Nombre = nombre;
		this.Telefono = telefono;
		this.Descripcion = descripcion;
		this.editado = false;	
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		this.Id = id;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		this.Nombre = nombre;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		this.Telefono = telefono;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.Descripcion = descripcion;
	}
	public boolean isEditado() {
        return editado;
    }
    public void setEditado(boolean editado) {
        this.editado = editado;
    }
}
