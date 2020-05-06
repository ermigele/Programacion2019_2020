package examenTema5CursoPasado;

public class Cadenas extends Conjunto implements IEstructuraOrdenable{
	private String[][] conjuntoCadenas;
	
	public Cadenas(String ident,int tamFil,int tamCol)
	{
		super(ident);
		
		if(tamFil<=10 && tamCol<=10)
			conjuntoCadenas=new String[tamFil][tamCol];
		else
			conjuntoCadenas=new String[10][10];
		
		for(int i=0;i<tamFil;i++)
			for(int j=0;j<tamCol;j++)
				this.conjuntoCadenas[i][j]=new String(" ");
		
	}
	
	public boolean introducirElemento()
	{
		String cad;
		int fil,col;
		System.out.println("Introduzca cadena: ");
		cad=Entrada.cadena();
		
		System.out.println("Introduzca la fila: ");
		fil=Entrada.entero();
		
		System.out.println("Introduzca la columna: ");
		col=Entrada.entero();
		
		if(fil<conjuntoCadenas.length && col<conjuntoCadenas[fil].length) {
			this.conjuntoCadenas[fil][col]=cad;
			return true;
		}
		return false;
	}
	
	public boolean borrarElemento(int pos)
	{
		int fil=0,col=0;
		
		for(int i=0;i<pos;i++)
		{
			col++;
			
			if(col==conjuntoCadenas[0].length)
			{
				col=0;
				fil++;
			}
		}
		
		if(fil<conjuntoCadenas.length && col<conjuntoCadenas.length) {
			this.conjuntoCadenas[fil][col]=new String(" ");
			return true;
		}
		return false;
	}
	
	public void concatenarCadena(int pos,String cad)
	{
		int fil=0,col=0;
		
		for(int i=0;i<pos;i++)
		{
			col++;
			
			if(col==conjuntoCadenas[0].length)
			{
				col=0;
				fil++;
			}
		}
		
		if(fil<conjuntoCadenas.length && col<conjuntoCadenas.length) 
			this.conjuntoCadenas[fil][col]=this.conjuntoCadenas[fil][col].concat(cad);
			
	}
	
	public String informacionConjunto() {
		String cad=super.informacionConjunto();
		cad+="\n{\t";
		
		for(int i=0;i<this.conjuntoCadenas.length;i++) {
			for(int j=0;j<this.conjuntoCadenas[i].length;j++)
			{
				if(!this.conjuntoCadenas[i][j].equals(" "))
					cad+=this.conjuntoCadenas[i][j]+"\t";
				else
					cad+="*\t";
			}
			
			cad+="\n\t";
		}
		
		cad=cad.substring(0,cad.length()-2).concat("}");
		
		return cad;		
	}
	
	public void ordenaEstructura(char op)
	{
		if(op=='a')
			this.ordenaDeMayorAMenor();
		else if(op=='b')
			this.ordenaDeMenorAMayor();
	}
	
	private void ordenaDeMayorAMenor() {
		int posFil = 0, posCol = 0, k, l;
		String temp = new String("");

		for (int i = 0; i < conjuntoCadenas.length; i++) {
			for (int j = 0; j < conjuntoCadenas[i].length; j++) {
				posFil = i;
				posCol = j;

				if (j == conjuntoCadenas[i].length - 1) {
					k = i + 1;
					l = 0;
				} else {
					k = i;
					l = j + 1;
				}

				if (!conjuntoCadenas[posFil][posCol].equals(" ")) {

					while (k < conjuntoCadenas.length) {
						while (l < conjuntoCadenas[k].length) {
							if (!conjuntoCadenas[k][l].equals(" ")
									&& conjuntoCadenas[k][l].compareTo(conjuntoCadenas[posFil][posCol]) < 0) {
								posFil = k;
								posCol = l;
							}
							l++;
						}
						l = 0;
						k++;
					}

					if (posFil != i || posCol != j) {
						temp = conjuntoCadenas[posFil][posCol];
						conjuntoCadenas[posFil][posCol] = conjuntoCadenas[i][j];
						conjuntoCadenas[i][j] = temp;
					}
				}

			}
		}
	}	
	
	private void ordenaDeMenorAMayor() {
		int posFil = 0, posCol = 0, k, l;
		String temp = new String("");

		for (int i = 0; i < conjuntoCadenas.length; i++) {
			for (int j = 0; j < conjuntoCadenas[i].length; j++) {
				posFil = i;
				posCol = j;

				if (j == conjuntoCadenas[i].length - 1) {
					k = i + 1;
					l = 0;
				} else {
					k = i;
					l = j + 1;
				}

				if (!conjuntoCadenas[posFil][posCol].equals(" ")) {

					while (k < conjuntoCadenas.length) {
						while (l < conjuntoCadenas[k].length) {
							if (!conjuntoCadenas[k][l].equals(" ")
									&& conjuntoCadenas[k][l].compareTo(conjuntoCadenas[posFil][posCol]) > 0) {
								posFil = k;
								posCol = l;
							}
							l++;
						}
						l = 0;
						k++;
					}

					if (posFil != i || posCol != j) {
						temp = conjuntoCadenas[posFil][posCol];
						conjuntoCadenas[posFil][posCol] = conjuntoCadenas[i][j];
						conjuntoCadenas[i][j] = temp;
					}
				}

			}
		}
	}	
}
