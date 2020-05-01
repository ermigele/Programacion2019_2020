package practica_7JAVA;

public class BibliotecaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int opc = 0, tipo = 0, posicion = 0, ordenar = 0;
		String buscarTipo = new String(""), nombre = new String(""), titulo = new String(""), autor = new String("");
		Libro libro = null;
		Biblioteca b1 = new Biblioteca();
		Biblioteca bibAux;

		System.out.println("---------------------CREANDO BIBLIOTECA---------------------\n\n\n");

		do {
			System.out.println(
					"*******************************Bienvenido a TU BIBLIOTECA*******************************\n\n");

			System.out.println("¿Qué desea hacer?\n");
			System.out.println(
					"1.Buscar libro\n2.Realizar prestamo\n3.Realizar devolución\n4.Listado de libros\n5.Añadir un libro\n6.Retirar un libro\n7.Salir");

			opc = Entrada.entero();

			switch (opc) {

			case 1:
				System.out.println("Buscar por (1)Titulo o (2)Autor?");
				buscarTipo = (Entrada.entero() == 1) ? "título" : "autor";
				System.out.println("Introduce el " + buscarTipo + " de la búsqueda:");
				nombre = Entrada.cadena().toLowerCase();

				if (buscarTipo.equals("título")) {
					libro = b1.getLibro(b1.buscaPorTitulo(nombre));
					if (libro != null)
						libro.mostrarLibro();
					else
						System.out.println("El libro no se ha encontrado \n");
				} else {
					libro = b1.getLibro(b1.buscaPorAutor(nombre));
					if (libro != null) {
						for (int i = 0; i < b1.getNumLibros(); i++)
							if (libro.getAutor().equals(b1.getLibro(i).getAutor())) {
								libro = b1.getLibro(i);
								libro.mostrarLibro();
							}
					} else {
						System.out.println("El libro no se ha encontrado \n");
					}
				}
				break;

			case 2:
				System.out.println("Indique el título del libro que quiere retirar:");
				posicion = b1.buscaPorTitulo(Entrada.cadena().toLowerCase());
				if (posicion != -1)
					if (b1.getLibro(posicion).prestar())
						System.out.println("Prestamo realizado con éxito");
					else
						System.out.println("El libro no esta disponible");
				else
					System.out.println("El libro no éxiste");
				break;

			case 3:
				System.out.println("Indique el título del libro que quiere devolver:");
				posicion = b1.buscaPorTitulo(Entrada.cadena().toLowerCase());
				if (posicion != -1)
					if (b1.getLibro(posicion).devolver())
						System.out.println("Devolución realizada con éxito");
					else
						System.out.println("No es posible realizar la devolución");
				else
					System.out.println("El libro no éxiste");
				break;

			case 4:
				System.out.println(
						"Indique los tipos de libro que quiere mostrar: (1) Todos (2) Libros de consulta (3) Libros de Prestamo");
				tipo = Entrada.entero();
				switch (tipo) {
				case 1:
					System.out.println("Indique ordenar por: (1) Título o (2) Autor");
					ordenar = Entrada.entero();
					b1.ordenarPor(ordenar);
					for (int i = 0; i < b1.getNumLibros(); i++) {
						b1.getLibro(i).mostrarLibro();
					}
				case 2:
					System.out.println("Introduzca el campo mediante el que quiere ordenar: (1)Título o (2)Autor");
					ordenar = Entrada.entero();
					b1.ordenarPor(ordenar);
					for (int i = 0; i < b1.getNumLibros(); i++) {
						libro = b1.getLibro(i);
						if (libro instanceof LibroConsulta)
							b1.getLibro(i).mostrarLibro();
					}
					break;
				case 3:
					bibAux = new Biblioteca(b1.getNumLibros());
					for (int i = 0; i < b1.getNumLibros(); i++) {
						libro = b1.getLibro(i);
						if (libro instanceof LibroPrestamo)
							bibAux.darDeAlta(libro);
					}
					System.out.println(
							"Introduzca el campo mediante el que quiere ordenar: (1)Título o (2)Autor (3)Número de ejemplares");
					ordenar = Entrada.entero();
					bibAux.ordenarPor(ordenar);
					for (int i = 0; i < bibAux.getNumLibros(); i++) {
						bibAux.getLibro(i).mostrarLibro();
					}
					break;
				default:
					System.out.println("Opción incorrecta");
				}
				break;

			case 5:
				System.out.println(
						"Introduzca el tipo de libro que quiere dar de alta: (1) Libro de consulta (2) Libro de prestamo");
				tipo = Entrada.entero();
				System.out.println("Introduzca el título:");
				titulo = Entrada.cadena();
				System.out.println("Introduzca el autor:");
				autor = Entrada.cadena();
				if (tipo == 1) {
					libro = new LibroConsulta(titulo, autor, false);
				} else {
					System.out.println("¿Cuantos ejemplares hay del libro?");
					libro = new LibroPrestamo(titulo, autor, Entrada.entero());
				}
				if (b1.darDeAlta(libro))
					System.out.println("Libro dado de alta con éxito");
				else
					System.out.println("Libro ya existe");
				break;

			case 6:
				System.out.println("Introduzca el título del libro que quiere dar de baja:");
				if (b1.darDeBaja(b1.buscaPorTitulo(Entrada.cadena())))
					System.out.println("Libro dado de baja con éxito");
				else
					System.out.println("Libro no existe");
				break;
			default:
				System.out.println("Opción incorrecta, pruebe de nuevo");
				break;
			}
		} while (opc != 7);

		System.out.println("_______________________FIN DE LA APLICACIÓN_______________________");
	}
}
