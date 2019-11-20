package practica3;

public class ejercicio4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Escribe un programa en JAVA que pida un número impar mayor de 6 al usuario
		 * (debe pedirle el número hasta que el usuario inserte un valor correcto) e
		 * imprima por pantalla la siguiente figura:
		 */

		int num = 0;

		while (num < 7 || num % 2 == 0) {
			System.out.print("Introduce un númer impar mayor que 6: ");
			num = Entrada.entero();
		}

		for (int fila = 0; fila < num; fila++) {

			for (int col = 0; col < num; col++) {

				if (col == num / 2 || fila == num / 2 || fila - col == num / 2 || col - fila == num / 2
						|| col + fila == num / 2 || col + fila == (num / 2) * 3) {
					System.out.print(" *");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}

	}
}
