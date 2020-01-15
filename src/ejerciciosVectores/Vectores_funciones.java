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

	// Recibe como par�metro un vector y muestra por pantalla la posici�n y el
	// contenido para cada posici�n del vector de la forma �la posici�n 0 contiene
	// el valor 3� y as� sucesivamente.
	//
	public static void muestraValoresVector(int[] vector) {

		for (int i = 0; i < vector.length; i++) {
			System.out.println("la posici�n " + i + " contiene el valor " + vector[i]);
		}

	}

	// Recibe como par�metro un vector y un n�mero y devuelve la primera posici�n
	// donde est� dicho n�mero. Si el n�mero no est� en el vector, devolver� el
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

	// Recibe como par�metro un vector y un n�mero y cambia todos los valores del
	// vector multiplic�ndolos por el n�mero dado.
	//
	public static void multiplicaPropioVector(int[] vector, int num) {

		for (int i = 0; i < vector.length; i++) {
			vector[i] = vector[i] * num;
		}

	}

	// Recibe como par�metro un vector y un n�mero y devuelve un vector del mismo
	// tama�o que el del par�metro con todos los valores multiplicados por el n�mero
	// dado.
	//
	public static int[] multiplicaVectorEnOtro(int[] vector, int num) {

		int[] array = vector.clone();

		for (int i = 0; i < vector.length; i++) {
			array[i] = vector[i] * num;
		}

		return array;
	}

	// Recibe como par�metro dos vectores (se suponen del mismo tama�o) y devuelve
	// un vector que en cada posici�n contiene la suma de los valores de los
	// vectores pasados como par�metros para la misma posici�n.
	//
	public static int[] sumaVectores(int[] vector1, int[] vector2) {

		int[] array = new int[vector1.length];

		for (int i = 0; i < vector1.length; i++) {
			array[i] = vector1[i] + vector2[i];
		}

		return array;
	}

	// Recibe como par�metro un vector y devuelve otro vector que
	// contiene s�lo los n�meros pares. �se podr�a hacer teniendo el vector devuelto
	// el tama�o correcto para que no rellene con 0 el resto de posiciones?
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

	// Recibe como par�metro un vector y un n�mero y devuelve en otro vector todas
	// las posiciones donde est� dicho n�mero.
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

	// Recibe como par�metro tres enteros: tam, min y max y devuelve un vector de
	// tama�o tam con valores aleatorios entre min y max.
	//
	public static int[] generaVectorAleatorio(int tam, int min, int max) {
		int[] vector = new int[tam];

		for (int i = 0; i < vector.length; i++) {
			vector[i] = (int) Math.floor(Math.random() * (max - min + 1) + (min));
		}
		return vector;
	}
}
