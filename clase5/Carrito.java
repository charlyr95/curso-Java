package ejercicios.clase5;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<ItemCarrito> items;

    public Carrito(List<ItemCarrito> items) {
        this.items = new ArrayList<ItemCarrito>();
    }

    public Carrito() {
        this.items = new ArrayList<>();
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
            total += item.getSubtotal();
        }
        return total;
    }

    public List<ItemCarrito> getItems() {
        return items;
    }
}
