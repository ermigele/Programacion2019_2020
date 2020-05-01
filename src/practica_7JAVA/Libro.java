package practica_7JAVA;

public abstract class Libro implements IPrestable, IComparable {

	// ATRIBUTOS
	protected String titulo;
	protected String autor;

	// CONSTRUCTOR
	public Libro(String titulo, String autor) {
		this.titulo = titulo;
		this.autor = autor;
	}

	// GETTERS & SETTERS
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	// METODO
	public void mostrarLibro() {
		System.out.println("____________________________________________");
		System.out.print("TITULO: " + getTitulo() + "\nAUTOR: " + getAutor() + "\n");
	}

	public boolean mayorQue(IComparable otro, int op) {
		Libro nuevoLibro = (Libro) otro;
		if (op == 1)
			if (this.titulo.compareTo(nuevoLibro.titulo) > 0)
				return true;

		if (op == 2)
			if (this.autor.compareTo(nuevoLibro.autor) > 0)
				return true;

		return false;
	}

	public boolean menorQue(IComparable otro, int op) {
		Libro nuevoLibro = (Libro) otro;
		if (op == 1)
			if (this.titulo.compareTo(nuevoLibro.titulo) < 0)
				return true;

		if (op == 2)
			if (this.autor.compareTo(nuevoLibro.autor) < 0)
				return true;

		return false;
	}

	public boolean igualQue(IComparable otro, int op) {
		Libro nuevoLibro = (Libro) otro;
		if (op == 1)
			if (this.titulo.compareTo(nuevoLibro.titulo) == 0)
				return true;

		if (op == 2)
			if (this.autor.compareTo(nuevoLibro.autor) == 0)
				return true;

		return false;
	}

	public abstract boolean prestar();
	public abstract boolean devolver();
}
