import java.util.ArrayList;
import java.util.List;

// guarda la lista de items y tiene las operaciones para manejarla
public class InventarioModel {
    private List<Item> items;

    public InventarioModel() {
        items = new ArrayList<>();
    }

    // si el item ya existe solo se suma la cantidad
    public void agregarItem(Item item) {
        Item existente = buscarItem(item.getNombre());
        if (existente != null) {
            existente.sumarCantidad(item.getCantidad());
        } else {
            items.add(item);
        }
    }

    public boolean eliminarItem(Item item) {
        return items.remove(item);
    }

    public List<Item> obtenerItems() {
        return items;
    }

    // busca por nombre sin importar mayusculas o minusculas y devuelve null si no lo encuentra
    public Item buscarItem(String nombre) {
        for (Item item : items) {
            if (item.getNombre().equalsIgnoreCase(nombre)) {
                return item;
            }
        }
        return null;
    }
}
