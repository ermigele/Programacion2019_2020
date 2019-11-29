package examenJAVA2211;

public class Ejercicio1 {

	public static void main(String[] args) {
		String PRIMERA_SECRETA_A = "alfa", PRIMERA_SECRETA_B = "trueno", SEGUNDA_SECRETA_A = "beta",
				SEGUNDA_SECRETA_B = "rayo", TERCERA_SECRETA_A = "omega", TERCERA_SECRETA_B = "nube";

		String pri_palabra = "", seg_palabra = "", ter_palabra = "";
		boolean acertaste = true;

		System.out.println("Introduzca una de las palabras claves para la posición 1");
		pri_palabra = Entrada.cadena().toLowerCase();

		if (pri_palabra.equals(PRIMERA_SECRETA_A) || pri_palabra.equals(PRIMERA_SECRETA_B)) {
			System.out.println("¡Palabra clave 1 ACERTADA!");
		} else {
			System.out.println("¡Fallaste la palabra clave 1. Las posibilidades eran: " + PRIMERA_SECRETA_A + " o "
					+ PRIMERA_SECRETA_B);
			acertaste = false;
		}
		if (acertaste) {
			System.out.println("Introduzca una de las palabras claves para la posición 2");
			seg_palabra = Entrada.cadena().toLowerCase();

			if (seg_palabra.equals(SEGUNDA_SECRETA_A) || seg_palabra.equals(SEGUNDA_SECRETA_B)) {
				System.out.println("¡Palabra clave 2 ACERTADA!");
			} else {
				System.out.println("¡Fallaste la palabra clave 2.Las posibilidades eran: " + SEGUNDA_SECRETA_A + " o "
						+ SEGUNDA_SECRETA_B);
				acertaste = false;
			}
		}
		if (acertaste) {
			System.out.println("Introduzca una de las palabras claves para la posición 3");
			ter_palabra = Entrada.cadena().toLowerCase();

			if (ter_palabra.equals(TERCERA_SECRETA_A) || ter_palabra.equals(TERCERA_SECRETA_B)) {
				System.out.println("¡Palabra clave 3 ACERTADA!");
			} else {
				System.out.println("¡Fallaste la palabra clave 3. Las posibilidades eran: " + TERCERA_SECRETA_A + " o "
						+ TERCERA_SECRETA_B);
				acertaste = false;
			}
		}

		if (acertaste) {
			System.out.println("La puerta se ha abierto...puedes entrar");
		} else {
			System.out.println("Has fallado una palabra clave...empezaremos a disparar en 5 segundos");
		}
	}
}
