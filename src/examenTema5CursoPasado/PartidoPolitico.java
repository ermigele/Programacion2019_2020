package examenTema5CursoPasado;

public class PartidoPolitico {
	private String nombre;	
	private int numeroVotos;
	
	public PartidoPolitico(String nombre)
	{
		this.nombre=nombre.toUpperCase();
		this.numeroVotos=0;		
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getNumeroVotos() {
		return numeroVotos;
	}
	
	public void sumarVotos(int num)
	{
		numeroVotos+=num;
	}
}
