import java.util.Scanner;

public class adivinar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int secreto =  56; // número aleatorio 1-100
       

        System.out.println("Adivina el número (1-100). Escribe 0 para salir.");

        do {
            System.out.print("Número: ");
            int intento = sinput.nextInt();

            if (intento == 0) break; // salir si pone 0

            if (intento == secreto) {
                System.out.println("¡Correcto!");
            } else if (Math.abs(intento - secreto) <= 5) {
                System.out.println("¡Muy cerca!");
            } else {
                System.out.println("Fallaste, intenta otra vez.");
            }

        } while (intento != secreto);

        System.out.println("El número secreto era: " + secreto);
    }
}
