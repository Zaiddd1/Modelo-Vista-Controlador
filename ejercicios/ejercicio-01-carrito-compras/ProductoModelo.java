import java.util.ArrayList;
import java.util.List;

// maneja el catalogo de productos que tiene la tienda
public class ProductoModelo {
    private List<Producto> productos;
    private int siguienteId;

    public ProductoModelo() {
        productos = new ArrayList<>();
        siguienteId = 1;
    }

    // el id se asigna solo y va aumentando de uno en uno
    public void agregarProducto(String nombre, double precio, int stock) {
        productos.add(new Producto(siguienteId, nombre, precio, stock));
        siguienteId++;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    // devuelve null si no existe ningun producto con ese id
    public Producto buscarPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
