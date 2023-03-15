/*
ArgentinaPrograma 4.0
Curso Inicial Java
Alumno: Carlos Romero
*/
package ejercicios.clase5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class c5ejercicio2 {
    public static void main(String[] args) {
        Carrito carrito = new Carrito();
        try {
            Scanner scanner = new Scanner(new File("archivo.csv"));
            scanner.useDelimiter(",");
            while (scanner.hasNextLine()) {
                int cantidad = scanner.nextInt();
                double precioUnitario = scanner.nextDouble();
                String producto = scanner.next().trim();
                scanner.nextLine(); // saltar al siguiente línea
                Producto p = new Producto(producto,precioUnitario,cantidad);
                ItemCarrito item = new ItemCarrito(p, cantidad);
                carrito.agregarItem(item);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            return;
        }
        System.out.println("El precio total es: $" + carrito.getTotal());
    }
}