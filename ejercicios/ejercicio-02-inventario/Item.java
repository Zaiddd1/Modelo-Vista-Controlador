// representa un objeto del inventario como un arma o una pocion
public class Item {
    private String nombre;
    private int cantidad;
    private String tipo;
    private String descripcion;

    public Item(String nombre, int cantidad, String tipo, String descripcion) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void sumarCantidad(int cantidad) {
        this.cantidad = this.cantidad + cantidad;
    }

    // las armas no se gastan pero las pociones si
    public String usarItem() {
        if (cantidad <= 0) {
            return "ya no te quedan unidades de " + nombre;
        }
        if (tipo.equals("Arma")) {
            return "atacaste con " + nombre;
        }
        // si llega aqui es una pocion y se gasta una unidad
        cantidad--;
        return "usaste una pocion de " + nombre + " y te quedan " + cantidad;
    }
}
