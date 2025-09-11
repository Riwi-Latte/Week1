package Day1;
import java.util.Scanner;

public class ClassifierNumber {
    public static void main(String[] args) {

        Scanner number = new Scanner(System.in);

        System.out.println("Ingresa un numero: ");
        int numberUser = number.nextInt();

        if (numberUser > 0) {
            System.out.println("El numero "+ numberUser + " es positivo.");
        }else if (numberUser < 0){
            System.out.println("El numero "+ numberUser + " es negativo.");
        }else{
            System.out.println("El numero "+ numberUser + " es cero.");
        }
        
        number.close();
    }
}

/* Actividad 5 – If - Else

Haz un programa que reciba un número entero e imprima:

    "Es positivo" si el número es mayor que 0.
    "Es negativo" si es menor que 0.
    "Es cero" si es exactamente 0.
*/
