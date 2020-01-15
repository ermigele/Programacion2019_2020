package ejerciciosVectores;

public class Vectores_funciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int vector[] = new int[8];
		int[] vector = { 1, 5, 5, 8 };

		// muestraValoresVector(vector);
		//
		// System.out.println(devuelvePosicion(vector, 5));
		//
		// multiplicaPropioVector(vector, 4);
		//
		// for (int v : vector) {
		// System.out.println(v);
		// }
		//
		// System.out.println("sumaVectores");
		// for (int v : sumaVectores(vector, vector2)) {
		// System.out.println(v);
		// }

		multiplicaVectorEnOtro(vector, 5);

		System.out.println("devuelvePosiciones");
		for (int v : devuelvePosiciones(vector, 5)) {
			System.out.println(v);
		}
		System.out.println("generaVectorAleatorio");
		for (int v : generaVectorAleatorio(4, 0, 9)) {
			System.out.println(v);
		}

	}

	// Recibe como parámetro un vector y muestra por pantalla la posición y el
	// contenido para cada posición del vector de la forma “la posición 0 contiene
	// el valor 3” y así sucesivamente.
	//
	public static void muestraValoresVector(int[] vector) {

		for (int i = 0; i < vector.length; i++) {
			System.out.println("la posición " + i + " contiene el valor " + vector[i]);
		}

	}

	// Recibe como parámetro un vector y un número y devuelve la primera posición
	// donde está dicho número. Si el número no está en el vector, devolverá el
	// valor -1.
	//
	public static int devuelvePosicion(int[] vector, int num) {

		int posicion = -1;

		for (int i = vector.length - 1; i >= 0; i--) {

			if (vector[i] == num)
				posicion = i;

		}
		return posicion;
	}

	// Recibe como parámetro un vector y un número y cambia todos los valores del
	// vector multiplicándolos por el número dado.
	//
	public static void multiplicaPropioVector(int[] vector, int num) {

		for (int i = 0; i < vector.length; i++) {
			vector[i] = vector[i] * num;
		}

	}

	// Recibe como parámetro un vector y un número y devuelve un vector del mismo
	// tamaño que el del parámetro con todos los valores multiplicados por el número
	// dado.
	//
	public static int[] multiplicaVectorEnOtro(int[] vector, int num) {

		int[] array = vector.clone();

		for (int i = 0; i < vector.length; i++) {
			array[i] = vector[i] * num;
		}

		return array;
	}

	// Recibe como parámetro dos vectores (se suponen del mismo tamaño) y devuelve
	// un vector que en cada posición contiene la suma de los valores de los
	// vectores pasados como parámetros para la misma posición.
	//
	public static int[] sumaVectores(int[] vector1, int[] vector2) {

		int[] array = new int[vector1.length];

		for (int i = 0; i < vector1.length; i++) {
			array[i] = vector1[i] + vector2[i];
		}

		return array;
	}

	// Recibe como parámetro un vector y devuelve otro vector que
	// contiene sólo los números pares. ¿se podría hacer teniendo el vector devuelto
	// el tamaño correcto para que no rellene con 0 el resto de posiciones?
	//
	public static int[] valoresPares(int[] vector) {
		int pares = 0;

		for (int i = 0; i < vector.length; i++) {
			if (vector[i] % 2 == 0) {
				pares++;
			}
		}

		int[] vector3 = new int[pares];
		int j = 0;

		for (int i = 0; i < vector.length; i++) {
			if (vector[i] % 2 == 0) {
				vector3[j] = vector[i];
				j++;
			}
		}
		return vector3;
	}

	// Recibe como parámetro un vector y un número y devuelve en otro vector todas
	// las posiciones donde está dicho número.
	//
	public static int[] devuelvePosiciones(int[] vector, int num) {

		int[] array = null;
		int cont = 0;

		for (int i = 0; i < vector.length; i++) {

			if (vector[i] == num) {
				cont++;
			}
		}
		array = new int[cont];
		return array;
	}

	// Recibe como parámetro tres enteros: tam, min y max y devuelve un vector de
	// tamaño tam con valores aleatorios entre min y max.
	//
	public static int[] generaVectorAleatorio(int tam, int min, int max) {
		int[] vector = new int[tam];

		for (int i = 0; i < vector.length; i++) {
			vector[i] = (int) Math.floor(Math.random() * (max - min + 1) + (min));
		}
		return vector;
	}
}
