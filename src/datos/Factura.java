package datos;

import java.util.LinkedList;

/**
 * Clase que representa una Factura.
 */
public class Factura {
    // Atributos privados de la clase Factura
    private String id;
    private String cantidad;
    private String producto;
    private String fecha;
    private String cedempleado;
    private String cedcliente;

    /**
     * Constructor de la clase Factura.
     *
     * @param id          Identificación de la factura.
     * @param cantidad    Cantidad de productos en la factura.
     * @param producto    Producto de la factura.
     * @param fecha       Fecha de la factura.
     * @param cedempleado Cédula del empleado que genera la factura.
     * @param cedcliente  Cédula del cliente asociado a la factura.
     */
    public Factura(String id, String cantidad, String producto, String fecha, String cedempleado, String cedcliente) {
        this.id = id;
        this.cantidad = cantidad;
        this.producto = producto;
        this.fecha = fecha;
        this.cedempleado = cedempleado;
        this.cedcliente = cedcliente;
    }

    /**
     * Método para mostrar una lista de facturas.
     *
     * @param nuevafactura Nueva factura a añadir a la lista.
     * @return LinkedList de facturas con la nueva factura añadida.
     */
    public LinkedList<Factura> Mostrar(Factura nuevafactura) {
        LinkedList<Factura> factura = new LinkedList<>();
        factura.add(nuevafactura);
        return factura;
    }

    // Getters y Setters

    /**
     * Obtiene el ID de la factura.
     *
     * @return ID de la factura.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece el ID de la factura.
     *
     * @param id Nuevo ID de la factura.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene la cantidad de productos en la factura.
     *
     * @return Cantidad de productos.
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de productos en la factura.
     *
     * @param cantidad Nueva cantidad de productos.
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el producto de la factura.
     *
     * @return Producto de la factura.
     */
    public String getProducto() {
        return producto;
    }

    /**
     * Establece el producto de la factura.
     *
     * @param producto Nuevo producto de la factura.
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }

    /**
     * Obtiene la fecha de la factura.
     *
     * @return Fecha de la factura.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la factura.
     *
     * @param fecha Nueva fecha de la factura.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la cédula del empleado que genera la factura.
     *
     * @return Cédula del empleado.
     */
    public String getCedempleado() {
        return cedempleado;
    }

    /**
     * Establece la cédula del empleado que genera la factura.
     *
     * @param cedempleado Nueva cédula del empleado.
     */
    public void setCedempleado(String cedempleado) {
        this.cedempleado = cedempleado;
    }

    /**
     * Obtiene la cédula del cliente asociado a la factura.
     *
     * @return Cédula del cliente.
     */
    public String getCedcliente() {
        return cedcliente;
    }

    /**
     * Establece la cédula del cliente asociado a la factura.
     *
     * @param cedcliente Nueva cédula del cliente.
     */
    public void setCedcliente(String cedcliente) {
        this.cedcliente = cedcliente;
    }
}
