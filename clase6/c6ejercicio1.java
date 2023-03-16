/*
ArgentinaPrograma 4.0
Curso Inicial Java
Alumno: Carlos Romero
*/
package ejercicios.clase6;


class c6ejercicio1 {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        double result1 = calc.multiplicar(80, 3);
        double aux1 = calc.sumar(150, 180);
        double result2 = calc.dividir(aux1,3);
        double aux2 = calc.restar(90, 50);
        double result3 = calc.multiplicar(aux2, 15);
        double aux3 = calc.sumar(70, 40);
        double result4 = calc.multiplicar(aux3, 25);

        System.out.println("Resultado 1: "+result1);
        System.out.println("Resultado 2: "+result2);
        System.out.println("Resultado 3: "+result3);
        System.out.println("Resultado 4: "+result4);
    }
}