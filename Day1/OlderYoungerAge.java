package Day1;
import java.util.Scanner;

public class OlderYoungerAge{
    public static void main(String[] args) {
        Scanner age = new Scanner(System.in);
        System.out.println("Ingresa tu edad: ");
        int ageUser = age.nextInt();

        if (ageUser < 12) {
            System.out.println("Niño");
        } else if (ageUser >= 12 && ageUser <= 17) {
            System.out.println("Adolescente");
        } else {
            System.out.println("Adulto");
        }
        
        age.close();
    }
}

/*Actividad 6 – If - Else If

Pide al usuario su edad y muestra:

    "Niño" si tiene menos de 12.
    "Adolescente" si tiene entre 12 y 17.
    "Adulto" si tiene 18 o más.
*/ 