package practica_7JAVA;

public class LibroConsulta extends Libro {

	// ATRIBUTO
	private boolean prestado;

	// CONSTRUCTOR
	public LibroConsulta(String titulo, String autor, boolean prestado) {
		super(titulo, autor);
		this.prestado = prestado;
	}

	// GETTER & SETTER
	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	// METODO
	public void mostrarLibro() {
		super.mostrarLibro();
		System.out.println("En prestamo: " + isPrestado());
		System.out.println("____________________________________________\n");
	}

	@Override
	public boolean prestar() {
		if (isPrestado()) {
			return false;
		} else {
			setPrestado(true);
			return true;
		}
	}

	@Override
	public boolean devolver() {
		if (isPrestado()) {
			setPrestado(false);
			return true;
		} else {
			return false;
		}
	}

}
