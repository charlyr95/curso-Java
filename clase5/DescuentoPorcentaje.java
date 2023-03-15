package ejercicios.clase5;

public class DescuentoPorcentaje extends Descuento {
    private double porcentaje;

    public DescuentoPorcentaje(String descripcion, double porcentaje) {
        super(descripcion);
        this.porcentaje = porcentaje;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    @Override
    public double calcularDescuento(Carrito carrito) {
        return carrito.getTotal() * (porcentaje / 100);
    }
}
