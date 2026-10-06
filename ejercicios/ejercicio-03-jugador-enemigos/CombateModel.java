import java.util.ArrayList;
import java.util.List;

// guarda al jugador y a los enemigos que participan en el combate
public class CombateModel {
    private Jugador jugador;
    private List<Enemigo> enemigos;

    public CombateModel(Jugador jugador) {
        this.jugador = jugador;
        enemigos = new ArrayList<>();
    }

    public void agregarEnemigo(Enemigo enemigo) {
        enemigos.add(enemigo);
    }

    public Jugador getJugador() {
        return jugador;
    }

    // devuelve solo los enemigos que todavia tienen vida
    public List<Enemigo> getEnemigosVivos() {
        List<Enemigo> vivos = new ArrayList<>();
        for (Enemigo enemigo : enemigos) {
            if (enemigo.estaVivo()) {
                vivos.add(enemigo);
            }
        }
        return vivos;
    }

    public boolean hayEnemigosVivos() {
        return !getEnemigosVivos().isEmpty();
    }
}
