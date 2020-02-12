package practica5_JAVA;

public class Ahorcado {

	static final int NUM_FILAS = 10, NUM_COL = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[][] matrizJuego = { { "el", "perro", "tiende", "peras" }, { "su", "niño", "coge", "curvas" },
				{ "tu", "algodon", "engaña", "a los pajaros" }, { "un", null, "come", "hierba" },
				{ "mi", null, null, "artistas" }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null } };

		String[] vectorFraseSecreta = new String[4];

		mostrarMatriz(matrizJuego);
	}

	// FUNCIONES
	public static String[][] creaMatrizConCadenas() {
		String[][] cadena = new String[NUM_FILAS][NUM_COL];
		String[] array = { "artículos", "sujetos", "verbos", "predicados" };
		String texto = new String("");
		int k = 0;

		for (int i = 0; i <= array.length; i++) {
			System.out.println("Introduce los" + array[i] + ", escribe \"fin\" para indicar que has terminado: ");
			for (int j = 0; j <= cadena.length; j++) {
				k = 0;
				while (k <= cadena[j].length && !texto.equals("fin")) {
					texto = Entrada.cadena();
					cadena[j][k] = texto;
					k++;
				}
			}
		}
		return cadena;
	}

	public static void mostrarMatriz(String[][] m) {
		String colum = new String("");
		for (int i = 0; i <= NUM_FILAS; i++) {
			for (int j = 0; j <= NUM_COL; j++) {

				if (i == 0) {
					if (j == 0) {
						System.out.print("\t\t" + "ArtDet \t\t" + "Suj \t\t" + "Verb \t\t" + "Pred \n");
					}
				} else {
					if (j == 0) {
						System.out.print(i - 1);
					} else {
						colum = (m[i - 1][j - 1] != null) ? m[i - 1][j - 1] : "";
						System.out.print("\t\t" + colum);
					}
				}
			}
			System.out.println();
		}
	}

	public static void ordenarColumnaMatriz(String[][] m, int colum) {

	}

	public static void ordenarMatrizPorColumnas(String[][] m) {

	}

	public static boolean existeCadenaEnColumna(String[][] m, String cadena, int colum) {

		return true;
	}

	public static boolean anyadeCadenaAMatriz(String[][] m, String cadena, int tipo) {

		return true;
	}

	public static int[] generaVectorJuego(String[][] m) {

		return null;
	}

	public static boolean contiene(String[] v, char letra) {

		return true;
	}

	public static boolean insertaLetraOrdenadaEnVector(String[] v, char letra) {

		return true;
	}

	public static String escondePalabra(String[] v, String cadena) {

		return cadena;
	}

	public static String pistaParteFrase(String[] v) {

		return v.toString();
	}

	public static boolean esParteDeLaFrase(String[] v, String subcadena) {

		return true;
	}

	public static boolean resolver(String[] v, String respuesta) {

		return true;
	}

}
