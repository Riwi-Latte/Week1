package Day2.exercisesLoops;

import java.util.Scanner;

public class AnalisisIntervalo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limiteInferior, limiteSuperior;
        int numero;
        int sumaDentro = 0;
        int fueraIntervalo = 0;
        boolean igualLimite = false;

        System.out.println("--- Analisis de Intervalo ---");

        do {
            System.out.print("Ingresa el limite inferior del intervalo: ");
            limiteInferior = scanner.nextInt();
            System.out.print("Ingresa el limite superior del intervalo: ");
            limiteSuperior = scanner.nextInt();

            if (limiteInferior > limiteSuperior) {
                System.out.println("Error: El limite inferior no puede ser mayor que el superior. Intenta de nuevo.");
            }
        } while (limiteInferior > limiteSuperior);

        System.out.println("\nIngresa numeros. Ingresa 0 para terminar.");
        do {
            System.out.print("Ingresa un numero: ");
            numero = scanner.nextInt();

            if (numero == 0) {
                break; 
            }

            if (numero > limiteInferior && numero < limiteSuperior) {
                sumaDentro += numero;
            } else {
                fueraIntervalo++;
            }

            if (numero == limiteInferior || numero == limiteSuperior) {
                igualLimite = true;
            }

        } while (true); 

        scanner.close();

        System.out.println("\n--- Resultados ---");
        System.out.println("La suma de los numeros dentro del intervalo es: " + sumaDentro);
        System.out.println("Numeros fuera del intervalo: " + fueraIntervalo);
        if (igualLimite) {
            System.out.println("Se introdujo al menos un numero igual a los limites.");
        } else {
            System.out.println("No se introdujo ningun numero igual a los limites.");
        }
    }
}