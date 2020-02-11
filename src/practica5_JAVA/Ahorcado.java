package practica5_JAVA;

public class Ahorcado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final int NUM_FILAS = 10, NUM_COL = 4;

		String[][] matrizJuego = { { "el", "perro", "tiende", "peras" }, { "su", "niño", "coge", "curvas" },
				{ "tu", "algodon", "engaña", "a los pajaros" }, { "un", null, "come", "hierba" },
				{ "mi", null, null, "artistas" }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null } };

		String[] vectorFraseSecreta = new String[4];
	}

	// FUNCIONES
	public static String[][] creaMatrizConCadenas() {

		return null;
	}

	public static void mostrarMatriz(String[][] m) {

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
