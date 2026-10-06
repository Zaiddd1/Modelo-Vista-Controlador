package modelo;
public class Pedido
{
	private String nombrePlato;
	// INICIALIZA EL NOMBRE DEL PLATO
	public Pedido(String nombrePlato)
	{
		this.nombrePlato = nombrePlato;
	}
	// RETORNA EL NOMBRE DEL PLATO
	public String getNombrePlato()
	{
		return this.nombrePlato;
	}
}
