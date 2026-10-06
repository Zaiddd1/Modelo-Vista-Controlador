// representa a un enemigo con su nombre, salud, nivel y tipo
public class Enemigo {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;

    public Enemigo(String nombre, int salud, int nivel, String tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getNivel() {
        return nivel;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean estaVivo() {
        return salud > 0;
    }

    // el danio del enemigo crece con su nivel
    public int atacar(Jugador jugador) {
        int danio = 3 + nivel * 2;
        jugador.recibirDanio(danio);
        return danio;
    }

    // la salud nunca baja de cero
    public void recibirDanio(int danio) {
        salud = salud - danio;
        if (salud < 0) {
            salud = 0;
        }
    }
}
