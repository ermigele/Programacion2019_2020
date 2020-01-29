package ejerciciosVectores;

public class EjerciciosOrdenacionBusqueda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int[] vector = { 12, -4, 1, 0, 3, 7, 15 };

		ejer2();
	}

	/*
	 * Ejercicio 1. Haz la traza de la ordenaci�n del siguiente vector con los
	 * algoritmos de burbuja optimizada, inserci�n, selecci�n y quicksort. �Cuantas
	 * iteraciones realiza cada uno?
	 */

	/*
	 * Ejercicio 2. Realiza un programa que cree dos vectores de 100 elementos. El
	 * primero almacenar� una serie de datos num�ricos desordenados. Dichos datos
	 * ser�n datos generados aleatoriamente. El segundo array contendr� los mismos
	 * datos pero ordenados por el m�todo de inserci�n.
	 */
	public static void ejer2() {
		int[] vector = generaVectorAleatorio(100, 1, 100);
		int[] vector2 = new int[100];

		int i, temp, j; // inserci�n
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
	 * Ejercicio 3. Realiza un m�todo que tome como par�metros de entrada dos arrays
	 * de enteros y devuelva como salida un �nico array con los elementos de los
	 * anteriores arrays ordenados de forma ascendente. Intenta hacerlo de la manera
	 * m�s eficiente posible. �Qu� m�todo de ordenaci�n has usado?
	 * 
	 */

	public static int[] ejer3(int[] vector, int[] vector2) {
		int[] array = new int[vector.length + vector2.length];

		int i, j, k, temp; // inserci�n

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
	 * Ejercicio 4. Realiza un programa que cree 1000 n�meros aleatorios y muestre
	 * los 10 mayores.
	 * 
	 * 
	 */

	/*
	 * Ejercicio 5. Realiza un programa que cree un vector de 100 posiciones con
	 * n�meros aleatorios entre 10 y 80. Una vez creado el vector el programa deber�
	 * mostrar el mayor, el menor, el valor que m�s se repite y la media.
	 */

	/*
	 * Ejercicio 6. Convierte la funci�n busquedabin la cual tenga un m�todo que
	 * busque un valor en un array ordenado utilizando la b�squeda binaria.
	 * Implementa el m�todo de tal manera que muestre las posiciones (min y max)
	 * desde las cuales va buscando y los valores de dichas posiciones as� como la
	 * posici�n intermedia y el valor de dicha posici�n., la salida debe ser algo
	 * as�:
	 */

	/*
	 * Ejercicio 7. Realiza un programa que cree un vector de 100 posiciones con
	 * n�meros aleatorios entre 1 y 100 (pueden repetirse). Una vez creado el vector
	 * el programa deber� mostrar los n�meros entre 1 y 100 que no han sido
	 * almacenados. Indica qu� algoritmo de ordenaci�n has usado y qu� algoritmo de
	 * b�squeda.
	 */

	/*
	 * Ejercicio 8. Convierte la funci�n busquedaBinaria en recursiva.
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
