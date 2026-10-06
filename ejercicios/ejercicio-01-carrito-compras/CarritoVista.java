import java.util.List;
import java.util.Scanner;

// se encarga de mostrar los datos y de pedirlos al usuario por consola
public class CarritoVista {
    private Scanner scanner;

    public CarritoVista() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n===== tienda en linea =====");
        System.out.println("1. agregar producto a la tienda");
        System.out.println("2. listar productos");
        System.out.println("3. agregar producto al carrito");
        System.out.println("4. ver carrito");
        System.out.println("5. eliminar producto del carrito");
        System.out.println("6. aplicar descuento");
        System.out.println("7. ver historial de compras");
        System.out.println("8. realizar compra");
        System.out.println("9. salir");
    }

    public String pedirTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    // sigue pidiendo el dato hasta que el usuario escriba un numero entero
    public int pedirEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("tienes que escribir un numero entero");
            }
        }
    }

    // igual que el anterior pero acepta decimales
    public double pedirDecimal(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("tienes que escribir un numero valido");
            }
        }
    }

    public void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("no hay productos registrados");
            return;
        }
        System.out.println("\nid | nombre | precio | stock");
        for (Producto p : productos) {
            System.out.printf("%d | %s | S/ %.2f | %d%n",
                    p.getId(), p.getNombre(), p.getPrecio(), p.getStock());
        }
    }

    // muestra los productos del carrito y luego el resumen de los montos
    public void mostrarCarrito(List<ItemCarrito> items, double subtotal,
                               double descuento, double envio, double total) {
        if (items.isEmpty()) {
            System.out.println("el carrito esta vacio");
            return;
        }
        System.out.println("\nid | producto | cantidad | subtotal");
        for (ItemCarrito item : items) {
            System.out.printf("%d | %s | %d | S/ %.2f%n",
                    item.getProducto().getId(), item.getProducto().getNombre(),
                    item.getCantidad(), item.getSubtotal());
        }
        System.out.printf("subtotal: S/ %.2f%n", subtotal);
        System.out.printf("descuento: S/ %.2f%n", descuento);
        System.out.printf("envio: S/ %.2f%n", envio);
        System.out.printf("total a pagar: S/ %.2f%n", total);
    }

    public void mostrarHistorial(List<Compra> compras) {
        if (compras.isEmpty()) {
            System.out.println("todavia no hay compras realizadas");
            return;
        }
        for (Compra compra : compras) {
            System.out.println("\ncompra numero " + compra.getNumero());
            for (ItemCarrito item : compra.getItems()) {
                System.out.printf("  %s x%d = S/ %.2f%n",
                        item.getProducto().getNombre(), item.getCantidad(), item.getSubtotal());
            }
            System.out.printf("  total pagado: S/ %.2f%n", compra.getTotal());
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
