package ejercicioHerenciaYPolimorfismoDOS;

public class ArrayDiscriminatorio extends Array {

	private int numeroProhibido;

	public ArrayDiscriminatorio(int tam, int num) {
		super(tam);
		this.numeroProhibido = num;
	}

	public int getNumeroProhibido() {
		return this.numeroProhibido;
	}

	public boolean insertaNumero(int num) {
		boolean insertado = false;
		if (num != this.numeroProhibido)
			insertado = super.insertaNumero(num);

		return insertado;
	}

	public void eliminaNumero(int num) {
		if (num != this.numeroProhibido)
			super.eliminaNumero(num);
	}

	public void muestraArray() {
		for (int i = 0; i < this.numerosEnteros.length; i++) {
			if (this.numerosEnteros[i] != 0)
				System.out.print("[" + this.numerosEnteros[i] + "]  ");
		}
	}

	public String toString() {
		return "\nSoy un Array discriminatorio";
	}
}
