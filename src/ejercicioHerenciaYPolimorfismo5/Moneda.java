package ejercicioHerenciaYPolimorfismo5;

public class Moneda extends ElementoDeJuego implements Ijugable {

	public Moneda(String identificador) {
		super(identificador);
	}

	@Override
	public void tirada() {
		int resultado = (Math.random() < 0.5) ? 0 : 1;
		setResultado(resultado);
	}

	@Override
	public void mostrarResultadoTirado() {
		if (getResultado() == 0)
			System.out.println("HA SALIDO CARA");
		else
			System.out.println("HA SALIDO CRUZ");
	}
}
