public class Main {
    public static void main(String[] args) {
        ProductoModelo productoModelo = new ProductoModelo();
        CarritoModelo carritoModelo = new CarritoModelo();
        HistorialModelo historialModelo = new HistorialModelo();
        CarritoVista vista = new CarritoVista();

        // productos de ejemplo para no empezar con la tienda vacia
        productoModelo.agregarProducto("laptop", 2500, 5);
        productoModelo.agregarProducto("mouse", 40, 20);
        productoModelo.agregarProducto("teclado", 80, 10);

        // el controlador recibe todo lo que necesita y arranca el programa
        CarritoControlador controlador = new CarritoControlador(
                productoModelo, carritoModelo, historialModelo, vista);
        controlador.iniciar();
    }
}
