package ejercicioHerenciaYPolimorfismoDOS;

public class ArrayTEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Array vectorPrueba;
		char tipoArray;
		int tam, insertar, num, numDisc;

		System.out.println("Indica el tipo de array que desea crear:" + "\na. Array de n�meros pares"
				+ "\nb.Array estad�stico" + "\nc.Array discriminatorio");
		tipoArray = Entrada.caracter();

		System.out.println("�Qu� tama�o tendr� el array?");
		tam = Entrada.entero();

		switch (tipoArray) {
		case 'a':
			vectorPrueba = new ArrayNumerosPares(tam);
			break;
		case 'b':
			vectorPrueba = new ArrayEstadistica(tam);
			break;
		case 'c':
			System.out.println("�Cual es el n�mero discriminatorio?");
			numDisc = Entrada.entero();
			vectorPrueba = new ArrayDiscriminatorio(tam, numDisc);
			break;
		default:
			vectorPrueba = new Array(tam);
			break;
		}
		System.out.println("Cu�ntos n�meros deseas insertar?");
		insertar = Entrada.entero();
		System.out.println("Insertalos:");
		for (int i = 0; i < insertar; i++) {
			num = Entrada.entero();
			if (vectorPrueba.insertaNumero(num))
				System.out.println("El n�mero " + num + " se ha insertado con �xito");
			else
				System.out.println("No ha podido insertarse el n�mero");
		}

		System.out.println(vectorPrueba.toString());
		System.out.println("Los valores del array son: ");
		vectorPrueba.muestraArray();
		System.out.println("El mayor es: " + vectorPrueba.devuelveMayor());
		System.out.println("El menor es: " + vectorPrueba.devuelveMenor());

		if (vectorPrueba instanceof ArrayNumerosPares)
			System.out
					.println("\nHay " + ((ArrayNumerosPares) vectorPrueba).cuantosNumerosParesHay() + " n�meros pares");
		else if (vectorPrueba instanceof ArrayEstadistica)
			System.out.println("\nLa media es: " + ((ArrayEstadistica) vectorPrueba).devuelveMedia());
		else if (vectorPrueba instanceof ArrayDiscriminatorio)
			System.out.println(
					"\nEl n�mero discriminado es: " + ((ArrayDiscriminatorio) vectorPrueba).getNumeroProhibido());
	}
}
