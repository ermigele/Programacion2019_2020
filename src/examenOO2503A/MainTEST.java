package examenOO2503A;

public class MainTEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String opc = new String("");
		int tamVector = 0, anyoIni = 0, anyoFin = 0, numHabi = 0, numInfe = 0, numDefu = 0;
		String continente = new String(""), nombrePais = new String(""), epidemia = new String(""),
				orden = new String("");

		Paises p0 = new Paises(6);

		System.out.println("A�adidiendo paises...\n");

		Pais pE1 = new Pais("Espa�a", "Europa", 5);
		if (p0.anyadePais(pE1))
			System.out.println("A�adido " + pE1.getNombrePais() + " con �xito");

		Pais pR2 = new Pais("Reino Unido", "Europa", 4);
		if (p0.anyadePais(pR2))
			System.out.println("A�adido " + pR2.getNombrePais() + " con �xito");

		Pais pB3 = new Pais("Brasil", "Latinoamerica", 6);
		if (p0.anyadePais(pB3))
			System.out.println("A�adido " + pB3.getNombrePais() + " con �xito");

		Pais pG4 = new Pais("Guinea", "Africa", 9);
		if (p0.anyadePais(pG4))
			System.out.println("A�adido " + pG4.getNombrePais() + " con �xito");

		System.out.println("\n\nA�adidiendo epidemia a los historiales de los pa�ses...\n");

		Epidemia e1 = new Epidemia("Viruela", 1980, 1984, 25032192, 65432, 35532);
		if (pE1.anyadeEpidemiaAHistorial(e1))
			System.out
					.println("Se ha a�adido la epidemia" + e1.getNombreEpidemia() + " al pais " + pE1.getNombrePais());

		Epidemia e2 = new Epidemia("Peste negra", 1348, 1351, 1938321, 530321, 231321);
		if (pE1.anyadeEpidemiaAHistorial(e2))
			System.out
					.println("Se ha a�adido la epidemia" + e2.getNombreEpidemia() + " al pais " + pE1.getNombrePais());

		Epidemia e3 = new Epidemia("Sida", 1980, 1986, 25032192, 5983212, 1392142);
		if (pE1.anyadeEpidemiaAHistorial(e3))
			System.out
					.println("Se ha a�adido la epidemia" + e3.getNombreEpidemia() + " al pais " + pE1.getNombrePais());

		Epidemia r1 = new Epidemia("Peste negra", 1348, 1351, 5493292, 1539212, 723213);
		if (pR2.anyadeEpidemiaAHistorial(r1))
			System.out
					.println("Se ha a�adido la epidemia" + r1.getNombreEpidemia() + " al pais " + pR2.getNombrePais());

		Epidemia b1 = new Epidemia("Zika", 2015, 2016, 398221412, 2593213, 6597);
		if (pB3.anyadeEpidemiaAHistorial(b1))
			System.out
					.println("Se ha a�adido la epidemia" + b1.getNombreEpidemia() + " al pais " + pB3.getNombrePais());

		Epidemia g1 = new Epidemia("Ebola", 2013, 2020, 39529131, 7421321, 432132);
		if (pG4.anyadeEpidemiaAHistorial(g1))
			System.out
					.println("Se ha a�adido la epidemia" + g1.getNombreEpidemia() + " al pais " + pG4.getNombrePais());

		do {
			System.out.println("\n\nAN�LISIS DE EPIDEMIAS POR PAISES...");
			System.out.println("�Qu� desea hacer?");
			System.out.println(
					"a. A�adir pa�s \nb. A�adir epidemia a pa�s \nc. Eliminar epidemia de un pa�s \nd. Mostrar epidemias de un continente \ns. Salir");

			opc = Entrada.cadena();
			switch (opc) {
			case "a":
				System.out.println("Nombre del pa�s: ");
				nombrePais = Entrada.cadena();
				System.out.println("Continente: ");
				continente = Entrada.cadena();
				System.out.println("Tama�o del vector de epidemias: ");
				tamVector = Entrada.entero();

				if (p0.anyadePais(new Pais(nombrePais, continente, tamVector)))
					System.out.println("Se a�adi� el pa�s con �xito");
				else
					System.out.println("Error al a�adir el pa�s");
				break;

			case "b":
				System.err.println("Nombre del pa�s al que quieres a�adir la epidemia:");
				nombrePais = Entrada.cadena();
				System.out.println("Nombre de la epidemia: ");
				epidemia = Entrada.cadena();
				System.out.println("A�o inicio de la epidemia: ");
				anyoIni = Entrada.entero();
				System.out.println("A�o fin de la epidemia: ");
				anyoFin = Entrada.entero();
				System.out.println("N�mero de habitantes durante la epidemia: ");
				numHabi = Entrada.entero();
				System.out.println("N�mero total de infectados: ");
				numInfe = Entrada.entero();
				System.out.println("N�mero de defunciones: ");
				numDefu = Entrada.entero();
				p0.anyadeEpidemiaAPais(nombrePais, new Epidemia(epidemia, anyoIni, anyoFin, numHabi, numInfe, numDefu));
				break;

			case "c":
				System.out.println("�De qu� pa�s quieres eliminar la epidemia?");
				nombrePais = Entrada.cadena();
				System.out.println("�Qu� epidemia quiere eliminar del historial?");
				epidemia = Entrada.cadena();
				p0.eliminarEpidemiaDePais(nombrePais, epidemia);
				break;

			case "d":
				System.out.println("�De qu� continente quieres mostrar las epidemias?");
				continente = Entrada.cadena();
				System.out.println("�C�mo quieres ordenados los historiales de epidemia? (a�o/porcentaje)");
				orden = Entrada.cadena();
				p0.muestraPaisesContinente(continente, orden);
				break;
			case "s":
				System.out.println("�Hasta luegor!");
				break;
			default:
				System.out.println("Opci�n incorrecta");
				break;
			}

		} while (!opc.equals("s"));

	}
}
