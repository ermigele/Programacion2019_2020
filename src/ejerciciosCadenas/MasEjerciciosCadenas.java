package ejerciciosCadenas;

public class MasEjerciciosCadenas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		System.out.println(cadenaPalindroma(Entrada.cadena()));
	}

	/*
	 * 1. Realiza un algoritmo que se le pase como par�metro una cadena y un
	 * car�cter y devuelva un vector que contenga todas las posiciones de la cadena
	 * donde est� dicho car�cter.
	 */

	/*
	 * 2. Escribe un programa que d� como resultado la frecuencia con la que aparece
	 * cada una de las parejas de letras adyacentes de una cadena introducida por
	 * teclado. No se har� diferencia entre may�sculas y min�sculas. El resultado se
	 * presentar� en forma de tabla de la siguiente manera:
	 */

	/*
	 * 3.Realiza un programa que lea una cadena de n caracteres e imprima el
	 * resultado que se obtiene cada vez que se realice una rotaci�n de un car�cter
	 * a la derecha sobre dicha cadena. El proceso finalizar� cuando se haya
	 * obtenido nuevamente la cadena de caracteres original.
	 * 
	 * Por ejemplo: HOLA AHOL LAHO OLAH HOLA
	 */

	/*
	 * 4. Escribe una funci�n cadenaPalindroma que se le pase como par�metro una
	 * cadena y devuelva true si dicha cadena es pal�ndroma o false en caso
	 * contrario. Una cadena es pal�ndroma cuando se lee igual de izquierda a
	 * derecha que de derecha a izquierda (sin tener en cuenta espacios).
	 * 
	 * Por ejemplo: D�bale arroz a la zorra el abad
	 * 
	 * d�balearrozalazorraelabad
	 */

	public static boolean cadenaPalindroma(String cadena) {
		boolean esPalindromo = true;
		String nuevaCadena = new String(" ");
		int desc = 0;

		nuevaCadena = cadena.toLowerCase().trim().replace(" ", "").replace("�", "a").replace("�", "e").replace("�", "i")
				.replace("�", "o").replace("�", "u");

		desc = nuevaCadena.length() - 1;
		
		for (int i = 0; i < nuevaCadena.length(); i++) {

			if (nuevaCadena.charAt(i) != nuevaCadena.charAt(desc))
				esPalindromo = false;

			desc--;
		}
		return esPalindromo;
	}

}
