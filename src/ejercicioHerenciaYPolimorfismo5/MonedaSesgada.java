package ejercicioHerenciaYPolimorfismo5;

public class MonedaSesgada extends Moneda {

	private double sesgo;

	public MonedaSesgada(String identificador, double sesgo) {
		super(identificador);
		this.sesgo = sesgo;
	}

	public void tirada() {
		double valor = Math.random();

		if (valor < this.sesgo)
			super.setResultado(0);
		else
			super.setResultado(1);
	}

}
