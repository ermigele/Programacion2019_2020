package ejerciciosInicialesOO;

public class Vagon {

	private String matricula;
	private double capacidadDeCarga;

	// CONSTRUCTOR VACIO
	public Vagon() {
		matricula = "";
		capacidadDeCarga = 0;
	}

	// CONSTRUCTOR POR PARAMETROS
	public Vagon(String matricula, double capacidadDeCarga) {
		this.matricula = matricula;
		this.capacidadDeCarga = capacidadDeCarga;
	}

	// CONSTRUCTOR COPIA
	public Vagon(Vagon vagonCopia) {
		this.matricula = vagonCopia.matricula;
		this.capacidadDeCarga = vagonCopia.capacidadDeCarga;
	}

	// GETTERS Y SETTERS
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getCapacidadDeCarga() {
		return capacidadDeCarga;
	}

	public void setCapacidadDeCarga(double capacidadDeCarga) {
		this.capacidadDeCarga = capacidadDeCarga;
	}

}
