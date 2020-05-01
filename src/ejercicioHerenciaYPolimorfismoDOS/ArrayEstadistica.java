package ejercicioHerenciaYPolimorfismoDOS;

public class ArrayEstadistica extends Array {

	public ArrayEstadistica(int num) {
		super(num);
	}

	public int devuelveMayor() {
		int num, cont, contMasRepetido = 0, masRepetido = -1;
		for (int i = 0; i < super.numerosEnteros.length; i++) {
			num = super.numerosEnteros[i];
			cont = 0;
			if (num != 0) {
				for (int j = 0; j < super.numerosEnteros.length; j++)
					if (super.numerosEnteros[j] == num)
						cont++;

				if (cont > contMasRepetido) {
					masRepetido = numerosEnteros[i];
					contMasRepetido = cont;
				}
			}
		}
		return masRepetido;
	}

	public int devuelveMenor() {
		int num, j, cont, contMenosRepetido = super.numerosEnteros.length + 1, menosRepetido = -1;
		for (int i = 0; i < super.numerosEnteros.length; i++) {
			num = super.numerosEnteros[i];
			cont = 0;
			if (num != 0) {
				j = 0;
				while (j < super.numerosEnteros.length) {
					if (super.numerosEnteros[j] == num)
						cont++;
					j++;
				}
				if (cont < contMenosRepetido) {
					menosRepetido = numerosEnteros[i];
					contMenosRepetido = cont;
				}
			}
		}
		return menosRepetido;

	}

	public String toString() {
		return new String("Soy un array estadístico");
	}

	public double devuelveMedia() {
		int sumaNumeros = 0;
		double media = 0;
		for (int i = 0; i < this.numerosEnteros.length; i++) {
			sumaNumeros += this.numerosEnteros[i];
		}

		media = (double) sumaNumeros / (double) this.numerosEnteros.length;

		return media;
	}
}
