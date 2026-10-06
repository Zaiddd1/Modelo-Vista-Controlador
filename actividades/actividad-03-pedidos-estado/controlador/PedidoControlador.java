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

	// AGREGA UN PEDIDO SI EL NOMBRE ES VALIDO
	public void agregarPedido()
	{
		String nombrePlato = vista.solicitarNombrePlato();
		if(!nombrePlato.isEmpty())
		{
			modelo.agregarPedidos(new Pedido(nombrePlato));
			vista.mostrarMensaje("Pedido agregado: " + nombrePlato);
		}
		else
		{
			vista.mostrarMensaje("El nombre del plato no puede estar vacio");
		}
	}

	// MUESTRA LOS PEDIDOS PENDIENTES Y RETORNA EL QUE ELIGE EL USUARIO (NULL SI NO ES VALIDO)
	public Pedido elegirPedidoPendiente()
	{
		List<Pedido> pendientes = modelo.getPorEstado("Pendiente");
		vista.mostrarPedidos(pendientes);
		if(pendientes.isEmpty())
		{
			return null;
		}
		int posicion = vista.solicitarNumeroPedido() - 1;
		if(posicion >= 0 && posicion < pendientes.size())
		{
			return pendientes.get(posicion);
		}
		vista.mostrarMensaje("Numero de pedido no valido");
		return null;
	}

	// MARCA UN PEDIDO PENDIENTE COMO COMPLETO
	public void marcarCompleto()
	{
		Pedido pedido = elegirPedidoPendiente();
		if(pedido != null)
		{
			modelo.cambiarEstado(pedido, "Completo");
			vista.mostrarMensaje("Pedido completado: " + pedido.getNombrePlato());
		}
	}

	// ELIMINA UN PEDIDO PENDIENTE (QUEDA EN EL HISTORIAL)
	public void eliminarPedido()
	{
		Pedido pedido = elegirPedidoPendiente();
		if(pedido != null)
		{
			modelo.cambiarEstado(pedido, "Eliminado");
			vista.mostrarMensaje("Pedido eliminado: " + pedido.getNombrePlato());
		}
	}

	// MUESTRA SOLO LOS PEDIDOS PENDIENTES O SOLO LOS COMPLETOS
	public void mostrarPorEstado()
	{
		String opcion = vista.solicitarEstado();
		if(opcion.equals("1"))
		{
			vista.mostrarPedidos(modelo.getPorEstado("Pendiente"));
		}
		else if(opcion.equals("2"))
		{
			vista.mostrarPedidos(modelo.getPorEstado("Completo"));
		}
		else
		{
			vista.mostrarMensaje("Opcion no valida");
		}
	}

	// MUESTRA CUANTOS PEDIDOS SIGUEN PENDIENTES
	public void contarPendientes()
	{
		vista.mostrarMensaje("Pedidos pendientes: " + modelo.contarPendientes());
	}

	// MUESTRA EL HISTORIAL DE PEDIDOS COMPLETOS Y ELIMINADOS
	public void mostrarHistorial()
	{
		vista.mostrarPedidos(modelo.getHistorial());
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
	                marcarCompleto();
	                break;
	            case "3":
	                eliminarPedido();
	                break;
	            case "4":
	                mostrarPorEstado();
	                break;
	            case "5":
	                contarPendientes();
	                break;
	            case "6":
	                mostrarHistorial();
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
