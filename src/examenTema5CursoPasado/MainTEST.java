package examenTema5CursoPasado;

public class MainTEST {

	public static void main(String[] args) {
		Conjunto[] vecConjuntos=new Conjunto[10];
		String tipoConjunto,ident,cadCon;
		int op=1,pos=0,posElem=0,tam=0,tamFil=0,tamCol=0,votos=0;
		char opOrd=' ';
		
		while(op!=0) {
			System.out.println("\n\n---GESTIÓN DE CONJUNTOS DIFERENTES---"
								+ "\n¿Qué quiere hacer?"
								+ "\n1.Añadir conjunto"
								+ "\n2.Mostrar conjunto"
								+ "\n3.Añadir elemento a conjunto"
								+ "\n4.Eliminar elemento de conjunto"
								+ "\n5.Concatenar cadena"
								+ "\n6.Añadir votos a partido"
								+"\n7.Ordenar y mostrar"
								+ "\n0.Salir");
			op=Entrada.entero();
			
			switch(op) {
				case 1:
					System.out.println("\n---AÑADIENDO CONJUNTO---\n");
					System.out.println("Indique en qué posición quiere añadir el conjunto: ");
					pos=Entrada.entero();
					
					if(pos<vecConjuntos.length && vecConjuntos[pos]==null) {
						System.out.println("Indique el tipo de conjunto que quiere añadir: ");
						tipoConjunto=Entrada.cadena().toLowerCase();
						
						System.out.println("Escriba el identificador del nuevo conjunto: ");
						ident=Entrada.cadena();
						
						switch(tipoConjunto) {
							case "numeros romanos":
								System.out.println("Indique el tamaño del vector de números romanos: ");
								tam=Entrada.entero();
								
								vecConjuntos[pos]=new NumerosRomanos(ident,tam);
								System.out.println("\nConjunto añadido con éxito\n");
								break;
							case "cadenas":
								System.out.println("Indique las filas de la matriz: ");
								tamFil=Entrada.entero();
								System.out.println("Indique las columnas de la matriz: ");
								tamCol=Entrada.entero();
								vecConjuntos[pos]=new Cadenas(ident,tamFil,tamCol);
								System.out.println("\nConjunto añadido con éxito\n");
								break;
							case "elecciones":
								System.out.println("Indique el tamaño del vector de partidos: ");
								tam=Entrada.entero();
								
								vecConjuntos[pos]=new Elecciones(ident,tam);
								System.out.println("\nConjunto añadido con éxito\n");
								break;
							default:
									System.out.println("Opción incorrecta");								
							}		
						}
					else
						System.out.println("No se pudo añadir el conjunto en la posición dada");
						break;
					case 2:
						System.out.println("\n---MOSTRANDO CONJUNTO---\n");
						
						System.out.println("Indique la posición del conjunto que quiere mostrar: ");
						pos=Entrada.entero();
						
						if(pos<vecConjuntos.length && vecConjuntos[pos]!=null) {
								System.out.println(vecConjuntos[pos].informacionConjunto());
								System.out.println("\n");
						}					
						break;
					case 3:
						System.out.println("\n---AÑADIENDO ELEMENTO A CONJUNTO---\n");
						System.out.println("Indique la posición del conjunto donde quiere añadir el elemento: ");
						pos=Entrada.entero();
						
						if(pos<vecConjuntos.length 
								&& vecConjuntos[pos]!=null 
									&& vecConjuntos[pos].introducirElemento())
							System.out.println("Elemento añadido con éxito");
						else
							System.out.println("No se pudo añadir el elemento");
						break;
					case 4:
						System.out.println("\n---BORRANDO ELEMENTO DE CONJUNTO---\n");
						System.out.println("Indique la posición del conjunto donde quiere borrar el elemento: ");
						pos=Entrada.entero();
						
						System.out.println("Indique la posición del elemento que quiere borrar: ");
						posElem=Entrada.entero();
						
						if(vecConjuntos[pos].borrarElemento(posElem))
							System.out.println("Elemento borrado con éxito");
						else
							System.out.println("No se pudo borrar el elemento");
						break;
					case 5:
						System.out.println("\n---CONCATENANDO CADENA---\n");
						System.out.println("Indique la posición del conjunto Cadenas donde quiere concatenar: ");
						pos=Entrada.entero();
						
						if(pos<vecConjuntos.length && (vecConjuntos[pos] instanceof Cadenas)) {
							System.out.println("Indique la posición del elemento donde quiere concatenar la cadena: ");
							posElem=Entrada.entero();
							
							System.out.println("Indique la cadena a concatenar: ");
							cadCon=Entrada.cadena();
							
							((Cadenas)vecConjuntos[pos]).concatenarCadena(posElem, cadCon);
						}
						break;
					case 6:
						System.out.println("\n---AÑADIENDO VOTOS---\n");
						System.out.println("Indique la posición del conjunto Elecciones donde quiere añadir votos: ");
						pos=Entrada.entero();
						
						if(pos<vecConjuntos.length && (vecConjuntos[pos] instanceof Elecciones)) {
							System.out.println("Indique la posición del partido donde quiere añadir votos: ");
							posElem=Entrada.entero();
							
							System.out.println("Indique la cantidad de votos a añadir: ");
							votos=Entrada.entero();
							
							((Elecciones)vecConjuntos[pos]).anyadirVotos(posElem, votos);
						}
						break;
					case 7:
						System.out.println("\n---ORDENANDO---\n");
						System.out.println("Indique el conjunto que quiere ordenar: ");
						pos=Entrada.entero();
						
						if(pos<vecConjuntos.length)
							if(vecConjuntos[pos] instanceof Cadenas)
							{
								System.out.println("El conjunto a ordenar es una matriz de cadena,"
										+ "¿como quiere ordenarlo \na)De menor a mayor\nb)De mayor a menor");
								opOrd=Entrada.caracter();
								
								((Cadenas)vecConjuntos[pos]).ordenaEstructura(opOrd);
							}
							else if(vecConjuntos[pos] instanceof Elecciones) {
								System.out.println("El conjunto a ordenar es un vector de partidos,"
										+ "¿como quiere ordenarlo? \na)Por nombres\nb)Por votos");
								opOrd=Entrada.caracter();
								
								((Elecciones)vecConjuntos[pos]).ordenaEstructura(opOrd);
							}
							else
								System.out.println("No se puede ordenar el conjunto de esa posición");
						else
							System.out.println("La posición no existe");
						break;
					case 0:
						System.out.println("¡Adios!");
						break;
					default: 
						System.out.println("Opción incorrecta");				
			}
		}	
	}

}
