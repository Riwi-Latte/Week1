package condicionales;
import java.util.Scanner;

public class actividad7 {
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        int number = 0;
        boolean validInputFlag = false;

        while (!validInputFlag) {
            try {
                System.out.println("Enter a number");
                number = scanner.nextInt();
                validInputFlag = true;
            } catch (Exception e) {
                System.out.println("Enter a valid number");
                scanner.nextLine();
            }
        }


        switch (number) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Invalid day number");
        }
    }
}
