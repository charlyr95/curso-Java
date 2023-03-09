/*
ArgentinaPrograma 4.0
Curso Inicial Java
Alumno: Carlos Romero
*/
package ejercicios.clase3;

import java.util.Scanner;

class c3ejercicio2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce una cadena de texto: ");
        String texto = sc.nextLine();
        System.out.print("Introduce el desplazamiento: ");
        int desplazamiento = sc.nextInt();

        String textoCodificado = codificar(texto, desplazamiento);
        System.out.println("Texto codificado: " + textoCodificado);

        String textoDecodificado = decodificar(textoCodificado, desplazamiento);
        System.out.println("Texto decodificado: " + textoDecodificado);
    }

    public static String codificar(String texto, int desplazamiento) {
        String resultado = "";
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            //if (Character.isLetter(letra)) {
                letra = (char) ((int) letra + desplazamiento);
            //}
            resultado += letra;
        }
        return resultado;
    }

    public static String decodificar(String texto, int desplazamiento) {
        String resultado = "";
        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            //if (Character.isLetter(letra)) {
                letra = (char) ((int) letra - desplazamiento);
            //}
            resultado += letra;
        }
        return resultado;
    }
}