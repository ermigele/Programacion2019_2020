package examenOO2503A;

public class Epidemia {

	// ATRIBUTOS
	private String nombreEpidemia;
	private int anyoInicio;
	private int anyoFin;
	private int numeroHabitantes;
	private int numeroTotalInfectados;
	private int defunciones;

	// CONSTRUCTORES
	public Epidemia(String nombreEpidemia, int anyoInicio, int anyoFin, int numeroHabitantes, int numeroTotalInfectados,
			int defunciones) {
		this.nombreEpidemia = nombreEpidemia;
		this.anyoInicio = anyoInicio;
		this.anyoFin = anyoFin;
		this.numeroHabitantes = numeroHabitantes;
		this.numeroTotalInfectados = numeroTotalInfectados;
		this.defunciones = defunciones;
	}

	public Epidemia(Epidemia epidemiaCopia) {
		this.nombreEpidemia = epidemiaCopia.nombreEpidemia;
		this.anyoInicio = epidemiaCopia.anyoInicio;
		this.anyoFin = epidemiaCopia.anyoFin;
		this.numeroHabitantes = epidemiaCopia.numeroHabitantes;
		this.numeroTotalInfectados = epidemiaCopia.numeroTotalInfectados;
		this.defunciones = epidemiaCopia.defunciones;
	}

	// GETTERS

	public String getNombreEpidemia() {
		return nombreEpidemia;
	}

	public int getAnyoInicio() {
		return anyoInicio;
	}

	public int getAnyoFin() {
		return anyoFin;
	}

	public int getNumeroHabitantes() {
		return numeroHabitantes;
	}

	public int getNumeroTotalInfectados() {
		return numeroTotalInfectados;
	}

	public int getDefunciones() {
		return defunciones;
	}

	// METODOS
	public double getPorcentajeDefunciones() {

		return (this.defunciones / this.numeroTotalInfectados) * 100;
	}

	public String toString() {

		return "____________\nNombre: " + this.nombreEpidemia + "\nAño inicio: " + this.anyoInicio + "\nAño fin: "
				+ this.anyoFin + "\nNúmero habitantes en la época:  " + this.numeroHabitantes
				+ "\nNúmero total infectados: " + this.numeroTotalInfectados + "\nNúmero defunciones: "
				+ this.defunciones + "\nPorcentaje infectados/defunciones:" + getPorcentajeDefunciones();
	}

}
