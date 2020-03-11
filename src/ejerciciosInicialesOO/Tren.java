package ejerciciosInicialesOO;

public class Tren {
	private int numIdentificacion;
	private Locomotora locomotora;
	private Vagon[] vagones;
	private String jefe;

	// CONSTRUCTOR VACIO
	Tren() {
		numIdentificacion = 0;
		locomotora = new Locomotora();
		vagones = new Vagon[5];
		jefe = "";
	}

	// CONSTRUCTOR POR PARAMETROS
	Tren(int numIdentificacion, Locomotora locomotora, String jefe) {
		this.numIdentificacion = numIdentificacion;
		this.locomotora = locomotora;
		this.vagones = new Vagon[5];
		this.jefe = jefe;
	}

	// CONSTRUCTOR COPIA
	Tren(Tren trenCopia) {
		this.numIdentificacion = trenCopia.numIdentificacion;
		this.locomotora = trenCopia.locomotora;
		this.vagones = trenCopia.vagones;
		this.jefe = trenCopia.jefe;
	}

	// GETTERS Y SETTERS
	public int getNumIdentificacion() {
		return numIdentificacion;
	}

	public void setNumIdentificacion(int numIdentificacion) {
		this.numIdentificacion = numIdentificacion;
	}

	public Locomotora getLocomotora() {
		return locomotora;
	}

	public void setLocomotora(Locomotora locomotora) {
		this.locomotora = locomotora;
	}

	public int cantidadMaximaVagones() {
		return vagones.length;
	}

	public Vagon getVagon(int pos) {
		if (pos >= 0 && pos < vagones.length)
			return vagones[pos];

		return null;
	}

	public boolean anyadeVagon(Vagon v) {
		for (int i = 0; i < vagones.length; i++)
			if (vagones[i] == null) {
				vagones[i] = v;
				return true;
			}

		return false;
	}

	public String getJefe() {
		return jefe;
	}

	public void setJefe(String jefe) {
		this.jefe = jefe;
	}

}
