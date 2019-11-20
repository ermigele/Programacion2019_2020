package practica3;

public class ejercicio2 {

	public static void main(String[] args) {
		/*
		 * Escribe un programa en JAVA que le pida al usuario dos números (siempre
		 * escribirá el primero menor que el segundo) e imprima por pantalla cuantos
		 * pares de primos gemelos hay entre esos dos números. Por ejemplo, si el
		 * usuario escribe los números 20 y 110, el algoritmo debe imprimir por pantalla
		 * lo siguiente: Números primos gemelos entre 20 y 110:
		 * 
		 * (29,31) (41,43) (59,61) (71,73) (101,103) (107,109).
		 */

		int num1 = 5, num2 = 25, k = 2;
		boolean esPrimoNum1=false, esPrimoNum2=false;
		System.out.print("Introduce el primer número: ");
		num1 = Entrada.entero();
		System.out.print("Introduce el segundo número: ");
		num2 = Entrada.entero();

		if (num1 > num2) {
			System.out.println(
					"El primer número " + num1 + " es mayor que el segundo número " + num2 + ", prueba de nuevo.");
		} else {

			for (int i = num1; i <= num2; i++) {
				for (int j = i + 1; j < num2; j++) {
					if (j - i == 2) {
						esPrimoNum1=false;
						esPrimoNum2=false;
						
						k = 2;
						while (i%k!=0 && (k<i))
							k++;
						
						if(i==k)
							esPrimoNum1=true;
						
						k = 2;
						while (j%k!=0 && (k<j))
							k++;
						
						if(j==k)
							esPrimoNum2=true;

						if (esPrimoNum1 && esPrimoNum2)
							System.out.println("("+i+") ("+j+")");
					}
				}
			}
		}
	}
}
