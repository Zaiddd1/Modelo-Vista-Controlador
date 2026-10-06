package modelo;
import java.util.ArrayList;
import java.util.List;
public class PedidoModelo
{
	private List<Pedido> pedidos;

	// INICIALIZA LA LISTA DE PEDIDOS
	public PedidoModelo()
	{
		pedidos = new ArrayList<>();
	}

	// AGREGA UN PEDIDO A LA LISTA
	public void agregarPedidos(Pedido pedido)
	{
		this.pedidos.add(pedido);
	}

	// CAMBIA EL ESTADO DE UN PEDIDO
	public void cambiarEstado(Pedido pedido, String estado)
	{
		pedido.setEstado(estado);
	}

	// RETORNA LOS PEDIDOS QUE TIENEN UN ESTADO
	public List<Pedido> getPorEstado(String estado)
	{
		List<Pedido> encontrados = new ArrayList<>();
		for(Pedido pedido : pedidos)
		{
			if(pedido.getEstado().equals(estado))
			{
				encontrados.add(pedido);
			}
		}
		return encontrados;
	}

	// CUENTA LOS PEDIDOS QUE SIGUEN PENDIENTES
	public int contarPendientes()
	{
		return getPorEstado("Pendiente").size();
	}

	// RETORNA EL HISTORIAL: LOS PEDIDOS COMPLETOS Y LOS ELIMINADOS
	public List<Pedido> getHistorial()
	{
		List<Pedido> historial = new ArrayList<>();
		for(Pedido pedido : pedidos)
		{
			if(!pedido.getEstado().equals("Pendiente"))
			{
				historial.add(pedido);
			}
		}
		return historial;
	}
}
