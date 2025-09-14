package JavaActivity;

import java.util.Scanner;

public class fitProGym {

    public static void main(String[] args) {
        discounts(args);
    }
    
    public static void data(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("What's your name?");
        String name = input.nextLine();
        System.out.println("How old are you?");
        int age = input.nextInt();
        System.out.println("How tall are you?");
        double height = input.nextDouble();
        System.out.println("how weight are you?");
        double weigth = input.nextDouble();
        System.out.println("What's your plan? (Basic, Plus, Premium)");
        String plan = input.nextLine();
        System.out.println("Is your first time? (True or False)");
        boolean firstTime = input.nextBoolean();
    }

    public static void discounts(String[] args) {
        data(args);

        
    }
}