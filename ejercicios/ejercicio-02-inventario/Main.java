public class Main {
    public static void main(String[] args) {
        // se crean las tres partes del patron y se conectan en el controlador
        InventarioModel modelo = new InventarioModel();
        InventarioView vista = new InventarioView();
        InventarioController controlador = new InventarioController(modelo, vista);
        controlador.iniciar();
    }
}
