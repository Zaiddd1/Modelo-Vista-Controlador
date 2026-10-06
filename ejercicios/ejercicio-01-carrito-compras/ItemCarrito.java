// guarda un producto del carrito junto con la cantidad que se quiere comprar
public class ItemCarrito {
    private Producto producto;
    private int cantidad;

    public ItemCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    // se usa cuando el cliente agrega otra vez el mismo producto
    public void sumarCantidad(int cantidad) {
        this.cantidad = this.cantidad + cantidad;
    }

    // precio del producto por la cantidad elegida
    public double getSubtotal() {
        return producto.getPrecio() * cantidad;
    }
}
