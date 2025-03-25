package Calculadora;

import java.util.Scanner;

public class Calculadora {
    
    public static void main(String[] args) {
        try{
            double Var1;
            double Var2;
            boolean looper = true;
            Scanner IDNumero = new Scanner(System.in);
            Calculadora cal = new Calculadora();

            while (looper) {
                System.out.println("introduzca el tipo de operacion de calculo que desea");
                System.out.println("[1]SUMA [2]RESTA [3]MULTIPLICACION [4]DIVISION [5]RESTOS [0]SALIR");
                int Opcion = IDNumero.nextInt();
                switch (Opcion) {
                    case 1 -> {
                        System.out.println("Introduzca el primer valor");
                        Var1 = IDNumero.nextDouble();
                        System.out.println("Introduzca el segundo valor");
                        Var2 = IDNumero.nextDouble();
                        cal.suma(Var1, Var2);
                    }
                    case 2 -> {
                        System.out.println("Introduzca el primer valor");
                        Var1 = IDNumero.nextDouble();
                        System.out.println("Introduzca el segundo valor");
                        Var2 = IDNumero.nextDouble();
                        cal.resta(Var1, Var2);
                        
                    }
                    case 3 -> {
                        System.out.println("Introduzca el primer valor");
                        Var1 = IDNumero.nextDouble();
                        System.out.println("Introduzca el segundo valor");
                        Var2 = IDNumero.nextDouble();
                        cal.multi(Var1, Var2);
                    }
                    case 4 -> {
                        System.out.println("Introduzca el primer valor");
                        Var1 = IDNumero.nextDouble();
                        System.out.println("Introduzca el segundo valor");
                        Var2 = IDNumero.nextDouble();
                        cal.division(Var1, Var2);
                    }
                    case 5 -> {
                        System.out.println("Introduzca el primer valor");
                        Var1 = IDNumero.nextDouble();
                        System.out.println("Introduzca el segundo valor");
                        Var2 = IDNumero.nextDouble();
                        cal.restos(Var1, Var2);
                    }
                    default -> looper = false;
                }
            }
            IDNumero.close();
            }catch(Exception e){
                System.err.println("Error Valor no valido");
            }
    }

    private double suma(double Var1, double Var2) {
        
        double suma = Var1 +Var2;
        System.out.println("El resulado de la suma es: " + suma);
        return suma;
    }

    private double resta(double Var1, double Var2) {
        
        double resta = Var1 -Var2;
        System.out.println("El resulado de la resta es: " + resta);
        return resta;

    }

    private double multi(double Var1, double Var2) {
        double multi = Var1 * Var2;
        System.out.println("El resulado de la multiplicacion es: " + multi);
        return multi;
    }

    private double division(double Var1, double Var2) {
        try{
            if (Var1 == 0 | Var2 == 0) {
                System.err.println("No puede dividir por cero");
                return 0;
            }
            double division = Var1 / Var2;
            System.out.println("El resulado de la divsion es: " + division);
            return division;
        }catch(Exception e){
            System.exit(0); 
            return 0;
        }
    }

    private double restos(double Var1, double Var2) {
        try{
            if (Var1 == 0 | Var2 == 0) {
                System.err.println("No puede dividir por cero");
                return 0;
            }
            double restos = Var1 % Var2;
                if (restos == 0) {
                    System.out.println("Es divisible");
                }
                else{
                    System.out.println("No es divisible");
                }

            return restos;
        }catch(Exception e){
            System.exit(0); 
            return 0;
        }
    }
}


