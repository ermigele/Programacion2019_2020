package examenJAVA2211;

public class Ejercicio2 {

	public static void main(String[] args) {

		int num_ini = 0, num_fin = 0, primo_ant = 0, primo_ult = 0, distancia = 0, cuenta = 0, acum = 0, k = 2;
		double total = 0, media = 0;

		System.out.println("Introduce el número inicial del rango: ");
		num_ini = Entrada.entero();
		System.out.println("Introduce el número final del rango: ");
		num_fin = Entrada.entero();

		for (int i = num_ini; i < num_fin; i++) {
			k = 2;
			while (i % k != 0 && (k < i)) {
				k++;
			}
			
			if (i == k) { // Es primo
				primo_ult = i;
				cuenta++;

			} else { // No es primo
				primo_ant = primo_ult;
				distancia = (primo_ult - primo_ant) - 1;
			}

			System.out.println("Distancia entre " + primo_ant + " y " + primo_ult + " es: " + distancia);
		}

		System.out.println("Cuenta primos vale: " + cuenta);

		System.out.println("La media de la distancia entre dos primos del rango es: " + media);
	}
}
