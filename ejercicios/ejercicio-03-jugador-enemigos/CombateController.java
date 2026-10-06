import java.util.List;
import java.util.Random;

// gestiona el combate: recibe las opciones del jugador y hace actuar a los enemigos
public class CombateController {
    private CombateModel modelo;
    private CombateView vista;
    private Random azar;

    public CombateController(CombateModel modelo, CombateView vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.azar = new Random();
    }

    // el jugador elige a que enemigo atacar, devuelve true si gasto su turno
    public boolean atacarEnemigo() {
        List<Enemigo> vivos = modelo.getEnemigosVivos();
        vista.mostrarEnemigos(vivos);
        int opcion = vista.pedirEntero("a que enemigo atacas: ");
        if (opcion < 1 || opcion > vivos.size()) {
            vista.mostrarMensaje("enemigo no valido");
            return false;
        }
        Jugador jugador = modelo.getJugador();
        Enemigo enemigo = vivos.get(opcion - 1);
        int danio = jugador.atacar(enemigo);
        vista.mostrarMensaje(jugador.getNombre() + " ataca a " + enemigo.getNombre()
                + " y le quita " + danio + " de salud");
        if (!enemigo.estaVivo()) {
            vista.mostrarMensaje(enemigo.getNombre() + " fue derrotado");
        }
        return true;
    }

    // el jugador elige un objeto de su inventario, devuelve true si gasto su turno
    public boolean usarObjeto() {
        Jugador jugador = modelo.getJugador();
        List<Item> items = jugador.getInventario().obtenerItems();
        if (items.isEmpty()) {
            vista.mostrarMensaje("no tienes objetos");
            return false;
        }
        vista.mostrarItems(items);
        int opcion = vista.pedirEntero("que objeto usas: ");
        if (opcion < 1 || opcion > items.size()) {
            vista.mostrarMensaje("objeto no valido");
            return false;
        }
        vista.mostrarMensaje(jugador.usarObjeto(items.get(opcion - 1)));
        return true;
    }

    // cada enemigo vivo elige al azar si ataca o se queda quieto
    public void turnoEnemigos() {
        Jugador jugador = modelo.getJugador();
        for (Enemigo enemigo : modelo.getEnemigosVivos()) {
            if (azar.nextInt(2) == 0) {
                int danio = enemigo.atacar(jugador);
                vista.mostrarMensaje(enemigo.getNombre() + " te ataca y te quita " + danio + " de salud");
            } else {
                vista.mostrarMensaje(enemigo.getNombre() + " se queda quieto");
            }
        }
    }

    // repite los turnos hasta que alguien gane o el jugador salga
    public void iniciar() {
        Jugador jugador = modelo.getJugador();
        int opcion = 0;
        while (opcion != 3 && jugador.estaVivo() && modelo.hayEnemigosVivos()) {
            vista.mostrarEstado(jugador, modelo.getEnemigosVivos());
            vista.mostrarMenu();
            opcion = vista.pedirEntero("elige una opcion: ");
            boolean gastoTurno = false;
            if (opcion == 1) {
                gastoTurno = atacarEnemigo();
            } else if (opcion == 2) {
                gastoTurno = usarObjeto();
            } else if (opcion == 3) {
                vista.mostrarMensaje("hasta luego");
            } else {
                vista.mostrarMensaje("opcion no valida");
            }
            // los enemigos solo actuan si el jugador uso su turno y quedan enemigos vivos
            if (gastoTurno && modelo.hayEnemigosVivos()) {
                turnoEnemigos();
            }
        }
        if (!jugador.estaVivo()) {
            vista.mostrarMensaje("\nhas sido derrotado");
        } else if (!modelo.hayEnemigosVivos()) {
            vista.mostrarMensaje("\nganaste el combate");
        }
        vista.cerrarScanner();
    }
}
