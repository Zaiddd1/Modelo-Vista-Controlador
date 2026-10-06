import java.util.ArrayList;
import java.util.List;

// guarda los productos elegidos y hace los calculos de la compra
public class CarritoModelo {
    // si la compra llega a este monto el envio no se cobra
    private static final double MONTO_ENVIO_GRATIS = 100;
    private static final double COSTO_ENVIO = 10;

    private List<ItemCarrito> items;
    private double porcentajeDescuento;

    public CarritoModelo() {
        items = new ArrayList<>();
        porcentajeDescuento = 0;
    }

    // si el producto ya esta en el carrito solo se suma la cantidad
    public void agregarProducto(Producto producto, int cantidad) {
        ItemCarrito existente = buscarItem(producto.getId());
        if (existente != null) {
            existente.sumarCantidad(cantidad);
        } else {
            items.add(new ItemCarrito(producto, cantidad));
        }
    }

    // devuelve false si el producto no estaba en el carrito
    public boolean eliminarProducto(int idProducto) {
        ItemCarrito item = buscarItem(idProducto);
        if (item == null) {
            return false;
        }
        items.remove(item);
        return true;
    }

    public ItemCarrito buscarItem(int idProducto) {
        for (ItemCarrito item : items) {
            if (item.getProducto().getId() == idProducto) {
                return item;
            }
        }
        return null;
    }

    // devuelve la cantidad que ya hay en el carrito de un producto
    public int cantidadEnCarrito(int idProducto) {
        ItemCarrito item = buscarItem(idProducto);
        if (item == null) {
            return 0;
        }
        return item.getCantidad();
    }

    // los codigos validos son DESC10 y DESC20
    public boolean aplicarDescuento(String codigo) {
        if (codigo.equalsIgnoreCase("DESC10")) {
            porcentajeDescuento = 10;
            return true;
        }
        if (codigo.equalsIgnoreCase("DESC20")) {
            porcentajeDescuento = 20;
            return true;
        }
        return false;
    }

    // suma lo que cuesta cada producto del carrito
    public double calcularSubtotal() {
        double subtotal = 0;
        for (ItemCarrito item : items) {
            subtotal = subtotal + item.getSubtotal();
        }
        return subtotal;
    }

    public double calcularDescuento() {
        return calcularSubtotal() * porcentajeDescuento / 100;
    }

    // el envio es gratis si la compra llega al monto minimo
    public double calcularEnvio() {
        if (items.isEmpty()) {
            return 0;
        }
        if (calcularSubtotal() - calcularDescuento() >= MONTO_ENVIO_GRATIS) {
            return 0;
        }
        return COSTO_ENVIO;
    }

    public double calcularTotal() {
        return calcularSubtotal() - calcularDescuento() + calcularEnvio();
    }

    // deja el carrito listo para una nueva compra
    public void vaciar() {
        items = new ArrayList<>();
        porcentajeDescuento = 0;
    }

    public boolean estaVacio() {
        return items.isEmpty();
    }

    public List<ItemCarrito> getItems() {
        return items;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }
}
