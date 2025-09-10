package Dia1;
import java.util.Scanner;

public class LogicVerifier{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Verificador Logico ---");

        System.out.print("Ingresa el primer numero entero: ");
        int numberOne = scanner.nextInt();

        System.out.print("Ingresa el segundo numero entero: ");
        int numberTwo = scanner.nextInt();

        scanner.close();

        System.out.println("\n--- Resultados ---");

        boolean bothArePositive = numberOne > 0 && numberTwo > 0;
        System.out.println("¿Ambos numeros son positivos? " + bothArePositive);

        boolean atLeastOneIsGreaterThanOneHundred = numberOne > 100 || numberTwo > 100;
        System.out.println("¿Al menos uno es mayor que 100? " + atLeastOneIsGreaterThanOneHundred);

        boolean areNotEqual = numberOne != numberTwo;
        System.out.println("¿El primer numero no es igual al segundo? " + areNotEqual);
    }
}


/*Actividad 4

Pide dos números enteros y verifica con operadores lógicos si:

    Ambos son positivos (&&).
    Al menos uno es mayor que 100 (||).
    El primero no es igual al segundo (!).
 */