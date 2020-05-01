package practica6_JAVA;

public class Reserva {

	// ATRIBUTOS
	private Persona personaResponsable;
	private Fecha fechaEntrada;
	private Fecha fechaSalida;

	// CONSTRUCTORES
	public Reserva(Persona personaResponsable, Fecha fechaEntrada, Fecha fechaSalida) {
		this.personaResponsable = personaResponsable;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
	}

	// GETTERS & SETTERS
	public Persona getPersonaResponsable() {
		return personaResponsable;
	}

	public Fecha getFechaEntrada() {
		return fechaEntrada;
	}

	public Fecha getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaEntrada(int dia, String mes, int anyo) {
		fechaEntrada.setDia(dia);
		fechaEntrada.setMes(mes);
		fechaEntrada.setAnyo(anyo);
	}

	public void setFechaSalida(int dia, String mes, int anyo) {
		fechaEntrada.setDia(dia);
		fechaEntrada.setMes(mes);
		fechaEntrada.setAnyo(anyo);
	}

	// METODO
	public void imprimeReserva() {

		System.out.print("______________________________________________________________________________\n");
		System.out.println("Fecha entrada: " + this.fechaEntrada.getDia() + " de " + this.fechaEntrada.getMes()
				+ " del " + this.fechaEntrada.getAnyo() + "\nFecha salida: " + this.fechaSalida.getDia() + " de "
				+ this.fechaSalida.getMes() + " del " + this.fechaSalida.getAnyo() + "\nReserva a nombre de: "
				+ this.personaResponsable.getNombre() + " " + this.personaResponsable.getApellidos() + " con DNI "
				+ this.personaResponsable.getDni() + "\n");
		System.out.print("______________________________________________________________________________\n\n");
	}

}
