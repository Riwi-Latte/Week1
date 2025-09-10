/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package JavaFundamentals;

import java.util.Scanner;

/**
 *
 * @author javaspringboot
 */
public class conditionalsActivity {
    
    public static void mainConditionals(String[] args) {
        firstConditional(args);
        secondConditional(args);
        thirdConditional(args);
    }
    
    public static void firstConditional(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Hello, enter a number");
        int num = input.nextInt();
        
        if (num > 0 ) {
            System.out.println("The number is positive");
        } else if (num < 0) {
            System.out.println("The number is negative");
        } else if (num == 0){
            System.out.println("The number is zero");
        }
    }
    
    public static void secondConditional(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Hello, how old are you?");
        int age = input.nextInt();
        
        if (age < 12) {
            System.out.println("You are a child");
        } else if (age >= 12 && age <= 17) {
            System.out.println("You are a teenager ");
        } else if (age >= 18) {
            System.out.println("You are an adult");
        }
    }
    
    public static void thirdConditional(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Hello, enter a number from 1 to 7");
        String var = input.nextLine();
        
        switch (var) {
            case "1":
                System.out.println("Monday");
                break;
            case "2":
                System.out.println("Tuesday");
                break;
            case "3":
                System.out.println("Wednesday");
                break;
            case "4":
                System.out.println("Thursday");
                break;
            case "5":
                System.out.println("Friday");
                break;
            case "6":
                System.out.println("Saturday");
                break;
            case "7":
                System.out.println("Sunday");
                break;
            
            default:
                System.out.println("Please, enter a number from 1 to 7");
        }
    }
    
    
}
