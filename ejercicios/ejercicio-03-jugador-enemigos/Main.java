public class Main {
    public static void main(String[] args) {
        // se crea el inventario del jugador con dos armas y pociones
        InventarioModel inventario = new InventarioModel();
        inventario.agregarItem(new Item("espada de hierro", 1, "Arma", "espada afilada de hierro", 12));
        inventario.agregarItem(new Item("daga", 1, "Arma", "daga rapida", 8));
        inventario.agregarItem(new Item("pocion de vida", 3, "Pocion", "recupera 50 de salud"));

        // se crean el jugador y el modelo del combate con dos enemigos
        Jugador jugador = new Jugador("Aventurero", 1, inventario);
        CombateModel modelo = new CombateModel(jugador);
        modelo.agregarEnemigo(new Enemigo("Goblin", 30, 1, "Bestia"));
        modelo.agregarEnemigo(new Enemigo("Esqueleto", 40, 2, "No muerto"));

        // se crean la vista y el controlador y empieza el combate
        CombateView vista = new CombateView();
        CombateController controlador = new CombateController(modelo, vista);
        controlador.iniciar();
    }
}
