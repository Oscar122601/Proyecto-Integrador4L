package datos;

/**
 * Clase que representa una venta realizada.
 */
public class Venta {
    // Atributos de la clase Venta
    private String id;
    private String fecha;
    private String cedulaEmpleado;
    private String docNumCliente;
    private boolean editado;

    /**
     * Constructor de la clase Venta.
     *
     * @param id            Identificador de la venta.
     * @param fecha         Fecha de la venta.
     * @param cedempleado   Cédula del empleado que realizó la venta.
     * @param docnumcliente Número de documento del cliente asociado a la venta.
     */
    public Venta(String id, String fecha, String cedempleado, String docnumcliente) {
        this.id = id;
        this.fecha = fecha;
        this.cedulaEmpleado = cedempleado;
        this.docNumCliente = docnumcliente;
        this.editado = false;
    }

    // Getters y Setters

    /**
     * Obtiene el identificador de la venta.
     *
     * @return Identificador de la venta.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el identificador de la venta.
     *
     * @param id Nuevo identificador de la venta.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha de la venta.
     *
     * @return Fecha de la venta.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la venta.
     *
     * @param fecha Nueva fecha de la venta.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la cédula del empleado que realizó la venta.
     *
     * @return Cédula del empleado.
     */
    public String getCedulaEmpleado() {
        return cedulaEmpleado;
    }

    /**
     * Establece la cédula del empleado que realizó la venta.
     *
     * @param cedempleado Nueva cédula del empleado.
     */
    public void setCedulaEmpleado(String cedempleado) {
        this.cedulaEmpleado = cedempleado;
    }

    /**
     * Obtiene el número de documento del cliente asociado a la venta.
     *
     * @return Número de documento del cliente.
     */
    public String getDocNumCliente() {
        return docNumCliente;
    }

    /**
     * Establece el número de documento del cliente asociado a la venta.
     *
     * @param docnumcliente Nuevo número de documento del cliente.
     */
    public void setDocNumCliente(String docnumcliente) {
        this.docNumCliente = docnumcliente;
    }

    /**
     * Comprueba si la venta ha sido editada.
     *
     * @return true si la venta ha sido editada, false en caso contrario.
     */
    public boolean isEditado() {
        return editado;
    }

    /**
     * Establece el estado de edición de la venta.
     *
     * @param editado Nuevo estado de edición de la venta.
     */
    public void setEditado(boolean editado) {
        this.editado = editado;
    }
}
