import java.util.List;

// guarda los datos de una compra ya realizada
public class Compra {
    private int numero;
    private List<ItemCarrito> items;
    private double total;

    public Compra(int numero, List<ItemCarrito> items, double total) {
        this.numero = numero;
        this.items = items;
        this.total = total;
    }

    public int getNumero() {
        return numero;
    }

    public List<ItemCarrito> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }
}
