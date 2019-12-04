package ejerciciosMasFunciones;

public class EjercicioFechas {

	final static int DIA_HOY = 3;
	final static int MES_HOY = 11;
	final static int ANYO_HOY = 2019;

	public static void main(String[] args) {
		int dia = 0;
		String mes = new String(" ");
		int anyo = 0;
		int mesEntero = 0;

		System.out.println("Introduce la fecha de nacimiento");
		System.out.println("Introduce el dia");
		dia = Entrada.entero();
		System.out.println("Introduce el mes");
		mes = Entrada.cadena();
		System.out.println("Introduce el a�o");
		anyo = Entrada.entero();

		mesEntero = pasaMesAEntero(mes);

		while (!fechaCorrecta(dia, mesEntero, anyo)) {
			System.err.println("fecha introducida incorrecta vuelve a introducirla");
			System.out.println("Introduce la fecha de nacimiento");
			System.out.println("Introduce el dia");
			dia = Entrada.entero();
			System.out.println("Introduce el mes");
			mes = Entrada.cadena();
			System.out.println("Introduce el a�o");
			anyo = Entrada.entero();

			mesEntero = pasaMesAEntero(mes);
		}

		calculaEdad(dia, mesEntero, anyo);

	}

	// ~~ METODOS ~~

	// devuelve cierto si el a�o es bisiesto y falso si el año no es bisiesto.

	public static boolean esBisiesto(int anyo) {

		if (anyo % 4 == 0 && (anyo % 100 != 0 || anyo % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	// devuelve el n�mero de d�as que tiene el mes.
	public static int diasMes(int mes, int anyo) {

		if (mes == 2) {
			mes = (esBisiesto(anyo)) ? 29 : 28;
		} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			mes = 30;
		} else {
			mes = 31;
		}
		return mes;
	}

	// devuelve el n�mero del mes pasado a cadena, si la cadena no se corresponde
	// con ning�n mes devuelve -1
	public static int pasaMesAEntero(String mesCad) {

		switch (mesCad) {

		case "enero":
			return 1;
		case "febrero":
			return 2;
		case "marzo":
			return 3;
		case "abril":
			return 4;
		case "mayo":
			return 5;
		case "junio":
			return 6;
		case "julio":
			return 7;
		case "agosto":
			return 8;
		case "septiembre":
			return 9;
		case "octubre":
			return 10;
		case "noviembre":
			return 11;
		case "diciembre":
			return 12;
		default:
			return -1;
		}
	}

	// devuelve cierto si es correcta la fecha
	public static boolean fechaCorrecta(int dia, int mes, int anyo) {

		if (dia > diasMes(mes, anyo) || dia < 1 || mes < 1 || anyo > ANYO_HOY
				|| (anyo == ANYO_HOY && esMayor(dia, mes))) {
			return false;
		} else {
			return true;
		}
	}

	// devuelve cierto si la fecha dia, mes es mayor que el d�a y el mes de la
	// fecha, actual.
	public static boolean esMayor(int dia, int mes) {
		if ((dia >= DIA_HOY && mes == MES_HOY) || mes > MES_HOY) {
			return true;
		} else {
			return false;
		}

	}

	// Que muestra por pantalla la edad de la fecha dada
	public static void calculaEdad(int dia, int mes, int anyo) {
		int edad = 0;
		edad = ANYO_HOY - anyo;

		if (esMayor(dia, mes))
			edad--;

		System.out.println("Tu edad es: " + edad);
	}
}
