import java.util.List;
import java.util.Scanner;

public class PedidoVista {
   private Scanner scanner;
   public PedidoVista() {
       scanner = new Scanner(System.in);
   }
   public String solicitarNombrePlato() {
       System.out.print("Introduce el nombre del plato: ");
       return scanner.nextLine();
   }
   public void mostrarPedidos(List<Pedido> pedidos) {
       if (pedidos.isEmpty()) {
           System.out.println("No hay pedidos en la lista.");
       } else {
           System.out.println("Lista de Pedidos:");
           int cont=0;
           for (Pedido pedido : pedidos) {
               System.out.println(cont+"."+" - " + pedido.getNombrePlato());
               cont++;
           }
       }
   }
   public void mostrarCompletado(List<Pedido> pedidos){
       for(Pedido p:pedidos){
           if (p.getNombrePlato().contains("(completo)")){
               System.out.println("- "+p.getNombrePlato());
           }
       }
   }
   public void mostrarPendiente(List<Pedido> pedidos){
       for(Pedido p:pedidos){
           if (!p.getNombrePlato().contains("(completo)")){
               System.out.println("- "+p.getNombrePlato());
           }
       }
   }
   public void mostrarCantPendientes(List<Pedido> pedidos){
       int cont=0;
       for(Pedido p:pedidos){
           if (!p.getNombrePlato().contains("(completo)")){
               cont++;
           }
       }
       System.out.println("pediddos pendientes:"+ cont);
   }
   public int solicitarIndicePedido() {
       System.out.print("Introduce el Indice del pedido (primer numero de la lista): ");
       return scanner.nextInt();
   }
   public void mostrarMenu() {
       System.out.println("\nOpciones:");
       System.out.println("1. Agregar Pedido");
       System.out.println("2. Mostrar Pedidos");
       System.out.println("3. Terminar Pedidos");
       System.out.println("4. Cantidad pedidos pendientes");
       System.out.println("5. Salir");
   }
   public String solicitarOpcion() {
       System.out.print("Selecciona una opción: ");
       return scanner.nextLine();
   }
   public void mostrarMensaje(String mensaje) {
       System.out.println(mensaje);
   }
   public void cerrarScanner() {
       scanner.close();
   }
}
