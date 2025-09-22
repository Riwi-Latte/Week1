package condicionales;
import java.util.Scanner;

public class actividad5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean validInputFlag = false;
        
        while (!validInputFlag) {
            try {
                System.out.print("Enter a number: ");
                number = scanner.nextInt();
                validInputFlag = true;
            } catch (Exception e) {
                System.out.println("Enter a valid number.");
                scanner.nextLine(); // Clear the invalid input from scanner buffer
            }
        }

        if (number > 0) {
            System.out.println("It's positive");
        } else if (number < 0) {
            System.out.println("It's negative");
        } else {
            System.out.println("It's zero");
        }
        
        scanner.close();
    }
}
