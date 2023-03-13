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
        String compare = " abcdefghijklmnñopqrstuvwxyz";
        String resultado = "";
        int index;
        int aux;
        boolean mayus;

        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            mayus = Character.isUpperCase(letra);
            letra = Character.toLowerCase(letra);
            index = compare.indexOf(letra);
            aux = index + desplazamiento;
            if (mayus) {
                if (index != -1) {
                    while (aux >= compare.length()) {
                        aux = aux - compare.length();
                    }
                    letra = compare.charAt(aux);
                    letra = Character.toUpperCase(letra);
                }
            }
            else {
                if (index != -1) {
                    while(aux >= compare.length()){
                        aux = aux - compare.length();
                    }
                    letra = compare.charAt(aux);
                }
            }
            resultado += letra;
        }
        return resultado;
    }

    public static String decodificar(String texto, int desplazamiento) {
        String compare = " abcdefghijklmnñopqrstuvwxyz";
        String resultado = "";
        int index;
        int aux;
        boolean mayus;

        for (int i = 0; i < texto.length(); i++) {
            char letra = texto.charAt(i);
            mayus = Character.isUpperCase(letra);
            letra = Character.toLowerCase(letra);
            index = compare.indexOf(letra);
            aux = index - desplazamiento;
            if (mayus) {
                if (index != -1) {
                    while (aux < 0) {
                        aux = aux + compare.length();
                    }
                    letra = compare.charAt(aux);
                    letra = Character.toUpperCase(letra);
                }
                resultado += letra;
            }
            else {
                if (index != -1) {
                    while (aux < 0) {
                        aux = aux + compare.length();
                    }
                    letra = compare.charAt(aux);
                }
                resultado += letra;
            }
        }
        return resultado;
    }
}