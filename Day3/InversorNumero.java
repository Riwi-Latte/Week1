package Day3;

import java.util.Scanner;

public class InversorNumero {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Inversor de Número y Verificador de Capicúa ---");
        System.out.print("Ingrese un número entero para invertir: ");
        int numeroIngresado = scanner.nextInt();
        
        int numeroOriginal = numeroIngresado;
        int numeroInvertido = 0;
        int ultimoDigito;

        while (numeroOriginal != 0) {
            ultimoDigito = numeroOriginal % 10;
            numeroInvertido = numeroInvertido * 10 + ultimoDigito;
            numeroOriginal = numeroOriginal / 10;
        }

        System.out.println("El número invertido es: " + numeroInvertido);

        if (numeroIngresado == numeroInvertido) {
            System.out.println("El número " + numeroIngresado + " es capicúa.");
        } else {
            System.out.println("El número " + numeroIngresado + " no es capicúa.");
        }

        scanner.close();
    }
}
