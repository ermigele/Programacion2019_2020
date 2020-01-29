package ejerciciosVectores;

public class EjerciciosOrdenacionBusqueda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int[] vector = { 12, -4, 1, 0, 3, 7, 15 };

		ejer2();
	}

	/*
	 * Ejercicio 1. Haz la traza de la ordenación del siguiente vector con los
	 * algoritmos de burbuja optimizada, inserción, selección y quicksort. ¿Cuantas
	 * iteraciones realiza cada uno?
	 */

	/*
	 * Ejercicio 2. Realiza un programa que cree dos vectores de 100 elementos. El
	 * primero almacenará una serie de datos numéricos desordenados. Dichos datos
	 * serán datos generados aleatoriamente. El segundo array contendrá los mismos
	 * datos pero ordenados por el método de inserción.
	 */
	public static void ejer2() {
		int[] vector = generaVectorAleatorio(100, 1, 100);
		int[] vector2 = new int[100];

		int i, temp, j; // inserción
		for (i = 0; i < vector.length; i++) {
			temp = vector[i];
			j = i - 1;
			while ((j >= 0) && (vector2[j] > temp)) {
				vector2[j + 1] = vector2[j];
				j--;
			}
			vector2[j + 1] = temp;
		}
	}

	/*
	 * Ejercicio 3. Realiza un método que tome como parámetros de entrada dos arrays
	 * de enteros y devuelva como salida un único array con los elementos de los
	 * anteriores arrays ordenados de forma ascendente. Intenta hacerlo de la manera
	 * más eficiente posible. ¿Qué método de ordenación has usado?
	 * 
	 */

	public static int[] ejer3(int[] vector, int[] vector2) {
		int[] array = new int[vector.length + vector2.length];

		int i, j, k, temp; // inserción

		for (i = 0; i < vector.length; i++) {
			for (k = 0; k < vector2.length; k++) {
				temp = vector[i];
				j = i - 1;
				while ((j >= 0) && (vector[j] < temp)) {
					vector[j + 1] = vector[j];
					j--;
				}
				vector[j + 1] = temp;
			}
		}
		return array;
	}

	/*
	 * Ejercicio 4. Realiza un programa que cree 1000 números aleatorios y muestre
	 * los 10 mayores.
	 * 
	 * 
	 */

	/*
	 * Ejercicio 5. Realiza un programa que cree un vector de 100 posiciones con
	 * números aleatorios entre 10 y 80. Una vez creado el vector el programa deberá
	 * mostrar el mayor, el menor, el valor que más se repite y la media.
	 */

	/*
	 * Ejercicio 6. Convierte la función busquedabin la cual tenga un método que
	 * busque un valor en un array ordenado utilizando la búsqueda binaria.
	 * Implementa el método de tal manera que muestre las posiciones (min y max)
	 * desde las cuales va buscando y los valores de dichas posiciones así como la
	 * posición intermedia y el valor de dicha posición., la salida debe ser algo
	 * así:
	 */

	/*
	 * Ejercicio 7. Realiza un programa que cree un vector de 100 posiciones con
	 * números aleatorios entre 1 y 100 (pueden repetirse). Una vez creado el vector
	 * el programa deberá mostrar los números entre 1 y 100 que no han sido
	 * almacenados. Indica qué algoritmo de ordenación has usado y qué algoritmo de
	 * búsqueda.
	 */

	/*
	 * Ejercicio 8. Convierte la función busquedaBinaria en recursiva.
	 */

	public static int[] generaVectorAleatorio(int tam, int min, int max) {

		int[] vector12 = new int[tam];

		for (int i = 0; i < vector12.length; i++) {
			int aleatorio = (int) (Math.random() * (max)) + min;
			vector12[i] = aleatorio;
		}
		return vector12;
	}

	public static void insercion(int vector[]) {
		int i, temp, j;
		for (i = 1; i < vector.length; i++) {
			temp = vector[i];
			j = i - 1;
			while ((j >= 0) && (vector[j] > temp)) {
				vector[j + 1] = vector[j];
				j--;
			}
			vector[j + 1] = temp;
		}
	}
}
