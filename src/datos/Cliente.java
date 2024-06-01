package datos;

/**
 * Clase que representa a un Cliente con información personal y de contacto.
 */
public class Cliente {
    private String doc_numero;
    private String doc_tipo;
    private String nombre;
    private String direccion;
    private String telefono;
    private String apellido;
    private boolean editado;

    /**
     * Constructor para crear un objeto Cliente.
     * 
     * @param documentonumero Número de documento del cliente.
     * @param documentotipo Tipo de documento del cliente.
     * @param nombre Nombre del cliente.
     * @param direccion Dirección del cliente.
     * @param telefono Teléfono del cliente.
     * @param apellido Apellido del cliente.
     */
    public Cliente(String documentonumero, String documentotipo, String nombre, String direccion, String telefono, String apellido) {
        this.doc_numero = documentonumero;
        this.doc_tipo = documentotipo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.apellido = apellido;
        this.editado = false;    
    }

    /**
     * Obtiene el número de documento del cliente.
     * 
     * @return Número de documento del cliente.
     */
    public String getdocumentonumero() {
        return doc_numero;
    }

    /**
     * Establece el número de documento del cliente.
     * 
     * @param documentonumero Número de documento a establecer.
     */
    public void setdocumentonumero(String documentonumero) {
        this.doc_numero = documentonumero;
    }

    /**
     * Obtiene el tipo de documento del cliente.
     * 
     * @return Tipo de documento del cliente.
     */
    public String getdocumentotipo() {
        return doc_tipo;
    }

    /**
     * Establece el tipo de documento del cliente.
     * 
     * @param documentotipo Tipo de documento a establecer.
     */
    public void setdocumentotipo(String documentotipo) {
        this.doc_tipo = documentotipo;
    }

    /**
     * Obtiene el nombre del cliente.
     * 
     * @return Nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     * 
     * @param nombre Nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del cliente.
     * 
     * @return Apellido del cliente.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del cliente.
     * 
     * @param apellido Apellido a establecer.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el teléfono del cliente.
     * 
     * @return Teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del cliente.
     * 
     * @param telefono Teléfono a establecer.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la dirección del cliente.
     * 
     * @return Dirección del cliente.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del cliente.
     * 
     * @param direccion Dirección a establecer.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Indica si el cliente ha sido editado.
     * 
     * @return true si el cliente ha sido editado, false en caso contrario.
     */
    public boolean isEditado() {
        return editado;
    }

    /**
     * Establece el estado de edición del cliente.
     * 
     * @param editado Estado de edición a establecer.
     */
    public void setEditado(boolean editado) {
        this.editado = editado;
    }
}
```

