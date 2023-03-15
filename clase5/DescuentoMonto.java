package ejercicios.clase5;

public class DescuentoMonto extends Descuento {
    private double monto;

    public DescuentoMonto(String descripcion, double monto) {
        super(descripcion);
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    @Override
    public double calcularDescuento(Carrito carrito) {
        return Math.min(carrito.getTotal(), monto);
    }
}
