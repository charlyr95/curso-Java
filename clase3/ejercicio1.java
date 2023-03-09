/*
ArgentinaPrograma 4.0
Curso Inicial Java
Alumno: Carlos Romero
*/
package Clase3;
class Ejercicio1a {
    public static void main(String[] args) {
        String texto = "Hola, estoy aprendiendo Java en Argentina Programa 4.0";
        char caracter = 'a';
        int repeticion = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == caracter) {
                repeticion++;
            }
        }
        System.out.println("La letra " + caracter + " aparece " + repeticion + " veces");
    }
};


class Ejercicio1b {
    public static void main(String[] args) {
        int[] numeros = {5, 12, 9, -4, -10, 0}; //Le paso un arreglo de enteros desordenado
        boolean orden = false; //true: ascendente || false: descendente

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

        // Imprimo el nuevo arreglo
        for (int num : numeros) {
            System.out.print(num + " ");
        }
    }
}


class Ejercicio1c {
    public static void main(String[] args) {
        int[] numeros = {5, 12, 9, -4, -10, 0, 7, 10, 14, 3, -6, -3, 1, -1}; //Le paso un arreglo de enteros
        int valor = 7; //elijo el valor para comparar
        int acumulado = 0;

        // Recorro el arreglo y hago la condicion del ejercicio
        for (int num : numeros) {
            if (num > valor) {
                acumulado = acumulado + num;
            }
        }
        System.out.print("La suma de lo numeros mayores a " + valor + " es: " + acumulado);
    }
}
