/*
ArgentinaPrograma 4.0
Curso Inicial Java
Alumno: Carlos Romero
*/
package ejercicios.clase1;

class c1ejercicio1 {
    public static void main(String[] args) {
        int numA = -5;
        int numB = 7;
        int aux;
        
        boolean paridad = false; // true:Par & false:impar
        
        aux = numA;
        while(aux <= numB){
            if(paridad){
                if(aux % 2 == 0){
                    System.out.print(aux + " ");
                }
            }else{
                if(aux % 2 != 0){
                    System.out.print(aux + " ");
                }
            }
        aux++;
        }
        
        System.out.println(" "); //Separador
        
        for(aux=numB; aux >= numA; aux--){
            if(aux % 2 == 0){
                    System.out.print(aux + " ");
            }
        }
    }
}