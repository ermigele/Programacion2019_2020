package practica3;

public class ejercicio3 {

	public static void main(String[] args) {
		/*
		 * Escribe un programa en JAVA que le pida al usuario dos fechas (la segunda
		 * será una fecha mayor que la primera siempre pues el usuario es buena gente).
		 * Los días y años de la fecha los escribirá en formato numérico, pero los meses
		 * de las dos fechas los escribirá en formato cadena (pudiendo el usuario
		 * escribirlas en mayúsculas o minúsculas o cualquier combinación de letras
		 * mayúsculas y minúsculas). También vamos a tener en cuenta que las fechas
		 * dadas por el usuario son correctas. El programa debe imprimir por pantalla
		 * cuantos años, meses y días hay entre una fecha y otra. En este ejercicio no
		 * se pueden usar bucles.
		 */

		int diaPrimer = 0, anyoPrimer = 0, diaSegun = 0, anyoSegun = 0, diaDif = 0, mesDif = 0, mesPrimer = 0, mesSegun = 0, anyoDif = 0;
		String mesPr = "", mesSeg = "";

		System.out.print("Introduce el dia de la primera fecha: ");
		diaPrimer = Entrada.entero();
		System.out.print("Introduce el mes de la primera fecha: ");
		mesPr = Entrada.cadena().toUpperCase();
		System.out.print("Introduce el año de la primera fecha: ");
		anyoPrimer = Entrada.entero();
		System.out.print("Introduce el dia de la segunda fecha: ");
		diaSegun = Entrada.entero();
		System.out.print("Introduce el mes de la segunda fecha: ");
		mesSeg = Entrada.cadena().toUpperCase();
		System.out.print("Introduce el año de la segunda fecha: ");
		anyoSegun = Entrada.entero();

		switch (mesPr) {
		case "ENERO":
			mesPrimer = 1;
			break;
		case "FEBRERO":
			mesPrimer = 2;
			break;
		case "MARZO":
			mesPrimer = 3;
			break;
		case "ABRIL":
			mesPrimer = 4;
			break;
		case "MAYO":
			mesPrimer = 5;
			break;
		case "JUNIO": 
			mesPrimer = 6;
			break;
		case "JULIO":
			mesPrimer = 7;
			break;
		case "AGOSTO":
			mesPrimer = 8;
			break;
		case "SEPTIEMBRE":
			mesPrimer = 9;
			break;
		case "OCTUBRE":
			mesPrimer = 10;
			break;
		case "NOVIEMBRE":
			mesPrimer = 11;
			break;
		case "DICIEMBRE":
			mesPrimer = 12;
			break;
		default:
			System.out.println("El mes introducido es incorrecto");
		}
		switch (mesSeg) {
		case "ENERO":
			mesSegun = 1;
			break;
		case "FEBRERO":
			mesSegun = 2;
			break;
		case "MARZO":
			mesSegun = 3;
			break;
		case "ABRIL":
			mesSegun = 4;
			break;
		case "MAYO":
			mesSegun = 5;
			break;
		case "JUNIO":
			mesSegun = 6;
			break;
		case "JULIO":
			mesSegun = 7;
			break;
		case "AGOSTO":
			mesSegun = 8;
			break;
		case "SEPTIEMBRE":
			mesSegun = 9;
			break;
		case "OCTUBRE":
			mesSegun = 10;
			break;
		case "NOVIEMBRE":
			mesSegun = 11;
			break;
		case "DICIEMBRE":
			mesSegun = 12;
			break;
		default:
			System.out.println("El mes introducido es incorrecto");
		}
		
		anyoDif = anyoSegun - anyoPrimer;
		
		if(mesPrimer > mesSegun) {
			mesDif= mesPrimer - mesSegun;
		}else {
			mesDif = mesSegun - mesPrimer;
			mesDif--;
		}
		
		if (diaSegun > diaPrimer) {
			diaDif = diaSegun - diaPrimer;
		} else {
			diaDif = diaPrimer - diaSegun;
		}

		System.out.println("La diferencia es de: " + diaDif + " dias, " + mesDif + " meses, " + anyoDif + " años.");
	}
}
