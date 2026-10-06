import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {
       private int cont=0;
       private List<Pedido> pedidos;
       public PedidoModelo() {
           pedidos = new ArrayList<>();
       }
       public void agregarPedido(Pedido pedido) {
           pedidos.add(pedido);
           cont++;
       }
       public List<Pedido> getPedidos() {
           return pedidos;
       }
       public void terminarPedido(int ind){
           String temp=pedidos.get(ind).getNombrePlato();
           pedidos.get(ind).setNombrePlato(temp+" (completo) ");
       }


}
