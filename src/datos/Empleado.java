package datos;

/**
 * Clase que representa un Empleado.
 */
public class Empleado {
    // Atributos privados de la clase Empleado
    private String cedula;
    private String puesto;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private boolean editado;

    /**
     * Constructor de la clase Empleado.
     *
     * @param cedula    Identificación del empleado.
     * @param puesto    Puesto del empleado en la empresa.
     * @param nombre    Nombre del empleado.
     * @param apellido  Apellido del empleado.
     * @param telefono  Teléfono del empleado.
     * @param direccion Dirección del empleado.
     */
    public Empleado(String cedula, String puesto, String nombre, String apellido, String telefono, String direccion) {
        this.cedula = cedula;
        this.puesto = puesto;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.editado = false; 
    }

    /**
     * Obtiene la cédula del empleado.
     *
     * @return cédula del empleado.
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Establece la cédula del empleado.
     *
     * @param cedula Nueva cédula del empleado.
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Obtiene el puesto del empleado.
     *
     * @return puesto del empleado.
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * Establece el puesto del empleado.
     *
     * @param puesto Nuevo puesto del empleado.
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /**
     * Obtiene el nombre del empleado.
     *
     * @return nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre Nuevo nombre del empleado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el apellido del empleado.
     *
     * @return apellido del empleado.
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Establece el apellido del empleado.
     *
     * @param apellido Nuevo apellido del empleado.
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Obtiene el teléfono del empleado.
     *
     * @return teléfono del empleado.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del empleado.
     *
     * @param telefono Nuevo teléfono del empleado.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la dirección del empleado.
     *
     * @return dirección del empleado.
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del empleado.
     *
     * @param direccion Nueva dirección del empleado.
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Verifica si el empleado ha sido editado.
     *
     * @return true si el empleado ha sido editado, false en caso contrario.
     */
    public boolean isEditado() {
        return editado;
    }

    /**
     * Establece el estado de edición del empleado.
     *
     * @param editado Nuevo estado de edición del empleado.
     */
    public void setEditado(boolean editado) {
        this.editado = editado;
    }
}
