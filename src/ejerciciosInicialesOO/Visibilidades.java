package ejerciciosInicialesOO;

public class Visibilidades {

	private int a;
	private int b;
	private int c;

	// CONSTRUCTOR
	public Visibilidades(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	// GETTERS & SETTERS
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	private int getC() {
		return c;
	}

	private void setC(int c) {
		this.c = c;
	}

}
