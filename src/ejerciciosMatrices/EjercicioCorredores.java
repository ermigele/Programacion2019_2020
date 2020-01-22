package ejerciciosMatrices;

public class EjercicioCorredores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Hay una liga de atletismo en la que compiten dos corredores durante 5
		 * carreras. Los tiempos de los corredores en esas carreras (segundos y dos
		 * decimales para expresar centésimas de segundo) están guardados en una matriz
		 * donde la fila 0 guarda los tiempos del corredor 1 y la fila 1 guarda los
		 * tiempos del corredor 2. Los tiempos de cada corredor serán pedidos al usuario
		 * con una funcion pideTiempos en los que se le pasa como parámetro la matriz y
		 * el número del corredor para el que vamos a introducir los tiempos (este
		 * parámetro valdrá 1 o 2). Hay otra función calculaPuntos que devuelve un
		 * vector de 2 posiciones donde en la primera posición aparecen los puntos del
		 * corredor 1 y en la segunda posición los puntos del corredor 2. Los puntos
		 * para cada carrera se rigen por lo siguiente: 3 puntos para el corredor que
		 * haya hecho menos tiempo y 1 punto para el corredor que haya hecho más tiempo
		 * en cada carrera. Si ambos tiempos son iguales en la misma carrera, ambos
		 * corredores obtienen 2 puntos. El corredor que gana la liga de atletismo es el
		 * que más puntos tiene. En caso que igualen a puntos, el ganador será aquel que
		 * haya realizado el menor tiempo en todas las carreras corridas. Usa una
		 * función corredorConMenorTiempo que devuelve 1 o 2 en función del corredor que
		 * haya hecho la carrera más rápida.
		 */

		double[][] tiempos = { { 9.98, 11.40, 8.36, 9.90, 10.13 }, { 9.98, 11.45, 9.39, 9.72, 9.97 } };

	}

	public static void pideTiempos(double[][] tiempos, int corredor) {

		for (int i = 0; i < tiempos[corredor].length; i++) {
			System.out.print("Introduce el tiempo " + i);
			tiempos[corredor - 1][i] = Entrada.real();
		}
	}

	public static int[] calculaPuntos(double[][] tiempos) {
		int[] puntos = new int[2];

		for (int i = 0; i < tiempos.length; i++) {
			for (int k = 0; k < tiempos[i].length; k++) {

				if (tiempos[0][k] > tiempos[1][k]) {
					puntos[0] += 3;
					puntos[1] += 1;
				} else {
					if (tiempos[1][k] > tiempos[0][k]) {
						puntos[0] += 1;
						puntos[1] += 3;
					} else {
						puntos[0] += 2;
						puntos[1] += 2;
					}
				}
			}
		}

		return puntos;
	}

	public static int corredorConMenorTiempo(double[][] tiempos) {
		
		return 1;
	}

}
