package ejercicioInicialesPolimorfismoYHerencia;

public class Numero {
	
	private String identificador = new String("");

	// Constructor vacío
	public Numero() {
		this.identificador = new String("No Ident");
	}

	// Constructor con parámetros
	public Numero(String ident) {
		this.identificador = ident;
	}

	// Métodos
	public void setIdentificador(String ident) {
		this.identificador = ident;
	}

	public String getIdentificador() {
		return new String("Tipo de número: " + this.identificador);
	}

	public String muestraAtributos() {
		return identificador;
	}
}
