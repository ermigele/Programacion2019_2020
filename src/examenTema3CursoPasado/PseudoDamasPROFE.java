package examenTema3CursoPasado;

public class PseudoDamasPROFE {

	public static boolean fichaProg1=true, fichaProg2=true, fichaProg3=true;
	
	public static boolean fichaUser1=true, fichaUser2=true, fichaUser3=true;
	
	public static int YProg1=2, YProg2=2, YProg3=2; //se les suma o resta 6 o 12
	public static int XProg1=3, XProg2=15, XProg3=27;  //se les suma 4
	
	public static int YUser1=18, YUser2=18, YUser3=18; //se les suma o resta 6 o 12
	public static int XUser1=3, XUser2=15, XUser3=27; //se les resta 4
	
	public static final int TAMCOL=30,TAMFIL=20; //TAMCOL siempre múltiplo de 6, TAMFIL siempre múltiplo de 4	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char ganador=' ',tablas='n';
		int ficha=0;
		String mov=" ";
		
		System.out.println("¡¡BIENVENIDO AL JUEGO DE DAMAS!!\n");
		
		construirTablero();
		
		System.out.println("\nEmpiezas tú\n");
		
		while(ganador==' ' && tablas!='s') {
			System.out.println("¿Tablas (s/n)?");
			tablas=Entrada.caracter();
			if(tablas!='s') {
				
				//JUGADOR USUARIO
				System.out.println("Indica la ficha que quieres mover: ");
				ficha=Entrada.entero();
				
				System.out.println("Indica hacia donde quieres mover la ficha: ");
				mov=Entrada.cadena().toUpperCase();
				
				if(mov.compareTo("IZQUIERDA")==0)
					if(mueveIzquierdaFichaUsuario(ficha))
						System.out.println("\nBUEN MOVIMIENTO!");
					else
						System.out.println("\nMovimiento erróneo, has perdido tu turno");
				else if(mov.compareTo("DERECHA")==0)
					if(mueveDerechaFichaUsuario(ficha))
						System.out.println("\nBUEN MOVIMIENTO!");
					else
						System.out.println("\nMovimiento erróneo, has perdido tu turno");
				else
					System.out.println("\nMovimiento erróneo, has perdido tu turno ");
				
				if(comeFicha('u',ficha))
					System.out.println("\nTe acabas de comer una ficha del contrario!");
				
				construirTablero();					
				
				//JUGADOR PROGRAMA
				ficha=fichaAleatoria();
				mov=ladoAleatorio();
				
				if(mov.compareTo("IZQUIERDA")==0)
					if(mueveIzquierdaFichaPrograma(ficha))
						System.out.println("\nBUEN MOVIMIENTO!");
					else
						System.out.println("\nMovimiento erróneo, el programa ha perdido su turno");
				else if(mov.compareTo("DERECHA")==0)
					if(mueveDerechaFichaPrograma(ficha))
						System.out.println("\nBUEN MOVIMIENTO!");
					else
						System.out.println("\nMovimiento erróneo, el programa ha perdido su turno");
				else
					System.out.println("\nMovimiento erróneo, el programa ha perdido su turno ");
				
				if(comeFicha('p',ficha))
					System.out.println("\nEl programa te acaba de comer una ficha!");
				
				construirTablero();
				
				if(fichaUser1==false && fichaUser2==false && fichaUser3==false)
					ganador='p';
				
				if(fichaProg1==false && fichaProg2==false && fichaProg3==false)
					ganador='u';
			}
			

		}
		
