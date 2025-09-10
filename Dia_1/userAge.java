import java.util.Scanner;

public class userAge {
    
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Ingresa tu edad");
        
       String ageString = input.nextLine();
       
       int age = Integer.parseInt(ageString) ;
       
       boolean min = false;
       boolean max = true;
       
       if (age >= 18){
           System.out.println("Eres mayor de edad " + max);
       }else{
           System.out.println("Eres menor de edad " + min);
       }
        
        
    }
}