/*
ArgentinaPrograma 4.0
Curso Inicial Java
Alumno: Carlos Romero
*/
package ejercicios.clase5;

class c5ejercicio1 {
    public static void main(String[] args) {
        Producto producto1 = new Producto("Mouse Cougar Airblader", 6749.99, 5);
        Producto producto2 = new Producto("Auriculares HyperX Cloud Stinger", 37799.35, 10);
        Producto producto3 = new Producto("Play Station 5 Digital Edition", 299999.98, 20);

        System.out.println(producto1.getPrecio());
    }
}

