package datos;

import java.util.LinkedList;

public class Factura{ 
	private String id;
	private String cantidad;
	private String producto;
	private String fecha;
	private String cedempleado;
	private String cedcliente;
	public Factura(String id, String cantidad,String producto,String fecha,String cedempleado,String cedcliente) {
		this.id = id;
		this.cantidad = cantidad;
		this.producto = producto;
		this.fecha = fecha;
		this.cedempleado =cedempleado;
		this.cedcliente =cedcliente;}

	public LinkedList<Factura> Mostrar(Factura nuevafactura) {
		LinkedList<Factura> factura = new LinkedList<>();
		factura.add(nuevafactura);	
		return factura;}
}
