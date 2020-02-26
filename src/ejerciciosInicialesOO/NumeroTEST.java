package ejerciciosInicialesOO;

public class NumeroTEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Crea un main donde crees dos objetos tipo Numero: El objeto num1 debe tener
		 * valor 5, luego añadirle 3, mostrarlo, restarle 2 y mostrarlo El objeto num2
		 * debe tener valor 0, luego añadirle 2, mostrar el doble y el triple. Crea un
		 * objeto num3 copia de num2 y muestra su valor por pantalla. Por último muestra
		 * la suma de num1 y de num2.
		 */

		Numero n1 = new Numero(5);
		n1.anyade(3);
		n1.resta(2);
		System.out.println(n1);
		
		Numero n2 = new Numero(0);
		n2.anyade(2);
		System.out.println("El valor doble es: " + n2.getDoble() + ", el valor triple es: " + n2.getTriple());

		Numero n3 = new Numero(n2);
		System.out.println(n3);

		System.out.println("La suma de num1 y num2 es: " + n1.getValor() + n2.getValor());
	}

}
