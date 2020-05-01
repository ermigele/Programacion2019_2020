package ejercicioHerenciaYPolimorfismoDOS;

public class Array {

	// ATRIBUTO
	protected int[] numerosEnteros;

	// CONSTRUCTOR
	public Array(int tamVector) {
		this.numerosEnteros = new int[tamVector];
	}

	// GETTER
	public int getNumerosEnteros(int posicion) {

		if (posicion < numerosEnteros.length)
			return numerosEnteros[posicion];
		return 0;
	}

	// METODOS

	public boolean insertaNumero(int num) {

		for (int i = 0; i < numerosEnteros.length; i++)
			if (getNumerosEnteros(i) == 0) {
				numerosEnteros[i] = num;
				return true;
			}
		return false;
	}

	public void eliminaNumero(int num) {

		for (int i = 0; i < numerosEnteros.length; i++)
			if (getNumerosEnteros(i) == num) {
				numerosEnteros[i] = 0;
			}
	}

	public int devuelveMayor() {
		int temp = 0;
		for (int i = 0; i < numerosEnteros.length; i++) {
			if (getNumerosEnteros(i) > temp)
				temp = getNumerosEnteros(i);
		}
		return temp;
	}

	public int devuelveMenor() {
		int temp = getNumerosEnteros(numerosEnteros.length - 1);
		for (int i = 0; i < numerosEnteros.length; i++) {
			if (getNumerosEnteros(i) < temp)
				temp = getNumerosEnteros(i);
		}
		return temp;
	}

	public void muestraArray() {
		for (int i = 0; i < numerosEnteros.length; i++) {
			System.out.print("[" + this.numerosEnteros[i] + "]  ");
		}
	}

	public String toString() {
		return "Soy un array normal";
	}

}
