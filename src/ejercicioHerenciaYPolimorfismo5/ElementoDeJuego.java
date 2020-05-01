package ejercicioHerenciaYPolimorfismo5;

public abstract class ElementoDeJuego implements Ijugable {

	private String identificador;
	private int resultado;

	public ElementoDeJuego(String identificador) {
		this.identificador = identificador;
	}

	public String getIdentificador() {
		return this.identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public int getResultado() {
		return this.resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "ElementoDeJuego [identificador=" + this.identificador + ", resultado=" + this.resultado + "]";
	}
}
