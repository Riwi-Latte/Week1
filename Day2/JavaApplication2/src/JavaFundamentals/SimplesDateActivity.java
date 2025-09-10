/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package JavaFundamentals;


/**
 *
 * @author javaspringboot
 */
public class SimplesDateActivity {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        personalData(args);
        operatorsActivity.mainOperators(args);
        conditionalsActivity.mainConditionals(args);
        
    }
    
    public static void personalData(String[] args) {
        String name = "Tomás Loaiza";
        int age = 21;
        double weigth = 1.73;
        boolean student = true;
        char initial = 'T';
        
        System.out.println("Hello, my name is "+name+", I am "+age+" years old, I am "+weigth+" meters tall, and my initial is "+initial);
    }
    
}
