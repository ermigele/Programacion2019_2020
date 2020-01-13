package ejerciciosVectores;

public class Vectores_funciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int vector[] = new int[8];
		int[] vector = { 1, 5, 5, 8 };

		muestraValoresVector(vector);

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

		for (int i = 0; i < vector.length; i++) {

			if (vector[i] == num)
				posicion = i;
		}
		return posicion;
	}

	// multiplicaPropioVector: que recibe como par�metro un vector y un n�mero y
	// cambia todos los valores del vector multiplic�ndolos por el n�mero dado.
	//
	public static void multiplicaPropioVector(int[] vector, int num) {

	}

	// multiplicaVectorEnOtro: que recibe como par�metro un vector y un n�mero y
	// devuelve un vector del mismo tama�o que el del par�metro con todos los
	// valores multiplicados por el n�mero dado.
	//
	public static int[] multiplicaVectorEnOtro(int[] vector, int num) {

		return vector;
	}

	// sumaVectores: que recibe como par�metro dos vectores (se suponen del mismo
	// tama�o) y devuelve un vector que en cada posici�n contiene la suma de los
	// valores de los vectores pasados como par�metros para la misma posici�n.
	//
	public static int[] sumaVectores(int[] vector1, int[] vector2) {

		return vector1;
	}

	// Recibe como par�metro un vector y devuelve otro vector que
	// contiene s�lo los n�meros pares. �se podr�a hacer teniendo el vector devuelto
	// el tama�o correcto para que no rellene con 0 el resto de posiciones?
	//
	public static int[] valoresPares(int[] vector) {

		return vector;
	}

	// Recibe como par�metro un vector y un n�mero y devuelve en otro vector todas
	// las posiciones donde est� dicho n�mero.
	//
	public static int[] devuelvePosiciones(int[] vector, int num) {

		return vector;
	}

	// Recibe como par�metro tres enteros: tam, min y max y devuelve un vector de
	// tama�o tam con valores aleatorios entre min y max.
	// Usa una funci�n main para ir probando las diferentes funciones.
	//
	public static int[] generaVectorAleatorio(int tam, int min, int max) {
		int[] vector = new int[tam];

		return vector;
	}
}
