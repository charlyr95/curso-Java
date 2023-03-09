/*
ArgentinaPrograma 4.0
Curso Inicial Java
Alumno: Carlos Romero
*/
package ejercicios.clase3;

import java.util.Scanner;

class Ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una cadena de texto: ");
        String texto = sc.nextLine();
        System.out.print("Introduce el desplazamiento: ");
        int desplazamiento = sc.nextInt();

        String textoCodificado = codificarCesar(texto, desplazamiento);
        System.out.println("Texto codificado: " + textoCodificado);

        String textoDecodificado = decodificarCesar(textoCodificado, desplazamiento);
        System.out.println("Texto decodificado: " + textoDecodificado);
    }

    public static String codificarCesar(String texto, int desplazamiento) {
        String resultado = "";
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            if (Character.isLetter(letra)) {
                letra = (char) (((int) letra + desplazamiento - 65) % 26 + 65);
            }
            resultado += letra;
        }
        return resultado;
    }

    public static String decodificarCesar(String texto, int desplazamiento) {
        String resultado = "";
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            if (Character.isLetter(letra)) {
                letra = (char) (((int) letra - desplazamiento - 65 + 26) % 26 + 65);
            }
            resultado += letra;
        }
        return resultado;
    }
}