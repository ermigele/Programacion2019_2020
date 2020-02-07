package practica6JAVA;

public class golfistas {

	static final int GOLFISTAS = 5;
	static final int JORNADAS = 4;

	public static int[][] golfistas_jornadas = { { 10, 12, 10, 14 }, { 11, 9, 13, 14 }, { 12, 11, 10, 14 },
			{ 10, 13, 10, 10 }, { 10, 15, 12, 12 } };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] puntosGolfistas;

	}

	public static void rellenaMatriz() {

	}

	public static void muestraResultados() {

		for (int i = 0; i < GOLFISTAS; i++) {
			for (int j = 0; j < JORNADAS; j++) {
				if (i == 0) {
					if (j == 0)
						System.out.println("Jornadas: \t");

					if (j != JORNADAS)
						System.out.println((j + 1) + "\t");
					
				} else {
					if (j == 0) {
						System.out.println("Jugador " + i + "\t");
					} else {
						System.out.println(golfistas_jornadas[i - 1][j - 1] + "\t");
					}
				}
			}
			System.out.println("");
		}
	}

	public static int[] calculaPuntosDeJornada(int[] punt_golf) {

		return punt_golf;
	}

	public static void imprimePodio() {

	}
}
