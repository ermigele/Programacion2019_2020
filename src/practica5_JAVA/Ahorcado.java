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
		ordenarColumnaMatriz(matrizJuego, 0);
		// creaMatrizConCadenas();
	}

	// FUNCIONES
	public static String[][] creaMatrizConCadenas() {
		String[][] cadena = new String[NUM_FILAS][NUM_COL];
		String[] array = { "artículos", "sujetos", "verbos", "predicados" };
		String frase;
		int k = 0;

		for (int j = 0; j <= cadena.length; j++) {
			for (int i = 0; i <= array.length; i++) {
				System.out.println("Introduce los " + array[i] + ", escribe \"fin\" para indicar que has terminado: ");
				frase = new String("");
				k = 0;
				while (k < cadena[j].length && !frase.equalsIgnoreCase("fin")) {
					frase = Entrada.cadena();
					if (!frase.equalsIgnoreCase("fin")) {
						cadena[j][k] = frase;
						k++;
					}
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

	public static void ordenarColumnaMatriz(String[][] m, int colum) { //ordena por filas
		int pos;
		String temp;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j <= (m[i].length - 2); j++) {
				pos = j;
				for (int k = j + 1; k <= (m[i].length - 1); k++)
					if (m[i][k].compareTo(m[i][pos]) < 0)
						pos = k;

				if (pos != j) {
					temp = m[i][pos];
					m[i][pos] = m[i][j];
					m[i][j] = temp;
				}
			}
		}
	}

	// public static void ordenaCadenas(String[] v) {
	// int posMin;
	// String aux;
	//
	// for (int i = 0; i < v.length - 1; i++) {
	// posMin = i;
	// for (int j = i + 1; j < v.length; j++)
	// if (v[posMin].compareTo(v[j]) > 0)
	// posMin = j;
	// if (posMin != i) {
	// aux = new String(v[i]);
	// v[i] = v[posMin];
	// v[posMin] = aux;
	// }
	// }
	// }

//	public static void ordenarColumnaMatriz(String[][] m, int colum) { //ordena por filas
//		int pos;
//		String temp;
//		for (int i = 0; i < m.length; i++) {
//			for (int j = 0; j <= (m[i].length - 2); j++) {
//				pos = j;
//				for (int k = j + 1; k <= (m[i].length - 1); k++)
//					if (m[i][k].compareTo(m[i][pos]) < 0)
//						pos = k;
//
//				if (pos != j) {
//					temp = m[i][pos];
//					m[i][pos] = m[i][j];
//					m[i][j] = temp;
//				}
//			}
//		}
//	}

	public static void ordenarMatrizPorColumnas(String[][] m) {

	}

	public static boolean existeCadenaEnColumna(String[][] m, String cadena, int colum) {

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {

			}
		}
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
