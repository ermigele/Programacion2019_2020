package examenTema5CursoPasado;

public class NumerosRomanos extends Conjunto {
	private boolean[] numerosRomanos;
	
	public NumerosRomanos(String ident,int tam)
	{
		super(ident);
		
		if(tam<100)
			numerosRomanos=new boolean[tam];
		else
			numerosRomanos=new boolean[100];
	}
	
	public boolean introducirElemento()
	{
		int num;
		System.out.println("Introduzca el número que quiere introducir: ");
		num=Entrada.entero();
		
		if(num>=0 && num<numerosRomanos.length && numerosRomanos[num]==false) {
			numerosRomanos[num]=true;
			return true;
		}
		else
			return false;
	}
	
	public boolean borrarElemento(int pos)
	{
		if(pos>=0 && pos<numerosRomanos.length && numerosRomanos[pos]==true) {
			numerosRomanos[pos]=false;
			return true;
		}
		else
			return false;		
	}
	
	private String convierteANumeroRomano(int num)
	{
		int un = num % 10;
		int dec = num / 10;
		String numRomano = new String("");

		switch (dec) {
		case 1:
			numRomano += "X";
			break;
		case 2:
			numRomano += "XX";
			break;
		case 3:
			numRomano += "XXX";
			break;
		case 4:
			numRomano += "XL";
			break;
		case 5:
			numRomano += "L";
			break;
		case 6:
			numRomano += "LX";
			break;
		case 7:
			numRomano += "LXX";
			break;
		case 8:
			numRomano += "LXXX";
			break;
		case 9:
			numRomano += "XC";
			break;
		}
		switch (un) {
		case 1:
			numRomano += "I";
			break;
		case 2:
			numRomano += "II";
			break;
		case 3:
			numRomano += "III";
			break;
		case 4:
			numRomano += "IV";
			break;
		case 5:
			numRomano += "V";
			break;
		case 6:
			numRomano += "VI";
			break;
		case 7:
			numRomano += "VII";
			break;
		case 8:
			numRomano += "VIII";
			break;
		case 9:
			numRomano += "IX";
			break;
		}

		return numRomano;		
	}
	
	
	public String informacionConjunto() {
		String numRomanos=new String("");
		
		
		for(int i=0;i<this.numerosRomanos.length;i++)
			if(numerosRomanos[i])
				numRomanos+=this.convierteANumeroRomano(i)+" ";
		
		return super.informacionConjunto()+"{ "+numRomanos+" }";
	}
}
