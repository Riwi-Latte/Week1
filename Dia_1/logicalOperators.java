import java.util.Scanner;

public class logicalOperators {
    
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Ingresa el primer numero");
        
       String num1S = input.nextLine();
       
       int num1 = Integer.parseInt(num1S) ;
       
       System.out.println("Ingresa el segundo numero");
        
       String num2S = input.nextLine();
       
       int num2 = Integer.parseInt(num2S) ;
       
       if (num1 > 100 || num2 > 100){
           System.out.println("Al menos uno de los numeros es mayor a 100");
       }else if (num1 >= 0 && num2 >= 0){
           System.out.println("Ambos numeros son positivos");
       }else if (num1 != num2){
           System.out.println("Los numeros no son iguales");
       }else{
           System.out.println("Pasaste las validaciones");
       }
       
       
        
    }
    
}