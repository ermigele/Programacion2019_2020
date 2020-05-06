package examenHP0605_A;

public class JuegoTEST {

	public static void main(String[] args) {

		boolean finalizarJuego = false;
		int jugadorTurno = 0, jugadorNoTurno = 0, jugador1 = 0, jugador2 = 0, arma = 0, turno = 0;
		char tipOrden;
		Stark s1 = null;
		Lannister l1 = null;

		Personaje[] personajes = new Personaje[5];
		personajes[0] = new Stark("Ned", 20, 15, 0.75, 0.30, 2);
		personajes[1] = new Lannister("Tyrion", 40, 5, 0.40, 0.60);
		personajes[2] = new Stark("Arya", 40, 7.5, 0.60, 0.90, 1);
		personajes[3] = new CaminanteBlanco("Manos Frias", 35, 8, 0.35, 0.35);
		personajes[4] = new Lannister("Jaime", 30, 10, 0.90, 0.55);

		s1 = (Stark) personajes[0];
		s1.anyadirArma(new Arma("hacha", 25));
		s1.anyadirArma(new Arma("espada", 31));
		l1 = (Lannister) personajes[1];
		l1.anyadirArma(new Arma("hacha", 20));
		s1 = (Stark) personajes[2];
		s1.anyadirArma(new Arma("espada", 5));
		l1 = (Lannister) personajes[4];
		l1.anyadirArma(new Arma("espada", 30));

		System.out.println("-------¡BIENVENIDO A JUEGO DE TRONOS!-------");
		System.out.println("Vamos a ver los jugadores. ¿Por qué campo quieres ordenarlos?");
		System.out.println("a.Puntos de vida\nb.Fuerza de golpe\nc.Probabilidad de golpe");
		tipOrden = Entrada.caracter();
		ordenarVectorPersonajesSELECCION(personajes, tipOrden);

		for (int i = 0; i < personajes.length; i++) {
			System.out.println("\n---------PERSONAJE " + i + "---------");
			personajes[i].muestraPersonaje();
		}

		System.out.println("Elige personaje JUGADOR1:");
		jugador1 = Entrada.entero();
		if (personajes[jugador1] instanceof Stark) {
			System.out.println("Elige arma: \n");
			s1 = (Stark) personajes[jugador1];
			s1.muestraArmas();
			arma = Entrada.entero();
			s1.usarArma(arma);
		}

		System.out.println("Elije pesona JUGADOR2: ");
		jugador2 = Entrada.entero();
		System.out.println("EMPIEZA LA LUCHA");

		while (!finalizarJuego) {

			if (turno % 2 == 0) {
				jugadorTurno = jugador1;
				jugadorNoTurno = jugador2;
			} else {
				jugadorTurno = jugador2;
				jugadorNoTurno = jugador1;
			}
			System.out.println(
					"------------Turno del jugador " + personajes[jugadorTurno].getNombrePersonaje() + "------------");

			if (personajes[jugadorTurno].aciertoGolpe() && !personajes[jugadorNoTurno].pararGolpe()) {
				System.out.println("ACIERTO EN EL GOLPE");
				personajes[jugadorNoTurno].pierdePuntosDeVida((personajes[jugadorTurno].getFuerzaGolpe()));
				finalizarJuego = (personajes[jugadorNoTurno].haPerdido()) ? true : false;
			} else {
				System.out.println("FALLO EN EL GOLPE");
			}
			turno++;

			try {
				System.out.println("\n---------------5 segundos para el siguiente ataque ---------------\n");
				Thread.sleep(5000);
			} catch (Exception e) {

			}
		}
		System.out.println("Ha ganado " + personajes[jugadorTurno].getNombrePersonaje());
	}

	public static void ordenarVectorPersonajesSELECCION(Personaje[] personajes, char tipo) {
		int pos;
		double temp;

		switch (tipo) {
		case 'a':
			for (int i = 0; i <= (personajes.length - 2); i++) {
				pos = i;
				for (int j = i + 1; j <= (personajes.length - 1); j++)
					if (personajes[j].puntosDeVida < personajes[pos].puntosDeVida) {
						pos = j;
					}
				if (pos != i) {
					temp = personajes[pos].puntosDeVida;
					personajes[pos].puntosDeVida = personajes[i].puntosDeVida;
					personajes[i].puntosDeVida = temp;
				}
			}
			break;
		case 'b':
			for (int i = 0; i <= (personajes.length - 2); i++) {
				pos = i;
				for (int j = i + 1; j <= (personajes.length - 1); j++)
					if (personajes[j].fuerzaGolpe < personajes[pos].fuerzaGolpe) {
						pos = j;
					}
				if (pos != i) {
					temp = personajes[pos].fuerzaGolpe;
					personajes[pos].fuerzaGolpe = personajes[i].fuerzaGolpe;
					personajes[i].fuerzaGolpe = temp;
				}
			}
			break;
		case 'c':
			for (int i = 0; i <= (personajes.length - 2); i++) {
				pos = i;
				for (int j = i + 1; j <= (personajes.length - 1); j++)
					if (personajes[j].probabilidadGolpe < personajes[pos].probabilidadGolpe) {
						pos = j;
					}
				if (pos != i) {
					temp = personajes[pos].puntosDeVida;
					personajes[pos].probabilidadGolpe = personajes[i].probabilidadGolpe;
					personajes[i].probabilidadGolpe = temp;
				}
			}
			break;
		}
	}
}
