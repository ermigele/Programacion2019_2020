package practica5_JAVA;

public class Ahorcado {

	static final int NUM_FILAS = 10, NUM_COL = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String[][] matriz = { { "el", "perro", "tiende", "peras" }, { "su", "niño",
		// "coge", "curvas" },
		// { "tu", "algodon", "engaña", "a los pajaros" }, { "un", null, "come",
		// "hierba" },
		// { "mi", null, null, "artistas" }, { null, null, null, null }, { null, null,
		// null, null },
		// { null, null, null, null }, { null, null, null, null }, { null, null, null,
		// null } };

		boolean acierto = false, existeCadena = false;
		int menu = 0, menuJugar = 0, intento = 0;
		String tipo = new String(""), cadena = new String("");
		char letra;
		char[] vecCarac = { '|', '|', '|', '|', '|' };
		String[][] matriz = new String[NUM_FILAS][NUM_COL];
		String[] vectorFraseSecreta = new String[NUM_COL];

		do {

			System.out.println("\n¿Qué quieres hacer? \n " + "1.Crear matriz de juego \n "
					+ "2.Mostrar matriz de juego ordenada \n "
					+ "3.Añadir matriz de juego \n 4.Buscar cadena de matriz de juego \n 5.Jugar \n 6.Salir");
			menu = Entrada.entero();

			switch (menu) {

			case 1:
				matriz = creaMatrizConCadenas();
				ordenarMatrizPorColumnas(matriz);
				break;

			case 2:
				System.out.println("Mostrando matriz de juego... \n");
				mostrarMatriz(matriz);
				break;

			case 3:
				System.out.println(
						"\nAñadir matriz de juego...\n ¿Qué quiere añadir articulo/det/sujeto/verbo/predicado?");
				tipo = Entrada.cadena().toLowerCase();
				System.out.println("Escriba la cadena añadir");
				cadena = Entrada.cadena().toLowerCase();
				if (anyadeCadenaAMatriz(matriz, cadena, tipo)) {
					System.out.println("Cadena añadida con éxito");
					ordenarMatrizPorColumnas(matriz);
				}
				break;

			case 4:
				System.out.println("\nBuscar cadena de matriz de juego... \n\n ¿Qué cadena quiere buscar?");
				cadena = Entrada.cadena().toLowerCase();
				for (int i = 0; i < NUM_FILAS; i++) {
					if (existeCadenaEnColumna(matriz, cadena, i))
						existeCadena = true;
					else
						existeCadena = false;
				}

				if (existeCadena)
					System.out.println("Existe " + cadena + " en la matriz de juego");
				else
					System.out.println("No existe " + cadena + " en la matriz de juego");
				break;

			case 5:
				vectorFraseSecreta = generaVectorJuego(matriz);

				System.out.println("\n\n\n ----A JUGAARRRRR----- \n\n\n");
				System.out.println("¡Puede pedir hasta 5 letras para resolver la frase y puede usar pistas!");

				for (int i = 0; i < vectorFraseSecreta.length; i++) {
					System.out.print(escondePalabra(vecCarac, vectorFraseSecreta[i]) + "\t");
				}

				do {
					System.out.println("\n\nPide letra: ");
					letra = Character.toLowerCase(Entrada.caracter());

					if (insertaLetraOrdenadaEnVector(vecCarac, letra))
						intento++;

					for (int i = 0; i < vectorFraseSecreta.length; i++) {
						System.out.print(escondePalabra(vecCarac, vectorFraseSecreta[i]) + "\t");
					}

					System.out.println("\n\nLas letras que has puesto son:");

					for (int i = 0; i < vecCarac.length; i++) {
						if (vecCarac[i] != '|')
							System.out.print("[" + vecCarac[i] + "]");
					}

					System.out.println("\n\n¿Qué quieres? \n 1.Resolver \n " + "2.Pista obtener parte de la frase \n "
							+ "3.Pista comprobar si sé una parte de la frase \n 4.Seguir");
					menuJugar = Entrada.entero();

					switch (menuJugar) {

					case 1:
						System.out.println("\nLa frase es: ");
						cadena = Entrada.cadena().toLowerCase();
						if (resolver(vectorFraseSecreta, cadena)) {
							System.out.println("\n¡Enhorabuena! Has resuelto la frase");
							acierto = true;
						}

						break;

					case 2:
						System.out
								.println("\nForma parte de la frase la cadena: " + pistaParteFrase(vectorFraseSecreta));
						break;

					case 3:
						System.out.println("\nEscribe la parte de la frase que crees que sabes:");
						cadena = Entrada.cadena().toLowerCase();

						if (esParteDeLaFrase(vectorFraseSecreta, cadena)) {
							System.out.println("Pues sí, " + cadena + " forma parte de la frase");
						} else {
							System.out.println("No, " + cadena + " no forma parte de la frase");
						}
						break;

					case 4:
						break;
					default:
						System.out.println("Introducida opción incorrecta de menu");
					}
				} while (!acierto && intento < 5);

				for (int i = 0; i < vecCarac.length; i++) {
					vecCarac[i] = '|';
				}
				intento = 0;

				if (!acierto) {
					System.out.print("\nLa frase secreta era: ");
					for (int i = 0; i < vectorFraseSecreta.length; i++) {
						System.out.print(vectorFraseSecreta[i] + " ");
					}
				}

				break;

			case 6:
				System.out.println("Hasta luegor!");
				break;
			default:
				System.out.println("Introducida opción incorrecta de menu");
				break;
			}
		} while (menu != 6);

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

	public static void ordenarColumnaMatriz(String[][] m, int columna) {
		int i = 0, pos = 0, tamanyo = 0;
		String[] arrayColum;
		String temp;

		while (i < NUM_FILAS && m[i][columna] != null) {
			tamanyo++;
			i++;
		}

		arrayColum = new String[tamanyo];

		for (int j = 0; j < tamanyo; j++)
			arrayColum[j] = m[j][columna];

		for (int k = 0; k < arrayColum.length; k++) {
			pos = k;
			for (int j = 0; j < arrayColum.length; j++) {

				if (arrayColum[j].compareTo(arrayColum[pos]) > 0) {
					pos = j;
				}

				if (pos != k) {
					temp = arrayColum[pos];
					arrayColum[pos] = arrayColum[k];
					arrayColum[k] = temp;
				}
			}
		}

		for (int j = 0; j < arrayColum.length; j++) {
			m[j][columna] = arrayColum[j];
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
		} while (i < v.length);
		return v;
	}

	public static boolean contiene(char[] v, char letra) {

		for (int i = 0; i < v.length; i++) {
			if (v[i] == letra)
				return true;
		}
		return false;
	}

	public static boolean insertaLetraOrdenadaEnVector(char[] v, char letra) {
		char temp;
		int j;

		while (contiene(v, letra)) {
			return false;
		}

		v[v.length - 1] = letra;

		for (int i = 0; i < v.length; i++) {
			temp = v[i];
			j = i - 1;
			while ((j >= 0) && (v[j] > temp)) {
				v[j + 1] = v[j];
				j--;
			}
			v[j + 1] = temp;
		}
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
		int posicionAleatoria, subCadAleatoriaIni, subCadAleatoriaFin;

		posicionAleatoria = (int) Math.floor(Math.random() * ((v.length - 1) - 0 + 1));
		subCadAleatoriaIni = (int) Math.floor(Math.random() * ((v[posicionAleatoria].length() - 1) - 0 + 1));
		subCadAleatoriaFin = (int) Math
				.floor(Math.random() * ((v[posicionAleatoria].length() - 1) - subCadAleatoriaIni + 1)
						+ subCadAleatoriaIni + 1);

		return v[posicionAleatoria].substring(subCadAleatoriaIni, subCadAleatoriaFin);
	}

	public static boolean esParteDeLaFrase(String[] v, String subcadena) {
		String cadena = new String("");

		for (int i = 0; i < v.length; i++) {
			cadena += v[i];
		}
		cadena = cadena.replace(" ", "");
		if (cadena.contains(subcadena.replace(" ", "")))
			return true;

		return false;
	}

	public static boolean resolver(String[] v, String respuesta) {

		String cadena = new String("");

		for (int i = 0; i < v.length; i++) {
			cadena += v[i];
		}
		cadena = cadena.replace(" ", "");
		if (cadena.equals(respuesta.replace(" ", "")))
			return true;

		return false;
	}
}
