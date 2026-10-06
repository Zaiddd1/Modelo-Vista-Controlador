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
	// MUESTRA LOS PEDIDOS REGISTRADOS
	public void mostrarPedidos(List<Pedido> pedidos)
	{
		if(pedidos.isEmpty())
		{
			System.out.println("No hay pedidos en la lista.");
		}
		else
		{
			System.out.println("Lista de pedidos:");
			for(Pedido pedido : pedidos)
			{
				System.out.println("- " + pedido.getNombrePlato());
			}
		}
	}
	// MUESTRA EL MENU DE OPCIONES
	public void MostrarMenu()
	{
		System.out.println("\nOpciones:");
		System.out.println("1. Agregar Pedido");
		System.out.println("2. Mostrar Pedidos");
		System.out.println("3. Salir");
	}
	// SOLICITA UNA OPCION
	public String solicitarOpcion()
	{
		System.out.println("Seleccione una opcion: ");
		return scanner.nextLine();
	}
	// MUESTRA UN MENSAJE
	public void mostrarMensaje(String mensaje)
	{
		System.out.println(mensaje);
	}
	// CIERRA EL SCANNER
	public void cerrarScaner()
	{
		scanner.close();
	}
}
