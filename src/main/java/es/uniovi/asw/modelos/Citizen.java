package es.uniovi.asw.modelos;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="CITIZEN")
public class Citizen {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ID;
	
	@Column(name="NOMBRE")
	private String nombre;
	@Column(name="APELLIDOS")
	private String apellidos;
	private String email;
	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_NACIMIENTO")
	private Date fechaNacimiento;
	
	private String direccionPostal;
	private String nacionalidad;
	private String dni;
	private String nombreUsuario;
	private String contraseña;
	
	//Constructor vacio para JPA
	public Citizen(){}
	
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
	
	

	public Citizen(String nombre, String apellidos, String email, Date fechaNacimiento, String direccionPostal,
			String nacionalidad, String dni) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.direccionPostal = direccionPostal;
		this.nacionalidad = nacionalidad;
		this.dni = dni;
	}

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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setDireccionPostal(String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Citizen [nombre=" + nombre + ", apellidos=" + apellidos
				+ ", email=" + email + ", fechaNacimiento=" + fechaNacimiento
				+ ", direccionPostal=" + direccionPostal + ", nacionalidad="
				+ nacionalidad + ", dni=" + dni + "]";
	}	
	
}
