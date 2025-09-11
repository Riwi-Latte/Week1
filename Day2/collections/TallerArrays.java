package Day2.collections;

import java.util.Scanner;
import java.util.Arrays; 

public class TallerArrays {
    public static void main(String[] args) {

        int[] numeros = {1, 2, 3, 4, 5};

        System.out.println("--- Array: numeros multiplicados por 2 ---");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i] * 2);
        }

        System.out.println("\n--- Array: llenar por consola ---");
        int[] numerosUsuario = new int[6];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numerosUsuario.length; i++) {
            System.out.print("Ingrese el numero para la posicion " + i + ": ");
            numerosUsuario[i] = scanner.nextInt();
        }

        System.out.println("El array final es: " + Arrays.toString(numerosUsuario));
        
        scanner.close();
    }
}