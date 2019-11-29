package ejerciciosMasFunciones;
/*
 * Diseña un método numerosPrimosGemelos que reciba como parámetro un número n e
 * imprima por pantalla las n primeras tuplas de primos gemelos. Por ejemplo, si
 * el número introducido es el 5, el método devolverá: Las 5 primeras tuplas de
 * números primos gemelos son:
 * 
 *  (3,5) (5,7) (11,13) (17,19) (29,31) 
 *  
 * Para diseñarlo, haz el uso de la función esPrimo implementada en los primeros
 * ejercicios de funciones y crea otra función auxiliar llamada siguientePrimo
 * que reciba como parámetro un número primo y devuelva el siguiente.
 */

public class Ejercicio2MasFunciones {

	public static void main(String[] args) {

		System.out.print("Introduce un número: ");

		numerosPrimosGemelos(Entrada.entero());

	}

	public static void numerosPrimosGemelos(int tupla) {

		int i = 0, cont = 0;
		int primo1 = 0, primo2 = 0;

		while (cont <= tupla) {

			if (esPrimo(i)) {
				primo1 = i;

				primo2 = siguientePrimo(primo1);
				i = primo2 + 1;
				cont++;
			} else {
				i++;
			}
			System.out.println(" (" + primo1 + "),(" + primo2 + ") ");
		}
	}

	public static int siguientePrimo(int num) {

		int posiblePrimo = num + 2;

		if (esPrimo(posiblePrimo)) {
			return posiblePrimo;
		} else {
			return num;
		}
	}

	public static boolean esPrimo(int num) {
		int cont = 2;

		while (cont < num) {
			if (num % cont == 0)
				return false;
			cont++;
		}
		return true;
	}
}
