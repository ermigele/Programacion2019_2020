package examenHP0605_A;

public class Lannister extends Personaje implements IAtaqueHumano {

	// ATRIBUTO
	private Arma armaUnica;

	// CONSTRUCTOR
	public Lannister(String nombrePersonaje, double puntosDeVida, double fuerzaGolpe, double probabilidadGolpe,
			double probabilidadPararGolpe) {
		super(nombrePersonaje, puntosDeVida, fuerzaGolpe, probabilidadGolpe, probabilidadPararGolpe);
	}

	// METODOS
	@Override
	public void anyadirArma(Arma nuevaArma) {
		this.armaUnica = nuevaArma;
	}

	@Override
	public double lanzarArma() {
		return (fuerzaGolpe * 0.40) + this.armaUnica.getFuerzaArma() * 0.60;
	}

	@Override
	public void muestraPersonaje() {
		System.out.println("____________PERSONAJE LANNISTER____________");
		super.muestraPersonaje();
		System.out.println("ARMA: " + this.armaUnica.getNombreArma() + " con fuerza " + this.armaUnica.getFuerzaArma());
	}
}
