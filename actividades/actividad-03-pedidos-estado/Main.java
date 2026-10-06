public class Main {
    public static void main(String[] args) {
        // se crean las tres partes del patron y se conectan en el controlador
        PedidoModelo modelo = new PedidoModelo();
        PedidoVista vista = new PedidoVista();
        PedidoControlador controlador = new PedidoControlador(modelo, vista);
        controlador.iniciar();
    }
}
