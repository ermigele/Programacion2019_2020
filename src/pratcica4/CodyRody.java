package pratcica4;

public class CodyRody {

	final static int TAM_TABLERO = 5;
	
	static int barrera1X = 0, barrera1Y = 0, barrera2X = 0, barrera2Y = 0;

	static int coordXCody = 0, coordYCody = 0, coordXRody = 0, coordYRody = 0;

	public static void main(String[] args) {

		boolean ganador = false;
		int dado = 0;
		String robotJuega = new String(""); // Cody - Rody

		System.out.println("Bienvenido al juego de Cody & Rody. ");
		System.out.println("Cuantas caras es el dado con el que se va a jugar: ");
		// dado = Entrada.entero();
		//
		// while (!ganador) {
		//
		// }

		System.out.println("La coordenada es: " + coordenadaAleatoria());
		System.out.println(" B1X= "+barrera1X +", B1Y= " + barrera1Y +" B2X= " + barrera2X +" B2Y= " + barrera1Y);
		asignaValoresBarreras();
		System.out.println(" B1X= "+barrera1X +", B1Y= " + barrera1Y +" B2X= " + barrera2X +" B2Y= " + barrera1Y);
		
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
		
		while (barrera1X == barrera2X && barrera1Y == barrera2Y) {
			barrera2X = coordenadaAleatoria();
			barrera2Y = coordenadaAleatoria();
		}
	}

	public static void mostrarTablero() {

	}

	public static int tirarDado(int numTotalDado) {
		return 1;
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
