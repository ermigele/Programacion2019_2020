package examenTema4CursoPasado;

public class MicroTeatro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] matrizPalabras = { { "arbol", "asturias", "austero" },
				{ "elemental", "elenco", "estuche", "estado" }, { "ion", "instancia", "ilogico", "italica", "imagen" },
				{ "ovalado", "obsesion", "oscuro" }, { "union", "ukelele", "usted", "uron" } };

		String[][] matrizDefiniciones = {
				{ "planta perenne, de tronco leñoso y elevado", "región del Norte de España cuya capital es Oviedo",
						"sobrio, sin excesos" },

				{ "fundamental, primordial", "conjunto de actores que actúan en una obra",
						"caja para guardar ordenadamente un objeto o varios",
						"situación en la que se encuentra alguien o algo" },

				{ "átomo que por pérdida o ganancia de electrones adquiere carga eléctrica",
						"acción y efecto de instar", "que es contrario a la lógica",
						"antigua ciudad romana situada en el actual Santiponce",
						"estatua de una divinidad o de un personaje sagrado" },

				{ "de forma de óvalo", "no es amor, es una...", "que carece de luz o claridad" },

				{ "acción y efecto de unir o unirse", "instrumento musical de cuerda originario de Hawaii",
						"tú, pero con tratamiento de cortesía", "persona huraña" } };

		System.out.println("Elige opción: \na) Ver todas las definiciones ordenadas\nb) JUGAR A PASAPALABRA VOCALES");
		char op = Entrada.caracter();

		if (op == 'a') {
			String[][] matDefinicionesCopia = copiaMatrizDefinicionesOrdenada(matrizDefiniciones);

			seleccionMatriz(matDefinicionesCopia);

			for (int i = 0; i < matDefinicionesCopia.length; i++) {
				for (int j = 0; j < matDefinicionesCopia[i].length; j++)
					System.out.println(matDefinicionesCopia[i][j]);
			}
		} else if (op == 'b') {
			int pos = 0, tipoRes = 0;
			String resp = new String("");
			String[][] matrizJuego = generaMatrizJuego(matrizPalabras, matrizDefiniciones);

			System.out.println("------BIENVENIDO A PASAPALABRA VOCALES!!!!------");

			while (!finJuego(matrizJuego)) {
				System.out.println("\n");
				if (pos == matrizJuego[0].length)
					pos = 0;

				if (matrizJuego[0][pos].compareTo("acierto") != 0 && matrizJuego[0][pos].compareTo("fallo") != 0) {

					System.out.println("Con la " + matrizJuego[0][pos].charAt(0) + ":\n" + matrizJuego[1][pos]);
					resp = Entrada.cadena();

					tipoRes = tipoRespuesta(resp, matrizJuego, pos);

					if (tipoRes == 2) {
						System.out.println("SI!");
						matrizJuego[0][pos] = "acierto";
						pos++;
					} else if (tipoRes == 1) {
						System.out.println("SIGUIENTE!");
						pos++;
					} else if (tipoRes == 0) {
						System.out.println("Elige letra que quieres ver: ");
						char letra = Entrada.caracter();
						pistaMostrarLetraColocadaRecursiva(matrizJuego[0][pos], letra, 0);
					} else if (tipoRes == -1) {
						System.out.println("NO!");
						System.out.println("La respuesta era: " + matrizJuego[0][pos]);
						matrizJuego[0][pos] = "fallo";
						pos++;
					}

					puntuacion(matrizJuego);
				} else
					pos++;
			}

			if (haGanado(matrizJuego))
				System.out.println("\n\nHAS GANADO Y TE HAS LLEVADO EL ROSCO!!!!");
			else
				System.out.println("\n\nOOOOH NO HAS CONSEGUIDO EL ROSCO....\nNos vemos en el próximo programa ;) ");

		}

	}

	public static String[][] generaMatrizJuego(String[][] matrizPal, String[][] matrizDef) {
		int pos;
		String[][] matrizJuego = new String[2][matrizPal.length];

		for (int i = 0; i < matrizPal.length; i++) {
			pos = (int) (Math.round(Math.random() * (matrizPal[i].length - 1)));
			matrizJuego[0][i] = matrizPal[i][pos];
			matrizJuego[1][i] = matrizDef[i][pos];
		}

		return matrizJuego;
	}

	public static int tipoRespuesta(String respuesta, String[][] matJuego, int pos) {
		respuesta = respuesta.toLowerCase().replaceAll("á", "a").replaceAll("é", "e").replaceAll("í", "i")
				.replaceAll("ó", "o").replaceAll("ú", "u");

		if (respuesta.equals(matJuego[0][pos])) {
			return 2;
		} else if (respuesta.equals("pasapalabra")) {
			return 1;
		} else if (respuesta.equals("pista"))
			return 0;
		else
			return -1;
	}

	public static void puntuacion(String[][] matJuego) {
		int aciertos = 0, fallos = 0, sincontestar = 0;
		for (int i = 0; i < matJuego[0].length; i++) {
			if (matJuego[0][i].equals("acierto"))
				aciertos++;
			else if (matJuego[0][i].equals("fallo"))
				fallos++;
			else
				sincontestar++;
		}

		System.out.println(
				"Llevas " + aciertos + " aciertos, " + fallos + " fallos y " + sincontestar + " no contestadas");
	}

	public static boolean finJuego(String[][] matJuego) {
		for (int i = 0; i < matJuego[0].length; i++)
			if (matJuego[0][i].compareTo("acierto") != 0 && matJuego[0][i].compareTo("fallo") != 0)
				return false;

		return true;
	}

	public static boolean haGanado(String[][] matJuego) {
		for (int i = 0; i < matJuego[0].length; i++)
			if (matJuego[0][i].compareTo("acierto") != 0)
				return false;

		return true;
	}

	public static String[][] copiaMatrizDefinicionesOrdenada(String[][] matrizDef) {
		String[][] matrizDefCopia = new String[matrizDef.length][];

		for (int i = 0; i < matrizDef.length; i++) {
			matrizDefCopia[i] = matrizDef[i].clone();
		}

		return matrizDefCopia;
	}

	public static void seleccionMatriz(String[][] mat) {
		int posFil = 0, posCol = 0, k, l;
		String temp = new String("");

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				posFil = i;
				posCol = j;

				if (j == mat[i].length - 1) {
					k = i + 1;
					l = 0;
				} else {
					k = i;
					l = j + 1;
				}

				while (k < mat.length) {
					while (l < mat[k].length) {
						if (mat[posFil][posCol].compareTo(mat[k][l]) > 0) {
							posFil = k;
							posCol = l;
						}
						l++;
					}
					l = 0;
					k++;
				}

				if (posFil != i || posCol != j) {
					temp = mat[posFil][posCol];
					mat[posFil][posCol] = mat[i][j];
					mat[i][j] = temp;
				}
			}
		}
	}

	public static void pistaMostrarLetraColocadaRecursiva(String pal, char letra, int pos) {
		if (pos < pal.length()) {
			if (pal.charAt(pos) == letra)
				System.out.print(letra + " ");
			else
				System.out.print("_ ");

			pistaMostrarLetraColocadaRecursiva(pal, letra, pos + 1);
		} else // caso base
			System.out.println();
	}
}
