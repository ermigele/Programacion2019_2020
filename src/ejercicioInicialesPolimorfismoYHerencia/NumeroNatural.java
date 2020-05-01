package ejercicioInicialesPolimorfismoYHerencia;

public class NumeroNatural extends Numero {
	private int numeroPositivo;

	// Constructor
	public NumeroNatural(int num) {

		super("Numero Natural");

		if (num > 0) {
			this.numeroPositivo = num;
		} else {
			this.numeroPositivo = 0;
		}
	}

	// getters

	public int getNumeroPositivo() {
		return this.numeroPositivo;
	}

	// setters

	public void setNumeroPositivo(int num) {
		if (num > 0) {
			this.numeroPositivo = num;
		} else {
			this.numeroPositivo = 0;
		}
	}

	// otros

	public void sumaValor(int num) {
		this.numeroPositivo += num;
	}

	public boolean restaValor(int num) {

		if ((this.numeroPositivo - num) > 0) {
			this.numeroPositivo -= num;
			return true;
		} else {
			return false;
		}
	}

	public String muestraAtributos() {
		return super.muestraAtributos() + "\n Numero Positivo: " + this.numeroPositivo;
	}
}
