package ejerciciosInicialesOO;

public class Locomotora {

	private String matricula;
	private double potencia;
	private double antiguedad;

	// CONSTRUCTOR VACIO
	Locomotora() {
		matricula = new String("");
		potencia = 0;
		antiguedad = 0;
	}

	// CONSTRUCTOR POR PARAMETROS
	Locomotora(String matricula, double potencia, double antiguedad) {
		this.matricula = matricula;
		this.potencia = potencia;
		this.antiguedad = antiguedad;
	}

	// CONSTRUCTOR COPIA
	Locomotora(Locomotora locomotoraCopia) {
		this.matricula = locomotoraCopia.matricula;
		this.potencia = locomotoraCopia.potencia;
		this.antiguedad = locomotoraCopia.antiguedad;
	}

	// GETTERS Y SETTERS
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getPotencia() {
		return potencia;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	public double getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(double antiguedad) {
		this.antiguedad = antiguedad;
	}

}
