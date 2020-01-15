package examen1812;

public class Gasolinera {

	final static int CAPACIDAD_SURTIDORES = 5000;

	static double precioGasolina = 1.56, precioGasolinaSuper = 1.62, precioGasoil = 1.29, precioGasoilPlus = 1.35;

	static int litrosGasolina = 150, litrosGasolinaSuper = 4900, litrosGasoil = 780, litrosGasoilPlus = 1050;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String opcion = "", tipo = "";
		int numLitros = 0;
		int cantidad = 0;

		System.out.println("BIENVENIDO A GASOLIJNERA COMBUSTIBLES & COMESTIBLES");

		while (!opcion.equals("s")) {

			System.out.println("¿Qué quiere hacer?");
			System.out.println("a.Mostrar litros de surtidor");
			System.out.println("b.Mostrar precio de surtidor");
			System.out.println("c.Rellenar surtidor");
			System.out.println("d.Cambiar precio de combustible");
			System.out.println("e.Poner combustible");
			System.out.println("s.Salir");

			opcion = Entrada.cadena().toLowerCase();

			switch (opcion) {

			case "a":
				System.out.println("Introduzca el combustible para el que quiere saber los litros disponibles");
				tipo = Entrada.cadena().toLowerCase();
				mostrarLitros(tipo);
				break;

			case "b":
				System.out.println("Introduzca el combustible para el que quiere saber el precio");
				tipo = Entrada.cadena().toLowerCase();
				System.out.println("El precio del combustible " + tipo + " es: " + devolverPrecio(tipo));
				break;

			case "c":
				System.out.println("Introduzca el combustible para el que quiera rellenar el surtidor");
				tipo = Entrada.cadena().toLowerCase();
				System.out.println("Introduzca los litros a rellenar en el surtidor:");
				numLitros = Entrada.entero();

				if (rellenarSurtidor(tipo, numLitros))
					System.out.println("Surtidor relleno con éxito");
				else
					System.out.println("No se pudo rellenar el surtidor con los litros indicados");
				break;

			case "d":
				cambiarPrecio();
				break;

			case "e":
				System.out.println("Introduzca el combustible con el que quiere surtir al vehículo");
				tipo = Entrada.cadena().toLowerCase();
				System.out.println("Introduzca la cantidad a surtir:");
				cantidad = Entrada.entero();
				System.out.println("Se han dispensado " + ponerCombustible(tipo, cantidad) + " de " + tipo);
				break;

			case "s":
				System.out.println("¡Hasta la próxima!");
				break;

			default:
				System.out.println("Opción incorrecta");
				break;
			}
			System.out.println();
		}
	}

	public static void mostrarLitros(String tipo) {

		if (tipo.equals("gasolina")) {
			System.out.println("El surtidor de " + tipo + " tiene " + litrosGasolina + " litros.");

		} else if (tipo.equals("gasolina super")) {
			System.out.println("El surtidor de " + tipo + " tiene " + litrosGasolinaSuper + " litros.");

		} else if (tipo.equals("gasoil")) {
			System.out.println("El surtidor de " + tipo + " tiene " + litrosGasoil + " litros.");

		} else if (tipo.equals("gasoil plus")) {
			System.out.println("El surtidor de " + tipo + " tiene " + litrosGasoilPlus + " litros.");

		} else {
			System.out.println("El tipo combustible indicado no existe");
		}
	}

	public static double devolverPrecio(String tipo) {

		if (tipo.equals("gasolina")) {
			return precioGasolina;

		} else if (tipo.equals("gasolina super")) {
			return precioGasolinaSuper;

		} else if (tipo.equals("gasoil")) {
			return precioGasoil;

		} else if (tipo.equals("gasoil plus")) {
			return precioGasoilPlus;

		} else {
			return -1;
		}
	}

	public static boolean rellenarSurtidor(String tipo, int numLitros) {

		boolean esPosibleLlenar = false;

		switch (tipo) {

		case "gasolina":
			if ((numLitros + litrosGasolina) < CAPACIDAD_SURTIDORES) {
				litrosGasolina += numLitros;
				esPosibleLlenar = true;
			}
			break;

		case "gasolina super":
			if ((numLitros + litrosGasolinaSuper) < CAPACIDAD_SURTIDORES) {
				litrosGasolinaSuper += numLitros;
				esPosibleLlenar = true;
			}
			break;

		case "gasoil":
			if ((numLitros + litrosGasoil) < CAPACIDAD_SURTIDORES) {
				litrosGasoil += numLitros;
				esPosibleLlenar = true;
			}
			break;

		case "gasoil plus":
			if ((numLitros + litrosGasoilPlus) < CAPACIDAD_SURTIDORES) {
				litrosGasoilPlus += numLitros;
				esPosibleLlenar = true;
			}
			break;
		}
		return esPosibleLlenar;
	}

	public static void cambiarPrecio() {
		System.out.println("Indica el combustible al que quiere cambiar el precio:");
		String combustible = Entrada.cadena().toLowerCase();
		System.out.println("Indique el nuevo precio del combustible:");
		double cantidad = Entrada.real();

		if (combustible.equals("gasolina")) {
			precioGasolina = cantidad;
			System.out.println("El precio del combustible " + combustible + " es: " + precioGasolina);
		} else if (combustible.equals("gasolina super")) {
			precioGasolinaSuper = cantidad;
			System.out.println("El precio del combustible " + combustible + " es: " + precioGasolinaSuper);
		} else if (combustible.equals("gasoil")) {
			precioGasoil = cantidad;
			System.out.println("El precio del combustible " + combustible + " es: " + precioGasoil);
		} else if (combustible.equals("gasoil plus")) {
			precioGasoilPlus = cantidad;
			System.out.println("El precio del combustible " + combustible + " es: " + precioGasoilPlus);
		} else {
			System.out.println("El combustible indicado no existe");
		}
	}

	public static boolean vaciarSurtidor(String tipo, int numLitros) {
		boolean esPosibleVaciar = false;

		switch (tipo) {

		case "gasolina":
			if ((numLitros - litrosGasolina) < 0) {
				litrosGasolina -= numLitros;
				esPosibleVaciar = true;
			}
			break;

		case "gasolina super":
			if ((numLitros - litrosGasolinaSuper) < 0) {
				litrosGasolinaSuper -= numLitros;
				esPosibleVaciar = true;
			}
			break;

		case "gasoil":
			if ((numLitros - litrosGasoil) < 0) {
				litrosGasoil -= numLitros;
				esPosibleVaciar = true;
			}
			break;

		case "gasoil plus":
			if ((numLitros - litrosGasoilPlus) < 0) {
				litrosGasoilPlus -= numLitros;
				esPosibleVaciar = true;
			}
			break;
		}
		return esPosibleVaciar;
	}

	public static double ponerCombustible(String tipo, int cantidad) {
		double litros = 0;
		int i = 0;
		boolean vacio = false;

		System.out.println("Coche repostado " + cantidad + " euros de " + tipo + "...");
		System.out.println("euros \t\t\t litros");

		if (tipo.equals("gasolina")) {
			litros = Math.rint(cantidad / precioGasolina);
			while (i <= cantidad || !vacio) {

				vacio = (vaciarSurtidor(tipo, (int) litros));

				System.out.println(i + "\t\t\t" + litros * i);
				i++;
			}
		} else if (tipo.equals("gasolina super")) {
			litros = Math.rint(cantidad / precioGasolinaSuper);
			while (i <= cantidad || !vacio) {

				vacio = (vaciarSurtidor(tipo, (int) litros));

				System.out.println(i + "\t\t\t" + litros * i);
				i++;
			}
		} else if (tipo.equals("gasoil")) {
			litros = Math.rint(cantidad / precioGasoil);
			while (i <= cantidad || !vacio) {

				vacio = (vaciarSurtidor(tipo, (int) litros));

				System.out.println(i + "\t\t\t" + litros * i);
				i++;
			}

		} else if (tipo.equals("gasoil plus")) {
			litros = Math.rint(cantidad / precioGasoilPlus);
			while (i <= cantidad || !vacio) {

				vacio = (vaciarSurtidor(tipo, (int) litros));

				System.out.println(i + "\t\t\t" + litros * i);
				i++;
			}
		}

		return cantidad;
	}
}
