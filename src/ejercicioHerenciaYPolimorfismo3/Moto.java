package ejercicioHerenciaYPolimorfismo3;

public class Moto extends Vehiculo {

	// CONSTRUCTOR
	public Moto(int potencia) {
		super(potencia);
	}

	// METODO
	@Override
	public void trucarVehiculo() {
		super.setPotencia(super.getPotencia() * 4);
	}

}
