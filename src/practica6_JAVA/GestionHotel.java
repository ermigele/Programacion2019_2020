package practica6_JAVA;

public class GestionHotel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hotel hot1 = new Hotel("Budapest", 20);
		Reserva re1;
		Habitacion hab1;
		int opc = 0, maxReservas = 0, habReserva = 0, diaEntrada = 0, anyoEntrada = 0, diaSalida = 0, anyoSalida = 0;
		String nombreReserva, apellidosReserva, dniReserva, mesEntrada, mesSalida;

		do {
			System.out.println("-----Bienvenido al HOTEL " + hot1.getNombreHotel().toUpperCase() + "------");
			System.out.println("1.A�adir habitaci�n");
			System.out.println("2.A�adir reserva a habitaci�n");
			System.out.println("3.Ver habitaciones ordenadas por numero de habitaci�n");
			System.out.println("4.Ver habitaciones ordenadas por cantidad de reservas actuales");
			System.out.println("5.Salir \n");

			opc = Entrada.entero();
			switch (opc) {
			case 1:
				hot1.anyadeHabitacion();
				break;

			case 2:
				System.out.println("�Qu� habitaci�n desea reservar?");
				habReserva = Entrada.entero();
				System.out.println("Indique apellidos de la reserva:");
				apellidosReserva = Entrada.cadena();
				System.out.println("Indique nombre de la reserva: ");
				nombreReserva = Entrada.cadena();
				System.out.println("Indique DNI de la reserva: ");
				dniReserva = Entrada.cadena();
				System.out.println("Indique d�a fecha entrada:");
				diaEntrada = Entrada.entero();
				System.out.println("Indique mes fecha entrada: ");
				mesEntrada = Entrada.cadena();
				System.out.println("Indique a�o fecha entrada: ");
				anyoEntrada = Entrada.entero();
				System.out.println("Indique d�a fecha salida:");
				diaSalida = Entrada.entero();
				System.out.println("Indique mes fecha salida: ");
				mesSalida = Entrada.cadena();
				System.out.println("Indique a�o fecha salida: ");
				anyoSalida = Entrada.entero();

				re1 = new Reserva(new Persona(dniReserva, nombreReserva, apellidosReserva),
						new Fecha(diaEntrada, mesEntrada, anyoEntrada), new Fecha(diaSalida, mesSalida, anyoSalida));
				hab1 = new Habitacion(habReserva, maxReservas);

				if (hab1.anyadeReserva(re1))
					System.out.println("La reserva se ha realizado con exito");
				else
					System.out.println("No se pudo realizar la reserva");
				break;
			case 3:
				hot1.ordenaHabitacionesPorNumeroHabitacionSeleccion();
				hot1.muestraHabitacionesYReservas();
				break;
			case 4:
				hot1.ordenaHabitacionesPorReservasActualesInsercion();
				hot1.muestraHabitacionesYReservas();
				break;

			case 5:
				System.out.println("Agur");
				break;
			default:
				System.out.println("Opci�n incorrecta");
				break;
			}
		} while (opc != 5);
	}
}
