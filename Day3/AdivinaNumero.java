package Day3;

import java.util.Scanner;
import java.util.Random;

public class AdivinaNumero {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroSecreto = random.nextInt(100) + 1;
        int numeroAdivinado;
        
        System.out.println("--- Adivina el Número ---");
        System.out.println("He generado un número entre 1 y 100.");
        
        do {
            System.out.print("Ingresa tu número: ");
            numeroAdivinado = scanner.nextInt();

            if (numeroAdivinado < numeroSecreto) {
                System.out.println("El número a adivinar es MAYOR.");
            } else if (numeroAdivinado > numeroSecreto) {
                System.out.println("El número a adivinar es MENOR.");
            }
            
            if (Math.abs(numeroAdivinado - numeroSecreto) <= 5 && numeroAdivinado != numeroSecreto) {
                System.out.println("¡Muy cerca!");
            }
            
        } while (numeroAdivinado != numeroSecreto);
        
        System.out.println("\n¡Felicidades! Adivinaste el número: " + numeroSecreto);

        scanner.close();
    }
}