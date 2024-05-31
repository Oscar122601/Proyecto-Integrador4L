package datos;

public class Venta {
	private String Id;
	private String Fecha;
	private String CedulaEmpleado;
	private String DocNumCliente;
	private boolean editado;
	public Venta(String id, String fecha, String cedempleado, String docnumcliente) {
		this.Id = id;
		this.Fecha = fecha;
		this.CedulaEmpleado = cedempleado;
		this.DocNumCliente = docnumcliente;
		this.editado = false;	
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		this.Id = id;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		this.Fecha = fecha;
	}
	public String getCedulaEmpleado() {
		return CedulaEmpleado;
	}
	public void setCedulaEmpleado(String cedempleado) {
		this.CedulaEmpleado = cedempleado;
	}
	public String getDocNumCliente() {
		return DocNumCliente;
	}
	public void setDocNumCliente(String docnumcliente) {
		this.DocNumCliente = docnumcliente;
	}
	public boolean isEditado() {
        return editado;
    }
    public void setEditado(boolean editado) {
        this.editado = editado;
    }
}
