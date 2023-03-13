/*
ArgentinaPrograma 4.0
Curso Inicial Java
Alumno: Carlos Romero
*/
package ejercicios.clase4;

import java.util.Scanner;

class c4ejercicio1 {
    public static void main(String[] args) {
        //int[] numeros = {5, 12, 9, -4, -10, 0}; // Le paso un arreglo de enteros desordenado
        int[] numeros = {}; // Si el array está vacío, entonces que pida los números

        if (numeros.length == 0){
            Scanner sc = new Scanner(System.in);
            System.out.print("Ingrese números separados por un espacio: ");
            String input = sc.nextLine();
            input = input.trim();
            String[] aux = input.split(" ");

            // Como no puedo redimencionar el array int entonces creo otro array
            int[] nuevosNumeros = new int[aux.length];
            for(int i = 0; i < aux.length; i++){
                nuevosNumeros[i] = Integer.parseInt(aux[i]);
            }

            // Imprimo los resultados
            nuevosNumeros = ordenar(nuevosNumeros, true); //true: ascendente || false: descendente
            imprimir(nuevosNumeros);
        }
        else {
            numeros = ordenar(numeros, true); //true: ascendente || false: descendente
            imprimir(numeros);
        }
    }


    public static int[] ordenar(int [] numeros, boolean orden){
        //orden -> true: ascendente || false: descendente
        //Aplico el ordenamiento tipo burbuja
        int n = numeros.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orden) { // Comparo si es ascendente o descendente
                    if (numeros[j] > numeros[j + 1]) {
                        int temp = numeros[j];
                        numeros[j] = numeros[j + 1];
                        numeros[j + 1] = temp;
                    }
                } else {
                    if (numeros[j] < numeros[j + 1]) {
                        int temp = numeros[j];
                        numeros[j] = numeros[j + 1];
                        numeros[j + 1] = temp;
                    }
                }
            }
        }
        return numeros;
    }
    public static void imprimir(int[] numeros){
        for (int num : numeros) {
            System.out.print(num + " ");
        }
    }
}
