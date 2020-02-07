package practica4;

public class CodyRody {

	final static int TAM_TABLERO = 5;

	static String robotJuega = new String("Cody");

	static int barrera1X = 0, barrera1Y = 0, barrera2X = 0, barrera2Y = 0;

	static int coordXCody = 0, coordYCody = 0, coordXRoby = 0, coordYRoby = 0;

	static boolean ganador = false;

	public static void main(String[] args) {

		boolean jugada = false;
		int carasDado = 0, nMovimientos = 0, turno = 0;
		char tecla;
		String movimiento;

		System.out.println("------------------¡BIENVENIDOS A CODY Y ROBY!------------------ ");
		System.out.println("¿De cuantas caras es tu dado?");
		carasDado = Entrada.entero();
		System.out.println();

		coordXCody = coordenadaAleatoria();
		coordYCody = coordenadaAleatoria();
		coordXRoby = coordenadaAleatoria();
		coordYRoby = coordenadaAleatoria();

		while (coordXRoby == coordXCody && coordYRoby == coordYCody) {
			coordXRoby = coordenadaAleatoria();
			coordYRoby = coordenadaAleatoria();
		}
		asignaValoresBarreras();
		System.out.println("Empezamos");
		System.out.println();

		while (!ganador) {
			mostrarTablero();
			robotJuega = (turno % 2 == 0) ? "Cody" : "Roby";

			System.out.println("¡Es el turno de " + robotJuega + "!");

			System.out.println("Pulsa la tecla d para lanzar dado...");
			tecla = Entrada.caracter();
			nMovimientos = tirarDado(carasDado);
			System.out.println("Ha salido " + nMovimientos);

			jugada = ejecutarJugada(nMovimientos, robotJuega);

			if (jugada) {
				System.out.println("Se completó la jugada");
			} else {
				System.out.println("No se pudo completar la jugada, " + robotJuega
						+ " se ha salido del tablero o chocado con una barrera");
			}
			turno++;
		}
		if (ganador) {
			System.out.println("Ha ganado " + robotJuega);
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

		for (int y = 0; y <= cuadrado; y++) {
			for (int x = 0; x <= cuadrado; x++) {

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
			if ((coordXCody >= 3 && coordYCody >= 3) && coordYCody <= (TAM_TABLERO * 6 - 3)
					&& (coordYCody != barrera1Y || coordXCody != barrera1X)
					&& (coordYCody != barrera2Y || coordXCody != barrera2X)) {
				posible = true;
			} else {
				coordYCody += 6;
				posible = false;
			}
		} else {
			coordYRoby -= 6;
			if ((coordXRoby >= 3 && coordYRoby >= 3) && coordYRoby <= (TAM_TABLERO * 6 - 3)
					&& (coordYRoby != barrera1Y || coordXRoby != barrera1X)
					&& (coordYRoby != barrera2Y || coordXRoby != barrera2X)) {
				posible = true;
			} else {
				posible = false;
				coordYRoby += 6;
			}
		}
		return posible;
	}

	public static boolean moverAbajo(String robotJuega) {
		boolean posible = false;
		if (robotJuega.equals("Cody")) {
			coordYCody += 6;
			if ((coordXCody >= 3 && coordYCody >= 3) && coordYCody <= (TAM_TABLERO * 6 - 3)
					&& (coordYCody != barrera1Y || coordXCody != barrera1X)
					&& (coordYCody != barrera2Y || coordXCody != barrera2X)) {
				posible = true;
			} else {
				coordYCody -= 6;
				posible = false;
			}
		} else {
			coordYRoby += 6;
			if ((coordXRoby >= 3 && coordYRoby >= 3) && coordYRoby <= (TAM_TABLERO * 6 - 3)
					&& (coordYRoby != barrera1Y || coordXRoby != barrera1X)
					&& (coordYRoby != barrera2Y || coordXRoby != barrera2X)) {
				posible = true;
			} else {
				posible = false;
				coordYRoby -= 6;
			}
		}
		return posible;

	}

	public static boolean moverDerecha(String robotJuega) {
		boolean posible = false;
		if (robotJuega.equals("Cody")) {
			coordXCody += 6;
			if ((coordXCody >= 3 && coordYCody >= 3) && coordXCody <= (TAM_TABLERO * 6 - 3)
					&& (coordYCody != barrera1Y || coordXCody != barrera1X)
					&& (coordYCody != barrera2Y || coordXCody != barrera2X)) {
				posible = true;
			} else {
				coordXCody -= 6;
				posible = false;
			}
		} else {
			coordXRoby += 6;
			if ((coordXRoby >= 3 && coordYRoby >= 3) && coordXRoby <= (TAM_TABLERO * 6 - 3)
					&& (coordYRoby != barrera1Y || coordXRoby != barrera1X)
					&& (coordYRoby != barrera2Y || coordXRoby != barrera2X)) {
				posible = true;
			} else {
				posible = false;
				coordXRoby -= 6;
			}
		}
		return posible;
	}

	public static boolean moverIzquierda(String robotJuega) {
		boolean posible = false;
		if (robotJuega.equals("Cody")) {
			coordXCody -= 6;
			if ((coordXCody >= 3 && coordYCody >= 3) && coordXCody <= (TAM_TABLERO * 6 - 3)
					&& (coordYCody != barrera1Y || coordXCody != barrera1X)
					&& (coordYCody != barrera2Y || coordXCody != barrera2X)) {
				posible = true;
			} else {
				coordXCody += 6;
				posible = false;
			}
		} else {
			coordXRoby -= 6;
			if ((coordXRoby >= 3 && coordYRoby >= 3) && coordXRoby <= (TAM_TABLERO * 6 - 3)
					&& (coordYRoby != barrera1Y || coordXRoby != barrera1X)
					&& (coordYRoby != barrera2Y || coordXRoby != barrera2X)) {
				posible = true;
			} else {
				posible = false;
				coordXRoby += 6;
			}
		}
		return posible;
	}
	// </MOVIMIENTOS>

	public static boolean ejecutarJugadaCody(String movimiento) {
		boolean posibleMovimiento = false;

		switch (movimiento) {

		case "ar":
			posibleMovimiento = moverArriba(robotJuega);
			break;
		case "ab":
			posibleMovimiento = moverAbajo(robotJuega);
			break;
		case "de":
			posibleMovimiento = moverDerecha(robotJuega);
			break;
		case "iz":
			posibleMovimiento = moverIzquierda(robotJuega);
			break;
		}
		ganador = (coordXCody == coordXRoby && coordYCody == coordYRoby);
		if (ganador)
			return true;
		else
			return posibleMovimiento;
	}

	public static boolean ejecutarJugadaRoby(int nMovimiento) {
		boolean posibleMovimiento = false;
		int posicion = (int) Math.floor(Math.random() * (4 - 1 + 1) + (1));
		System.out.println("Roby tiene: " + nMovimiento);

		if (nMovimiento == 0) { // CASO BASE
			return true;
		}

		switch (posicion) { // CASO RECURSIVO

		case 1:
			posibleMovimiento = moverArriba(robotJuega);
			System.out.println("ar");
			break;
		case 2:
			posibleMovimiento = moverAbajo(robotJuega);
			System.out.println("ab");
			break;
		case 3:
			posibleMovimiento = moverDerecha(robotJuega);
			System.out.println("de");
			break;
		case 4:
			posibleMovimiento = moverIzquierda(robotJuega);
			System.out.println("iz");
			break;
		}
		ganador = (coordXCody == coordXRoby && coordYCody == coordYRoby);
		if (ganador)
			return true;
		else
			return posibleMovimiento ? ejecutarJugadaRoby(nMovimiento - 1) : false;
	}

	public static boolean ejecutarJugada(int nMovimiento, String robotJuega) {
		String movimiento;
		boolean posibleJugada = true;

		if (robotJuega.equals("Cody")) {
			while (nMovimiento > 0 && posibleJugada && !ganador) {
				System.out.println("Indique el movimiento: ");
				movimiento = Entrada.cadena().toLowerCase();
				posibleJugada = ejecutarJugadaCody(movimiento);
				nMovimiento--;
			}
		} else {
			posibleJugada = ejecutarJugadaRoby(nMovimiento);
		}
		return posibleJugada;
	}
}
