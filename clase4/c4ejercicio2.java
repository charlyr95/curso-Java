/*
ArgentinaPrograma 4.0
Curso Inicial Java
Alumno: Carlos Romero
*/
package ejercicios.clase4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class c4ejercicio2 {
    public static void main(String[] args) {
        ArrayList number = new ArrayList<>();
        String ubicacion = "./ejercicios/clase4/archivo.txt";

        Scanner texto = leerArchivo(ubicacion);
        ArrayList numeros = listNumber(texto);
        operacion(numeros, "sumar"); // "sumar" o "multiplicar"

    }

    public static Scanner leerArchivo(String ubicacion){
        try {
            File archivo = new File(ubicacion);
            Scanner contenido = new Scanner(archivo);
            return contenido;

        } catch (FileNotFoundException e) {
            System.out.println("No se puede leer el archivo.");
        }
        return null;
    }

    public static ArrayList listNumber(Scanner texto){
        ArrayList arreglo = new ArrayList<>();;
        if (texto != null) {
            while (texto.hasNextLine()) {
                String data = texto.nextLine();
                data = data.trim();
                String[] linea = data.split(" ");
                for(String num : linea){
                    arreglo.add(Integer.parseInt(num));
                }
            }
        }
        return arreglo;
    }

    public static void operacion(ArrayList lista, String accion){
        int resultado = 0;

        if (accion.toLowerCase() == "sumar"){
            for(int i = 0; i < lista.size(); i++){
                resultado = resultado + (int)lista.get(i);
            }
            System.out.println("El resultado de la suma de los números es: " + resultado);
        } else if (accion.toLowerCase() == "multiplicar") {
            resultado = 1;
            for(int i = 0; i < lista.size(); i++){
                resultado = resultado * (int)lista.get(i);
            }
            System.out.println("El resultado de la multiplicación de los números es: " + resultado);
        } else if (accion.toLowerCase() == "imprimir") {
            for(int i = 0; i < lista.size(); i++){
                System.out.print(lista.get(i) + " ");
            }
        } else {
            System.out.println("No se reconoce la acción");
        }

    }


}