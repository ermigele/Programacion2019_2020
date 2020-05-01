package ejercicioHerenciaYPolimorfismo5;

public class Dado extends ElementoDeJuego {

	public Dado(String identificador) {
		super(identificador);
	}

	public void tirada() {
		int res = (int) (Math.random() * 6 + 1);
		super.setResultado(res);
	}

	public void mostrarResultadoTirado() {
		int num = super.getResultado();

		switch (num) {

		case 1:
			System.out.println("HA SALIDO UN UNO");
			break;
		case 2:
			System.out.println("HA SALIDO UN DOS");
			break;
		case 3:
			System.out.println("HA SALIDO UN TRES");
			break;
		case 4:
			System.out.println("HA SALIDO UN CUATRO");
			break;
		case 5:
			System.out.println("HA SALIDO UN CINCO");
			break;
		case 6:
			System.out.println("HA SALIDO UN SEIS");
			break;
		}

	}

}
