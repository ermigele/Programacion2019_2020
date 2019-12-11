package pratcica4;

public class CodyRody {

	final static int TAM_TABLERO = 5;

	final static String robotJuega = new String("Cody");

	static int barrera1X = 0, barrera1Y = 0, barrera2X = 0, barrera2Y = 0;

	static int coordXCody = 0, coordYCody = 0, coordXRody = 0, coordYRody = 0;

	public static void main(String[] args) {

		boolean ganador = false;
		int dado = 0;

		System.out.println("Bienvenido al juego de Cody & Rody. ");
		System.out.println("Cuantas caras es el dado con el que se va a jugar: ");

		dado = Entrada.entero();

		coordXCody = coordenadaAleatoria();
		coordYCody = coordenadaAleatoria();
		coordXRody = coordenadaAleatoria();
		coordYRody = coordenadaAleatoria();

		while (coordXRody == coordXCody && coordYRody == coordYCody) {
			coordXRody = coordenadaAleatoria();
			coordYRody = coordenadaAleatoria();
		}

		asignaValoresBarreras();
		System.out.println(
				" Bar1X = " + barrera1X + ", Bar1Y = " + barrera1Y + " Bar2X = " + barrera2X + " Bar2Y = " + barrera1Y);
		System.out.println(" CodyX = " + coordXCody + ", CodyY = " + coordYCody + " RodyX = " + coordXRody + " RodyY = "
				+ coordYRody);

		System.out.println();

		mostrarTablero();
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
				|| (barrera1X == coordXRody && barrera1Y == coordYRody)) {

			barrera1X = coordenadaAleatoria();
			barrera1Y = coordenadaAleatoria();
		}

		barrera2X = coordenadaAleatoria();
		barrera2Y = coordenadaAleatoria();

		while ((barrera2X == coordXCody && barrera2Y == coordYCody)
				|| (barrera2X == coordXRody && barrera2Y == coordYRody)
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
					if (x == coordXCody && y == coordXCody) {
						System.out.print(" C");
					} else {
						if (x == coordXRody && y == coordXRody) {
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

		return true;
	}

	public static boolean moverAbajo(String robotJuega) {
		return true;
	}

	public static boolean moverDerecha(String robotJuega) {
		return true;
	}

	public static boolean moverIzquierda(String robotJuega) {
		return true;
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
