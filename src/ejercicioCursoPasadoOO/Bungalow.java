package ejercicioCursoPasadoOO;

public class Bungalow {

	// ATRIBUTOS
	private String identificador;
	private boolean ocupado;
	private int diaFin;
	private int mesFin;
	private int anyoFin;
	private Persona[] personasAlojadas;
	private int numPersonasAlojadas;
	private int numBunga;

	// CONSTRUCTOR
	public Bungalow(int tamPersonas) {
		this.personasAlojadas = new Persona[tamPersonas];
	}

	
	
}
