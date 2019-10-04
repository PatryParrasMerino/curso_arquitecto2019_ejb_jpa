package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contactos database table.
 * 
 */
@Entity
@Table(name="contactos")
public class Contacto implements Serializable {
	private static final long serialVersionUID = 1L;

	//Al ser primary key lleva esas etiquetas
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idContacto;
	
	@Column(name = "edad")
	private int edad;

	@Column(name = "email")
	private String email;

	@Column(name = "nombre")
	private String nombre;
	

	public Contacto() {
	}	

	public Contacto(int idContacto, int edad, String email, String nombre) {
		super();
		this.idContacto = idContacto;
		this.edad = edad;
		this.email = email;
		this.nombre = nombre;
	}



	public int getIdContacto() {
		return this.idContacto;
	}

	public void setIdContacto(int idContacto) {
		this.idContacto = idContacto;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}