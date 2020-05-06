package examenHP0605_A;

public class Stark extends Personaje implements IAtaqueHumano {
	// ATRIBUTOS
	private Arma[] armas;
	private int numArmas;
	private int posArmaEnUso;

	// CONSTRUCTOR
	public Stark(String nombrePersonaje, double puntosDeVida, double fuerzaGolpe, double probabilidadGolpe,
			double probabilidadPararGolpe, int numMaximoArmas) {
		super(nombrePersonaje, puntosDeVida, fuerzaGolpe, probabilidadGolpe, probabilidadPararGolpe);

		this.armas = new Arma[numMaximoArmas];
		this.numArmas = 0;
		this.posArmaEnUso = 0;
	}

	// METODOS
	@Override
	public void anyadirArma(Arma nuevaArma) {
		if (numArmas <= armas.length - 1) {
			armas[numArmas] = nuevaArma;
			System.out.println("Se añadió un " + nuevaArma.getNombreArma() + " al armamento del personaje "
					+ this.nombrePersonaje);
			numArmas++;
		} else {
			System.out.println("No se añadido el arma");
		}
	}

	@Override
	public double lanzarArma() {
		Arma armaUso = armas[posArmaEnUso];
		return (this.fuerzaGolpe + armaUso.getFuerzaArma()) / 2;
	}

	public void usarArma(int pos) {
		if (armas[pos] != null)
			this.posArmaEnUso = pos;
	}

	public void muestraArmas() {
		Arma arma;

		System.out.println("\n-----ARMAS-----\n");
		for (int i = 0; i < numArmas; i++) {
			arma = armas[i];
			System.out.println("Arma " + i + ": " + arma.getNombreArma() + " con fuerza " + arma.getFuerzaArma());
		}
	}

	@Override
	public void muestraPersonaje() {
		System.out.println("____________PERSONAJE STARK____________");
		super.muestraPersonaje();
		muestraArmas();
	}
}
