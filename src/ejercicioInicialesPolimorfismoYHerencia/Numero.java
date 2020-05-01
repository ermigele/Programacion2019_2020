package ejercicioInicialesPolimorfismoYHerencia;

public class Numero {
	
	private String identificador = new String("");

	// Constructor vac�o
	public Numero() {
		this.identificador = new String("No Ident");
	}

	// Constructor con par�metros
	public Numero(String ident) {
		this.identificador = ident;
	}

	// M�todos
	public void setIdentificador(String ident) {
		this.identificador = ident;
	}

	public String getIdentificador() {
		return new String("Tipo de n�mero: " + this.identificador);
	}

	public String muestraAtributos() {
		return identificador;
	}
}
