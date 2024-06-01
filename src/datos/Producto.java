package datos;

/**
 * Clase que representa un Producto.
 */
public class Producto {
    // Atributos privados de la clase Producto
    private String id;
    private String nombre;
    private String stock;
    private String descripcion;
    private String precio;
    private boolean editado;

    /**
     * Constructor de la clase Producto.
     *
     * @param id          Identificación del producto.
     * @param nombre      Nombre del producto.
     * @param stock       Stock del producto.
     * @param descripcion Descripción del producto.
     * @param precio      Precio del producto.
     */
    public Producto(String id, String nombre, String stock, String descripcion, String precio) {
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
        this.descripcion = descripcion;
        this.precio = precio;
        this.editado = false;
    }

    // Getters y Setters

    /**
     * Obtiene la identificación del producto.
     *
     * @return Identificación del producto.
     */
    public String getId() {
        return id;
    }

    /**
     * Establece la identificación del producto.
     *
     * @param id Nueva identificación del producto.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return Nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre Nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el stock del producto.
     *
     * @return Stock del producto.
     */
    public String getStock() {
        return stock;
    }

    /**
     * Establece el stock del producto.
     *
     * @param stock Nuevo stock del producto.
     */
    public void setStock(String stock) {
        this.stock = stock;
    }

    /**
     * Obtiene la descripción del producto.
     *
     * @return Descripción del producto.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción del producto.
     *
     * @param descripcion Nueva descripción del producto.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return Precio del producto.
     */
    public String getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio Nuevo precio del producto.
     */
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    /**
     * Comprueba si el producto ha sido editado.
     *
     * @return true si el producto ha sido editado, false en caso contrario.
     */
    public boolean isEditado() {
        return editado;
    }

    /**
     * Establece el estado de edición del producto.
     *
     * @param editado Nuevo estado de edición del producto.
     */
    public void setEditado(boolean editado) {
        this.editado = editado;
    }
}
