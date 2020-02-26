package ejerciciosInicialesOO;

public class Finanzas {

	private double moneda;

	// CONSTRUCTORES

	public Finanzas() {
		this.moneda = 1.36;
	}

	public Finanzas(double dolar) {
		this.moneda = dolar;
	}

	// GETTERS & SETTERS

	public double getMoneda() {
		return moneda;
	}

	public void setMoneda(double moneda) {
		this.moneda = moneda;
	}

	// METODOS

	public double dolaresToEuros(double dolares) {

		return moneda * dolares;
	}

	public double eurosToDolares(double euros) {

		return moneda / euros;
	}

	// MAIN
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Finanzas f1 = new Finanzas();
		System.out.println(f1.getMoneda());
		f1.setMoneda(5);

	}
}
