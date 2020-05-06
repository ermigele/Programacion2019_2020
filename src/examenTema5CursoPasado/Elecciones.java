package examenTema5CursoPasado;

public class Elecciones extends Conjunto implements IEstructuraOrdenable{
	private PartidoPolitico[] parpol;
	
	public Elecciones(String ident, int tam)
	{
		super(ident);
		this.parpol=new PartidoPolitico[tam];
	}
	
	public PartidoPolitico getPartido(int pos)
	{
		if(pos>=0 && pos<parpol.length)
			return parpol[pos];
		
		return null;
	}
	
	public boolean introducirElemento()
	{
		int pos;
		String nom;
		
		System.out.println("Introduce el nombre del partido político: ");
		nom=Entrada.cadena();
		
		System.out.println("Introduce la posición donde introducir el partido político: ");
		pos=Entrada.entero();
		
		if(pos>=0 && pos<parpol.length && parpol[pos]==null)
		{
			parpol[pos]=new PartidoPolitico(nom);
			return true;			
		}
		else
			return false;
	}
	
	public boolean borrarElemento(int pos)
	{
		if(pos>=0 && pos<parpol.length && parpol[pos]!=null)
		{
			parpol[pos]=null;
			return true;
		}
		else
			return false;
	}
	
	public boolean anyadirVotos(int pos, int numVotos)
	{
		PartidoPolitico pp=this.getPartido(pos);
		
		if(pp!=null) {
			pp.sumarVotos(numVotos);
			return true;
		}
		else
			return false;
	}
	
	public String informacionConjunto() {
		String cad=super.informacionConjunto();
			
		for(int i=0;i<parpol.length;i++)
		{
			cad+="\nPartido posición: "+i+"\n";
			if(parpol[i]!=null)
				cad+="Nombre: "+parpol[i].getNombre()+"\nNumero Votos: "+parpol[i].getNumeroVotos()+"\n\n";
			else
				cad+="No hay partido guardado en esta posición\n";			
		}
		return cad;
	}	
	
	public void ordenaEstructura(char op)
	{
		if(op=='a')
			this.ordenaPorNombre();
		else if(op=='b')
			this.ordenaPorVotos();
	}
	
	private void ordenaPorNombre()
	{
		int  pos;
		PartidoPolitico temp;
		for (int i = 0; i <parpol.length - 1; i++) {
			pos = i;			
			for (int j = i + 1; j < parpol.length; j++) {
				if (parpol[j]!=null && parpol[pos]!=null && parpol[j].getNombre().compareTo(parpol[pos].getNombre())<0)
					pos = j;
			}
			
			if (pos != i) {
				temp = parpol[pos];
				parpol[pos] = parpol[i];
				parpol[i] = temp;
			}
		}
	}
	
	private void ordenaPorVotos()
	{
		int  pos;
		PartidoPolitico temp;
		for (int i = 0; i <parpol.length - 1; i++) {
			pos = i;
			for (int j = i + 1; j < parpol.length; j++) {
				if (parpol[j]!=null && parpol[pos]!=null && parpol[j].getNumeroVotos()>parpol[pos].getNumeroVotos())
					pos = j;
			}
			
			if (pos != i) {
				temp = parpol[pos];
				parpol[pos] = parpol[i];
				parpol[i] = temp;
			}
		}
	}
}
