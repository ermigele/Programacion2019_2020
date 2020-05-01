package ejercicioHerenciaYPolimorfismoDOS;

public class ArrayNumerosPares extends Array {

	public ArrayNumerosPares(int tamVec) {
		super(tamVec);

	}

	public boolean insertaNumero(int num) {
		if (num % 2 == 0 && super.insertaNumero(num)) {
			return true;
		}
		return false;
	}

	public void eliminaNumero(int num) {
		if (num % 2 == 0) {
			super.eliminaNumero(num);
		}
	}

	public String toString() {
		return "Soy un array de números pares";
	}

	public int cuantosNumerosParesHay() {
		int cuentaPares = 0;
		for (int i = 0; i < super.numerosEnteros.length; i++) {
			if (super.numerosEnteros[i] != 0) {
				cuentaPares++;
			}
		}
		return cuentaPares;
	}

}
