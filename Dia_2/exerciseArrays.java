import java.util.Scanner;

import java.util.ArrayList;

import java.util.HashMap;


public class exerciseArrays {
    
    public static void main(String[] args){
        
        //Taller de practica
        //Arrays
        int[] numbers = {2,5,3,9,10};
        
        
        for ( int i = 0; i < numbers.length;  i++){
           System.out.println(numbers[i]*2);
            
        }
                      
                
        int[] nums = {0,0,0,0,0,0};
        
        for (int i = 0; i < nums.length;i++){
            
            
            
            Scanner input = new Scanner(System.in);
        
            System.out.println("Ingresa un numero: ");
        
            int n = input.nextInt();
            nums[i] = n;
        }
        
        
        System.out.println("Lista de numeros");
        for(int num : nums){
            System.out.println("Numero:" + num);
        }
        
                        
        //ArrayList
        
        ArrayList<String> nombres = new ArrayList<>();
        
        nombres.add("Isabella");
        nombres.add("Adrian");
        nombres.add("Esteban");
        nombres.add("Maria");
        nombres.add("Brandon");
        
        System.out.println(nombres);
        
        nombres.forEach(nombre -> System.out.println("Hola " + nombre));

        
        //HashMap
        
        HashMap<Integer, String> people = new HashMap<>();
        
        people.put(58214, "Isabella");
        people.put(98723, "Adrian");
        people.put(10584, "Luz");
        people.put(16005, "Laura");
        
        for(var person : people.entrySet()){

            System.out.println("Documento: " + person.getKey() + " Nombre: " + person.getValue());
        }

    }
}