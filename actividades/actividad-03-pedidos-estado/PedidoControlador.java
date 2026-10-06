import java.util.List;
public class PedidoControlador {
   private PedidoModelo modelo;
   private PedidoVista vista;
   public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
       this.modelo = modelo;
       this.vista = vista;
   }
   public void agregarPedido(String nombrePlato) {
       if (!nombrePlato.isEmpty()) {
           modelo.agregarPedido(new Pedido(nombrePlato));
           vista.mostrarMensaje("Pedido agregado: " + nombrePlato);
       } else {
           vista.mostrarMensaje("El nombre del plato no puede estar vacío.");
       }
   }
   public void mostrarPedidos() {
       List<Pedido> pedidos = modelo.getPedidos();
       vista.mostrarPedidos(pedidos);
   }
   public void marcarCompleto(){
           mostrarPedidos();
           modelo.terminarPedido(vista.solicitarIndicePedido());
   }


   public void iniciar() {
       String opcion;
       String op;
       do {
           vista.mostrarMenu();
           opcion = vista.solicitarOpcion();
           switch (opcion) {
               case "1":
                   String nombrePlato = vista.solicitarNombrePlato();
                   agregarPedido(nombrePlato);
                   break;
               case "2":
                   List<Pedido> pedidos = modelo.getPedidos();
                   vista.mostrarMensaje("ingrese: \n1. Mostrar historial de pedidos\n2. MostrarPedidos completados\n3. Mostrar pedidos pendientes\nOpcion:");
                   while(true){
                       op=vista.solicitarOpcion();
                       switch (op){
                           case "1":
                               mostrarPedidos();
                               break;
                           case "2":

                               vista.mostrarCompletado(pedidos);
                               break;
                           case "3":

                               vista.mostrarPendiente(pedidos);
                               break;
                           default:
                               vista.mostrarMensaje("ingreso invalido");
                       }
                       break;
                   }
                   break;
               case "3":
                   marcarCompleto();
               case "4":
                   List<Pedido> p = modelo.getPedidos();
                   vista.mostrarCantPendientes(p);
               case "5":
                   vista.mostrarMensaje("Saliendo...");
                   break;
               default:
                   vista.mostrarMensaje("Opción no válida. Inténtalo de nuevo.");
           }
       } while (!opcion.equals("5"));
       vista.cerrarScanner();
   }

}
