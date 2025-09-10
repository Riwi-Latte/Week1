import java.util.Scanner;

public class conditionsIntnum {
    
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Ingresa un numero");
        
       String numS = input.nextLine();
       
       int num = Integer.parseInt(numS);
       
       if (num > 0){
           System.out.println("Numero positivo");
       }else if (num < 0){
           System.out.println("Numero negativo");
       }else{
           System.out.println("Numero igual a cero");
       }
    }
    
}