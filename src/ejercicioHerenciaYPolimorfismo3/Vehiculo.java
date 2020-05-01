package ejercicioHerenciaYPolimorfismo3;

public abstract class Vehiculo {

	// ATRIBUTOS
	private int potencia;

	// CONSTRUCTOR
	public Vehiculo(int potencia) {
		this.potencia = potencia;
	}

	// GETTERS & SETTERS
	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	// METODO ABSTRACTO
	public abstract void trucarVehiculo();
}
