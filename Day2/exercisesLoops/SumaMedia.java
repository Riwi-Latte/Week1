package Day2.exercisesLoops;

import java.util.Scanner;

public class SumaMedia {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;
        double suma = 0;
        int contador = 0;
        double media;

        System.out.println("--- Suma y Media ---");
        System.out.println("Ingresa numeros para sumar. Ingresa 0 para terminar.");

        do {
            System.out.print("Ingresa un numero: ");
            numero = scanner.nextInt();
            if (numero != 0) {
                suma += numero;    
                contador++;        
            }
        } while (numero != 0);

        scanner.close();

        System.out.println("\n--- Resultados ---");
        if (contador > 0) {
            media = suma / contador;
            System.out.println("La suma de todos los numeros es: " + suma);
            System.out.println("La media de los numeros es: " + media);
        } else {
            System.out.println("No se ingresaron numeros para calcular.");
        }
    }
}