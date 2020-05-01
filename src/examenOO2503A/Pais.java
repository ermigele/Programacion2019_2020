package examenOO2503A;

public class Pais {

	// ATRIBUTOS
	private String nombrePais;
	private String continente;
	private Epidemia[] historialEpidemias;
	private int posicionLibre;

	// CONSTRUCTOR
	public Pais(String nombrePais, String continente, int tamVector) {
		this.nombrePais = nombrePais;
		this.continente = continente;
		this.historialEpidemias = new Epidemia[tamVector];
		this.posicionLibre = 0;
	}

	// GETTERS
	public String getNombrePais() {
		return nombrePais;
	}

	public String getContinente() {
		return continente;
	}

	// METODOS

	public boolean anyadeEpidemiaAHistorial(Epidemia ep1) {

		if (posicionLibre < historialEpidemias.length) {
			for (int i = 0; i < posicionLibre; i++) {
				if (historialEpidemias[i].getNombreEpidemia().equals(ep1.getNombreEpidemia()))
					return false;
			}
			historialEpidemias[posicionLibre] = ep1;
			this.posicionLibre++;
			return true;
		}
		return false;
	}

	public boolean eliminarEpidemiaDeHistorial(String nombreEpidemia) {

		for (int i = 0; i < posicionLibre; i++) {
			if (historialEpidemias[i].getNombreEpidemia().equals(nombreEpidemia)) {
				historialEpidemias[i] = historialEpidemias[posicionLibre - 1];
				historialEpidemias[posicionLibre - 1] = null;
				return true;
			}
		}
		return false;
	}

	public void mostrarEpidemiasDelPais() {
		for (int i = 0; i < posicionLibre; i++) {
			historialEpidemias[i].toString();
		}
	}

	public void ordenarHistorialPorAnyoInicioSeleccion() {
		int pos;
		Epidemia temp;
		for (int i = 0; i <= (posicionLibre - 2); i++) {
			pos = i;
			for (int j = i + 1; j <= (posicionLibre - 1); j++)
				if (historialEpidemias[j].getAnyoInicio() > historialEpidemias[pos].getAnyoInicio())
					pos = j;

			if (pos != i) {
				temp = historialEpidemias[pos];
				historialEpidemias[pos] = historialEpidemias[i];
				historialEpidemias[i] = temp;
			}
		}
	}

	public void ordenarHistorialPorPorcentajeDeDefuncionesInsercion() {

	}

}
