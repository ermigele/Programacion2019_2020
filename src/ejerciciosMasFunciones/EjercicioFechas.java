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
		mes = Entrada.cadena();
		System.out.print("A�o: ");
		anio = Entrada.entero();

	}

	// METODOS

	// devuelve cierto si el a�o es bisiesto y falso si el a�o no es bisiesto.

	public static boolean esBisiesto(int anio) {

		if (anio % 4 == 0 && (anio % 100 != 0 || anio % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	// devuelve el n�mero de d�as que tiene el mes.

	public static int diasMes(int mes, int anyo) {

		return 1;
	}

	// devuelve el n�mero del mes pasado a cadena, si la cadena no se corresponde
	// con ning�n mes devuelve -1
	public static int pasaMesAEntero(String mesCad) {

		return 1;
	}

	// devuelve cierto si es correcta la fecha
	public static boolean fechaCorrecta(int dia, int mes, int anyo) {

		return false;
	}

	// devuelve cierto si la fecha dia, mes es mayor que el d�a y el mes de la
	// fecha,actual.
	public static boolean esMayor(int dia, int mes) {
		return false;

	}

	// Que muestra por pantalla la edad de la fecha dada
	public static void calculaEdad(int dia, int mes, int anyo) {

	}
}
