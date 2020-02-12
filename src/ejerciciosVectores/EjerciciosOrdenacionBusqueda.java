package ejerciciosVectores;

public class EjerciciosOrdenacionBusqueda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Ejercicio 7
		int[] vector = new int[100];
		int res = 0;

		for (int i = 0; i < vector.length; i++) {
			vector[i] = (int) (Math.random() * 100 + 1);
		}
		Ordenacion.insercion(vector);

		for (int i = 1; i <= 100; i++) {
			res = busquedaBinaria(vector, i);
			if (res == -1)
				System.out.println("El valor " + i + " no ha sido encontrado en el vector.");
		}
	}

	/*
	 * Ejercicio 2. Realiza un programa que cree dos vectores de 100 elementos. El
	 * primero almacenar� una serie de datos num�ricos desordenados. Dichos datos
	 * ser�n datos generados aleatoriamente. El segundo array contendr� los mismos
	 * datos pero ordenados por el m�todo de inserci�n.
	 */

	static void insercionEnOtro(int vector[], int vector_ordenado[]) {
		int i, j;
		for (i = 0; i < vector.length; i++) {
			j = i - 1;
			while ((j >= 0) && (vector_ordenado[j] > vector[i])) {
				vector_ordenado[j + 1] = vector_ordenado[j];
				j--;
			}
			vector_ordenado[j + 1] = vector[i];
		}
	}

	public static void ejer2() {
		int[] vector = Ordenacion.generaVectorAleatorio(100, 1, 100);
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
	public static int[] ordenarVectores(int[] vector1, int[] vector2) {
		int vectorOrdenado[] = new int[vector1.length + vector2.length];

		int i, j;

		for (i = 0; i < vector1.length; i++) {
			j = i - 1;
			while ((j >= 0) && (vectorOrdenado[j] > vector1[i])) {
				vectorOrdenado[j + 1] = vectorOrdenado[j];
				j--;
			}
			vectorOrdenado[j + 1] = vector1[i];
		}

		for (i = 0; i < vector2.length; i++) {
			j = vector1.length + i - 1;
			while ((j >= 0) && (vectorOrdenado[j] > vector2[i])) {
				vectorOrdenado[j + 1] = vectorOrdenado[j];
				j--;
			}
			vectorOrdenado[j + 1] = vector2[i];
		}

		return vectorOrdenado;
	}

	static int[] ordenaDosVectoresInserc(int[] arr1, int[] arr2) {
		int[] arrOrd = new int[arr1.length + arr2.length];
		int k1 = 0, k2 = 0, temp = 0, j = 0;

		for (int k = 0; k < (arr1.length + arr2.length); k = k + 2) // recorro el vector desordenado
		{
			if (k1 < arr1.length) {
				j = k - 1;
				temp = arr1[k1];

				while ((j >= 0) && (arrOrd[j] > temp)) { // uso m�todo de inserci�n
					arrOrd[j + 1] = arrOrd[j];
					j--;
				}
				arrOrd[j + 1] = temp;
				k1++;
			}

			if (k2 < arr2.length) {
				j = k;
				temp = arr2[k2];

				while ((j >= 0) && (arrOrd[j] > temp)) { // uso m�todo de inserci�n
					arrOrd[j + 1] = arrOrd[j];
					j--;
				}
				arrOrd[j + 1] = temp;
				k2++;
			}
		}

		return arrOrd;
	}

	/*
	 * Ejercicio 4. Realiza un programa que cree 1000 n�meros aleatorios y muestre
	 * los 10 mayores.
	 * 
	 * 
	 */
	static void seleccionDescendente(int[] vector, int numMayores) {
		int pos, temp;
		for (int i = 0; i < numMayores; i++) {
			pos = i;
			for (int j = i + 1; j <= (vector.length - 1); j++)
				if (vector[j] > vector[pos])
					pos = j;

			if (pos != i) {
				temp = vector[pos];
				vector[pos] = vector[i];
				vector[i] = temp;
			}
		}
	}

	public static void muestraMayores(int[] arr, int n) // lo he hecho aplicando una burbuja (que ordena del mayor
	// n�mero al menor, pero s�lo hasta donde queramos llegar
	{
		int temp;
		int i, j;
		int[] array = arr.clone();
		for (i = array.length - 1; i > array.length - 1 - n; i--) {
			for (j = i - 1; j >= 0; j--) {
				if (array[i] < array[j]) {
					temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
			System.out.println(array[i]);
		}
	}

	/*
	 * Ejercicio 5. Realiza un programa que cree un vector de 100 posiciones con
	 * n�meros aleatorios entre 10 y 80. Una vez creado el vector el programa deber�
	 * mostrar el mayor, el menor, el valor que m�s se repite y la media.
	 */
	public static void menorMayorRepeticiones(int[] vector) {

		int cont = 0, contFinal = 0, num = 0, numFinal = 0;

		Ordenacion.insercion(vector);

		numFinal = vector[0];
		num = numFinal;
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] == num)
				cont++;
			else {
				if (cont > contFinal) {
					numFinal = num;
					contFinal = cont;
				}

				cont = 1;
				num = vector[i];
			}
			if (cont > contFinal) {
				numFinal = num;
				contFinal = cont;
			}
		}
	}

	public static void menorMayorMediaRepite(int[] vec) {
		Ordenacion.quicksort(vec, 0, vec.length - 1);

		System.out.println("El mayor es: " + vec[vec.length - 1]);
		System.out.println("El menor es: " + vec[0]);

		int rep = 0, numRep = vec[0], contRep = 1, cont = 1, suma = vec[0];

		for (int i = 1; i < vec.length; i++) {
			suma = suma + vec[i];
			cont++;

			if (vec[i] == vec[i - 1])
				contRep++;
			else {
				if (contRep > rep) {
					rep = contRep;
					numRep = vec[i - 1];
				}
				contRep = 1;
			}
		}

		if (contRep > rep) {
			rep = contRep;
			numRep = vec[vec.length - 1];
		}

		System.out.println("El n�mero que m�s se repite es " + numRep + " que se repite " + rep + " veces");
		System.out.println("La media es " + (double) suma / cont);
	}

	/*
	 * Ejercicio 6. Convierte la funci�n busquedabin la cual tenga un m�todo que
	 * busque un valor en un array ordenado utilizando la b�squeda binaria.
	 * Implementa el m�todo de tal manera que muestre las posiciones (min y max)
	 * desde las cuales va buscando y los valores de dichas posiciones as� como la
	 * posici�n intermedia y el valor de dicha posici�n., la salida debe ser algo
	 * as�:
	 */

	public static int busquedaBinaria(int vector[], int dato) {
		int centro, inf = 0, sup = vector.length - 1;

		System.out.print(vector[0]);
		for (int i = 1; i < vector.length; i++)
			System.out.print(", " + vector[i]);
		System.out.println("");

		while (inf <= sup) {
			System.out.println("\nBuscando entra las posiciones " + inf + " y " + sup);
			System.out.println("Con valores menor: " + vector[inf] + " y mayor: " + vector[sup]);

			centro = (sup + inf) / 2;

			System.out.println("Posicion central: " + centro + " y su valor es " + vector[centro]);

			if (vector[centro] == dato) {
				System.out.println("\nSu valor ha sido encontrado: " + centro);
				return centro;
			} else if (dato < vector[centro])
				sup = centro - 1;
			else
				inf = centro + 1;
		}
		return -1;
	}

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

	public static int busquedaBinariaRecursiva(int vector[], int dato, int inf, int sup) {
		int centro = (sup + inf) / 2;

		if (inf > sup)
			return -1;
		else if (dato > vector[centro])
			return busquedaBinariaRecursiva(vector, dato, centro + 1, sup);
		else if (dato < vector[centro])
			return busquedaBinariaRecursiva(vector, dato, inf, centro - 1);
		else
			return centro;
	}
}
