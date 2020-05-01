package practica6_JAVA;

public class Hotel {

	// ATRIBUTOS
	private String nombreHotel;
	private Habitacion[] habitaciones;
	private int posLibre;

	// CONSTRUCTOR
	public Hotel(String nombreHotel, int maxHabitaciones) {
		this.nombreHotel = nombreHotel;
		this.habitaciones = new Habitacion[maxHabitaciones];
		this.posLibre = 0;
	}

	// GETTERS
	public String getNombreHotel() {
		return nombreHotel;
	}

	public Habitacion getHabitaciones(int posicion) {

		if (habitaciones[posicion] != null) {
			Habitacion h1 = habitaciones[posicion];
			return h1;
		} else {
			return null;
		}
	}

	public int getPosLibre() {
		return posLibre;
	}

	// METODOS

	public boolean anyadeHabitacion() {
		int numHabitacion, maxReservas;
		Habitacion temp;

		if (posLibre >= 0) {
			System.out.println("Indica el número de habitacion: ");
			numHabitacion = Entrada.entero();
			System.out.println("Indica la cantidad máxima de reservas que se pueden realizar: ");
			maxReservas = Entrada.entero();

			for (int i = 0; i < posLibre; i++) {
				temp = habitaciones[i];
				if (temp.getNumHabitacion() == numHabitacion) {
					return false;
				}
			}
			habitaciones[posLibre] = new Habitacion(numHabitacion, maxReservas);
			this.posLibre++;
			return true;
		}
		return false;
	}

	/*
	 * ordenará el vector de habitaciones según sus números de habitación usando el
	 * método de selección. Ojo que no acceda a las posiciones donde no hay
	 * habitaciones y hay valores null. La ordenación será de manera ASCENDENTE
	 */
	public void ordenaHabitacionesPorNumeroHabitacionSeleccion() {
		int pos;
		Habitacion temp;
		for (int i = 0; i <= (habitaciones.length - 2); i++) {
			if (habitaciones[i] == null)
				break;
			else
				pos = i;
			for (int j = i + 1; j <= (habitaciones.length - 1); j++)
				if (habitaciones[j].getNumHabitacion() < habitaciones[pos].getNumHabitacion())
					pos = j;

			if (pos != i) {
				temp = habitaciones[pos];
				habitaciones[pos] = habitaciones[i];
				habitaciones[i] = temp;
			}
		}
	}

	/*
	 * ordenará el vector de habitaciones según la cantidad de reservas que haya
	 * hechas en las habitaciones. Ojo que no acceda a las posiciones donde no hay
	 * habitaciones y hay valores null. La ordenación será de manera DESCENDENTE
	 */
	public void ordenaHabitacionesPorReservasActualesInsercion() {
		int i, j;
		Habitacion temp;

		for (i = 1; i < habitaciones.length; i++) {
			if (habitaciones[i] == null)
				break;
			else
				temp = habitaciones[i];
			for (int k = 0; k < temp.getPosicionLibre(); k++) {
				j = i - 1;
			}
		}
	}

	// mostrará las habitaciones con sus
	// correspondientes reservas, así como el total de habitaciones que hay en el
	// hotel
	public void muestraHabitacionesYReservas() {

		for (int i = 0; i < habitaciones.length; i++) {
			System.out.println("Habitación número: " + i);
			habitaciones[i].getReservasHabitacion(i).imprimeReserva();
		}
		System.out.println("Total habitaciones del hotel: " + posLibre);
	}
}
