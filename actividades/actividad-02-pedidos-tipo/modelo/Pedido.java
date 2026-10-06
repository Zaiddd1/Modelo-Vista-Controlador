package modelo;
public class Pedido
{
	private String nombrePlato;
	private String tipo;
	// INICIALIZA EL NOMBRE Y EL TIPO DEL PLATO
	public Pedido(String nombrePlato, String tipo)
	{
		this.nombrePlato = nombrePlato;
		this.tipo = tipo;
	}
	// RETORNA EL NOMBRE DEL PLATO
	public String getNombrePlato()
	{
		return this.nombrePlato;
	}
	// CAMBIA EL NOMBRE DEL PLATO
	public void setNombrePlato(String nombrePlato)
	{
		this.nombrePlato = nombrePlato;
	}
	// RETORNA EL TIPO DEL PLATO
	public String getTipo()
	{
		return this.tipo;
	}
}
