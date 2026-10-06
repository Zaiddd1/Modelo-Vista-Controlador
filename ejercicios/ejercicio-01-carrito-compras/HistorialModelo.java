import java.util.ArrayList;
import java.util.List;

// guarda todas las compras que se han hecho
public class HistorialModelo {
    private List<Compra> compras;

    public HistorialModelo() {
        compras = new ArrayList<>();
    }

    // se hace una copia de la lista para que no cambie cuando se vacie el carrito
    public void registrarCompra(List<ItemCarrito> items, double total) {
        int numero = compras.size() + 1;
        compras.add(new Compra(numero, new ArrayList<>(items), total));
    }

    public List<Compra> getCompras() {
        return compras;
    }
}
