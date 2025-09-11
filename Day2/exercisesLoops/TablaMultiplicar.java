package Day2.exercisesLoops;

import java.util.Scanner;

public class TablaMultiplicar {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int numero;

        System.out.println("--- Tabla de Multiplicar ---");

        System.out.print("Ingresa un numero para ver su tabla de multiplicar: ");
        numero = scanner.nextInt();
        
        System.out.println("\nTabla del " + numero + ":");
        
        for (int i = 1; i <= 10; i++) {
            int resultado = numero * i;
            System.out.println(numero + " x " + i + " = " + resultado);
        }
        
        scanner.close();
    }
}
