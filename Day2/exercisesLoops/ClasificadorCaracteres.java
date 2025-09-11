package Day2.exercisesLoops;

import java.util.Scanner;

public class ClasificadorCaracteres {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        char caracter;

        System.out.println("--- Clasificador de Vocales ---");
        System.out.println("Ingresa un caracter o un espacio para terminar.");

        do {
            System.out.print("Ingresa un caracter: ");
            String entrada = scanner.nextLine();
            
            if (entrada.length() == 0) {
                continue; 
            }

            caracter = entrada.charAt(0);

            if (caracter == ' ') {
                break;
            }

            char caracterMinuscula = Character.toLowerCase(caracter);

            if (caracterMinuscula == 'a' || caracterMinuscula == 'e' || caracterMinuscula == 'i' || caracterMinuscula == 'o' || caracterMinuscula == 'u') {
                System.out.println("VOCAL");
            } else {
                System.out.println("NO VOCAL");
            }
        } while (true); 

        System.out.println("Programa terminado.");
        scanner.close();
    }
}