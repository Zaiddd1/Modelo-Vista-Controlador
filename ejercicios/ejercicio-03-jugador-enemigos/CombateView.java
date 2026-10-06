import java.util.List;
import java.util.Scanner;

// muestra el estado del combate y los mensajes, y pide los datos al usuario
public class CombateView {
    private Scanner scanner;

    public CombateView() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\n===== combate =====");
        System.out.println("1. atacar");
        System.out.println("2. usar objeto");
        System.out.println("3. salir");
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

    // muestra la salud del jugador y de cada enemigo que sigue vivo
    public void mostrarEstado(Jugador jugador, List<Enemigo> enemigos) {
        String arma = "ninguna";
        if (jugador.getEquipado() != null) {
            arma = jugador.getEquipado().getNombre();
        }
        System.out.println("\n--- estado del combate ---");
        System.out.println(jugador.getNombre() + " (nivel " + jugador.getNivel() + ") salud: "
                + jugador.getSalud() + " arma: " + arma);
        for (Enemigo enemigo : enemigos) {
            System.out.println(enemigo.getNombre() + " (" + enemigo.getTipo() + ", nivel "
                    + enemigo.getNivel() + ") salud: " + enemigo.getSalud());
        }
    }

    public void mostrarEnemigos(List<Enemigo> enemigos) {
        for (int i = 0; i < enemigos.size(); i++) {
            System.out.println((i + 1) + ". " + enemigos.get(i).getNombre());
        }
    }

    public void mostrarItems(List<Item> items) {
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.println((i + 1) + ". " + item.getNombre() + " (" + item.getTipo()
                    + ") cantidad: " + item.getCantidad());
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}
