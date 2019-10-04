package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pedidos database table.
 * 
 */
@Entity
@Table(name="pedidos")
public class Pedido implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPedido;
	
	@Column(name = "categoria")
	private String categoria;
	
	@Column(name = "precio")
	private double precio;
	
	@Column(name = "producto")
	private String producto;

	public Pedido() {
	}	

	public Pedido(int idPedido, String categoria, double precio, String producto) {
		super();
		this.idPedido = idPedido;
		this.categoria = categoria;
		this.precio = precio;
		this.producto = producto;
	}



	public int getIdPedido() {
		return this.idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public String getCategoria() {
		return this.categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getProducto() {
		return this.producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

}