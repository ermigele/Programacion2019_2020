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

		cadena = "HOLA";
		rotacionCaracter(cadena);

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

	/*
	 * 3.Realiza un programa que lea una cadena de n caracteres e imprima el
	 * resultado que se obtiene cada vez que se realice una rotación de un carácter
	 * a la derecha sobre dicha cadena. El proceso finalizará cuando se haya
	 * obtenido nuevamente la cadena de caracteres original.
	 * 
	 * Por ejemplo: HOLA AHOL LAHO OLAH HOLA
	 */
	public static void rotacionCaracter(String cadena) {
		String nuevaCadena = cadena;
		char[] caracter = cadena.toCharArray();
		System.out.println(cadena);

		for (int i = 0; i < cadena.length() - 1; i++) {

			for (int j = 0; j < cadena.length(); j--) {

			}
			nuevaCadena += String.valueOf(caracter[nuevaCadena.length() - 1]);
			nuevaCadena += caracter[i];
		}
	}

	/*
	 * 4. Escribe una función cadenaPalindroma que se le pase como parámetro una
	 * cadena y devuelva true si dicha cadena es palíndroma o false en caso
	 * contrario. Una cadena es palíndroma cuando se lee igual de izquierda a
	 * derecha que de derecha a izquierda (sin tener en cuenta espacios).
	 * 
	 * Por ejemplo: Dábale arroz a la zorra el abad
	 * 
	 *
	 */

	public static boolean cadenaPalindroma(String cadena) {
		boolean esPalindromo = true;
		String nuevaCadena = new String(" ");
		int desc = 0;

		nuevaCadena = cadena.toLowerCase().trim().replaceAll(" ", "").replace("á", "a").replace("é", "e")
				.replace("í", "i").replace("ó", "o").replace("ú", "u");

		desc = nuevaCadena.length() - 1;

		for (int i = 0; i < nuevaCadena.length(); i++) {

			if (nuevaCadena.charAt(i) != nuevaCadena.charAt(desc))
				esPalindromo = false;

			desc--;
		}
		return esPalindromo;
	}

}
