package ejerciciosCadenas;

public class MasEjerciciosCadenas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String cadena = new String(" ");
		char carac;

		// System.out.print("Introduce una cadena: ");
		// cadena = Entrada.cadena();
		// System.out.print("Introduce el caracter que quieras buscar: ");
		// carac = Entrada.caracter();
		// buscaCaracter(carac, cadena);
		//
		// System.out.print("Introduce un palindromo: ");
		// if (cadenaPalindroma(Entrada.cadena()))
		// System.out.println("Es un palindromo");
		// else
		// System.out.println("No es un palindromo");
		// cadena = "HOLA";
		// rotarCadena(cadena);
	}

	/*
	 * 1. Realiza un algoritmo que se le pase como parámetro una cadena y un
	 * carácter y devuelva un vector que contenga todas las posiciones de la cadena
	 * donde está dicho carácter.
	 */
	public static int[] buscaCaracter(int carac, String cadena) {
		int cont = 0;

		for (int i = 0; i < cadena.length(); i++) {
			if (carac == cadena.charAt(i)) {
				cont++;
			}
		}

		int[] posiciones = new int[cont];
		cont = 0;

		for (int i = 0; i < cadena.length(); i++) {
			if (carac == cadena.charAt(i)) {
				posiciones[cont] = i;
				cont++;
			}
		}
		return posiciones;
	}

	/*
	 * 2. Escribe un programa que dé como resultado la frecuencia con la que aparece
	 * cada una de las parejas de letras adyacentes de una cadena introducida por
	 * teclado. No se hará diferencia entre mayúsculas y minúsculas. El resultado se
	 * presentará en forma de tabla de la siguiente manera:
	 */
	public static int[][] frecuenciaParejasCaracter(String cadena) {

		int[][] frecuencia = new int[26][26];
		cadena = cadena.toLowerCase();
		for (int i = 0; i <= cadena.length() - 2; i++) {
			if ((cadena.charAt(i)) != ' ' && (cadena.charAt(i + 1)) != ' ') {
				frecuencia[cadena.charAt(i) - 97][(cadena.charAt(i + 1)) - 97] += 1;
			}
		}
		return frecuencia;
	}

	public static void imprimeMatriz(int[][] resultados) {

		System.out.print("         ");
		for (int i = 0; i <= 26; i++) {
			System.out.print("  " + (char) (i + 97) + "  ");
		}
		System.out.println();
		for (int i = 0; i < resultados.length; i++) {
			System.out.print("Fila " + ((char) (i + 97)) + ":  ");
			for (int j = 0; j < resultados[i].length; j++) {
				System.out.printf(" [" + resultados[i][j] + "] ");
			}
			System.out.println();
		}
	}

	/*
	 * 3.Realiza un programa que lea una cadena de n caracteres e imprima el
	 * resultado que se obtiene cada vez que se realice una rotación de un carácter
	 * a la derecha sobre dicha cadena. El proceso finalizará cuando se haya
	 * obtenido nuevamente la cadena de caracteres original.
	 * 
	 * Por ejemplo: HOLA AHOL LAHO OLAH HOLA
	 */
	public static void rotarCadena(String cad) {

		for (int i = 0; i <= cad.length(); i++) {
			System.out.println(cad);
			cad = (cad.charAt(cad.length() - 1)) + cad.substring(0, cad.length() - 1);
		}

	}

	/*
	 * 4. Escribe una función cadenaPalindroma que se le pase como parámetro una
	 * cadena y devuelva true si dicha cadena es palíndroma o false en caso
	 * contrario. Una cadena es palíndroma cuando se lee igual de izquierda a
	 * derecha que de derecha a izquierda (sin tener en cuenta espacios).
	 * 
	 * Por ejemplo: Dábale arroz a la zorra el abad
	 */

	public static boolean cadenaPalindroma(String cadena) {
		int desc = 0;

		cadena = cadena.toLowerCase().replace(" ", "").replace("á", "a")
				.replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");

		desc = cadena.length() - 1;

		for (int i = 0; i < cadena.length() / 2; i++) {

			if (cadena.charAt(i) != cadena.charAt(desc))
				return false;

			desc--;
		}
		return true;
	}

}
