package examenOO2503A;

public class MainTEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String opc = new String("");
		int tamVector = 0, anyoIni = 0, anyoFin = 0, numHabi = 0, numInfe = 0, numDefu = 0;
		String continente = new String(""), nombrePais = new String(""), epidemia = new String(""),
				orden = new String("");

		Paises p0 = new Paises(6);

		System.out.println("Añadidiendo paises...\n");

		Pais pE1 = new Pais("España", "Europa", 5);
		if (p0.anyadePais(pE1))
			System.out.println("Añadido " + pE1.getNombrePais() + " con éxito");

		Pais pR2 = new Pais("Reino Unido", "Europa", 4);
		if (p0.anyadePais(pR2))
			System.out.println("Añadido " + pR2.getNombrePais() + " con éxito");

		Pais pB3 = new Pais("Brasil", "Latinoamerica", 6);
		if (p0.anyadePais(pB3))
			System.out.println("Añadido " + pB3.getNombrePais() + " con éxito");

		Pais pG4 = new Pais("Guinea", "Africa", 9);
		if (p0.anyadePais(pG4))
			System.out.println("Añadido " + pG4.getNombrePais() + " con éxito");

		System.out.println("\n\nAñadidiendo epidemia a los historiales de los países...\n");

		Epidemia e1 = new Epidemia("Viruela", 1980, 1984, 25032192, 65432, 35532);
		if (pE1.anyadeEpidemiaAHistorial(e1))
			System.out
					.println("Se ha añadido la epidemia" + e1.getNombreEpidemia() + " al pais " + pE1.getNombrePais());

		Epidemia e2 = new Epidemia("Peste negra", 1348, 1351, 1938321, 530321, 231321);
		if (pE1.anyadeEpidemiaAHistorial(e2))
			System.out
					.println("Se ha añadido la epidemia" + e2.getNombreEpidemia() + " al pais " + pE1.getNombrePais());

		Epidemia e3 = new Epidemia("Sida", 1980, 1986, 25032192, 5983212, 1392142);
		if (pE1.anyadeEpidemiaAHistorial(e3))
			System.out
					.println("Se ha añadido la epidemia" + e3.getNombreEpidemia() + " al pais " + pE1.getNombrePais());

		Epidemia r1 = new Epidemia("Peste negra", 1348, 1351, 5493292, 1539212, 723213);
		if (pR2.anyadeEpidemiaAHistorial(r1))
			System.out
					.println("Se ha añadido la epidemia" + r1.getNombreEpidemia() + " al pais " + pR2.getNombrePais());

		Epidemia b1 = new Epidemia("Zika", 2015, 2016, 398221412, 2593213, 6597);
		if (pB3.anyadeEpidemiaAHistorial(b1))
			System.out
					.println("Se ha añadido la epidemia" + b1.getNombreEpidemia() + " al pais " + pB3.getNombrePais());

		Epidemia g1 = new Epidemia("Ebola", 2013, 2020, 39529131, 7421321, 432132);
		if (pG4.anyadeEpidemiaAHistorial(g1))
			System.out
					.println("Se ha añadido la epidemia" + g1.getNombreEpidemia() + " al pais " + pG4.getNombrePais());

		do {
			System.out.println("\n\nANÁLISIS DE EPIDEMIAS POR PAISES...");
			System.out.println("¿Qué desea hacer?");
			System.out.println(
					"a. Añadir país \nb. Añadir epidemia a país \nc. Eliminar epidemia de un país \nd. Mostrar epidemias de un continente \ns. Salir");

			opc = Entrada.cadena();
			switch (opc) {
			case "a":
				System.out.println("Nombre del país: ");
				nombrePais = Entrada.cadena();
				System.out.println("Continente: ");
				continente = Entrada.cadena();
				System.out.println("Tamaño del vector de epidemias: ");
				tamVector = Entrada.entero();

				if (p0.anyadePais(new Pais(nombrePais, continente, tamVector)))
					System.out.println("Se añadió el país con éxito");
				else
					System.out.println("Error al añadir el país");
				break;

			case "b":
				System.err.println("Nombre del país al que quieres añadir la epidemia:");
				nombrePais = Entrada.cadena();
				System.out.println("Nombre de la epidemia: ");
				epidemia = Entrada.cadena();
				System.out.println("Año inicio de la epidemia: ");
				anyoIni = Entrada.entero();
				System.out.println("Año fin de la epidemia: ");
				anyoFin = Entrada.entero();
				System.out.println("Número de habitantes durante la epidemia: ");
				numHabi = Entrada.entero();
				System.out.println("Número total de infectados: ");
				numInfe = Entrada.entero();
				System.out.println("Número de defunciones: ");
				numDefu = Entrada.entero();
				p0.anyadeEpidemiaAPais(nombrePais, new Epidemia(epidemia, anyoIni, anyoFin, numHabi, numInfe, numDefu));
				break;

			case "c":
				System.out.println("¿De qué país quieres eliminar la epidemia?");
				nombrePais = Entrada.cadena();
				System.out.println("¿Qué epidemia quiere eliminar del historial?");
				epidemia = Entrada.cadena();
				p0.eliminarEpidemiaDePais(nombrePais, epidemia);
				break;

			case "d":
				System.out.println("¿De qué continente quieres mostrar las epidemias?");
				continente = Entrada.cadena();
				System.out.println("¿Cómo quieres ordenados los historiales de epidemia? (año/porcentaje)");
				orden = Entrada.cadena();
				p0.muestraPaisesContinente(continente, orden);
				break;
			case "s":
				System.out.println("¡Hasta luegor!");
				break;
			default:
				System.out.println("Opción incorrecta");
				break;
			}

		} while (!opc.equals("s"));

	}
}
