package condicionales;

import java.util.Scanner; // Add this import

public class actividad6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        if (age < 12) {
            System.out.println("You're a child");
        } else if (age >= 12 && age <= 17) { 
            System.out.println("You're a teenager");
        } else if (age >= 18 && age < 65) {
            System.out.println("You're an adult");
        } else { // 65 and above
            System.out.println("You're a senior");
        }
        
        scanner.close();
    }
}