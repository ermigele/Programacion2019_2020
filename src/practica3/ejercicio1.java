package practica3;

public class ejercicio1 {

	public static void main(String[] args) {
		/* Escribe un programa en JAVA en el que el usuario tiene que acertar un nombre  y dos apellidos secretos. El programa tiene un nombre y dos apellidos
		 * secretos y va pidiendo al usuario un nombre y dos apellidos hasta que el usuario acierte o gaste el número de intentos (este número de intentos puede
		 * ser modificado por el programador, de inicio, le puedes darle el valor 4). Cada vez que pide al usuario el nombre y los apellidos, debe darle pistas, o
		 * sea, si el nombre escrito por el usuario es mayor, menor o igual que el nombre secreto, e igualmente con los dos apellidos. Ten en cuenta que el
		 * nombre y los apellidos secretos deben estar escritos en minúscula (me refiero al valor, no al identificador que los guarda). Si termina y el usuario no
		 * acierta, el programa debe mostrarle el nombre y los apellidos secretos al usuario. */

		String NOMBRE_SECRETO = "miguel", APELLIDO1_SECRETO = "chaparro", APELLIDO2_SECRETO = "fernandez";
		int INTENTO = 4;
		String nombre = "", apellido1 = "", apellido2 = "";
		boolean acertado = false;

		do {
			System.out.println();
			System.out.print("Introduce un nombre: ");
			nombre = Entrada.cadena();
			System.out.print("Introduce el primer apellido: ");
			apellido1 = Entrada.cadena();
			System.out.print("Introduce el segundo apellido: ");
			apellido2 = Entrada.cadena();

			if (nombre.equals(NOMBRE_SECRETO) && apellido1.equals(APELLIDO1_SECRETO) && apellido2.equals(APELLIDO2_SECRETO)) {
				acertado = true;
			} else {
				INTENTO--;
				
				if (nombre.equals(NOMBRE_SECRETO)) {
					System.out.println("El nombre introducido es correcto ");
				} else if(nombre.length() < NOMBRE_SECRETO.length()) {
					System.out.println("El nombre es mayor al introducido ");
				} else if (nombre.length() > NOMBRE_SECRETO.length()) {
					System.out.println("El nombre es menor al introducido ");
				} else {
					System.out.println("El nombre es igual al introducido pero incorrecto ");
				}
				
				if (apellido1.equals(APELLIDO1_SECRETO)) {
					System.out.println("El primer apellido introducido es correcto ");
				} else if (apellido1.length() < APELLIDO1_SECRETO.length()) {
					System.out.println("El primer apellido es mayor al introducido ");
				} else if (apellido1.length() > APELLIDO1_SECRETO.length()) {
					System.out.println("El primer apellido es menor al introducido ");
				} else {
					System.out.println("El primer apellido es igual al introducido pero incorrecto ");
				}
				
				if (apellido2.equals(APELLIDO2_SECRETO)) {
					System.out.println("El segundo apellido introducido es correcto ");
				} else if (apellido2.length() < APELLIDO2_SECRETO.length()) {
					System.out.println("El segundo apellido es mayor al introducido ");
				} else if (apellido2.length() > APELLIDO2_SECRETO.length()) {
					System.out.println("El segundo apellido es menor al introducido ");
				} else {
					System.out.println("El segundo apellido es igual al introducido pero incorrecto ");
				}
			}
		} while (!acertado  &&  INTENTO > 0);

		if (acertado) {
			System.out.println("Enorabuena has acertado con el nombre y apellidos del usuario");
		} else {
			System.out.println("El nombre y apellidos del usuario son " + NOMBRE_SECRETO + " " + APELLIDO1_SECRETO + " " + APELLIDO2_SECRETO);
		}
	}
}
