package examenTema5CursoPasado;

public abstract class Conjunto {
	private static int numeroConjuntos=0;
	private String ident;
	
	public Conjunto(String ident)
	{
		numeroConjuntos++;
		this.ident=ident;
	}
	
	public void mostrarCantidadConjuntosCreados()
	{
		System.out.println("N�mero total de conjuntos creados: "+numeroConjuntos);
	}
	
	public String informacionConjunto()
	{
		return "El conjunto "+this.ident+" est� compuesto por los siguientes elementos: ";
	}
	
	public abstract boolean introducirElemento();
	
	public abstract boolean borrarElemento(int pos);	
}


