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
            Scanner scanner = new Scanner(new File("./ejercicios/clase5/productos.csv"));
            scanner.nextLine(); // salta los títulos
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] datos = linea.split(",");
                int cantidad = Integer.parseInt(datos[0]);
                double precio = Double.parseDouble(datos[1]);
                String producto = datos[2];
                Producto p = new Producto(producto,precio);
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