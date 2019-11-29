package ejerciciosMasFunciones;

public class Ejercicio1MasFunciones {

	static final double PI = 3.14;

	public static void main(String[] args) {

		/*
		 * Dise�a un m�todo menu que muestre opciones para calcular el area de un
		 * cuadrado, un rect�ngulo, un tri�ngulo o un c�rculo y luego muestre por
		 * pantalla el resultado del c�lculo. Para calcular el �rea de cada figura
		 * utiliza una funci�n tambi�n. Piensa bien si cada una de estas funciones debe
		 * llevar par�metros y si debe o no devolver algo de manera que cada m�todo sea
		 * lo m�s eficiente y legible posible.
		 */

		char operacion = ' ';
		double lado = 0, base = 0, altura = 0, radio = 0;

		System.out.println("Elija la opci�n que desee");
		System.out.println(
				"A. �rea del cuadrado /ln B. �rea del rectangulo /ln C. �rea del triangulo &/ln D. �rea del circulo");

		operacion = Entrada.caracter();
		if (operacion == 'a') {
			System.out.println("Introduce la medida del lado del cuadrado");
			lado = Entrada.real();
			System.out.println("El �rea es: " + areaCuadrado(lado));
		}
		if (operacion == 'b') {
			System.out.println("Introduce la medida de la base del rectangulo");
			lado = Entrada.real();
			System.out.println("Introduce la medida de la altura del rectangulo");
			altura = Entrada.real();
			System.out.println("El �rea es: " + areaRectangulo(base, altura));
		}
		if (operacion == 'c') {
			System.out.println("Introduce la medida de la base del triagulo");
			lado = Entrada.real();
			System.out.println("Introduce la medida de la altura del triagulo");
			altura = Entrada.real();
			System.out.println("El �rea es: " + areaTriangulo(base, altura));
		}
		if (operacion == 'd') {
			System.out.println("Introduce la medida del lado del circulo");
			radio = Entrada.real();
			System.out.println("El �rea es: " + areaCirculo(radio));
		}
	}

	public static double areaCuadrado(double lado) {
		return Math.pow(lado, 2);
	}

	public static double areaRectangulo(double base, double altura) {
		return base * altura;
	}

	public static double areaTriangulo(double base, double altura) {
		return (base * altura) / 2;
	}

	public static double areaCirculo(double radio) {
		return PI * Math.pow(radio, 2);
	}

}
