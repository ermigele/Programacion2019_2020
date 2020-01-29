package ejerciciosMatrices;

public class EjercicioInicialMatrices {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] m = { { 2, 4, 6 }, { 3, 5, 7 } };
		mostrarMatriz(m);

		sumaMatriz(m);
		buscaElemento(m, 7);

		mostrarVector(buscayDevuelvePosicionesElemento(m, 5));
	}

	// UTILES
	public static void mostrarVector(int[] vector) {

		for (int i = 0; i < vector.length; i++) {
			System.out.println(vector[i]);
		}

		System.out.println();
	}

	public static void mostrarMatriz(int[][] matriz) {

		for (int i = 0; i < matriz.length; i++) {
			for (int k = 0; k < matriz[i].length; k++) {
				System.out.print("   " + matriz[i][k]);
			}
			System.out.println();
		}
		System.out.println();
	}

	// EJERCICIOS

	// 1. Crea una función sumaMatriz a la que se le pase como parámetro una matriz
	// de tipo entero y devuelva la suma de todos los elementos de dicha matriz.
	//
	public static int sumaMatriz(int[][] mat) {
		int suma = 0;

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {

				suma += mat[i][j];
			}
		}
		return suma;
	}

	// 2. Crea una función buscaElemento que se le pase como parámetro una matriz de
	// tipo entero y un número entero y muestre por pantalla todas las apariciones
	// de ese número y en qué fila y columna se encuentra dicho número. Al final
	// también debe imprimir el número de apariciones de dicho número.
	//
	public static void buscaElemento(int[][] mat, int num) {

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {

				if (num == mat[i][j]) {
					System.out.println("El número " + num + " esta en la fila " + i + " y en la columna " + j);
				}
			}
		}
	}

	// 3. Crea una función buscayDevuelvePosicionesElemento que se le pase como
	// parámetro una matriz de tipo entero y un número entero y devuelva un vector
	// de dos posiciones en la que la que se guarde la fila y la columna donde se
	// encuentra dicho número.
	//
	public static int[] buscayDevuelvePosicionesElemento(int[][] mat, int num) {
		int[] array = new int[2];

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {

				if (num == mat[i][j]) {
					array[0] = i;
					array[1] = j;
				}
			}
		}
		return array;
	}

	// 4. Crea una función esMatrizCuadrada que se le pase como parámetro una matriz
	// y devuelva cierto si la matriz es cuadrada o falso si no lo es. Una matriz es
	// cuadrada cuando el número de filas es igual al número de columnas de todas
	// las filas.
	//
	public static boolean esMatrizCuadrada(int[][] mat) {
		boolean cuadrada = false;

		for (int i = 0; i < mat.length; i++) {

			if (mat[i].length == mat.length) {
				cuadrada = true;
			}
		}
		return cuadrada;
	}

	// 5. Crea una función esMatrizEscalar que se le pase como parámetro una matriz
	// y devuelva cierto si la matriz es Escalar o falso si no lo es. Una matriz es
	// escalar si es cuadrada y si todos los elementos de la diagonal son iguales.
	//
	public static boolean esMatrizEscalar(int[][] mat) {
		int i = 1;

		if (!esMatrizTriangularSuperior(mat) && !esMatrizTriangularInferior(mat))
			return false;

		while ((i < mat.length)) {
			if (mat[i - 1][i - 1] != mat[i][i])
				return false;

			i++;
		}
		return true;
	}

	// 6. Crea una función esMatrizIdentidad que se le pase como parámetro una
	// matriz y devuelva cierto si la matriz es Identidad o falso si no lo es. Una
	// matriz es cuadrada, todos los elementos de la diagonal son 1 y el resto de
	// elementos son 0.
	//
	public static boolean esMatrizIdentidad(int[][] matriz) {
		if (matriz[0][0] == 1 && esMatrizEscalar(matriz) == true)
			return true;
		else
			return false;
	}

	// 7. Crea una función esMatrizTriangular que se le pase como parámetro una
	// matriz y devuelva una cadena “es diagonal” si todos los elementos excepto la
	// diagonal son 0 ́s, “es triangular superior” si todos los elementos por debajo
	// de la diagonal son 0’s, “es triangular inferior” si todos los elementos por
	// encima de la diagonal son 0’s o “no es triangular” si no cumple con ninguna
	// de las anteriores. Utiliza dos funciones auxiliares
	// esMatrizTriangularSuperior y esMatrizTriangularInferior que devuelvan
	// verdadero o falso.
	//

	public static boolean esMatrizTriangularSuperior(int matriz[][]) {

		if (!esMatrizCuadrada(matriz))
			return false;

		for (int i = 0; i < matriz.length; i++)
			for (int j = 0; j < i; j++)
				if (matriz[i][j] != 0)
					return false;
		return true;
	}

	public static boolean esMatrizTriangularInferior(int matriz[][]) {
		if (!esMatrizCuadrada(matriz))
			return false;

		for (int i = 0; i < matriz.length; i++)
			for (int j = i + 1; j < matriz[i].length; j++)
				if (matriz[i][j] != 0)
					return false;
		return true;
	}

	// 8. Crea una función sumaMatrices que se le pase como parámetro dos matrices
	// tipo double y devuelva otra matriz con la suma de las dos anteriores (ten en
	// cuenta que las dos matrices deben tener el mismo número de filas y de
	// columnas), en caso de no poder hacerlo devolverá la matriz nula.
	//
	public static int[][] sumaMatrices(int[][] m1, int[][] m2) {
		// int[][] mat = new int[][];
		//
		// if (m1.length != m2.length)
		 return null;

	}

	// 9. Crea una función multiplicaMatrices que se le pase como parámetro dos
	// matrices tipo double y devuelva una matriz que sea la multiplicación de ambas
	// matrices. Ten en cuenta que para que se puedan multiplicar, el número de
	// filas de una debe ser igual al número de columnas de la otra y viceversa.
	//

	// 10. Crea una función clonaMatriz que reciba como parámetro una matriz y
	// devuelva la misma matriz clonada. En el main haz una prueba de modificación
	// sobre la nueva matriz para comprobar que la matriz original no es modificada.
	//

	// 11. Crea una función transponerFilas que reciba como parámetro una matriz y
	// dos números y transponga las filas que se encuentran en esos dos números. La
	// función devolverá TRUE si ha podido transponer las filas y FALSE en caso
	// contrario.
	//

	// 12. Crea una función transponerColumnas idem que la anterior pero
	// transponiendo columnas.

}
