package examenHP0605_A;

public class Arma {

	// ATRIBUTOS
	private String nombreArma;
	private double fuerzaArma;

	// CONSTRUCTOR
	public Arma(String nombreArma, double fuerzaArma) {
		if (!nombreArma.equals("hacha") && !nombreArma.equals("arco"))
			this.nombreArma = "espada";
		else
			this.nombreArma = nombreArma;

		this.fuerzaArma = fuerzaArma;
	}

	// GETTERS & SETTER
	public String getNombreArma() {
		return nombreArma;
	}

	public double getFuerzaArma() {
		return fuerzaArma;
	}

	public void setFuerzaArma(double fuerzaArma) {
		this.fuerzaArma = fuerzaArma;
	}

}
