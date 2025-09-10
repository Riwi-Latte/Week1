import java.util.Scanner;

public class conditionsAge {
    
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Ingresa tu edad");
        
       String ageString = input.nextLine();
       
       int age = Integer.parseInt(ageString) ;
       
       if (age < 12){
           System.out.println("Eres niño");
       }else if (age > 11 && age < 18){
           System.out.println("Eres adolescente");
       }else{
           System.out.println("Eres adulto");
       }
    }
    
}
