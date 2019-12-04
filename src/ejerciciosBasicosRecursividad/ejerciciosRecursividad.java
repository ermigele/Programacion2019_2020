package ejerciciosBasicosRecursividad;

public class ejerciciosRecursividad {

	public static void main(String[] args) {

		System.out.print("Introduce un número: ");
		imprimeImparesNoPrimos(Entrada.entero());

	}

	// METODOS

	// Ejercicio 1
	// Escribe una función recursiva llamada tablaDeMultiplicar(entero num) que
	// imprima la tabla de multiplicar del número dado como parámetro.

	public static void tablaDeMultiplicar(int num, int i) {

		// caso base
		if (i == 1)
			System.out.println("" + num + " x " + i + " es: " + num * i);

		// caso recursivo
		else {
			tablaDeMultiplicar(num, i - 1);
			System.out.println("" + num + " x " + i + " es: " + num * i);

		}
	}

	// Ejercicio 2
	// Escribe una función recursiva llamada potencia(entero base, entero exponente)
	// que imprima la potencia del parámetro base elevada al parámetro exponente.
	public static int potencia(int base, int exp) {
		// caso base
		if (exp == 0)
			return 1;

		// caso recursivo
		else
			return potencia(base, exp - 1) * base;
	}

	// Ejercicio 3
	// Escribe una función recursiva imprimeCifrasNumero(entero numero) que muestre
	// las cifras de un número entero en su mismo orden, por ejemplo, para el número
	// 1051 la salida debe ser 1,0,5,1.
	public static void imprimeCifrasNumero(int num) {
		// caso base
		if (num == 0)
			System.out.println();

		// caso recursivo
		if (num > 0) {
			imprimeCifrasNumero(num / 10);
			System.out.print(num % 10 + ",");
		}
	}

	// Ejercicio 4
	// Escribe una función recursiva imprimeImparesNoPrimos(entero n) que imprima
	// solo los números impares y no primos desde 1 hasta n.
	public static void imprimeImparesNoPrimos(int num) {
		int div = 2;
		// case base
		if (num % div == 0 && num == num)
			System.out.println();

		else  {
			System.out.println(num);
			imprimeImparesNoPrimos(num - 1);

		}
	}
}
