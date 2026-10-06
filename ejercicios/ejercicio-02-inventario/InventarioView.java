import java.util.List;
import java.util.Scanner;

// muestra la informacion en consola y pide los datos al usuario
public class InventarioView {
    private Scanner scanner;

    public InventarioView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n===== inventario =====");
        System.out.println("1. agregar item");
        System.out.println("2. eliminar item");
        System.out.println("3. ver inventario");
        System.out.println("4. mostrar detalles de un item");
        System.out.println("5. buscar item");
        System.out.println("6. usar item");
        System.out.println("7. salir");
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

    public void mostrarInventario(List<Item> items) {
        if (items.isEmpty()) {
            System.out.println("el inventario esta vacio");
            return;
        }
        System.out.println("\nnombre | cantidad | tipo");
        for (Item item : items) {
            System.out.println(item.getNombre() + " | " + item.getCantidad() + " | " + item.getTipo());
        }
    }

    public void mostrarDetallesItem(Item item) {
        System.out.println("\nnombre: " + item.getNombre());
        System.out.println("cantidad: " + item.getCantidad());
        System.out.println("tipo: " + item.getTipo());
        System.out.println("descripcion: " + item.getDescripcion());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
