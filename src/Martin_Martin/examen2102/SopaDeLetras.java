package Martin_Martin.examen2102;

public class SopaDeLetras {

	static final int NUM_PAL_HOR = 3, NUM_PAL_VER = 3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] sopaLetras = new char[9][9];
		String[] vecPal = { "pera", "trueno", "casaca", "edificio", "ropa", "dato", "sospechoso", "lluvia", "ahorcado",
				"roble", "cogorza" };
		String[] vecDef = { "fruto del peral", "estruendo del cielo", "chaqueta militar",
				"construcción de varias plantas", "lo que te pones para no ir desnudo", "ojo al...",
				"posible culpable de delito", "agua que cae del cielo", "juego de la práctica anteriror",
				"árbol robusto", "borrachera" };

		int[] vecPosDefinicionesHorizontal, vecPosDefinicionesVertical;
		String palabra = new String("");
		int fila = 0, colum = 0;
		char opc;
		int finH = NUM_PAL_HOR, finV = NUM_PAL_VER;

		for (int i = 0; i < sopaLetras.length; i++) {
			for (int j = 0; j < sopaLetras[i].length; j++) {
				sopaLetras[i][j] = '*';
			}
		}

		System.out.println("Monstrando las palabras con sus definiciones ordenadas: ");
		for (int i = 0; i < vecPal.length; i++) {
			System.out.print("Palabra: " + vecPal[i] + "\n");
			System.out.print("Definicion: " + vecDef[i] + " \n\n");
		}

		System.out.println("\n\n----¡COMPLETA LA SOPA DE LETRAS!---- \n\n");

		while (finH > 0 && finV > 0) {

			System.out.println("Definiciones palabras horizontal: ");
			for (int i = 0; i < vecDef.length; i++) {
				System.out.print(vecPal[i] + "\n");
			}

			System.out.println("Definiciones palabras vertical: ");
			for (int i = 0; i < vecDef.length; i++) {
				System.out.print(vecPal[i] + "\n");
			}

			muestraSopaDeLetras(sopaLetras);

			System.out.println("Dime la fila donde ves la palabra: ");
			fila = Entrada.entero();
			System.out.println("Dime la columna donde ves la palabra: ");
			colum = Entrada.entero();
			System.out.println("¿Está en horinzontal o en vertical? (v/h)");
			opc = Character.toLowerCase(Entrada.caracter());
			System.out.println("Y la palabra es...");
			palabra = Entrada.cadena().toLowerCase();

			if (aciertoPalabra(sopaLetras, palabra, fila, colum, opc)) {
				System.out.println("¡Bravo!");
				if (opc == 'h')
					finH--;
				else
					finV--;
			} else {
				System.out.println("¡Fallaste!");
			}
		}
	}

	public static void ordenaVectoresPorLongitudPalabra(String[] vecPal, String[] vecDef) {

		int pos, pos2;
		String temp, temp2;

		for (int i = 0; i < vecPal.length; i++) {
			pos = i;
			pos2 = i;
			for (int j = 0; j < vecPal.length; j++) {
				if (vecPal[j].length() < vecPal[pos].length()) {
					pos = j;
					pos2 = j;
				}

				if (pos != i) {
					temp = vecPal[pos];
					vecDef[pos2] = vecDef[i];
					vecPal[i] = temp;
				}
			}
		}
	}

	public static void muestraSopaDeLetras(char[][] sopaLetras) {

		for (int i = 0; i < sopaLetras.length; i++) {
			for (int j = 0; j < sopaLetras[i].length; j++) {

				if (i == 0 && j == 0)
					System.out.print(" ");
				if (i == 0) {
					System.out.print(" " + j + " ");

				} else {

					if (j == 0) {
						System.out.print(i - 1);
					} else {
						System.out.print(" " + sopaLetras[i][j] + " ");
					}
				}
			}
			System.out.println();
		}

	}

	public static boolean entraPalabraHorinzontal(char[][] sopaLetras, String palabra, int fila, int colum) {
		String cadena = new String("");

		for (int i = colum; i <= sopaLetras[fila].length; i++) {
			cadena += String.valueOf(sopaLetras[fila][i]);
		}

		if (cadena.compareTo(palabra) > 0) {
			if (cadena.equals("*")) {
				return true;
			}
		}
		return false;
	}

	public static boolean entraPalabraVertical(char[][] sopaLetras, String palabra, int fila, int colum) {

		String cadena = new String("");

		for (int i = fila; i <= sopaLetras.length; i++) {
			cadena += String.valueOf(sopaLetras[i][colum]);
		}

		if (cadena.compareTo(palabra) > 0) {
			if (cadena.equals("*")) {
				return true;
			}
		}
		return false;
	}

	public static void insertaPalabrasHorizontal(char[][] sopaLetras, String[] vecPal,
			int[] vecPosDefinicionesHorizontal) {

		int fila = 0, colum = 0, pos = 0, cont = 0;

		fila = (int) Math.floor(Math.random() * ((sopaLetras.length - 1) - 0 + 1));
		colum = (int) Math.floor(Math.random() * ((sopaLetras.length - 1) - 0 + 1));
		pos = (int) Math.floor(Math.random() * ((vecPal.length - 1) - 0 + 1));

		while (NUM_PAL_HOR < cont) {

			for (int i = 0; i < vecPal.length; i++)
				if (entraPalabraHorinzontal(sopaLetras, vecPal[i], fila, colum)) {
					vecPosDefinicionesHorizontal[i] = 1;
					vecPal[i] = "";
					cont++;
				}
		}
	}

	public static void insertaPalabrasVertical(char[][] sopaLetras, String[] vecPal, int[] vecPosDefinicionesVertical) {

	}

	public static void rellenaSopaDeLetras(char[][] sopaLetras) {

	}

	public static boolean aciertoPalabra(char[][] sopaLetras, String palabra, int fila, int colum, char opc) {

		String cadena = new String("");

		if (opc == 'h') {
			for (int i = colum; i < sopaLetras[fila].length; i++) {
				cadena += sopaLetras[fila][i];
			}

			if (cadena.contains(palabra))
				return true;

		} else {

			for (int i = fila; i < sopaLetras.length; i++) {
				cadena += sopaLetras[i][colum];
			}
			if (cadena.contains(palabra))
				return true;
		}
		return false;

	}

	public static void pasaAMayusculas(char[][] sopaLetras, String palabra, int fila, int colum, char opc) {
		int cont = 0;

		if (opc == 'h') {
			for (int i = colum; i < sopaLetras[fila].length; i++) {
				if (cont < palabra.length()) {
					sopaLetras[fila][i] = Character.toUpperCase(sopaLetras[fila][i]);
					cont++;
				}
			}

		} else {
			for (int i = fila; i < sopaLetras.length; i++) {
				if (cont < palabra.length()) {
					sopaLetras[i][colum] = Character.toUpperCase(sopaLetras[i][colum]);
					cont++;
				}
			}
		}

	}
}
