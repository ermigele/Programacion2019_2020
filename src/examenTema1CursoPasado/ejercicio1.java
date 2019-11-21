package examenTema1CursoPasado;

public class ejercicio1 {

	public static void main(String[] args) {
		/*
		 * Vamos a hacer un programa en JAVA para construir una ventana y romper uno de
		 * los cristales de la misma. El programa pedir� al usuario el tama�o de la
		 * ventana, que debe ser un n�mero impar mayor de 10. Luego preguntar� al
		 * usuario qu� cuadrante de la ventana quiere romper, podr� ser �arriba
		 * izquierda�, �arriba derecha�, �abajo izquierda� o �abajo derecha�, el usuario
		 * puede escribir estas cadenas en may�sculas, min�sculas o unas en min�sculas y
		 * otras en may�sculas. El usuario tambi�n podr�a escribir cualquier otra
		 * cadena, de manera que no se romper�a ning�n cuadrante. En este ejercicio no
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

		if (posicion.equals("ARRIBA IZQUIERDA")) {
			for (int x = 0; x < num; x++) {
				for (int y = 0; y < num; y++) {

					if ((y >= 0 && y < mitad && x <= mitad) || y == 0 || x == 0 || y == num - 1 || x == num - 1
							|| y == mitad || x == mitad) {
						System.out.print(" *");

					} else {
						System.out.print("  ");
					}
				}
				System.out.println();
			}
		} else {
			if (posicion.equals("ARRIBA DERECHA")) {
				for (int x = 0; x < num; x++) {
					for (int y = 0; y < num; y++) {

						if ((y >= 0 && y > mitad && x < mitad) || y == 0 || x == 0 || y == num - 1 || x == num - 1
								|| y == mitad || x == mitad) {
							System.out.print(" *");

						} else {
							System.out.print("  ");
						}
					}
					System.out.println();
				}
			} else {
				if (posicion.equals("ABAJO IZQUIERDA")) {
					for (int x = 0; x < num; x++) {
						for (int y = 0; y < num; y++) {

							if ((y >= 0 && y < mitad && x > mitad) || y == 0 || x == 0 || y == num - 1 || x == num - 1
									|| y == mitad || x == mitad) {
								System.out.print(" *");

							} else {
								System.out.print("  ");
							}
						}
						System.out.println();
					}
				} else {
					if (posicion.equals("ABAJO DERECHA")) {
						for (int x = 0; x < num; x++) {
							for (int y = 0; y < num; y++) {

								if ((y >= 0 && y > mitad && x > mitad) || y == 0 || x == 0 || y == num - 1
										|| x == num - 1 || y == mitad || x == mitad) {
									System.out.print(" *");

								} else {
									System.out.print("  ");
								}
							}
							System.out.println();
						}
					} else { // Imprime la ventana sin romper
						for (int x = 0; x < num; x++) {
							for (int y = 0; y < num; y++) {

								if (y == 0 || x == 0 || y == num - 1 || x == num - 1 || y == mitad || x == mitad) {
									System.out.print(" *");
								} else {
									System.out.print("  ");
								}
							}
							System.out.println();
						}
					}
				}
			}
		}
	}
}
