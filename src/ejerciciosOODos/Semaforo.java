package ejerciciosOODos;

public class Semaforo {

	private String color;

	// CONSTRUCTORES
	public Semaforo() {
	}

	public Semaforo(String color) {
		this.color = color;
	}

	// GETTERS & SETTERS
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	// METODOS

	public void cambiarRojo() {
		this.color = "Rojo";
	}

	public void cambiarAmarillo() {
		this.color = "Amarillo";
	}

	public void cambiarVerde() {
		this.color = "Verde";
	}

	public boolean estaRojo(Semaforo s) {
		return s.getColor().equals("Rojo");
	}

	public boolean estaAmarillo(Semaforo s) {
		return s.getColor().equals("Amarillo");
	}

	public boolean estaVerde(Semaforo s) {
		return s.getColor().equals("Verde");
	}

}
