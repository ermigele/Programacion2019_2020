package examenOO2503A;

public class Paises {

	// ATRIBUTOS
	private Pais[] conjuntoPaises;
	private int posicionLibre;

	// CONSTRUCTOR
	public Paises(int tam) {
		this.conjuntoPaises = new Pais[tam];
		this.posicionLibre = 0;
	}

	// METODOS
	public int devuelvePosicionPais(String nombrePais) {
		int posicion = -1;
		for (int i = 0; i < posicionLibre; i++) {
			if (conjuntoPaises[i].equals(nombrePais))
				posicion = i;
		}
		return posicion;
	}

	public boolean anyadePais(Pais p1) {
		if (posicionLibre < conjuntoPaises.length) {
			for (int i = 0; i < posicionLibre; i++) {
				if (conjuntoPaises[i].getNombrePais().equals(p1.getNombrePais()))
					return false;
			}
			conjuntoPaises[posicionLibre] = p1;
			this.posicionLibre++;
			return true;
		}
		return false;
	}

	public void anyadeEpidemiaAPais(String nombrePais, Epidemia epidemia) {
		Pais p1 = null;
		boolean esAnyadido = false;
		for (int i = 0; i < posicionLibre; i++) {
			if (conjuntoPaises[i].getNombrePais().equals(nombrePais)) {
				p1 = conjuntoPaises[i];
				esAnyadido = p1.anyadeEpidemiaAHistorial(epidemia);
			}
			if (esAnyadido)
				System.out.println("La epidemia se ha añadido del historial");
			else
				System.out.println("No se ha podido añadir la epidemia al historial");
		}
	}

	public void eliminarEpidemiaDePais(String nombrePais, String nombreEpidemia) {
		Pais p1 = null;
		boolean esBorrado = false;
		for (int i = 0; i < posicionLibre; i++) {
			if (conjuntoPaises[i].getNombrePais().equals(nombrePais)) {
				p1 = conjuntoPaises[i];
				esBorrado = p1.eliminarEpidemiaDeHistorial(nombreEpidemia);
			}
			if (esBorrado)
				System.out.println("La epidemia se ha eliminado del historial");
			else
				System.out.println("No se ha podido eliminar la epidemia del historial");
		}
	}

	public void muestraPaisesContinente(String continente, String opc) {
		Pais p1 = null;

		for (int i = 0; i < posicionLibre; i++) {
			if (conjuntoPaises[i].getContinente().equals(continente))
				p1 = conjuntoPaises[i];

			System.out.println("Pais: " + p1.getNombrePais() + "\nContinente: " + continente);

			switch (opc) {
			case "año":
				p1.ordenarHistorialPorAnyoInicioSeleccion();
				p1.mostrarEpidemiasDelPais();
				break;

			case "porcentaje":
				p1.ordenarHistorialPorPorcentajeDeDefuncionesInsercion();
				p1.mostrarEpidemiasDelPais();
				break;
			default:
				p1.mostrarEpidemiasDelPais();
				break;
			}
			System.out.println("\n\n\n");
		}
	}

}
