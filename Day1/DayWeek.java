package Day1;
import java.util.Scanner;

public class DayWeek {
    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);

        System.out.println("Ingresa un numero del 1 al 7: ");
        int numberUser = number.nextInt();
        number.close();

        switch (numberUser) {
            case 1:
                System.out.println("Lunes");
                break;
            case 2:
                System.out.println("Martes");
                break;
            case 3:
                System.out.println("Miercoles");
                break;
            case 4:
                System.out.println("Jueves");
            case 5:
                System.out.println("Viernes");
                break;
            case 6:
                System.out.println("Sabado");
                break;
            case 7:
                System.out.println("Domingo");
                break;
            default:
                System.out.println("El numero no es valido (Debe ser entre 1 y 7).");
                break;
        }


    }
}

/*Actividad 7 – Switch

Crea un programa que pida un número del 1 al 7 y muestre el día de la semana:

    1 → Lunes
    2 → Martes
    3 → Miércoles
    …
    7 → Domingo
*/