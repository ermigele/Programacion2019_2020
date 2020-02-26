package ejerciciosInicialesOO;

public class Numero {

	private int valor = 0;

	// CONSTRUCTORES

	public Numero() {
	}

	public Numero(int valor) {
		this.valor = valor;
	}

	public Numero(Numero numeroCopia) {
		this.valor = numeroCopia.valor;
	}

	// GETTER
	public int getValor() {
		return valor;
	}

	// SETTER

	public void setValor(int valor) {
		this.valor = valor;
	}

	// METODOS

	public void anyade(int valorNuevo) {

		this.valor += valorNuevo;
	}

	public void resta(int valorNuevo) {
		this.valor -= valorNuevo;
	}

	public int getDoble() {

		return this.valor * 2;
	}

	public int getTriple() {

		return this.valor * 3;
	}

}
