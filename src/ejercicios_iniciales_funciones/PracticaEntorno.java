package ejercicios_iniciales_funciones;

public class PracticaEntorno {

	public static void main(String[] args) {

		/*
		 * 1º Ejercicio
		 */
		int num = 0;

		System.out.print("Introduce un número: ");
//		num = Entrada.entero();
//		factorial(num);

		/*
		 * 2º Ejercicio
		 */
		int[][] m = new int[5][2];

		for (int i = 0; i < m.length; i++) {
			for (int k = 0; k < m[i].length; k++) {
				m[i][k] = (int) Math.floor(Math.random() * 100);
			}
		}

		/*
		 * 3º Ejercicio
		 */
		int num1 = 0, num2 = 0, cont = 2;

		System.out.println("Introduzca un número");
		num1 = Entrada.entero();

		num2 = num1;

		while (num2 != 0) {
			if (!esPrimo(cont)) {
				cont++;
			} else {
				if (num2 % cont == 0) {

					if (num2 == cont)
						System.out.print(cont);
					else
						System.out.print(cont + "*");

					num2 /= cont;
				} else {
					cont++;
				}
			}
		}

	}

	public static void factorial(int num) {
		int factorial = num;
		for (int i = num; i <= num; i--) {
			num *= i;
		}

	}

	public static boolean esPrimo(int num) {
		int cont = 2;

		if (num == 0)
			return false;

		while (cont < num) {
			if (num % cont == 0) {
				return false;
			}
			cont++;
		}
		return true;
	}

}
