package ejerciciosMasFunciones;

public class EjercicioFechas {

	final int DIA_HOY = 2, ANIO_HOY = 2019;
	final String MES_HOY = "diciembre";

	public static void main(String[] args) {
		int dia = 0, anio = 0;
		String mes;

		System.out.println("Introduce su fecha de nacimiento ");
		System.out.print("Dia: ");
		dia = Entrada.entero();
		System.out.print("Mes: ");
		mes = Entrada.cadena().toLowerCase();
		System.out.print("Año: ");
		anio = Entrada.entero();

		System.out.println(pasaMesAEntero(mes));
		System.out.println(diasMes(dia, pasaMesAEntero(mes)));
		// calculaEdad(dia, pasaMesAEntero(mes), anio);

		// int aletorio = (int) (Math.random() * (50 - 1 + 1) + 1);
		// System.out.println(aletorio);

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

	// devuelve el número de días que tiene el mes.
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

	// devuelve el número del mes pasado a cadena, si la cadena no se corresponde
	// con ningún mes devuelve -1
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

		if (anyo < 1500 && (diasMes < 1 || diaMes > 31)) {
			return false;
		} else {
			return true;
		}
	}

	// devuelve cierto si la fecha dia, mes es mayor que el día y el mes de la
	// fecha, actual.
	public static boolean esMayor(int dia, int mes) {
		return false;

	}

	// Que muestra por pantalla la edad de la fecha dada
	public static void calculaEdad(int dia, int mes, int anyo) {

	}
}
