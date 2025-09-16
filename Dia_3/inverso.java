import java.util.Scanner;

public class inverso {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

      
        System.out.print("Ingresa un número entero: ");
        int numero = input.nextInt();
        int original = numero;  

    
        int invertido = 0;
        while (numero != 0) {
            int digito = numero % 10;         
            System.out.println(digito);
            System.out.println(numero);
            invertido = invertido * 10 + digito; 
            System.out.println(invertido);
            System.out.println(numero);
            numero /= 10;                     
            System.out.println(numero);
        }

       
        System.out.println("Número invertido: " + invertido);

      
        if (original == invertido) {
            System.out.println("El número ES capicúa.");
        } else {
            System.out.println("El número NO es capicúa.");
        }
    }
}
