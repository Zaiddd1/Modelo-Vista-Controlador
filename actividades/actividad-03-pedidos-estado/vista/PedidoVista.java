package vista;
import java.util.Scanner;
import java.util.List;
import modelo.*;
public class PedidoVista
{
	private Scanner scanner;
	// INICIALIZA EL SCANNER
	public PedidoVista()
	{
		scanner = new Scanner(System.in);
	}
	// SOLICITA EL NOMBRE DEL PLATO
	public String solicitarNombrePlato()
	{
		System.out.println("Introduce el nombre del plato: ");
		return scanner.nextLine();
	}
	// SOLICITA EL NUMERO DE UN PEDIDO (0 SI NO ES UN NUMERO)
	public int solicitarNumeroPedido()
	{
		System.out.println("Introduce el numero del pedido: ");
		String texto = scanner.nextLine();
		if(texto.matches("[0-9]+"))
		{
			return Integer.parseInt(texto);
		}
		return 0;
	}
	// MUESTRA LOS PEDIDOS CON SU NUMERO Y SU ESTADO
	public void mostrarPedidos(List<Pedido> pedidos)
	{
		if(pedidos.isEmpty())
		{
			System.out.println("No hay pedidos en la lista.");
		}
		else
		{
			System.out.println("Lista de pedidos:");
			for(int i = 0; i < pedidos.size(); i++)
			{
				Pedido pedido = pedidos.get(i);
				System.out.println((i + 1) + ". " + pedido.getNombrePlato() + " (" + pedido.getEstado() + ")");
			}
		}
	}
	// MUESTRA EL MENU DE OPCIONES
	public void mostrarMenu()
	{
		System.out.println("\nOpciones:");
		System.out.println("1. Agregar Pedido");
		System.out.println("2. Marcar Pedido como Completo");
		System.out.println("3. Eliminar Pedido");
		System.out.println("4. Mostrar Pedidos por Estado");
		System.out.println("5. Contador de Pedidos Pendientes");
		System.out.println("6. Historial de Pedidos");
		System.out.println("7. Salir");
	}
	// SOLICITA UNA OPCION
	public String solicitarOpcion()
	{
		System.out.println("Seleccione una opcion: ");
		return scanner.nextLine();
	}
	// SOLICITA SI SE QUIEREN VER LOS PENDIENTES O LOS COMPLETOS
	public String solicitarEstado()
	{
		System.out.println("Ver pedidos:");
		System.out.println("1. Pendientes");
		System.out.println("2. Completos");
		System.out.println("Seleccione una opcion: ");
		return scanner.nextLine();
	}
	// MUESTRA UN MENSAJE
	public void mostrarMensaje(String mensaje)
	{
		System.out.println(mensaje);
	}
	// CIERRA EL SCANNER
	public void cerrarScanner()
	{
		scanner.close();
	}
}
