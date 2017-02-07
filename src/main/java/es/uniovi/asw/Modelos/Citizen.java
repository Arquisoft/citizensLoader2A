package es.uniovi.asw.Modelos;

import java.util.Date;

public class Citizen {
	
	
	private String nombre; 
	private String apellidos;
	private String email;
	private Date fechaNacimiento;
	private String direccionPostal; //Calle?nº de la calle?
	private String nacionalidad;
	private String dni;
	
	private String nombreUsuario;
	private String contraseña;
	
	
	
	
	public Citizen(String nombre, String apellidos, String email, Date fechaNacimiento, String direccionPostal,
			String nacionalidad, String dni, String nombreUsuario, String contraseña) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.direccionPostal = direccionPostal;
		this.nacionalidad = nacionalidad;
		this.dni = dni;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
	}



/** Solo getters excepto en usuario y contraseña que también tendrán setters para poder modificarlos,
 *  lo demás solo se modifica en el constructor una vez
 * @return
 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}


	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getEmail() {
		return email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getDireccionPostal() {
		return direccionPostal;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public String getDni() {
		return dni;
	}
	
	

}
