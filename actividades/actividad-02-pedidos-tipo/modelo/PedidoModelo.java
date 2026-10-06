package modelo;
import java.util.ArrayList;
import java.util.List;
public class PedidoModelo
{
	// TIPOS DE PLATO DISPONIBLES
	public static final String[] TIPOS = {"Entrada", "Plato de fondo", "Postre", "Bebida"};
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

	// ELIMINA EL PEDIDO DE LA POSICION INDICADA
	public void eliminarPedido(int posicion)
	{
		this.pedidos.remove(posicion);
	}

	// ACTUALIZA EL NOMBRE DEL PEDIDO DE LA POSICION INDICADA
	public void actualizarPedido(int posicion, String nuevoNombre)
	{
		this.pedidos.get(posicion).setNombrePlato(nuevoNombre);
	}

	// BUSCA LOS PEDIDOS CUYO NOMBRE CONTENGA EL TEXTO
	public List<Pedido> buscarPorNombre(String texto)
	{
		List<Pedido> encontrados = new ArrayList<>();
		for(Pedido pedido : pedidos)
		{
			if(pedido.getNombrePlato().toLowerCase().contains(texto.toLowerCase()))
			{
				encontrados.add(pedido);
			}
		}
		return encontrados;
	}

	// BUSCA LOS PEDIDOS DE UN TIPO
	public List<Pedido> buscarPorTipo(String tipo)
	{
		List<Pedido> encontrados = new ArrayList<>();
		for(Pedido pedido : pedidos)
		{
			if(pedido.getTipo().equals(tipo))
			{
				encontrados.add(pedido);
			}
		}
		return encontrados;
	}

	// CUENTA LOS PEDIDOS DE UN TIPO
	public int contarPorTipo(String tipo)
	{
		return buscarPorTipo(tipo).size();
	}
}
