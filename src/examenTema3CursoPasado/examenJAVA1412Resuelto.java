package examenTema3CursoPasado;

public class examenJAVA1412Resuelto {
	
	public static int x1=0,x2=0,x3=0;
	
	public static int o1=0,o2=0,o3=0;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char op='n';
		boolean seguirJugando=true, programaWin=false, usuarioWin=false ;
		String movimiento;
		
		int numFichaUsuario=1,numFichaPrograma=1;
		
		System.out.println("¡Juguemos al tres en raya!");
		
		while(seguirJugando)
		{
			limpiarTablero();
			numFichaUsuario=1;
			numFichaPrograma=1;
			programaWin=false;
			usuarioWin=false;
			imprimeTablero();
			
			
			while(!programaWin && !usuarioWin && quedanFichas())
			{
				System.out.println("\n\n¡Tu turno!");				
				
				System.out.println("\nElige donde quieres colocar tu ficha: ");
				movimiento=Entrada.cadena();
		
				while(!usuarioMueveFicha(numFichaUsuario,movimiento)) {
					System.out.println("\nMovimiento erróneo!\nElige donde quieres colocar tu ficha: ");
					movimiento=Entrada.cadena();	
				}
				System.out.println("\nMOVIMIENTO VÁLIDO");
				imprimeTablero();
				usuarioWin=ganaUsuario();
				numFichaUsuario++;
				if(!usuarioWin)
				{
					System.out.println("\n\nTurno de la máquina!");
					
					while(!mueveFichaAleatoria(numFichaPrograma)) {
						System.out.println("\nMovimiento erróneo del programa");
					}
					System.out.println("\nMOVIMIENTO VÁLIDO");
					imprimeTablero();
					programaWin=ganaPrograma();
					numFichaPrograma++;
				}				
			}
			
			if(usuarioWin)
				System.out.println("\nGanaste!");
			else if(programaWin)
				System.out.println("\nGana la máquina!");
			else
				System.out.println("\nEmpate!");
			
			System.out.println("\n¿Otra partidita? (s/n)");
			op=Entrada.caracter();
			if(op=='n')
				seguirJugando=false;
		}
		
		System.out.println("¡AGUR!");
	}
	
	public static void imprimeTablero()
	{
		for(int i=1;i<=9;i++) {
			if(x1==i || x2==i || x3==i)
				System.out.print("x\t");
			else if(o1==i || o2==i || o3==i)
				System.out.print("o\t");
			else
				System.out.print("-\t");
		
			if(i%3==0)
				System.out.println();
		}
	}
	
	public static boolean mueveFichaAleatoria(int numFicha)
	{
		int posicion=(int)(Math.random()*9)+1;
		
		switch(numFicha) {
			case 1:
				if(o1!=posicion) {
					x1=posicion;
					return true;
				}
				else
					return false;
			case 2:
				if(o1!=posicion && x1!=posicion && o2!=posicion) {
					x2=posicion;
					return true;
				}
				else
					return false;
			case 3:
				if(o1!=posicion && x1!=posicion && o2!=posicion && x2!=posicion && o3!=posicion) {
					x3=posicion;
					return true;
				}
				else
					return false;					
		}
		return false;
	}
	
	public static int convierteAPosicionMovimiento(String mov)
	{
		mov=mov.toUpperCase();
		
		if(mov.equals("ARRIBA IZQUIERDA"))
			return 1;
		else if(mov.equals("ARRIBA CENTRO"))
			return 2;
		else if(mov.equals("ARRIBA DERECHA"))
			return 3;
		else if(mov.equals("CENTRO IZQUIERDA"))
			return 4;
		else if(mov.equals("CENTRO CENTRO"))
			return 5;
		else if(mov.equals("CENTRO DERECHA"))
			return 6;
		if(mov.equals("ABAJO IZQUIERDA"))
			return 7;
		else if(mov.equals("ABAJO CENTRO"))
			return 8;
		else if(mov.equals("ABAJO DERECHA"))
			return 9;
		else
			return 0;		
	}

	public static boolean usuarioMueveFicha(int numFicha, String mov)
	{
		int posicion=convierteAPosicionMovimiento(mov);
		
		switch(numFicha) {
		case 1:			
				o1=posicion;
				return true;			
		case 2:
			if(x1!=posicion && o1!=posicion) {
				o2=posicion;
				return true;
			}
			else
				return false;
		case 3:
			if(x1!=posicion && o1!=posicion && x2!=posicion) {
				o3=posicion;
				return true;
			}
			else
				return false;
		}
		
		return false;
	}
	
	public static void limpiarTablero()
	{
		x1=0;
		x2=0;
		x3=0;
		o1=0;
		o2=0;
		o3=0;
	}
	
	public static boolean quedanFichas()
	{
		if(x1==0 || x2==0 || x3==0 || o1==0 || o2==0 || o3==0)
			return true;
		else
			return false;
	}
	
	public static boolean ganaPrograma()
	{
		if((x1==1 || x1==2 || x1==3) && (x2==1 || x2==2 || x2==3) && (x3==1 || x3==2 || x3==3))
			return true;
		else if((x1==4 || x1==5 || x1==6) && (x2==4 || x2==5 | x2==6) && (x3==4 || x3==5 || x3==6))
			return true;
		else if((x1==7 || x1==8 || x1==9) && (x2==7 || x2==8 | x2==9) && (x3==7 || x3==8 || x3==9))
			return true;
		else if((x1==1 || x1==4 || x1==7) && (x2==1 || x2==4 | x2==7) && (x3==1 || x3==4 || x3==7))
			return true;
		else if((x1==2 || x1==5 || x1==8) && (x2==2 || x2==5 | x2==8) && (x3==2 || x3==5 || x3==8))			
			return true;
		else if((x1==3 || x1==6 || x1==9) && (x2==3 || x2==6 | x2==9) && (x3==3 || x3==6 || x3==9))
			return true;
		else if((x1==1 || x1==5 || x1==9) && (x2==1 || x2==5 | x2==9) && (x3==1 || x3==5 || x3==9))
			return true;
		else if((x1==3 || x1==5 || x1==7) && (x2==3 || x2==5 | x2==7) && (x3==3 || x3==5 || x3==7))
			return true;
		else
			return false;
	}
	
	public static boolean ganaUsuario()
	{
		if((o1==1 || o1==2 || o1==3) && (o2==1 || o2==2 | o2==3) && (o3==1 || o3==2 || o3==3))
			return true;
		else if((o1==4 || o1==5 || o1==6) && (o2==4 || o2==5 | o2==6) && (o3==4 || o3==5 || o3==6))
			return true;
		else if((o1==7 || o1==8 || o1==9) && (o2==7 || o2==8 | o2==9) && (o3==7 || o3==8 || o3==9))
			return true;
		else if((o1==1 || o1==4 || o1==7) && (o2==1 || o2==4 | o2==7) && (o3==1 || o3==4 || o3==7))
			return true;
		else if((o1==2 || o1==5 || o1==8) && (o2==2 || o2==5 | o2==8) && (o3==2 || o3==5 || o3==8))			
			return true;
		else if((o1==3 || o1==6 || o1==9) && (o2==3 || o2==6 | o2==9) && (o3==3 || o3==6 || o3==9))
			return true;
		else if((o1==1 || o1==5 || o1==9) && (o2==1 || o2==5 | o2==9) && (o3==1 || o3==5 || o3==9))
			return true;
		else if((o1==3 || o1==5 || o1==7) && (o2==3 || o2==5 | o2==7) && (o3==3 || o3==5 || o3==7))
			return true;
		else
			return false;
	}	
}
