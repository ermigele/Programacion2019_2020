package examenHP0605_A;

public class CaminanteBlanco extends Personaje implements IAtaqueNoHumano {

	// CONSTRUCTOR
	public CaminanteBlanco(String nombrePersonaje, double puntosDeVida, double fuerzaGolpe, double probabilidadGolpe,
			double probabilidadPararGolpe) {
		super(nombrePersonaje, puntosDeVida, fuerzaGolpe, probabilidadGolpe, probabilidadPararGolpe);
	}

	// METODOS
	@Override
	public double morder() {
		return fuerzaGolpe;
	}

	@Override
	public void muestraPersonaje() {
		System.out.println("____________PERSONAJE CAMINANTE BLANCO____________");
		super.muestraPersonaje();
	}

}
