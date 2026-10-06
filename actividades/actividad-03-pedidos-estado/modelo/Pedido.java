package modelo;
public class Pedido
{
	private String nombrePlato;
	private String estado;
	// INICIALIZA EL NOMBRE DEL PLATO Y EL ESTADO PENDIENTE
	public Pedido(String nombrePlato)
	{
		this.nombrePlato = nombrePlato;
		this.estado = "Pendiente";
	}
	// RETORNA EL NOMBRE DEL PLATO
	public String getNombrePlato()
	{
		return this.nombrePlato;
	}
	// RETORNA EL ESTADO (PENDIENTE, COMPLETO O ELIMINADO)
	public String getEstado()
	{
		return this.estado;
	}
	// CAMBIA EL ESTADO DEL PEDIDO
	public void setEstado(String estado)
	{
		this.estado = estado;
	}
}
