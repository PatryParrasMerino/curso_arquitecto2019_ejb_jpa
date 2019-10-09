package model;

import java.io.Serializable;

public class Pedido implements Serializable{ // tiene que implementar serializable,no puedes guardar un objeto en u fichero si no implementas serializable
											// para poder guardar objetos en un disco. lo aplica la jvm.
	private String producto;
	private double precio;
	private String descripcion;
	public Pedido() { // se necesita para recontruir cuando se serialice
		
	}
	public Pedido(String producto, double precio, String descripcion) {
		super();
		this.producto = producto;
		this.precio = precio;
		this.descripcion = descripcion;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
