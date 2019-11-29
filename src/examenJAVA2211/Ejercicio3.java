package examenJAVA2211;

public class Ejercicio3 {

	public static void main(String[] args) {

		int alt = 0, base = 0, x = -1, u = 0;

		System.out.println("Introduce un número");
		alt = Entrada.entero();
		base = alt * 2;
		u = base + 1;
		for (int i = 0; i < alt + 1; i++) {

			for (int j = 0; j < base + 1; j++) {

				if (j == alt || (x >= j && i > 0) || u <= j && i > 0) {
					System.out.print("  ");
				} else {
					System.out.print(" *");
				}
			}
			x++;
			u--;
			System.out.println();
		}
	}
}
