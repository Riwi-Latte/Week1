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
public class operatorsActivity {
    public static void mainOperators(String[] args) {
        firstOperator(args);
        secondOperator(args);
        thirdOperator(args);
    }
    
    public static void firstOperator(String[] args) {
        int a = 6;
        int b = 3;
        
        System.out.println("6+3="+(a+b));
        System.out.println("6-3="+(a-b));
        System.out.println("6*3="+(a*b));
        System.out.println("6/3="+(a/b));
        System.out.println("6%3="+(a%b));
    }
    
    public static void secondOperator(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Hello, how old are you?");
        int age = input.nextInt();
        
        if (age >= 18) {
            System.out.println(true);
        } else if (age < 18)
            System.out.println(false);
        
    }
    
    public static void thirdOperator(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Hello, enter the first number");
        int number1 = input.nextInt();
        System.out.println("Hello, enter the second number");
        int number2 = input.nextInt();
        
        if (number1 > 0 && number2 > 0) {
            System.out.println("Both numbers are greather than to 0");
        } else if (number1 > 100 || number2 > 100) {
            System.out.println("At least one number is greatest that 100");
        } else if (number1 != number2) {
            System.out.println("The first number not same than second");
        }
    }
}
