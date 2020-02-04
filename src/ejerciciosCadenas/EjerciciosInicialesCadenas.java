package ejerciciosCadenas;

public class EjerciciosInicialesCadenas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String nombre = new String(""), dominio = new String(""), TLD = new
		// String("");
		//
		// System.out.print("Introduce un nombre: ");
		// nombre = Entrada.cadena().toLowerCase().trim().replace(" ", "");
		// System.out.print("Introduce un dominio: ");
		// dominio = Entrada.cadena().toLowerCase().trim().replace(" ", "");
		// System.out.print("Introduce un TLD: ");
		// TLD = Entrada.cadena().toLowerCase().trim().replace(" ", "");
		//
		// System.out.println(correo(nombre, dominio, TLD));

		// imprimeCadena(Entrada.cadena().replace(" ", ""));
		// cambioDeVocales(Entrada.cadena());
	}

	/*
	 * 1. Crea una funci�n que pida al usuario un nombre, un dominio y un TLD (top
	 * level domain) y que a partir de estos datos devuelva una direcci�n de correo
	 * electr�nico. Por ejemplo:
	 * 
	 * Introduzca nombre: juan89 Introduzca dominio: gmail Introduzca TLD: com. Su
	 * cuenta de correo es juan89@gmail.com
	 * 
	 */
	public static String correo(String nombre, String dominio, String TLD) {

		return nombre + "@" + dominio + "." + TLD;
	}

	/*
	 * 2. Crea una funci�n que devuelva el n�meo de vocales que tiene la cadena que
	 * se le pasa como par�metro.
	 */
	public static int numVocales(String cadena) {
		int numVocales = 0;
		char caracter;

		for (int i = 0; i <= cadena.length(); i++) {

			caracter = cadena.charAt(i);
			if (caracter == 'a' || caracter == 'e' || caracter == 'i' || caracter == 'o' || caracter == 'u') {
				numVocales++;
			}
		}
		return numVocales;
	}

	/*
	 * 3. Crea una funci�n que a partir de una cadena que se le pasa como par�metro
	 * imprima por pantalla cada car�cter separado por un '-'.
	 */
	public static void imprimeCadena(String cadena) {

		char[] array = cadena.toCharArray();

		for (int i = 0; i < cadena.length() - 1; i++) {

			System.out.print(array[i] + "-");
		}
		System.out.print(array[array.length - 1]);
	}

	/*
	 * 4. Crea una funci�n que se le pase como par�metro una cadena y muestre por
	 * pantalla todas las posibles combinaciones de cambio de todas las vocales por
	 * la misma vocal. La funci�n no debe modificar la cadena que se le pasa como
	 * par�metro.
	 */
	public static void cambioDeVocales(String cadena) {
		String nuevaCadena = new String("");

		nuevaCadena = cadena.replace('e', 'a').replace('i', 'a').replace('o', 'a').replace('u', 'a').replace("qa", "qu")
				.replace("gaa", "gua");
		System.out.println(nuevaCadena);
		nuevaCadena = nuevaCadena.replace('a', 'e').replace("qe", "qu").replace("gee", "gue");
		System.out.println(nuevaCadena);
		nuevaCadena = nuevaCadena.replace('e', 'i').replace("qi", "qu").replace("gii", "gui");
		System.out.println(nuevaCadena);
		nuevaCadena = nuevaCadena.replace('i', 'o').replace("qo", "qu").replace("goo", "guo");
		System.out.println(nuevaCadena);
		nuevaCadena = nuevaCadena.replace('o', 'u');
		System.out.println(nuevaCadena);
	}

}
