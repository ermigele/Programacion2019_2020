package ejercicioInicialesPolimorfismoYHerencia;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Numero[] vector = new Numero[4];

		vector[0] = new Numero();
		vector[1] = new NumeroNatural(3);
		vector[2] = new NumeroFraccion(4, 9);
		vector[3] = new NumeroNatural(1);

		for (int i = 0; i < vector.length; i++) {
			if (vector[i] instanceof NumeroFraccion)
				((NumeroFraccion) vector[i]).sumaFraccion(1, 3);
			else if (vector[i] instanceof NumeroNatural) {
				if (((NumeroNatural) vector[i]).restaValor(3) == true)
					System.out.println("(Se ha restado)");
				else // (NumeroNatural)vector[i]).restaValor(3)==false)
					System.out.println("(No se ha restado)");
			}

			System.out.println("\nPosición " + i + ": " + vector[i].muestraAtributos() + "\n");
		}
	}

}
