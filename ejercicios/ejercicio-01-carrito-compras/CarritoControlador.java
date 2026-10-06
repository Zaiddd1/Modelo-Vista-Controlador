// recibe las opciones del usuario y coordina los modelos con la vista
public class CarritoControlador {
    private ProductoModelo productoModelo;
    private CarritoModelo carritoModelo;
    private HistorialModelo historialModelo;
    private CarritoVista vista;

    public CarritoControlador(ProductoModelo productoModelo, CarritoModelo carritoModelo,
                              HistorialModelo historialModelo, CarritoVista vista) {
        this.productoModelo = productoModelo;
        this.carritoModelo = carritoModelo;
        this.historialModelo = historialModelo;
        this.vista = vista;
    }

    // pide los datos del producto nuevo y los valida antes de guardarlos
    public void agregarProductoATienda() {
        String nombre = vista.pedirTexto("nombre del producto: ");
        if (nombre.isEmpty()) {
            vista.mostrarMensaje("el nombre no puede estar vacio");
            return;
        }
        double precio = vista.pedirDecimal("precio: ");
        int stock = vista.pedirEntero("stock: ");
        if (precio <= 0 || stock < 0) {
            vista.mostrarMensaje("el precio debe ser mayor a cero y el stock no puede ser negativo");
            return;
        }
        productoModelo.agregarProducto(nombre, precio, stock);
        vista.mostrarMensaje("producto agregado a la tienda");
    }

    public void listarProductos() {
        vista.mostrarProductos(productoModelo.getProductos());
    }

    public void agregarAlCarrito() {
        listarProductos();
        if (productoModelo.getProductos().isEmpty()) {
            return;
        }
        int id = vista.pedirEntero("id del producto: ");
        Producto producto = productoModelo.buscarPorId(id);
        if (producto == null) {
            vista.mostrarMensaje("ese producto no existe");
            return;
        }
        int cantidad = vista.pedirEntero("cantidad: ");
        if (cantidad <= 0) {
            vista.mostrarMensaje("la cantidad debe ser mayor a cero");
            return;
        }
        // se cuenta lo que ya esta en el carrito para no pasarse del stock
        int totalPedido = carritoModelo.cantidadEnCarrito(id) + cantidad;
        if (totalPedido > producto.getStock()) {
            vista.mostrarMensaje("no hay stock suficiente");
            return;
        }
        carritoModelo.agregarProducto(producto, cantidad);
        vista.mostrarMensaje("producto agregado al carrito");
    }

    public void verCarrito() {
        vista.mostrarCarrito(carritoModelo.getItems(),
                carritoModelo.calcularSubtotal(),
                carritoModelo.calcularDescuento(),
                carritoModelo.calcularEnvio(),
                carritoModelo.calcularTotal());
    }

    public void eliminarDelCarrito() {
        if (carritoModelo.estaVacio()) {
            vista.mostrarMensaje("el carrito esta vacio");
            return;
        }
        verCarrito();
        int id = vista.pedirEntero("id del producto a eliminar: ");
        if (carritoModelo.eliminarProducto(id)) {
            vista.mostrarMensaje("producto eliminado del carrito");
        } else {
            vista.mostrarMensaje("ese producto no esta en el carrito");
        }
    }

    public void aplicarDescuento() {
        String codigo = vista.pedirTexto("codigo de descuento: ");
        if (carritoModelo.aplicarDescuento(codigo)) {
            vista.mostrarMensaje("descuento aplicado del " + carritoModelo.getPorcentajeDescuento() + "%");
        } else {
            vista.mostrarMensaje("codigo no valido");
        }
    }

    public void verHistorial() {
        vista.mostrarHistorial(historialModelo.getCompras());
    }

    // baja el stock guarda la compra en el historial y limpia el carrito
    public void realizarCompra() {
        if (carritoModelo.estaVacio()) {
            vista.mostrarMensaje("no puedes comprar con el carrito vacio");
            return;
        }
        double total = carritoModelo.calcularTotal();
        for (ItemCarrito item : carritoModelo.getItems()) {
            item.getProducto().reducirStock(item.getCantidad());
        }
        historialModelo.registrarCompra(carritoModelo.getItems(), total);
        carritoModelo.vaciar();
        vista.mostrarMensaje("compra realizada con exito");
    }

    // muestra el menu una y otra vez hasta que el usuario elija salir
    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.pedirEntero("elige una opcion: ");
            switch (opcion) {
                case 1:
                    agregarProductoATienda();
                    break;
                case 2:
                    listarProductos();
                    break;
                case 3:
                    agregarAlCarrito();
                    break;
                case 4:
                    verCarrito();
                    break;
                case 5:
                    eliminarDelCarrito();
                    break;
                case 6:
                    aplicarDescuento();
                    break;
                case 7:
                    verHistorial();
                    break;
                case 8:
                    realizarCompra();
                    break;
                case 9:
                    vista.mostrarMensaje("hasta luego");
                    break;
                default:
                    vista.mostrarMensaje("opcion no valida");
            }
        } while (opcion != 9);
        vista.cerrarScanner();
    }
}
