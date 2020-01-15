package ejerciciosMatrices;

public class EjercicioInicialMatrices {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] matriz = { { 1, 5, 5, 8 }, { 3, 7, 4, 4, 9 } };

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
	public void buscaElemento(int[][] mat, int num) {
		int cont;

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {

				if (num == mat[i][j]) {
					System.out.println("El número esta en la fila" + i + " y en la columna" + j);
				}
			}
		}

	}

	// 3. Crea una función buscayDevuelvePosicionesElemento que se le pase como
	// parámetro una matriz de tipo entero y un número entero y muestre por pantalla
	// devuelva un vector de dos posiciones en la que la que se guarde la fila y la
	// columna donde se encuentra dicho número.
	//
	public static int buscayDevuelvePosicionesElemento(int[][] m) {
		return 0;
	}

	// 4. Crea una función esMatrizCuadrada que se le pase como parámetro una matriz
	// y devuelva cierto si la matriz es cuadrada o falso si no lo es. Una matriz es
	// cuadrada cuando el número de filas es igual al número de columnas de todas
	// las filas.
	//
	public static int esMatrizCuadrada(int[][] m) {
		return 0;
	}

	// 5. Crea una función esMatrizEscalar que se le pase como parámetro una matriz
	// y devuelva cierto si la matriz es Escalar o falso si no lo es. Una matriz es
	// escalar si es cuadrada y si todos los elementos de la diagonal son iguales.
	//
	public static int esMatrizEscalar(int[][] m) {
		return 0;
	}

	// 6. Crea una función esMatrizIdentidad que se le pase como parámetro una
	// matriz y devuelva cierto si la matriz es Identidad o falso si no lo es. Una
	// matriz es cuadrada, todos los elementos de la diagonal son 1 y el resto de
	// elementos son 0.
	//
	public static int esMatrizIdentidad(int[][] m) {
		return 0;
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
	public static int esMatrizTriangular(int[][] m) {
		return 0;
	}

	// 8. Crea una función sumaMatrices que se le pase como parámetro dos matrices
	// tipo double y devuelva otra matriz con la suma de las dos anteriores (ten en
	// cuenta que las dos matrices deben tener el mismo número de filas y de
	// columnas), en caso de no poder hacerlo devolverá la matriz nula.
	//
	public static int sumaMatrices(int[][] m) {
		return 0;
	}
}