		if(ganador=='u')
			System.out.println("¡GANASTE!");
		else if(ganador=='p')
			System.out.println("¡TE GANÓ EL PROGRAMA!");
		else
			System.out.println("¡TABLAS!");
			
		
		
		
	}
	
	public static void imprimeLetrasTablero()
	{
		int numLetra=65;
		int siguientePosicion=3;
		
		
		for(int i=0;i<=TAMCOL;i++)
		{
			if(i==siguientePosicion) {
				System.out.print((char)numLetra);
				numLetra++;
				siguientePosicion+=6;
			}
			else
				System.out.print(" ");
		}
		System.out.println();
	}
	
	public static void construirTablero()
	{
		int contNum=1;
		int siguientePosicion=2;
		
		imprimeLetrasTablero();
		
		for(int i=0;i<=TAMFIL;i++)
		{
			if(i%4==0)
				for(int j=0;j<=TAMCOL;j++)
					System.out.print("*");
			else
				for(int j=0;j<=TAMCOL;j++)
					if(j%6==0)
						System.out.print("*");
					else
						imprimeFichas(j,i);
			
			if(i==siguientePosicion)
			{
				System.out.print(" "+contNum);
				contNum++;
				siguientePosicion+=4;
			}
			
			System.out.println("");
		}
	}
	
	public static void imprimeFichas(int posX, int posY)
	{
		if(fichaProg1 && posX==XProg1 && posY==YProg1)
			System.out.print("P");
		else
			if(fichaProg2 && posX==XProg2 && posY==YProg2)
				System.out.print("P");
			else
				if(fichaProg3 && posX==XProg3 && posY==YProg3)
					System.out.print("P");
				else
					if(fichaUser1 && posX==XUser1 && posY==YUser1)
					System.out.print("U");
					else
						if(fichaUser2 && posX==XUser2 && posY==YUser2)
							System.out.print("D");
						else
							if(fichaUser3 && posX==XUser3 && posY==YUser3)
								System.out.print("T");
							else
								System.out.print(" ");
	}
	
	public static boolean mueveIzquierdaFichaPrograma(int numFicha)
	{
		switch(numFicha)
		{
			case 1:
			if (fichaProg1 && XProg1 + 6 < TAMCOL && YProg1 + 4 < TAMFIL
					&& (!fichaProg2 && (XProg1 + 6 != XProg2 || YProg1 + 4 != YProg2))
					&& (!fichaProg3 && (XProg1 + 6 != XProg3 || YProg1 + 4 != YProg3))) {
					XProg1+=6;
					YProg1+=4;
					return true;
				}
				else
					return false;
			case 2:
				if(fichaProg2 && XProg2+6<TAMCOL && YProg2+4<TAMFIL
									&& (!fichaProg1 && (XProg2+6!=XProg1 || YProg2+4!=YProg1)) 
										&& (!fichaProg3 && (XProg2+6!=XProg3 || YProg2+4!=YProg3))) {
					XProg2+=6;
					YProg2+=4;
					return true;
				}
				else
					return false;
				
			case 3:
				if(fichaProg3 && XProg3+6<TAMCOL && YProg3+4<TAMFIL
									&& (!fichaProg1 && (XProg3+6!=XProg1 || YProg3+4!=YProg1)) 
										&& (!fichaProg2 && (XProg3+6!=XProg2 || YProg3+4!=YProg2))) {
					XProg3+=6;
					YProg3+=4;
					return true;
				}
				else
					return false;
				default:
					return false;
		}


	}
	
	public static boolean mueveDerechaFichaPrograma(int numFicha)
	{
		switch(numFicha)
		{
			case 1:
			if (fichaProg1 && XProg1 - 6 > 0 && YProg1 + 4 < TAMFIL
					&& ((!fichaProg2) || (fichaProg2 && (XProg1 - 6 != XProg2 || YProg1 + 4 != YProg2)))
					&& ((!fichaProg3) || (fichaProg3 && (XProg1 - 6 != XProg3 || YProg1 + 4 != YProg3)))) {
					XProg1-=6;
					YProg1+=4;
					return true;
				}
				else //if (((YProg1+4 == YProg2 && XProg1+6 == XProg2) && fichaProg2 == true) 
					 //    || ((YProg1+4 == YProg3 && XProg1+6 == XProg3) && fichaProg3 == true))
					return false;
			case 2:
				if(fichaProg2 && XProg2-6>0 && YProg2+4<TAMFIL
									&& ((!fichaProg1) || (fichaProg1 && (XProg2-6!=XProg1 || YProg2+4!=YProg1))) 
										&& ((!fichaProg3) || (fichaProg3 && (XProg2-6!=XProg3 || YProg2+4!=YProg3)))) {
					XProg2-=6;
					YProg2+=4;
					return true;
				}
				else
					return false;
				
			case 3:
				if(fichaProg3 && XProg3-6>0 && YProg3+4<TAMFIL
									&& ((!fichaProg1) || (fichaProg1 && (XProg3-6!=XProg1 || YProg3+4!=YProg1))) 
										&& ((!fichaProg2) || (fichaProg2 && (XProg3-6!=XProg2 || YProg3+4!=YProg2)))) {
					XProg3-=6;
					YProg3+=4;
					return true;
				}
				else
					return false;
				default:
					return false;
		}

	}

	public static boolean mueveIzquierdaFichaUsuario(int numFicha)
	{
		switch(numFicha)
		{
			case 1:
				if(fichaUser1 && XUser1-6>0 && YUser1-4>0 
									&& ((!fichaUser2) || (fichaUser2 && (XUser1-6!=XUser2 || YUser1-4!=YUser2))) 
										&& ((!fichaUser3) ||(fichaUser3 && (XUser1-6!=XUser3 || YUser1-4!=YUser3)))) {
					XUser1-=6;
					YUser1-=4;
					return true;
				}
				else
					return false;
			case 2:
				if(fichaUser2 && XUser2-6>0 && YUser2-4>0
									&& ((!fichaUser1) || (fichaUser1 && (XUser2-6!=XUser1 || YUser2-4!=YUser1))) 
										&& ((!fichaUser3) ||(fichaUser3 && (XUser2-6!=XUser3 || YUser2-4!=YUser3)))) {
					XUser2-=6;
					YUser2-=4;
					return true;
				}
				else
					return false;
				
			case 3:
				if(fichaUser3 && XUser3-6>0 && YUser3-4>0
									&& ((!fichaUser1) ||(fichaUser1 && (XUser3-6!=XUser1 || YUser3-4!=YUser1))) 
										&& ((!fichaUser2) ||(fichaUser2 && (XUser3-6!=XUser2 || YUser3-4!=YUser2)))) {
					XUser3-=6;
					YUser3-=4;
					return true;
				}
				else
					return false;
				default:
					return false;
		}


	}
	
	public static boolean mueveDerechaFichaUsuario(int numFicha)
	{
		switch(numFicha)
		{
			case 1:
				if(fichaUser1 && XUser1+6<TAMCOL && YUser1-4>0 
									&& ((!fichaUser2) ||(fichaUser2 && (XUser1+6!=XUser2 || YUser1-4!=YUser2))) 
										&& ((!fichaUser3) ||(fichaUser3 && (XUser1+6!=XUser3 || YUser1-4!=YUser3)))) {
					XUser1+=6;
					YUser1-=4;
					return true;
				}
				else
					return false;
			case 2:
				if(fichaUser2 && XUser2+6<TAMCOL && YUser2-4>0
									&& ((!fichaUser1) ||(fichaUser1 && (XUser2+6!=XUser1 || YUser2-4!=YUser1))) 
										&& ((!fichaUser3) ||(fichaUser3 && (XUser2+6!=XUser3 || YUser2-4!=YUser3)))) {
					XUser2+=6;
					YUser2-=4;
					return true;
				}
				else
					return false;
				
			case 3:
				if(fichaUser3 && XUser3+6<TAMCOL && YUser3-4>0
									&& ((!fichaUser1) ||(fichaUser1 && (XUser3+6!=XUser1 || YUser3-4!=YUser1))) 
										&& ((!fichaUser2) ||(fichaUser2 && (XUser3+6!=XUser2 || YUser3-4!=YUser2)))) {
					XUser3+=6;
					YUser3-=4;
					return true;
				}
				else
					return false;
				default:
					return false;
		}
	}
	
	public static boolean comeFicha(char jugador, int ficha)
	{
		if(jugador=='p')
		{
			switch(ficha)
			{
				case 1:
					if(fichaProg1 && fichaUser1 && XProg1==XUser1 && YProg1==YUser1) {
						fichaUser1=false;
						return true;
					}
					else if(fichaProg1 && fichaUser2 &&  XProg1==XUser2 && YProg1==YUser2) {
						fichaUser2=false;
						return true;
					}
					else if(fichaProg1 && fichaUser3 &&  XProg1==XUser3 && YProg1==YUser3) {
						fichaUser3=false;
						return true;
					}
					break;
				 case 2:
					 if(fichaProg2 && fichaUser1 && XProg2==XUser1 && YProg2==YUser1) {
							fichaUser1=false;
							return true;
						}
						else if(fichaProg2 && fichaUser2 && XProg2==XUser2 && YProg2==YUser2) {
							fichaUser2=false;
							return true;
						}
						else if(fichaProg2 && fichaUser3 && XProg2==XUser3 && YProg2==YUser3) {
							fichaUser3=false;
							return true;
						}
						break;
				 case 3:
					 if(fichaProg3 && fichaUser1 && XProg3==XUser1 && YProg3==YUser1) {
							fichaUser1=false;
							return true;
						}
						else if(fichaProg3 && fichaUser2 && XProg3==XUser2 && YProg3==YUser2) {
							fichaUser2=false;
							return true;
						}
						else if(fichaProg3 && fichaUser3 &&  XProg3==XUser3 && YProg3==YUser3) {
							fichaUser3=false;
							return true;
						}
						break;
					}			
		}else if(jugador=='u') {
			switch(ficha)
			{
				case 1:
					if(fichaUser1 && fichaProg1 && XUser1==XProg1 && YUser1==YProg1) {
						fichaProg1=false;
						return true;
					}
					else if(fichaUser1 && fichaProg2 && XUser1==XProg2 && YUser1==YProg2) {
						fichaProg2=false;
						return true;
					}
					else if(fichaUser1 && fichaProg3 && XUser1==XProg3 && YUser1==YProg3) {
						fichaProg3=false;
						return true;
					}
					break;
				 case 2:
					 if(fichaUser2 && fichaProg1 && XUser2==XProg1 && YUser2==YProg1) {
							fichaProg1=false;
							return true;
						}
						else if(fichaUser2 && fichaProg2 && XUser2==XProg2 && YUser2==YProg2) {
							fichaProg2=false;
							return true;
						}
						else if(fichaUser2 && fichaProg3 && XUser2==XProg3 && YUser2==YProg3) {
							fichaProg3=false;
							return true;
						}
						break;
				 case 3:
					 if(fichaUser3 && fichaProg1 && XUser3==XProg1 && YUser3==YProg1) {
							fichaProg1=false;
							return true;
						}
						else if(fichaUser3 && fichaProg2 && XUser3==XProg2 && YUser3==YProg2) {
							fichaProg2=false;
							return true;
						}
						else if(fichaUser3 && fichaProg3 && XUser3==XProg3 && YUser3==YProg3) {
							fichaProg3=false;
							return true;
						}
						break;
			}
		}
		return  false;
	}
	
	
	public static String ladoAleatorio()
	{
		int valor=(int)Math.round(Math.random());
		
		if(valor==0)
			return "IZQUIERDA";
		else
			return "DERECHA";		
	}
	
	public static int fichaAleatoria() {
		return (int)(Math.random()*3+1);
	}
	
}
