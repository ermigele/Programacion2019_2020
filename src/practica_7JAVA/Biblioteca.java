package practica_7JAVA;

public class Biblioteca implements IAltaBajable, IOrdenarArray {

	// ATRIBUTOS
	private Libro[] catalogo;
	private int numLibros;

	// CONSTRUCTORES
	public Biblioteca() {
		System.out.println("¿Cuentos libros desea introducir en al biblioteca?");
		this.catalogo = new Libro[Entrada.entero()];
		this.numLibros = 0;
		// this.catalogo = new Libro[5];
		// catalogo[0] = new LibroConsulta("Vida en los arboles", "David At", false);
		// catalogo[1] = new LibroPrestamo("Rayuela", "Julio Cortazar", 4);
		// catalogo[2] = new LibroPrestamo("Caballo de troya", "JJ Benitez", 7);
		// catalogo[3] = new LibroConsulta("Pensando en Java", "RSA", false);
		// catalogo[4] = new LibroPrestamo("La iliada", "Homero", 10);
		// this.numLibros = 5;
	}

	public Biblioteca(int tam) {
		this.catalogo = new Libro[tam];
		this.numLibros = 0;
	}

	// GETTERS
	public Libro getLibro(int posicion) {

		if (posicion != -1)
			return catalogo[posicion];

		return null;
	}

	public int getNumLibros() {
		return this.numLibros;
	}

	// METODOS
	public int buscaPorTitulo(String titulo) {
		if (numLibros > 0)
			for (int i = 0; i < numLibros; i++) {
				if (catalogo[i].getTitulo().toLowerCase().contains(titulo))
					return i;
			}
		return -1;
	}

	public int buscaPorAutor(String autor) {
		if (numLibros > 0)
			for (int i = 0; i < numLibros; i++) {
				if (catalogo[i].getAutor().toLowerCase().contains(autor))
					return i;
			}
		return -1;
	}

	@Override
	public boolean darDeAlta(Object ob) {
		Libro nuevoLibro = (Libro) ob;
		if (buscaPorTitulo(nuevoLibro.getTitulo()) != -1) {
			return false;
		}
		catalogo[numLibros] = nuevoLibro;
		numLibros++;
		return true;
	}

	@Override
	public boolean darDeBaja(int pos) {
		if (pos > 0 && pos < numLibros) {
			catalogo[pos] = catalogo[numLibros - 1];
			catalogo[numLibros - 1] = null;
			numLibros--;
			return true;
		}
		return false;
	}

	@Override
	public void ordenarPor(int op) {
		int pos;
		Libro temp;

		for (int i = 0; i <= (numLibros - 2); i++) {
			pos = i;
			for (int j = i + 1; j <= (numLibros - 1); j++) {
				if (catalogo[j].menorQue(catalogo[pos], op) == true) {
					pos = j;
				}
				if (pos != i) {
					temp = catalogo[pos];
					catalogo[pos] = catalogo[i];
					catalogo[i] = temp;
				}
			}
		}
	}
}
