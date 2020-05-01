package ejercicioInicialesPolimorfismoYHerencia;

public class NumeroFraccion extends Numero {
	private int numerador;
	private int denominador;

	// constructores
	public NumeroFraccion(int num, int den) {
		super("Fraccion");
		this.numerador = num;
		this.denominador = den;
	}

	// getters
	public int getNumerador() {
		return numerador;
	}

	public int getDenominador() {
		return denominador;
	}

	// setters
	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public void setDenominador(int denominador) {
		this.denominador = denominador;
	}

	public void sumaFraccion(int num, int den) {
		this.numerador += num;
		this.denominador += den;
	}

	public String muestraAtributos() {
		String cadena = new String(
				super.muestraAtributos() + "\n numerador: " + this.numerador + "\n denominador: " + this.denominador);

		return cadena;

	}
}
