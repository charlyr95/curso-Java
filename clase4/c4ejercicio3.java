/*
ArgentinaPrograma 4.0
Curso Inicial Java
Alumno: Carlos Romero
*/
package ejercicios.clase4;

import java.io.*;

class c4ejercicio3 {
    public static void main(String[] args) {
        /*String archivoEntrada = "./ejercicios/clase4/entrada.txt";
        String archivoSalida = "./ejercicios/clase4/salida.txt";
        elCodigoEnigma(true, 13, archivoEntrada, archivoSalida);
*/
         //Descomentar para testear
        String archivoEntrada = "./ejercicios/clase4/salida.txt";
        String archivoSalida = "./ejercicios/clase4/test.txt"; //Genero un nuevo archivo para verificar que se haya decodificado correctamente
        elCodigoEnigma(false, 13, archivoEntrada, archivoSalida);


    }

    public static void elCodigoEnigma(boolean codificar, int desplazamiento, String input, String output) {
        // Nombre de los archivos de entrada y salida
        String archivoEntrada = input;
        String archivoSalida = output;

        try {
            // Abrir el archivo de entrada
            FileReader archivoLectura = new FileReader(archivoEntrada);
            BufferedReader lector = new BufferedReader(archivoLectura);

            // Verificar si el archivo de salida existe
            File archivo = new File(archivoSalida);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            // Abrir el archivo de salida
            FileWriter archivoEscritura = new FileWriter(archivo, true);
            BufferedWriter escritor = new BufferedWriter(archivoEscritura);

            // Leer y escribir el contenido del archivo de entrada y escribir codificado o decodificado en el archivo de salida
            String linea;
            while ((linea = lector.readLine()) != null) {
                if(codificar){
                    linea = codificar(linea, desplazamiento);
                    escritor.write(linea);
                    escritor.newLine();
                } else {
                    linea = decodificar(linea, desplazamiento);
                    escritor.write(linea);
                    escritor.newLine();
                }
            }

            // Cerrar los archivos
            lector.close();
            archivoLectura.close();
            escritor.close();
            archivoEscritura.close();


            if (codificar){
                System.out.println("El archivo " + archivoEntrada + " ha sido codificado en" + archivoSalida);
            } else {
                System.out.println("El archivo " + archivoEntrada + " ha sido decodificado en" + archivoSalida);
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
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