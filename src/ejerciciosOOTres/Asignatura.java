package ejerciciosOOTres;

public class Asignatura {

	// ATRIBUTOS
	private String nombreAsignatura;
	private double nota;

	// CONSTRUCTOR
	public Asignatura(String nombreAsignatura, double nota) {
		this.nombreAsignatura = nombreAsignatura;
		this.nota = nota;
	}

	// GETTERS & SETTERS

	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	// METODOS
	@Override
	public String toString() {
		return "Asignatura [nombreAsignatura=" + nombreAsignatura + ", nota=" + nota + "]";
	}

}
