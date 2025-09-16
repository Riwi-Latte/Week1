/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loops;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author chico
 */
public class Loops {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //firstLoop();
        //secondLoop();
        //thirdLopp();
        //fourthLoop();
        //fifthLoop();
        //sixthLoop();
        //seventhLoop();
        //eighthLoop();
        //ninthLoop();
        tenthLoop();
    }
    
    public static void firstLoop() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = input.nextInt();
        int factorial = 1;
        
        for (int i = 1; i <= number; i++) {
            factorial = factorial * i;
        }
        System.out.println("The factorial of: "+ number +" = " + factorial);
    }
    
    public static void secondLoop() {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int attemps = 0;
        int min = 1;
        int max = 100;
        int numberRandom = random.nextInt(max - min + 1) + min;
        
        for (int i = 9; i >= 0; i--) {
            attemps = attemps + 1;
            System.out.println("Enter a number: ");
            int number = input.nextInt();
            if (number == numberRandom) {
                System.out.println("Congratulations, you guessed the number in "+ attemps + " attemps.");
                break;
            } else if (i == 0) {
                System.out.println("You lost, the number is: "+ numberRandom);
            } else if (number < numberRandom) {
                System.out.println("The number is greater, you have "+i+" attemps left.");
            } else if (number > numberRandom) {
                System.out.println("The number is smaller, you have "+i+" attemps left.");
            }
        }
    }
    
    public static void thirdLopp() {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        int sum = 0;
        double average = 0;
        while(true) {
            System.out.println("Enter a number: ");
            int number = input.nextInt();
            if (number != 0) {
                numbers.add(number);
            } else if (number == 0) {
                for (int num : numbers) {
                    sum += num;
                }
                average = sum/numbers.size();
                System.out.println("The sum of the numbers is: "+sum+" \nthe average of numbers is: "+average);
                break;
            }
        }
    }
    
    public static void fourthLoop() {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> numbersGreater = new ArrayList<>();
        ArrayList<Integer> numbersSmaller = new ArrayList<>();
        ArrayList<Integer> numbersEqual = new ArrayList<>();
        System.out.println("How many numbers do you want to enter");
        int quantNumbers = input.nextInt();
        for (int i = 0; i < quantNumbers; i ++) {
            System.out.println("Enter a number:");
            int number = input.nextInt();
            if (number > 0) {
                numbersGreater.add(number);
            } else if (number < 0) {
                numbersSmaller.add(number);
            } else if (number == 0) {
                numbersEqual.add(number);
            }
        }
        System.out.println(numbersGreater.size()+" numeros son mayores a 0\n"
                +numbersSmaller.size()+" numeros son menores que 0\n"
                +numbersEqual.size()+" numeros son iguales a 0.");
    }
    
    public static void fifthLoop() {
        Scanner input = new Scanner(System.in);
        String vowels = "aeiou";
        String noVowels = "bcdfghjklmnpqrstvwxyz";
        System.out.println("Enter a letter");
        String character = input.nextLine();
        if (vowels.contains(character.toLowerCase())) {
            System.out.println("Is a vowel");
        } else if (noVowels.contains(character.toLowerCase())) {
            System.out.println("Not is a vowel");
        } else {
            System.out.println("Not is a letter");
        }
    }
    
    public static void sixthLoop() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first number");
        int number1 = input.nextInt();
        System.out.println("Enter the second number");
        int number2 = input.nextInt();
    
    }
    
    public static void seventhLoop() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number");
        int number = input.nextInt();
        for (int i = 1; i <= 10; i++) {
            int result = number * i;
            System.out.println(number+"*"+i+"="+result);
        }
    }
    
    public static void eighthLoop() {
        Scanner input = new Scanner(System.in);    
        ArrayList<Integer> numberOnInterval = new ArrayList<>();
        ArrayList<Integer> numberNotInterval = new ArrayList<>();
        ArrayList<Integer> numberEqualInterval = new ArrayList<>();
        int lower = 0;
        int upper = 0;
        int sum = 0;
        while(true) {
            System.out.println("Enter the lower interval");
            lower = input.nextInt();
            System.out.println("Enter the upper interval");
            upper = input.nextInt();        
            if (lower > upper) {
                System.out.println("Please, the lower interval must be less tahn the upper interval");
            } else {
                break;
            }            
        }
        while(true) {
            System.out.println("Enter a number");
            int number = input.nextInt();
            if (number == 0) {
                break;
            } else if (number > lower && number < upper) {
                numberOnInterval.add(number);
            } else if (number < lower || number > upper) {
                numberNotInterval.add(number);
            } else if (number == lower || number == upper) {
                numberEqualInterval.add(number);
            } else if (number == 0){
                break;
            }
        }
        
        for (int numbers : numberOnInterval) {
            sum += numbers;
        }
        System.out.println("The sum of the numbers within the interval is: "+sum);
        System.out.println(numberNotInterval.size()+" numbers are outside the interval");
        System.out.println("You have entered "+numberEqualInterval.size()+" numbers equal to the extremes of the interval");
    }
    
    public static void ninthLoop() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the base number");
        int base = input.nextInt();
        System.out.println("Enter the exponent number");
        int exponent = input.nextInt();
        int result = base;
        for (int i = 1; i < exponent; i++) {
            result *= base;
        }
        System.out.println("The enhancement of "+base+" a la " +exponent+" es: "+result);
    }
    
    public static void tenthLoop() {
        int result = 0;
        for (int i = 1; i < 5;i++){
            System.out.println("Tabla de multiplicar del "+i);
            for (int j = 1; j <= 10;j++){
                result = i*j;
                System.out.println(i+"*"+j+"="+result);
            }
        }
    }
    
}
