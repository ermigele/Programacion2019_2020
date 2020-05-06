package examenHP0605_A;

public abstract class Personaje implements IProbable {

	// ATRIBUTOS
	protected String nombrePersonaje;
	protected double puntosDeVida;
	protected double fuerzaGolpe;
	protected double probabilidadGolpe;
	protected double probabilidadPararGolpe;

	// CONSTRUCTOR
	public Personaje(String nombrePersonaje, double puntosDeVida, double fuerzaGolpe, double probabilidadGolpe,
			double probabilidadPararGolpe) {
		this.nombrePersonaje = nombrePersonaje;
		this.puntosDeVida = puntosDeVida;
		this.fuerzaGolpe = fuerzaGolpe;
		this.probabilidadGolpe = probabilidadGolpe;
		this.probabilidadPararGolpe = probabilidadPararGolpe;
	}

	// GETTERS
	public String getNombrePersonaje() {
		return nombrePersonaje;
	}

	public double getPuntosDeVida() {
		return puntosDeVida;
	}

	public double getFuerzaGolpe() {
		return fuerzaGolpe;
	}

	public double getProbabilidadGolpe() {
		return probabilidadGolpe;
	}

	public double getProbabilidadPararGolpe() {
		return probabilidadPararGolpe;
	}

	// METODOS
	@Override
	public boolean aciertoGolpe() {
		int resultado = (Math.random() < 0.5) ? 0 : 1;
		if (resultado <= this.probabilidadGolpe)
			return true;
		else
			return false;
	}

	@Override
	public boolean pararGolpe() {
		int resultado = (Math.random() < 0.5) ? 0 : 1;
		if (resultado <= this.probabilidadPararGolpe)
			return true;
		else
			return false;
	}

	public void pierdePuntosDeVida(double puntosPerdidos) {
		this.puntosDeVida -= puntosPerdidos;
	}

	public boolean haPerdido() {

		if (this.puntosDeVida <= 0)
			return true;
		else
			return false;
	}

	public void muestraPersonaje() {
		System.out.println("NOMBRE: " + this.nombrePersonaje + "\nPUNTOS DE VIDA: " + this.puntosDeVida
				+ "\nFUERZA GOLPE: " + this.fuerzaGolpe + "\nPROBABILIDAD GOLPEO: " + this.probabilidadGolpe
				+ "\nPROBABILIDAD PARA GOLPE: " + this.probabilidadPararGolpe);
	}

}
