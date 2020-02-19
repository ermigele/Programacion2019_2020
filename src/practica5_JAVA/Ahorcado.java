package practica5_JAVA;

public class Ahorcado {

	static final int NUM_FILAS = 10, NUM_COL = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[][] matriz = { { "el", "perro", "tiende", "peras" }, { "su", "niño", "coge", "curvas" },
				{ "tu", "algodon", "engaña", "a los pajaros" }, { "un", null, "come", "hierba" },
				{ "mi", null, null, "artistas" }, { null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null }, { null, null, null, null } };
		
		int opc = 0;
		String tipo = new String(""), texto = new String("");
		char letra;
		char[] vecCarac = new char[NUM_COL];
		// String[][] matriz = new String[NUM_FILAS][NUM_COL];

		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		do {

			System.out.println("\n ¿Qué quieres hacer? \n " + "1.Crear matriz de juego \n "
					+ "2.Mostrar matriz de juego ordenada \n "
					+ "3.Añadir matriz de juego \n 4.Buscar cadena de matriz de juego \n 5.Juegar \n 6.Salir");
			opc = Entrada.entero();

			switch (opc) {

			case 1:
				matriz = creaMatrizConCadenas();
				break;
			case 2:
				System.out.println("Mostrando matriz de juego... \n");
				mostrarMatriz(matriz);
				break;
			case 3:
				System.out.println(
						"\n Añadir matriz de juego...\n ¿Qué quiere añadir articulo/det/sujeto/verbo/predicado?");
				tipo = Entrada.cadena();
				System.out.println("Escriba la cadena añadir");
				texto = Entrada.cadena();
				if (anyadeCadenaAMatriz(matriz, texto, tipo)) {
					System.out.println("Cadena añadida éxito");
				}
				break;
			case 4:
				System.out.println("Buscar cadena de matriz de juego... \n\n ¿Qué cadena quiere buscar?");
				// existeCadenaEnColumna(Entrada.cadena());
				break;
			case 5:
				String[] vectorFraseSecreta = new String[NUM_COL];

				System.out.println("Jugar \n\n\n ----A JUGAARRRRR----- \n\n\n");
				System.out.println("¡Puede pedir hasta 5 letras para resolver la frase y puede usar pistas!");
				System.out.println(escondePalabra(vecCarac, String.valueOf(vecCarac)));
				// System.out.println(escondePalabra(vecCarac, letra));

				do {
					System.out.println("¿Qué quieres? \n 1.Resolver \n " + "2.Pista obtener parte de la frase \n "
							+ "3.Pista comprobar si sé una parte de la frase \n 4.Seguir");
					opc = Entrada.entero();

					switch (opc) {

					case 1:
						System.out.println("La frase es: ");

						if (resolver(vectorFraseSecreta, Entrada.cadena()) && vecCarac.length < 6)
							System.out.println("¡Enhorabuena! Has resuelto la frase");
						else
							System.out.println(vectorFraseSecreta);

						break;

					case 2:
						System.out
								.println("Forma parte  de la frase la cadena: " + pistaParteFrase(vectorFraseSecreta));
						break;

					case 3:
						System.out.println("Escribe la parte de la frase que crees que sabes:");
						texto = Entrada.cadena().toLowerCase();

						if (esParteDeLaFrase(vectorFraseSecreta, texto)) {
							System.out.println("Pues sí, " + texto + " forma parte de la frase");
						} else {
							System.out.println("No, " + texto + " no forma parte de la frase");
						}
						break;

					case 4:
						System.out.println("Pide letra:");
						letra = Entrada.caracter();
						System.out.println(escondePalabra(vecCarac, String.valueOf(letra)));
						break;
					default:
						break;
					}
				} while (vecCarac.length <= 5);

				break;

			case 6:
				System.out.println("Hasta luegor!");
				break;
			default:
				break;
			}
		} while (opc != 6);
	}

	// FUNCIONES
	public static String[][] creaMatrizConCadenas() {
		String[][] matriz = new String[NUM_FILAS][NUM_COL];
		String[] array = { "artículos", "sujetos", "verbos", "predicados" };
		String frase;
		int k = 0;

		for (int j = 0; j < matriz.length; j++) {
			for (int i = 0; i < array.length; i++) {
				System.out.println("Introduce los " + array[i] + ", escribe \"fin\" para indicar que has terminado: ");
				frase = new String("");
				k = 0;
				while (k < matriz[j].length && !frase.equalsIgnoreCase("fin")) {
					frase = Entrada.cadena();
					if (!frase.equalsIgnoreCase("fin")) {
						matriz[j][k] = frase;
						k++;
					}
				}
			}
		}
		return matriz;
	}

	public static void mostrarMatriz(String[][] m) {
		String colum = new String("");
		for (int i = 0; i <= NUM_FILAS; i++) {
			for (int j = 0; j <= NUM_COL; j++) {

				if (i == 0) {
					if (j == 0) {
						System.out.print("\t\t" + "ArtDet \t\t" + "Suj \t\t" + "Verb \t\t" + "Pred \n");
					}
				} else {
					if (j == 0) {
						System.out.print(i - 1);
					} else {
						colum = (m[i - 1][j - 1] != null) ? m[i - 1][j - 1] : "";
						System.out.print("\t\t" + colum);
					}
				}
			}
			System.out.println();
		}
	}

	public static void ordenarColumnaMatriz(String[][] m, int colum) {
		int pos = 0;
		String temp;

		for (int fila = 0; fila < m.length; fila++) {
			for (int col = 0; col < m[fila].length; col++) {
				if (col == colum) {

					if (m[fila][col] == null)
						continue;

					System.out.println(m[pos][col] + " :: " + m[fila][col]);

					if (m[pos][col].compareTo(m[fila][col]) < 0) {
						pos = fila;
					}

					if (pos != fila) {
						temp = m[pos][col];
						m[pos][col] = m[fila][col];
						m[fila][col] = temp;
					}
				}

			}
		}
	}

	public static void ordenarMatrizPorColumnas(String[][] m) {
		for (int i = 0; i < NUM_COL; i++) {
			ordenarColumnaMatriz(m, i);
		}
	}

	public static boolean existeCadenaEnColumna(String[][] m, String cadena, int colum) {
		boolean existeCadena = false;
		int i = 0, inf = 0, sup = 0, centro = 0, filasDisponibles = 0;

		for (i = 0; i < NUM_FILAS; i++)
			if (m[i][colum] != null)
				filasDisponibles++;

		sup = filasDisponibles - 1;

		while (inf <= sup) {

			centro = (sup + inf) / 2;

			if (m[centro][colum].contains(cadena)) {
				return true;

			} else if (cadena.compareTo(m[centro][colum]) < 0) {
				sup = centro - 1;

			} else {
				inf = centro + 1;
			}
		}
		return existeCadena;
	}

	public static boolean anyadeCadenaAMatriz(String[][] m, String cadena, String tipo) {

		int i = 0, j;

		switch (tipo) {
		case "articulodet":
			i = 0;
			break;

		case "sujeto":
			i = 1;
			break;

		case "verbo":
			i = 2;
			break;

		case "predicado":
			i = 4;
			break;
		}

		for (j = 0; j < NUM_FILAS; j++)
			if (cadena.equalsIgnoreCase(m[i][j]))
				return true;

		return false;
	}

	public static String[] generaVectorJuego(String[][] m) {

		int i = 0, filAleatorio = 0;
		String[] v = new String[NUM_COL];

		do {
			filAleatorio = (int) Math.floor(Math.random() * ((NUM_COL - 1) - 0 + 1));

			if (m[filAleatorio][i] != null) {
				v[i] = m[filAleatorio][i];
				i++;
			} else {
				i--;
			}
		} while (i <= v.length);
		return v;
	}

	public static boolean contiene(char[] v, char letra) {

		for (int i = 0; i < v.length; i++) {
			if (v[i] == letra)
				return true;
		}
		return false;
	}

	/*
	 * recibe como parámetro un vector de caracteres y una letra, comprueba si la
	 * letra no está en dicho vector y si hay hueco para meterla y si se cumplen
	 * ambas premisas inserta la letra de manera ordenada en el vector devolviendo
	 * TRUE. En caso contrario devuelve FALSE. Usa el algoritmo de ordenación que
	 * estimes oportuno.
	 */

	public static boolean insertaLetraOrdenadaEnVector(String[] v, char letra) {

		return true;
	}

	public static String escondePalabra(char[] v, String cadena) {
		String palabra = new String("");
		for (int j = 0; j < cadena.length(); j++) {

			if (contiene(v, cadena.charAt(j))) {
				palabra += cadena.charAt(j);
			} else {
				palabra += "_ ";
			}
		}
		return palabra;
	}

	public static String pistaParteFrase(String[] v) {
		int posicionAleatoria, subCadenaAleatoria1, subCadenaAleatoria2;

		posicionAleatoria = (int) Math.floor(Math.random() * ((v.length - 1) - 0 + 1));
		subCadenaAleatoria1 = (int) Math.floor(Math.random() * ((v[posicionAleatoria].length() - 1) - 0 + 1));
		subCadenaAleatoria2 = (int) Math.floor(
				Math.random() * ((v[posicionAleatoria].length() - 1) - subCadenaAleatoria1 + 1) + subCadenaAleatoria1);

		return v[posicionAleatoria].substring(subCadenaAleatoria1, subCadenaAleatoria2);
	}

	public static boolean esParteDeLaFrase(String[] v, String subcadena) {
		String cadena = new String("");

		for (int i = 0; i < v.length; i++) {
			cadena += v[i];
		}

		if (cadena.contains(subcadena.replace(" ", "")))
			return true;

		return false;
	}

	public static boolean resolver(String[] v, String respuesta) {

		return esParteDeLaFrase(v, respuesta);
	}
}
