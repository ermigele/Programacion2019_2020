package practica6_JAVA;

public class Fecha {

	// ATRIBUTOS
	private int dia;
	private String mes;
	private int anyo;

	// CONSTRUCTORES
	public Fecha(int dia, String mes, int anyo) {

		if (esFechaCorrecta()) {
			this.dia = dia;
			this.mes = mes;
			this.anyo = anyo;
		} else {
			this.dia = 1;
			this.mes = "mes";
			this.anyo = 2020;
		}

	}

	public Fecha(Fecha fechaCopia) {
		this.dia = fechaCopia.dia;
		this.mes = fechaCopia.mes;
		this.anyo = fechaCopia.anyo;
	}

	// GETTERS & SETTERS
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		int temp = this.dia;
		if (!esFechaCorrecta())
			this.dia = temp;
		else
			this.dia = dia;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		String temp = this.mes;
		if (!esFechaCorrecta())
			this.mes = temp;
		else
			this.mes = mes;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		int temp = this.anyo;
		if (!esFechaCorrecta())
			this.anyo = temp;
		else
			this.anyo = anyo;
	}

	// METODOS

	public boolean esBisiesto() {

		if ((getAnyo() % 4 == 0) && ((getAnyo() % 100 != 0) || (getAnyo() % 400 == 0)))
			return true;
		else
			return false;
	}

	public int devuelveMesNumerico() {
		int mes = 0;

		switch (this.mes) {

		case "enero":
			mes = 1;
			break;
		case "febrero":
			mes = 2;
			break;
		case "marzo":
			mes = 3;
			break;
		case "abril":
			mes = 4;
			break;
		case "mayo":
			mes = 5;
			break;
		case "junio":
			mes = 6;
			break;
		case "julio":
			mes = 7;
			break;
		case "agosto":
			mes = 8;
			break;
		case "septiembre":
			mes = 9;
			break;
		case "octubre":
			mes = 10;
			break;
		case "noviembre":
			mes = 11;
			break;
		case "diciembre":
			mes = 12;
			break;
		default:
			mes = -1;
			break;
		}
		return mes;
	}

	public int devuelveDiasTotalesDelMes() {
		int dias = devuelveMesNumerico();

		if (dias == 2) {
			if (esBisiesto())
				return 29;
			else
				return 28;
		} else if (dias == 4 || dias == 6 || dias == 9 || dias == 11) {
			return 30;
		} else {
			return 31;
		}
	}

	public boolean esFechaCorrecta() {
		int diasT = devuelveDiasTotalesDelMes();

		if (getAnyo() < 2020 && diasT != 0)
			return true;

		return false;
	}

	public boolean esIgual(Fecha fecha) {

		if (fecha.getAnyo() == getAnyo() && (fecha.getMes().equals(getMes()) && (fecha.getDia() == getDia())))
			return true;
		else
			return false;
	}

	public boolean esMenor(Fecha fecha) {

		if (fecha.getAnyo() < getAnyo() || fecha.getAnyo() == getAnyo())
			return true;
		if (fecha.devuelveMesNumerico() < devuelveMesNumerico() || fecha.devuelveMesNumerico() == devuelveMesNumerico())
			return true;
		if (fecha.getDia() < getDia())
			return true;

		return false;
	}

	public boolean esMayor(Fecha fecha) {

		if (fecha.getAnyo() > getAnyo() || fecha.getAnyo() == getAnyo())
			return true;
		if (fecha.devuelveMesNumerico() > devuelveMesNumerico() || fecha.devuelveMesNumerico() == devuelveMesNumerico())
			return true;
		if (fecha.getDia() > getDia())
			return true;

		return false;
	}

	public boolean esMayorOIgual(Fecha fecha) {

		if (fecha.esMayor(fecha) || fecha.esIgual(fecha))
			return true;
		else
			return false;
	}

	public boolean esMenorOIgual(Fecha fecha) {

		if (fecha.esMenorOIgual(fecha) || fecha.esIgual(fecha))
			return true;
		else
			return false;
	}

}
