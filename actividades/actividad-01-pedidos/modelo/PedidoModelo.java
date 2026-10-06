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

	// RETORNA LA LISTA DE PEDIDOS
	public List<Pedido> getPedidos()
	{
		return this.pedidos;
	}
}
