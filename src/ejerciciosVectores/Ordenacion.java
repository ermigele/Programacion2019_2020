package ejerciciosVectores;

public class Ordenacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = { 6, 5, 8, 9, 11, 40, 67, 29, 67, 25 };

		quicksort(array, 1, 2);

	}

	public static int[] generaVectorAleatorio(int tam, int min, int max) {

		int[] vector12 = new int[tam];

		for (int i = 0; i < vector12.length; i++) {
			int aleatorio = (int) (Math.random() * (max)) + min;
			vector12[i] = aleatorio;
		}
		return vector12;
	}

	static void muestraVector(int[] vec) {
		System.out.print("\n" + vec[0]);
		for (int i = 1; i < vec.length; i++)
			System.out.print("," + vec[i]);
	}

	static void burbujaSimple(int[] vector) {
		int temp;
		for (int i = 1; i < vector.length; i++)
			for (int j = 0; j <= (vector.length - 2); j++) {
				if (vector[j] > vector[j + 1]) {
					temp = vector[j];
					vector[j] = vector[j + 1];
					vector[j + 1] = temp;
				}
			}
	}

	static void burbujaOptimizada(int vector[]) {
		int temp;
		int i, j;
		for (i = 1; i < vector.length; i++) {
			for (j = 0; j < i; j++) {
				if (vector[i] < vector[j]) {
					temp = vector[j];
					vector[j] = vector[i];
					vector[i] = temp;
				}
			}
		}
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

	public static void seleccion(int[] vector) {
		int pos, temp;
		for (int i = 0; i <= (vector.length - 2); i++) {
			pos = i;
			for (int j = i + 1; j <= (vector.length - 1); j++)
				if (vector[j] < vector[pos])
					pos = j;

			if (pos != i) {
				temp = vector[pos];
				vector[pos] = vector[i];
				vector[i] = temp;
			}
		}
	}

	public static void quicksort(int A[], int izq, int der) {

		int pivote = A[izq]; // tomamos primer elemento como pivote
		int i = izq; // i realiza la búsqueda de izquierda a derecha
		int j = der; // j realiza la búsqueda de derecha a izquierda
		int aux;

		while (i < j) { // mientras no se crucen las búsquedas
			while (A[i] <= pivote && i < j) {
				i++;
				// busca elemento mayor que pivote
			}
			while (A[j] > pivote) {
				j--;
				// busca elemento menor que pivote
			}
			if (i < j) { // si no se han cruzado
				aux = A[i]; // los intercambia
				A[i] = A[j];
				A[j] = aux;
			}
		}
		A[izq] = A[j]; // se coloca el pivote en su lugar de forma que tendremos
		A[j] = pivote; // los menores a su izquierda y los mayores a su derecha
		if (izq < j - 1)
			quicksort(A, izq, j - 1); // ordenamos subarray izquierdo
		if (j + 1 < der)
			quicksort(A, j + 1, der); // ordenamos subarray derecho
	}

}
