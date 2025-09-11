import java.util.Scanner;

/**
 *
 * @author javaspringboot
 */
public class fitProGym {
    
    public static void main(String[] args){
        
         Scanner input = new Scanner(System.in);
        
        System.out.println("Bienvenido a FitPro Gym");
        System.out.println("Cotiza aqui!");
        System.out.println("Ingresa tu nombre");
        
        String name = input.nextLine();
       
        System.out.println("Ingresa tu edad");
        
        String ageString = input.nextLine();
        
        int age = Integer.parseInt(ageString);
        
        System.out.println("Ingresa tu estatura en metros");
        
        String estatureString = input.nextLine();
        
        double estature = Float.parseFloat(estatureString);
        
        System.out.println("Ingresa tu peso en kg");
        
        String weightString = input.nextLine();
        
        double weight = Float.parseFloat(weightString);

        System.out.println("¿Que plan deseas tomar?(Ingresa un numero del 1 al 3)");
        System.out.println("1.Basico 80.0");
        System.out.println("2.Plus 120.0");
        System.out.println("3.Premium 180.0");
        
        String planOption = input.nextLine();
        
        System.out.println("Es tu primera vez en el gym? true = si/false = no");
       
        String firstTime = input.nextLine();
        
        boolean first = Boolean.parseBoolean(firstTime);
        
        if (first == true){
            
            System.out.println("Primera vez");
           
        }else if ( first == false){
            
            System.out.println("Usuario antiguo");
            
        }else{
            System.out.println("Equivocado, escribe true o false ");
        }
        
        
        
        if (age < 14){
            
            System.out.println("No elegible");
        }else if (age < 18){
            
            System.out.println("Requiere autorización de acudiente");
        }
        
        double discount = 0.0;
        
        if ((age <= 25 && age >= 16) && (first == true)){
            
            discount = 0.20;
        }else if (age <= 25 && age >= 16){
            
            discount = 0.10;
        }else if (first == true){
            
            discount = 0.10;
        }
       
        double plan = 0;
        String namePlan = "";
        
        switch (planOption){
            
            case "1":
                
                plan = 80.0;
                namePlan = "Basico";
                System.out.println(namePlan + " " + plan);
                break;
            
            case "2":
                
                plan = 120.0;
                namePlan = "Plus";
                System.out.println(namePlan + " " + plan);
                break;
                
            case "3":
                plan = 180.0;
                namePlan = "Premium";
                System.out.println(namePlan + " "+ plan);
                break;
                
            default:
                System.out.println("Caracter incorrecto");
                break;
        }

        
        double bmi = (weight / (estature * estature));
        
        double price = plan-(plan * discount);
        
        String categoryBmi = "";
        
        if (bmi < 18.5){
            
            categoryBmi = "Bajo peso";
        }else if (bmi <= 24.9){
            
            categoryBmi = "Normal";
        }else if (bmi >= 25 && bmi < 29.9){
            
            categoryBmi = "Sobrepeso";
        }else{
            categoryBmi = "Obesidad";
        }
        
       
            System.out.println("Cotizacion");
            System.out.println("Nombre: " + name);
            System.out.println("Plan: " + namePlan);
            System.out.println("Precio del plan : " + plan);
            System.out.println("Descuento: " + discount*100);
            System.out.println("Precio total: " + price);
            System.out.println("Bmi: " + categoryBmi);

        
    }
}
