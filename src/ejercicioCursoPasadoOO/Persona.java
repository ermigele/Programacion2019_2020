package ejercicioCursoPasadoOO;

public class Persona {

	// ATRIBUTO
	private String dni;
	private String nombre;
	private String apellidos;

	// CONSTRUCTORES
	public Persona() {
		this.dni = new String("");
		this.nombre = new String("");
		this.apellidos = new String("");
	}

	public Persona(String dni, String nombre, String apellidos) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public Persona(Persona persona) {
		this.dni = persona.dni;
		this.nombre = persona.nombre;
		this.apellidos = persona.apellidos;
	}

	// GETTERS & SETTERS
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}

}
