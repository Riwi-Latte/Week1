package Day2.exercisesLoops;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese un numero para calcular su factorial: ");
        int numero = scanner.nextInt();

        if (numero < 0) {
            System.out.println("El factorial no esta definido para numeros negativos.");
        } else {
            long factorial = 1;

            for (int i = 1; i <= numero; i++) {
                factorial = factorial * i;
            }

            System.out.println("El factorial de " + numero + " es: " + factorial);
        }

        scanner.close();
    }
}
