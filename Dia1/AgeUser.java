package Dia1;
import java.util.Scanner;

public class AgeUser {
    public static void main(String[] args) {
        Scanner age = new Scanner(System.in);
        System.out.println("Ingresa tu edad: ");
        int ageUser = age.nextInt();

        if (ageUser >= 18) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

        age.close();
    }
}


/*Actividad 3

Pide al usuario su edad e imprime:

    true si es mayor o igual a 18.
    false si es menor.
 */