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
	public void agregarPedido(String nombrePlato)
	{
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

	// OBTIENE Y MUESTRA LOS PEDIDOS
	public void mostrarPedidos()
	{
		List<Pedido> pedidos = modelo.getPedidos();
		vista.mostrarPedidos(pedidos);
	}
	// CONTROLA EL MENU PRINCIPAL
	public void iniciar()
	{
	    String opcion;
	    do
	    {
	        vista.MostrarMenu();
	        opcion = vista.solicitarOpcion();
	        switch(opcion)
	        {
	            case "1":
	                String nombrePlato = vista.solicitarNombrePlato();
	                agregarPedido(nombrePlato);
	                break;
	            case "2":
	                mostrarPedidos();
	                break;
	            case "3":
	                vista.mostrarMensaje("Saliendo....");
	                break;
	            default:
	                vista.mostrarMensaje("Opcion no valida. Intentalo de nuevo.");
	        }
	    } while(!opcion.equals("3"));
	    // CIERRA EL SCANNER
	    vista.cerrarScaner();
	}
}
