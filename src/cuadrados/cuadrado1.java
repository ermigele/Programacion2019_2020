package cuadrados;

public class cuadrado1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int tam = 0, cant = 0;

		System.out.print("Introduce el número de tamaño del cuadrado: ");
		tam = Entrada.entero();
		System.out.print("Introduce la cantidad de cuadrados: ");
		cant = Entrada.entero();
		System.out.println();

		for (int i = 0; i < tam; i++) {

			if (cant <= 1) {

				for (int j = 0; j < tam; j++) {
					System.out.print(" *");
				}

			} else {
				for (int j = 0; j < cant; j++) {
					for (int k = 0; k < tam; k++) {
						System.out.print(" *");
					}
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

}
