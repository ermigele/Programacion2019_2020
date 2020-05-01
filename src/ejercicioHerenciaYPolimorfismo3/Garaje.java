package ejercicioHerenciaYPolimorfismo3;

public class Garaje {

	// ATRIBUTOS
	private Vehiculo[] vehiculos;
	private int numPlazas;
	private int plazaLibre;

	// CONSTRUCTOR
	public Garaje(int maxPlazas) {
		this.numPlazas = maxPlazas;
		this.vehiculos = new Vehiculo[maxPlazas];
		this.plazaLibre = 0;
	}

	// GETTER
	public int getPlazaLibre() {
		return plazaLibre;
	}

	// METODOS

	public boolean anyadirVehiculo() {
		String tipoVehiculo = new String("");
		Vehiculo nuevoVehiculo = null;

		if (plazaLibre < numPlazas) {
			System.out.println("¿Qué tipo de vehiculo quieres guardar? (coche/moto)");
			tipoVehiculo = Entrada.cadena().toLowerCase();

			switch (tipoVehiculo) {
			case "coche":
				nuevoVehiculo = new Coche(50, 5);
				break;
			case "moto":
				nuevoVehiculo = new Moto(50);
				break;
			default:
				return false;
			}
			vehiculos[plazaLibre] = nuevoVehiculo;
			plazaLibre++;
			return true;
		} else {
			return false;
		}
	}

	public Vehiculo devuelveVehiculo(int posicion) {

		return (vehiculos[posicion] != null ? vehiculos[posicion] : null);
	}

	public double cuotaMes(int posicion) {

		return 0.0;
	}

}
