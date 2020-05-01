package ejercicioHerenciaYPolimorfismo3;

public class Coche extends Vehiculo {

	// ATRIBUTO
	private int numPlazas;

	// CONSTRUCTOR
	public Coche(int potencia, int numPlazas) {
		super(potencia);
		this.numPlazas = numPlazas;
	}

	// GETTER
	public int getNumPlazas() {
		return numPlazas;
	}

	// METODO
	@Override
	public void trucarVehiculo() {
		super.setPotencia(super.getPotencia() * 2);
	}
}
