package ejercicios_iniciales_funciones;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

public class EjerciciosIniciales {

	public static void main(String[] args) {
		int num1 = 0, num2 = 0, num3 = 0;
		char caracter;

		// System.out.println("Ejercicio 1. ");
		// System.out.print("Introduce un n�mero: ");
		// modulo(Entrada.entero());
		//
		// System.out.println("Ejercicio 2. ");
		// System.out.print("Introduce un n�mero: ");
		// num1 = Entrada.entero();
		// System.out.print("Introduce otro n�mero: ");
		// num2 = Entrada.entero();
		// System.out.println("El n�mero maximo es: "+ maximoDosNum(num1, num2));
		//
		// System.out.println("Ejercicio 3. ");
		// System.out.print("Introduce el primer n�mero: ");
		// num1 = Entrada.entero();
		// System.out.print("Introduce el segundo n�mero: ");
		// num2 = Entrada.entero();
		// System.out.print("Introduce el ultimo n�mero: ");
		// num3 = Entrada.entero();
		// System.out.println("El n�mero maximo es: " + maximoTresNum(num1, num2,
		// num3));
		//
		// System.out.println("Ejercicio 4. ");
		// System.out.print("Introduce un n�mero n�mero: ");
		// num1 = Entrada.entero();
		// System.out.print("Introduce otro n�mero n�mero: ");
		// num2 = Entrada.entero();
		// entreNumeros(num1, num2);
		//
		// System.out.println("Ejercicio 5. ");
		// System.out.print("Introduce un n�mero n�mero: ");
		// System.out.println("El doble del n�mero es: " +
		// dobleValor(Entrada.entero()));
		//
		// System.out.println("Ejercicio 6. Calcular el area o volumen de un cilindro
		// ");
		// System.out.print("Introduce [a] para el area o [v] para el volumen: ");
		// caracter = Character.toLowerCase(Entrada.caracter());
		// System.out.print("Introduce el radio: ");
		// num1 = Entrada.entero();
		// System.out.print("Introduce la altura: ");
		// num2 = Entrada.entero();
		// System.out.printf("%.2f", cilintro(caracter, num1, num2));
		//
		// System.out.println("Ejercicio 7. Primo");
		// System.out.print("Introduce un n�mero n�mero: ");
		// num1 = Entrada.entero();
		// if (esPrimo(num1))
		// System.out.println("El n�mero " + num1 + " es primo");
		// else
		// System.out.println("El n�mero " + num1 + " no es primo");
	}

	/*
	 * Realizar una funci�n, a la que se le pase como par�metro un n�mero N, y
	 * muestre por pantalla N veces, el mensaje: �M�dulo ejecut�ndose�.
	 */
	// Ejercicio 1
	public static void modulo(int num) { // Ejercicio 1

		while (num > 0) {
			System.out.println("M�dulo ejecut�ndose");
			num--;
		}
	}

	/*
	 * Dise�ar una funci�n que tenga como par�metros dos n�meros, y que devuelva el
	 * m�ximo.
	 */
	// Ejercicio 2
	public static int maximoDosNum(int num1, int num2) {

		if (num1 == num2)
			return num1;
		else
			return (num2 > num1) ? num2 : num1;
	}

	/*
	 * �dem una versi�n que calcule el m�ximo de 3 n�meros y lo devuelva.
	 */
	// Ejercicio 3
	public static int maximoTresNum(int num1, int num2, int num3) {

		int maximo = maximoDosNum(num1, num2);
		maximo = maximoDosNum(maximo, num3);

		return maximo;
	}

	/*
	 * Funci�n a la que se le pasan dos enteros y muestra todos los n�meros
	 * comprendidos entre ellos, inclusive.
	 */
	// Ejercicio 4
	public static void entreNumeros(int num1, int num2) {

		for (int i = num1; i <= num2; i++) {
			System.out.println("N�mero " + i);
		}
	}

	/*
	 * Funci�n que devuelve el doble del valor que se le pasa como par�metro. "
	 */
	// Ejercicio 5
	public static int dobleValor(int num1) {

		return num1 * 2;
	}

	/*
	 * Realizar una funci�n que calcule y devuelva el �rea o el volumen de un
	 * cilindro, seg�n se especifique. Para distinguir un caso de otro se le pasar�
	 * el car�cter 'a' (para �rea) o 'v'(para el volumen). Adem�s hemos de pasarle a
	 * la funci�n el radio y la altura(que pueden contener decimales). "
	 */
	// Ejercicio 6
	public static double cilindro(char caracter, int radio, int alt) {
		double total = 0;

		switch (caracter) {
		case 'a':
			total = (Math.PI * 2) * (radio * (radio + alt));
			break;
		case 'v':
			total = (Math.PI * (radio * radio)) * alt;
			break;
		default:
			total = -1;
		}
		return total;
	}

	/*
	 * Realizar una funci�n que dado un n�mero entero devuelva un booleano para
	 * indicar si el n�mero es primo o no.
	 */
	// Ejercicio 7
	public static boolean esPrimo(int num) {
		int cont = 2;

		while (cont < num) {
			if (num % cont == 0)
				return false;
			cont++;
		}
		return true;
	}

	/*
	 * M�dulo al que se le pasa un n�mero entero y devuelve el n�mero de divisores
	 * primos que tiene. Usa la funci�n realizada en el ejercicio anterior.
	 */
	// Ejercicio 8
	public static int numDivisoresPrimos(int num) {
		int cuentaPrimosDivisores = 0;

		for (int i = 1; i <= num; i++)
			if (num % i == 0 && esPrimo(i))
				cuentaPrimosDivisores++;

		return cuentaPrimosDivisores;
	}
}
