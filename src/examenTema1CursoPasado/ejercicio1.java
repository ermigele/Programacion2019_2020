package examenTema1CursoPasado;

public class ejercicio1 {

	public static void main(String[] args) {
		/*
		 * Vamos a hacer un programa en JAVA para construir una ventana y romper uno de
		 * los cristales de la misma. El programa pedirá al usuario el tamaño de la
		 * ventana, que debe ser un número impar mayor de 10. Luego preguntará al
		 * usuario qué cuadrante de la ventana quiere romper, podrá ser “arriba
		 * izquierda”, “arriba derecha”, “abajo izquierda” o “abajo derecha”, el usuario
		 * puede escribir estas cadenas en mayúsculas, minúsculas o unas en minúsculas y
		 * otras en mayúsculas. El usuario también podría escribir cualquier otra
		 * cadena, de manera que no se rompería ningún cuadrante. En este ejercicio no
		 * se puede usar una estructura SWITCH-CASE.
		 */

		int num = 0, mitad = 0;
		String posicion = "";
		while (num < 10 || num % 2 == 0) {
			System.out.print("Introduce un número impar mayor de 10: ");
			num = Entrada.entero();
		}
		mitad = num / 2;

		System.out.print("Que cuadrante de la ventana quiere romper: ");
		posicion = Entrada.cadena().toUpperCase();
		System.out.println();

		for (int x = 0; x < num; x++) {

			for (int y = 0; y < num; y++) {

				if (y == 0 || x == 0 || y == num - 1 || x == num - 1 ||  y == mitad || x == mitad) {
					System.out.print(" *");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}

		if (posicion == "ARRIBA IZQUIERDA") {

		} else {
			if (posicion == "ARRIBA DERECHA") {

			} else {
				if (posicion == "ABAJO IZQUIERDA") {

				} else {
					if (posicion == "ABAJO DERECHA") {

					} else {
						
					}
				}
			}
		}

		System.out.print("Introduce la cantidad de cuadrados: ");
		System.out.println();

	}
}
