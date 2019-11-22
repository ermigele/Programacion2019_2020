package examenTemaCursoAnterior;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 0;

		String cuadranteRoto = " ";

		System.out.println("Introduce el tama�o de tu ventana, debe ser un n�mero impar mayor de diez: ");
		num = Entrada.entero();

		System.out.println("Elige cuadrante a romper: ");
		cuadranteRoto = Entrada.cadena().toUpperCase();

		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= num; j++) {
				if (i == 1 || i == num || j == 1 || j == num || i == (num / 2 + 1) || j == (num / 2 + 1))
					System.out.print("* ");
				else {
					if (cuadranteRoto.equals("ARRIBA IZQUIERDA"))
						if (i <= (num / 2) && j <= (num / 2))
							System.out.print("* ");
						else
							System.out.print("  ");
					else if (cuadranteRoto.equals("ARRIBA DERECHA"))
						if (i <= (num / 2) && j > (num / 2))
							System.out.print("* ");
						else
							System.out.print("  ");
					else if (cuadranteRoto.equals("ABAJO IZQUIERDA"))
						if (i > (num / 2) && j <= (num / 2))
							System.out.print("* ");
						else
							System.out.print("  ");
					else if (cuadranteRoto.equals("ABAJO DERECHA"))
						if (i > (num / 2) && j > (num / 2))
							System.out.print("* ");
						else
							System.out.print("  ");
					else
						System.out.print("  ");
				}

			}
			System.out.println();
		}
	}

}
