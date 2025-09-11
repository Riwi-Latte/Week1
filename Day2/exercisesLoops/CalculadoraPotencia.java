package Day2.exercisesLoops;

import java.util.Scanner;

public class CalculadoraPotencia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double base;
        int exponente;
        double resultado = 1.0;

        System.out.println("--- Calculadora de Potencia ---");

        System.out.print("Ingresa la base (numero real): ");
        base = scanner.nextDouble();

        do {
            System.out.print("Ingresa el exponente (entero positivo): ");
            exponente = scanner.nextInt();
            if (exponente < 0) {
                System.out.println("Error: El exponente debe ser un entero positivo. Intenta de nuevo.");
            }
        } while (exponente < 0);

        if (exponente == 0) {
            resultado = 1.0;
        } else {
            for (int i = 0; i < exponente; i++) {
                resultado *= base; 
            }
        }

        System.out.println("\n--- Resultado ---");
        System.out.println(base + " elevado a la " + exponente + " es: " + resultado);

        scanner.close();
    }
}