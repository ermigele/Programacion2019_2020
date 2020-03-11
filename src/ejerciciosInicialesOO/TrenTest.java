package ejerciciosInicialesOO;

public class TrenTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mat;
		double cap;
		Vagon v;
		Locomotora loc = new Locomotora("123Loc", 235.5, 12);

		Tren tren1 = new Tren(1, loc, "Paco");

		if (tren1.anyadeVagon(new Vagon("01Vag", 500)))
			System.out.println("Añadido vagon con éxito");
		if (tren1.anyadeVagon(new Vagon("02Vag", 1000)))
			System.out.println("Añadido vagon con éxito");

		System.out.println("Dime matrícula del vagón: ");
		mat = Entrada.cadena();
		System.out.println("Dime capacidad del vagón: ");
		cap = Entrada.real();

		if (tren1.anyadeVagon(new Vagon(mat, cap)))
			System.out.println("Añadido vagon con éxito");

		System.out.println("El jefe del tren es: " + tren1.getJefe());
		System.out.println("La locomotora tiene como matrícula: " + tren1.getLocomotora().getMatricula());
		System.out.println("La locomotora tiene una potencia de: " + tren1.getLocomotora().getPotencia());

		for (int i = 0; i < tren1.cantidadMaximaVagones(); i++) {
			v = tren1.getVagon(i);
			if (v != null)
				System.out.println("La matrícula del vagón " + i + " es" + v.getMatricula());
		}

	}
}
