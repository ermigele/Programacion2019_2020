package practica6_JAVA;

class Habitacion {

	// ATRIBUTOS
	private static int totalHabitaciones;
	private int numHabitacion;
	private Reserva[] reservasHabitacion;
	private int posicionLibre;

	// CONSTRUCTOR
	Habitacion(int numHabitacion, int maxReservas) {
		this.numHabitacion = numHabitacion;
		totalHabitaciones++;
		this.reservasHabitacion = new Reserva[maxReservas];
		this.posicionLibre = 0;
	}

	// GETTERS & SETTERS
	public int getTotalHabitaciones() {
		return totalHabitaciones;
	}

	public int getNumHabitacion() {
		return numHabitacion;
	}

	public void setNumHabitacion(int numHabitacion) {
		this.numHabitacion = numHabitacion;
	}

	/*
	 * Esta clase tendrá getters para todos los atributos (ten en cuenta que para el
	 * vector reservasHabitacion el getter debe devolver la habitación de la
	 * posición que se pase como parámetro si es que existe, si no, ha de devolver
	 * null). Y el único setter que tiene es el del atributo del número de
	 * habitación.
	 */
	public Reserva getReservasHabitacion(int posicion) {
		return reservasHabitacion[posicion];
	}

	public int getPosicionLibre() {
		return posicionLibre;
	}

	// METODOS

	/*
	 * o Hay hueco en el vector de reservas
	 * 
	 * o Si la fecha de entrada es menor que la fecha de salida de la reserva pasada
	 * como parámetro (te serán útiles los métodos de la clase fecha, esMenor,
	 * esMayor, esMenorIgual, esMayorIgual..).
	 * 
	 * o Si las fechas de la reserva pasada como parámetro no se solapa con ninguna
	 * otra reserva de las que ya hay hechas.
	 * 
	 * Si la reserva puede hacerse, se mete el objeto Reserva en la primera posición
	 * libre que haya en el vector (aumentando el atributo que indica la posición
	 * libre) y devolverá TRUE. En caso contrario ha de devolver FALSE.
	 */
	public boolean anyadeReserva(Reserva r1) {
		if (this.posicionLibre < 0)
			return false;
		Reserva temp;

		for (int i = 0; i < this.posicionLibre; i++) {
			temp = reservasHabitacion[i];
			if ( // Si se solapan las fechas
			temp != null && r1.getFechaEntrada().esMenorOIgual(temp.getFechaSalida())
					&& r1.getFechaSalida().esMayorOIgual(temp.getFechaEntrada())) {
				return false;
			}
		}
		reservasHabitacion[this.posicionLibre] = r1;
		this.posicionLibre = (reservasHabitacion.length == posicionLibre + 1) ? -1 : posicionLibre + 1;
		return true;
	}

	public void imprimirReservas() {
		for (int i = 0; i < reservasHabitacion.length; i++) {
			System.out.println("Reserva nº:" + i);
			reservasHabitacion[i].imprimeReserva();
		}
	}
}
