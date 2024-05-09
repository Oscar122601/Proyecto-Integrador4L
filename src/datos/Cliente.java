package datos;

public class Cliente {
	private String doc_numero;
	private String doc_tipo;
	private String nombre;
	private String direccion;
	private String telefono;
	private String apellido;
	private boolean editado;
	public Cliente(String documentonumero, String documentotipo, String nombre, String direccion, String telefono, String apellido) {
		this.doc_numero = documentonumero;
		this.doc_tipo = documentotipo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.apellido = apellido;
		this.editado = false;	
	}
	public String getdocumentonumero() {
		return doc_numero;
	}
	public void setdocumentonumero(String documentonumero) {
		this.doc_numero = documentonumero;
	}
	public String getdocumentotipo() {
		return doc_tipo;
	}
	public void setdocumentotipo(String documentotipo) {
		this.doc_tipo = documentotipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public boolean isEditado() {
        return editado;
    }
    public void setEditado(boolean editado) {
        this.editado = editado;
    }
}
