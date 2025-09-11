package Day2.exercisesLoops;

import java.util.Scanner;

public class ClasificadorNumeros {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int cantidad;
        int numero;
        int mayoresCero = 0;
        int menoresCero = 0;
        int igualesCero = 0;

        System.out.print("¿Cuantos numeros quieres introducir?: ");
        cantidad = scanner.nextInt();

        System.out.println("--- Ingresa los numeros ---");

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingresa el numero #" + (i + 1) + ": ");
            numero = scanner.nextInt();

            if (numero > 0) {
                mayoresCero++;
            } else if (numero < 0) {
                menoresCero++;
            } else {
                igualesCero++;
            }
        }

        scanner.close();

        System.out.println("\n--- Informe de numeros ---");
        System.out.println("Numeros mayores que 0: " + mayoresCero);
        System.out.println("Numeros menores que 0: " + menoresCero);
        System.out.println("Numeros iguales a 0: " + igualesCero);
    }
}
