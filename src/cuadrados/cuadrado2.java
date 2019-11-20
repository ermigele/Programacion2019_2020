package cuadrados;

public class cuadrado2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int tam = 0, cant = 0, salto = 0;

		System.out.print("Introduce el número de tamaño del cuadrado: ");
		tam = Entrada.entero();
		System.out.print("Introduce la cantidad de cuadrados: ");
		cant = Entrada.entero();
		System.out.println();

		for (int i = 0; i < tam; i++) {

			for (int j = 0; j < tam * cant; j++) {

				System.out.print(" *");
				salto++;
				if (tam == salto) {
					System.out.print(" ");
					salto = 0;
				}
			}
			System.out.println();
		}

	}

}
