package pratcica4;

public class CodyRody {

	final static int TAM_TABLERO = 5;

	final static String robotJuega = new String("Cody");

	static int barrera1X = 0, barrera1Y = 0, barrera2X = 0, barrera2Y = 0;

	static int coordXCody = 0, coordYCody = 0, coordXRoby = 0, coordYRoby = 0;

	public static void main(String[] args) {

		boolean ganador = false;
		int carasDado = 0;
		char tiradaDado;

		System.out.println("------------------¡BIENVENIDOS A CODY Y ROBY!------------------ ");
		System.out.println("¿De cuantas caras es tu dado?");

		carasDado = Entrada.entero();

		coordXCody = coordenadaAleatoria();
		coordYCody = coordenadaAleatoria();
		coordXRoby = coordenadaAleatoria();
		coordYRoby = coordenadaAleatoria();

		while (coordXRoby == coordXCody && coordYRoby == coordYCody) {
			coordXRoby = coordenadaAleatoria();
			coordYRoby = coordenadaAleatoria();
		}

		asignaValoresBarreras();
		// System.out.println(
		// " Bar1X = " + barrera1X + ", Bar1Y = " + barrera1Y + " Bar2X = " + barrera2X
		// + " Bar2Y = " + barrera1Y);
		// System.out.println(" CodyX = " + coordXCody + ", CodyY = " + coordYCody + "
		// RobyX = " + coordXRoby + " RobyY = "
		// + coordYRoby);
		System.out.println();
		System.out.println("Empezamos");

		while (!ganador) {
			mostrarTablero();

			System.out.println("¡Es el turno de " + robotJuega + "!");
			System.out.println("Pulsa la tecla d para lanzar dado...");
			tiradaDado = Entrada.caracter();
			System.out.println("Ha salido " + tirarDado(carasDado));
		}

	}

	public static int coordenadaAleatoria() {
		int coordenada = 0;

		do {
			coordenada = (int) Math.round(Math.random() * (TAM_TABLERO * 2));
		} while (coordenada % 2 == 0);

		return coordenada * 3;
	}

	public static void asignaValoresBarreras() {

		barrera1X = coordenadaAleatoria();
		barrera1Y = coordenadaAleatoria();

		while ((barrera1X == coordXCody && barrera1Y == coordYCody)
				|| (barrera1X == coordXRoby && barrera1Y == coordYRoby)) {

			barrera1X = coordenadaAleatoria();
			barrera1Y = coordenadaAleatoria();
		}

		barrera2X = coordenadaAleatoria();
		barrera2Y = coordenadaAleatoria();

		while ((barrera2X == coordXCody && barrera2Y == coordYCody)
				|| (barrera2X == coordXRoby && barrera2Y == coordYRoby)
				|| (barrera1X == barrera2X && barrera1Y == barrera2Y)) {

			barrera2X = coordenadaAleatoria();
			barrera2Y = coordenadaAleatoria();
		}
	}

	public static void mostrarTablero() {

		int cuadrado = TAM_TABLERO * 6;

		for (int x = 0; x <= cuadrado; x++) {

			for (int y = 0; y <= cuadrado; y++) {

				if (x % 6 == 0 || y % 6 == 0) {
					System.out.print(" *");

				} else {
					if (x == coordXCody && y == coordYCody) {
						System.out.print(" C");
					} else {
						if (x == coordXRoby && y == coordYRoby) {
							System.out.print(" R");
						} else {

							if (x == barrera1X && y == barrera1Y) {
								System.out.print(" B");

							} else {
								if (x == barrera2X && y == barrera2Y) {
									System.out.print(" B");

								} else {
									System.out.print("  ");
								}

							}
						}
					}
				}
			}
			System.out.println();
		}
	}

	public static int tirarDado(int dado) {
		return (int) Math.floor(Math.random() * (dado - 1 + 1) + (1));
	}

	// <MOVIMIENTOS>
	public static boolean moverArriba(String robotJuega) {
		boolean posible = false;
		if (robotJuega.equals("Cody")) {
			coordYCody -= 6;
			if ((coordXCody >= 3 && coordYCody >= 3) && coordYCody <= (TAM_TABLERO * 6 - 3) && coordYCody != barrera1Y
					&& coordYCody != barrera2Y) {
				posible = true;
			} else
				coordYCody += 6;
			posible = false;
		} else {
			coordYRoby -= 6;
			if ((coordXRoby >= 3 && coordYRoby >= 3) && coordYRoby <= (TAM_TABLERO * 6 - 3) && coordYRoby != barrera1Y
					&& coordYRoby != barrera2Y) {
				posible = true;
			} else
				posible = false;
			coordYRoby += 6;
		}
		return posible;
	}

	public static boolean moverAbajo(String robotJuega) {
		boolean posible = false;
		if (robotJuega.equals("Cody")) {
			coordYCody += 6;
			if ((coordXCody >= 3 && coordYCody >= 3) && coordYCody <= (TAM_TABLERO * 6 - 3) && coordYCody != barrera1Y
					&& coordYCody != barrera2Y) {
				posible = true;
			} else
				coordYCody -= 6;
			posible = false;
		} else {
			coordYRoby += 6;
			if ((coordXRoby >= 3 && coordYRoby >= 3) && coordYRoby <= (TAM_TABLERO * 6 - 3) && coordYRoby != barrera1Y
					&& coordYRoby != barrera2Y) {
				posible = true;
			} else
				posible = false;
			coordYRoby -= 6;
		}
		return posible;

	}

	public static boolean moverDerecha(String robotJuega) {
		boolean posible = false;
		if (robotJuega.equals("Cody")) {
			coordXCody += 6;
			if ((coordXCody >= 3 && coordYCody >= 3) && coordXCody <= (TAM_TABLERO * 6 - 3) && coordXCody != barrera1Y
					&& coordXCody != barrera2Y) {
				posible = true;
			} else
				coordXCody -= 6;
			posible = false;
		} else {
			coordXRoby += 6;
			if ((coordXRoby >= 3 && coordYRoby >= 3) && coordXRoby <= (TAM_TABLERO * 6 - 3) && coordXRoby != barrera1Y
					&& coordXRoby != barrera2Y) {
				posible = true;
			} else
				posible = false;
			coordXRoby -= 6;
		}
		return posible;
	}

	public static boolean moverIzquierda(String robotJuega) {
		boolean posible = false;
		if (robotJuega.equals("Cody")) {
			coordXCody -= 6;
			if ((coordXCody >= 3 && coordYCody >= 3) && coordXCody <= (TAM_TABLERO * 6 - 3) && coordXCody != barrera1Y
					&& coordXCody != barrera2Y) {
				posible = true;
			} else
				coordXCody += 6;
			posible = false;
		} else {
			coordXRoby -= 6;
			if ((coordXRoby >= 3 && coordYRoby >= 3) && coordXRoby <= (TAM_TABLERO * 6 - 3) && coordXRoby != barrera1Y
					&& coordXRoby != barrera2Y) {
				posible = true;
			} else
				posible = false;
			coordXRoby += 6;
		}
		return posible;
	}
	// </MOVIMIENTOS>

	public static boolean ejecutarJugadaCody(int movimientos) {
		return true;
	}

	public static int ejecutarJugadaRoby(int movimientos) { // RECURSIVA

		// caso Base

		// caso Recursivo
		return 1;
	}

	public static boolean ejecutarJugada(int movimientos, String robotJuega) {
		return true;
	}

}
