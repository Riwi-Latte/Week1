package Day2.exercisesLoops;

import java.util.Scanner;
import java.lang.Math; 

public class NumerosPares {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int numero1, numero2;

        System.out.println("--- Numeros Pares ---");

        System.out.print("Ingresa el primer numero: ");
        numero1 = scanner.nextInt();

        System.out.print("Ingresa el segundo numero: ");
        numero2 = scanner.nextInt();

        int inicio = Math.min(numero1, numero2);
        int fin = Math.max(numero1, numero2);
        
        System.out.println("\nNumeros pares entre " + inicio + " y " + fin + ":");

        for (int i = inicio; i <= fin; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
        
        scanner.close();
    }
}