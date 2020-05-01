package practica_7JAVA;

public class LibroPrestamo extends Libro {

	// ATRIBUTOS
	private int numEjemplares;
	private int ejemplaresEnPrestamo;

	// CONSTRUCTOR
	public LibroPrestamo(String titulo, String autor, int numEjemplares) {
		super(titulo, autor);
		this.numEjemplares = numEjemplares;
	}

	// GETTERS & SETTERS
	public int getNumEjemplares() {
		return numEjemplares;
	}

	public void setNumEjemplares(int numEjemplares) {
		this.numEjemplares = numEjemplares;
	}

	public int getEjemplaresEnPrestamo() {
		return ejemplaresEnPrestamo;
	}

	public void setEjemplaresEnPrestamo(int ejemplaresEnPrestamo) {
		this.ejemplaresEnPrestamo = ejemplaresEnPrestamo;
	}

	// METODOS
	public void mostrarLibro() {
		super.mostrarLibro();
		System.out.println(
				"Ejemplares disponibles en la biblioteca: " + (this.numEjemplares - this.ejemplaresEnPrestamo));
		System.out.println("____________________________________________\n");

	}

	public boolean prestar() {
		if (this.numEjemplares > this.ejemplaresEnPrestamo) {
			ejemplaresEnPrestamo++;
			return true;
		}
		return false;
	}

	public boolean devolver() {
		if (this.ejemplaresEnPrestamo > 0) {
			ejemplaresEnPrestamo--;
			return true;
		}
		return false;
	}

	@Override
	public boolean mayorQue(IComparable otro, int op) {

		if (op == 3) {
			LibroPrestamo nuevoLibroPres = (LibroPrestamo) otro;
			if (this.numEjemplares > nuevoLibroPres.numEjemplares)
				return true;
		} else {
			return super.mayorQue(otro, op);
		}
		return false;
	}

	@Override
	public boolean menorQue(IComparable otro, int op) {

		if (op == 3) {
			LibroPrestamo nuevoLibroPres = (LibroPrestamo) otro;
			if (this.numEjemplares < nuevoLibroPres.numEjemplares)
				return true;
		} else {
			return super.menorQue(otro, op);
		}
		return false;
	}

	@Override
	public boolean igualQue(IComparable otro, int op) {

		if (op == 3) {
			LibroPrestamo nuevoLibroPres = (LibroPrestamo) otro;
			if (this.numEjemplares == nuevoLibroPres.numEjemplares)
				return true;
		} else {
			return super.igualQue(otro, op);
		}
		return false;
	}

}
