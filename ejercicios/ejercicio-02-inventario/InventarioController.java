// recibe las opciones del usuario y coordina el modelo con la vista
public class InventarioController {
    private InventarioModel modelo;
    private InventarioView vista;

    public InventarioController(InventarioModel modelo, InventarioView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    // pide los datos del item y los valida antes de guardarlo
    public void agregarItem() {
        String nombre = vista.pedirTexto("nombre del item: ");
        if (nombre.isEmpty()) {
            vista.mostrarMensaje("el nombre no puede estar vacio");
            return;
        }
        int cantidad = vista.pedirEntero("cantidad: ");
        if (cantidad <= 0) {
            vista.mostrarMensaje("la cantidad debe ser mayor a cero");
            return;
        }
        // el tipo se elige con un numero para evitar errores al escribir
        int opcionTipo = vista.pedirEntero("tipo 1 arma o 2 pocion: ");
        String tipo;
        if (opcionTipo == 1) {
            tipo = "Arma";
        } else if (opcionTipo == 2) {
            tipo = "Pocion";
        } else {
            vista.mostrarMensaje("tipo no valido");
            return;
        }
        String descripcion = vista.pedirTexto("descripcion: ");
        modelo.agregarItem(new Item(nombre, cantidad, tipo, descripcion));
        vista.mostrarMensaje("item agregado al inventario");
    }

    public void eliminarItem() {
        String nombre = vista.pedirTexto("nombre del item a eliminar: ");
        Item item = modelo.buscarItem(nombre);
        if (item == null) {
            vista.mostrarMensaje("ese item no existe");
            return;
        }
        modelo.eliminarItem(item);
        vista.mostrarMensaje("item eliminado");
    }

    public void verInventario() {
        vista.mostrarInventario(modelo.obtenerItems());
    }

    public void mostrarDetalles() {
        String nombre = vista.pedirTexto("nombre del item: ");
        Item item = modelo.buscarItem(nombre);
        if (item == null) {
            vista.mostrarMensaje("ese item no existe");
        } else {
            vista.mostrarDetallesItem(item);
        }
    }

    public void buscarItem() {
        String nombre = vista.pedirTexto("nombre a buscar: ");
        Item item = modelo.buscarItem(nombre);
        if (item == null) {
            vista.mostrarMensaje("no se encontro el item");
        } else {
            vista.mostrarMensaje("item encontrado: " + item.getNombre());
        }
    }
    // el item decide que pasa al usarse y la vista muestra el mensaje
    public void usarItem() {
        String nombre = vista.pedirTexto("nombre del item a usar: ");
        Item item = modelo.buscarItem(nombre);
        if (item == null) {
            vista.mostrarMensaje("ese item no existe");
            return;
        }
        vista.mostrarMensaje(item.usarItem());
    }
    // muestra el menu una y otra vez hasta que el usuario elija salir
    public void iniciar() {
        int opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.pedirEntero("elige una opcion: ");
            switch (opcion) {
                case 1:
                    agregarItem();
                    break;
                case 2:
                    eliminarItem();
                    break;
                case 3:
                    verInventario();
                    break;
                case 4:
                    mostrarDetalles();
                    break;
                case 5:
                    buscarItem();
                    break;
                case 6:
                    usarItem();
                    break;
                case 7:
                    vista.mostrarMensaje("hasta luego");
                    break;
                default:
                    vista.mostrarMensaje("opcion no valida");
            }
        } while (opcion != 7);
        vista.cerrarScanner();
    }
}
