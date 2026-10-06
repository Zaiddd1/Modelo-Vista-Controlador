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
	// MUESTRA LOS TIPOS Y RETORNA EL ELEGIDO (NULL SI NO ES VALIDO)
	public String solicitarTipo()
	{
		System.out.println("Tipos de plato:");
		for(int i = 0; i < PedidoModelo.TIPOS.length; i++)
		{
			System.out.println((i + 1) + ". " + PedidoModelo.TIPOS[i]);
		}
		System.out.println("Seleccione el tipo: ");
		String opcion = scanner.nextLine();
		for(int i = 0; i < PedidoModelo.TIPOS.length; i++)
		{
			if(opcion.equals(String.valueOf(i + 1)))
			{
				return PedidoModelo.TIPOS[i];
			}
		}
		return null;
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
	// SOLICITA SI SE BUSCA POR NOMBRE O POR TIPO
	public String solicitarCriterioBusqueda()
	{
		System.out.println("Buscar por:");
		System.out.println("1. Nombre");
		System.out.println("2. Tipo");
		System.out.println("Seleccione una opcion: ");
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
			for(int i = 0; i < pedidos.size(); i++)
			{
				Pedido pedido = pedidos.get(i);
				System.out.println((i + 1) + ". " + pedido.getNombrePlato() + " (" + pedido.getTipo() + ")");
			}
		}
	}
	// MUESTRA EL MENU DE OPCIONES
	public void mostrarMenu()
	{
		System.out.println("\nOpciones:");
		System.out.println("1. Agregar Pedido");
		System.out.println("2. Mostrar Pedidos");
		System.out.println("3. Eliminar Pedido");
		System.out.println("4. Actualizar Pedido");
		System.out.println("5. Buscar Pedido");
		System.out.println("6. Contar Pedidos");
		System.out.println("7. Salir");
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
	public void cerrarScanner()
	{
		scanner.close();
	}
}
