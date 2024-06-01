package datos;

/**
 * Clase que representa un Proveedor.
 */
public class Proveedor {
    // Atributos privados de la clase Proveedor
    private String id;
    private String nombre;
    private String telefono;
    private String descripcion;
    private boolean editado;

    /**
     * Constructor de la clase Proveedor.
     *
     * @param id          Identificación del proveedor.
     * @param nombre      Nombre del proveedor.
     * @param telefono    Teléfono del proveedor.
     * @param descripcion Descripción del proveedor.
     */
    public Proveedor(String id, String nombre, String telefono, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.descripcion = descripcion;
        this.editado = false;
    }

    // Getters y Setters

    /**
     * Obtiene la identificación del proveedor.
     *
     * @return Identificación del proveedor.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece la identificación del proveedor.
     *
     * @param id Nueva identificación del proveedor.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del proveedor.
     *
     * @return Nombre del proveedor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del proveedor.
     *
     * @param nombre Nuevo nombre del proveedor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el teléfono del proveedor.
     *
     * @return Teléfono del proveedor.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del proveedor.
     *
     * @param telefono Nuevo teléfono del proveedor.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la descripción del proveedor.
     *
     * @return Descripción del proveedor.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del proveedor.
     *
     * @param descripcion Nueva descripción del proveedor.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Comprueba si el proveedor ha sido editado.
     *
     * @return true si el proveedor ha sido editado, false en caso contrario.
     */
    public boolean isEditado() {
        return editado;
    }

    /**
     * Establece el estado de edición del proveedor.
     *
     * @param editado Nuevo estado de edición del proveedor.
     */
    public void setEditado(boolean editado) {
        this.editado = editado;
    }
}
