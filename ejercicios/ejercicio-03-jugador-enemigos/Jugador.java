// representa al jugador: guarda su salud, su inventario y el arma que tiene equipada
public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private InventarioModel inventario;
    private Item equipado;

    public Jugador(String nombre, int nivel, InventarioModel inventario) {
        this.nombre = nombre;
        this.salud = 100;
        this.nivel = nivel;
        this.inventario = inventario;
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

    public InventarioModel getInventario() {
        return inventario;
    }

    public Item getEquipado() {
        return equipado;
    }

    public boolean estaVivo() {
        return salud > 0;
    }

    // el danio depende del arma equipada, sin arma solo golpea con las manos
    public int atacar(Enemigo enemigo) {
        int danio = 2;
        if (equipado != null) {
            danio = equipado.getDanio();
        }
        danio = danio + nivel;
        enemigo.recibirDanio(danio);
        return danio;
    }

    // si el objeto es un arma la equipa y si es una pocion recupera 50 de salud
    public String usarObjeto(Item item) {
        if (item.getTipo().equals("Arma")) {
            equipado = item;
            return "equipaste " + item.getNombre();
        }
        if (item.getCantidad() <= 0) {
            return "ya no te quedan unidades de " + item.getNombre();
        }
        item.usarItem();
        salud = salud + 50;
        if (salud > 100) {
            salud = 100;
        }
        return "usaste " + item.getNombre() + " y tu salud ahora es " + salud;
    }

    // la salud nunca baja de cero
    public void recibirDanio(int danio) {
        salud = salud - danio;
        if (salud < 0) {
            salud = 0;
        }
    }
}
