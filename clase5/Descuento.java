package ejercicios.clase5;

public abstract class Descuento {
    private String descripcion;

    public Descuento(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public abstract double calcularDescuento(Carrito carrito);
}
