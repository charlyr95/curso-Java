package ejercicios.clase5;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<ItemCarrito> items;

    public Carrito() {
        items = new ArrayList<ItemCarrito>();
    }

    public void agregarItem(ItemCarrito item) {
        items.add(item);
    }

    public void quitarItem(ItemCarrito item) {
        items.remove(item);
    }

    public double getTotal() {
        double total = 0;
        for (ItemCarrito item : items) {
            total += item.getTotal();
        }
        return total;
    }

    public List<ItemCarrito> getItems() {
        return items;
    }
}
