package Day2.exercisesLoops;

import java.util.Scanner;
import java.util.Random;

public class AdivinaNumero {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numeroSecreto = random.nextInt(100) + 1;
        int intentosMaximos = 10;
        int intentosRestantes = intentosMaximos;
        int numeroUsuario;
        boolean haAdivinado = false;

        System.out.println("--- Adivina el Numero ---");
        System.out.println("He generado un numero entre 1 y 100.");
        System.out.println("Tienes 10 intentos para adivinarlo.");

        while (intentosRestantes > 0) {
            System.out.println("\nIntentos restantes: " + intentosRestantes);
            System.out.print("Ingresa tu numero: ");
            numeroUsuario = scanner.nextInt();

            if (numeroUsuario == numeroSecreto) {
                haAdivinado = true;
                break; 
            } else if (numeroUsuario < numeroSecreto) {
                System.out.println("El numero a adivinar es MAYOR.");
            } else {
                System.out.println("El numero a adivinar es MENOR.");
            }
            
            intentosRestantes--;
        }

        if (haAdivinado) {
            int intentosUsados = intentosMaximos - intentosRestantes;
            System.out.println("\n--- ¡Felicidades! ---");
            System.out.println("Adivinaste el numero en " + intentosUsados + " intentos.");
        } else {
            System.out.println("\n--- ¡Lo siento! ---");
            System.out.println("Has agotado tus 10 intentos.");
            System.out.println("El numero era: " + numeroSecreto);
        }

        scanner.close();
    }
}
