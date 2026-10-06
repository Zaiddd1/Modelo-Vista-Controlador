package controlador;
import java.util.List;
import modelo.*;
import vista.*;
public class PedidoControlador
{
	private PedidoModelo modelo;
	private PedidoVista vista;

	// INICIALIZA EL MODELO Y LA VISTA
	public PedidoControlador(PedidoModelo modelo, PedidoVista vista)
	{
		this.modelo = modelo;
		this.vista = vista;
	}

	// AGREGA UN PEDIDO SI EL NOMBRE Y EL TIPO SON VALIDOS
	public void agregarPedido()
	{
		String nombrePlato = vista.solicitarNombrePlato();
		String tipo = vista.solicitarTipo();
		if(nombrePlato.isEmpty())
		{
			vista.mostrarMensaje("El nombre del plato no puede estar vacio");
		}
		else if(tipo == null)
		{
			vista.mostrarMensaje("Tipo no valido");
		}
		else
		{
			modelo.agregarPedidos(new Pedido(nombrePlato, tipo));
			vista.mostrarMensaje("Pedido agregado: " + nombrePlato + " (" + tipo + ")");
		}
	}

	// OBTIENE Y MUESTRA LOS PEDIDOS
	public void mostrarPedidos()
	{
		List<Pedido> pedidos = modelo.getPedidos();
		vista.mostrarPedidos(pedidos);
	}

	// ELIMINA UN PEDIDO ELEGIDO POR EL USUARIO
	public void eliminarPedido()
	{
		mostrarPedidos();
		if(!modelo.getPedidos().isEmpty())
		{
			int posicion = vista.solicitarNumeroPedido() - 1;
			if(posicion >= 0 && posicion < modelo.getPedidos().size())
			{
				modelo.eliminarPedido(posicion);
				vista.mostrarMensaje("Pedido eliminado");
			}
			else
			{
				vista.mostrarMensaje("Numero de pedido no valido");
			}
		}
	}

	// ACTUALIZA EL NOMBRE DE UN PEDIDO ELEGIDO POR EL USUARIO
	public void actualizarPedido()
	{
		mostrarPedidos();
		if(!modelo.getPedidos().isEmpty())
		{
			int posicion = vista.solicitarNumeroPedido() - 1;
			if(posicion >= 0 && posicion < modelo.getPedidos().size())
			{
				String nuevoNombre = vista.solicitarNombrePlato();
				if(!nuevoNombre.isEmpty())
				{
					modelo.actualizarPedido(posicion, nuevoNombre);
					vista.mostrarMensaje("Pedido actualizado");
				}
				else
				{
					vista.mostrarMensaje("El nombre del plato no puede estar vacio");
				}
			}
			else
			{
				vista.mostrarMensaje("Numero de pedido no valido");
			}
		}
	}

	// BUSCA PEDIDOS POR NOMBRE O POR TIPO
	public void buscarPedido()
	{
		String criterio = vista.solicitarCriterioBusqueda();
		if(criterio.equals("1"))
		{
			String texto = vista.solicitarNombrePlato();
			vista.mostrarPedidos(modelo.buscarPorNombre(texto));
		}
		else if(criterio.equals("2"))
		{
			String tipo = vista.solicitarTipo();
			if(tipo != null)
			{
				vista.mostrarPedidos(modelo.buscarPorTipo(tipo));
			}
			else
			{
				vista.mostrarMensaje("Tipo no valido");
			}
		}
		else
		{
			vista.mostrarMensaje("Opcion no valida");
		}
	}

	// MUESTRA EL TOTAL DE PEDIDOS Y LA CANTIDAD POR TIPO
	public void contarPedidos()
	{
		vista.mostrarMensaje("Total de pedidos: " + modelo.getPedidos().size());
		for(String tipo : PedidoModelo.TIPOS)
		{
			vista.mostrarMensaje("- " + tipo + ": " + modelo.contarPorTipo(tipo));
		}
	}

	// CONTROLA EL MENU PRINCIPAL
	public void iniciar()
	{
	    String opcion;
	    do
	    {
	        vista.mostrarMenu();
	        opcion = vista.solicitarOpcion();
	        switch(opcion)
	        {
	            case "1":
	                agregarPedido();
	                break;
	            case "2":
	                mostrarPedidos();
	                break;
	            case "3":
	                eliminarPedido();
	                break;
	            case "4":
	                actualizarPedido();
	                break;
	            case "5":
	                buscarPedido();
	                break;
	            case "6":
	                contarPedidos();
	                break;
	            case "7":
	                vista.mostrarMensaje("Saliendo....");
	                break;
	            default:
	                vista.mostrarMensaje("Opcion no valida. Intentalo de nuevo.");
	        }
	    } while(!opcion.equals("7"));
	    // CIERRA EL SCANNER
	    vista.cerrarScanner();
	}
}
