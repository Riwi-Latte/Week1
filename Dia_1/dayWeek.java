import java.util.Scanner;

public class dayWeek {
    
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Ingresa un numero del 1 al 7 y te dire el dia de la semana");
        
       String day = input.nextLine();
       
       switch (day){
           
           case "1":
               System.out.println("Lunes");
               break;
           case "2":
               System.out.println("Martes");
               break;
           case "3":
               System.out.println("Miercoles");
               break;
           case "4":
               System.out.println("Jueves");
               break;
           case "5":
               System.out.println("Viernes");
               break;
           case "6":
               System.out.println("Sabado");
               break;
           case "7":
               System.out.println("Domingo");
               break;
           default:
               System.out.println("Incorrecto, no coincide con el dia");
       }
    }
}