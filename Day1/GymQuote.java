package Day1;
import java.util.Scanner;

public class GymQuote {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("-----------------------------------");
        System.out.println("  Bienvenido al Cotizador FitPro Gym");
        System.out.println("-----------------------------------");
        
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();
        
        if (edad < 14) {
            System.out.println("--------------------------------------------------------");
            System.out.println("¡Lo sentimos! No es elegible. La edad mínima es 14 años.");
            System.out.println("--------------------------------------------------------");
            scanner.close();
            return; 
        }
        
        if (edad < 18) {
            System.out.println("----------------------------------------------");
            System.out.println("¡Atención! Requiere autorización de acudiente.");
            System.out.println("----------------------------------------------");
        }
        
        System.out.print("Ingrese su altura en metros (ej. 1,75): ");
        double altura = scanner.nextDouble();
        
        System.out.print("Ingrese su peso en kg (ej. 70,5): ");
        double peso = scanner.nextDouble();
        
        scanner.nextLine(); 
        
        System.out.print("Ingrese el plan deseado (BASICO, PLUS, PREMIUM): ");
        String plan = scanner.nextLine().toUpperCase();
        
        System.out.print("¿Es la primera vez que se inscribe? (true/false): ");
        boolean primeraVez = scanner.nextBoolean();
        
        double precioBase = 0.0;
        double descuentoTotal = 0.0;
        
        switch (plan) {
            case "BASICO":
                precioBase = 80.0;
                break;
            case "PLUS":
                precioBase = 120.0;
                break;
            case "PREMIUM":
                precioBase = 180.0;
                break;
            default:
                System.out.println("Plan no válido. Se asignará el plan BÁSICO por defecto.");
                precioBase = 80.0;
                break;
        }
        
        double descuentoPrimeraVez = 0.0;
        double descuentoJoven = 0.0;
        
        if (primeraVez) {
            descuentoPrimeraVez = 0.10 * precioBase;
            descuentoTotal += descuentoPrimeraVez;
        }
        
        if (edad >= 16 && edad <= 25) {
            descuentoJoven = 0.10 * precioBase;
            descuentoTotal += descuentoJoven;
        }
        
        if (descuentoTotal > (0.20 * precioBase)) {
            descuentoTotal = 0.20 * precioBase;
        }
        
        double precioFinal = precioBase - descuentoTotal;
        
        double bmi = peso / (altura * altura);
        String categoriaBmi;
        
        if (bmi < 18.5) {
            categoriaBmi = "Bajo peso";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            categoriaBmi = "Normal";
        } else if (bmi >= 25 && bmi <= 29.9) {
            categoriaBmi = "Sobrepeso";
        } else {
            categoriaBmi = "Obesidad";
        }
        
        System.out.println("\n-----------------------------------");
        System.out.println("       Resumen de Cotización");
        System.out.println("-----------------------------------");
        System.out.println("Nombre: " + nombre);
        System.out.println("Plan elegido: " + plan);
        System.out.printf("Precio base: $%.2f%n", precioBase);
        System.out.printf("Descuento aplicado: $%.2f%n", descuentoTotal);
        System.out.printf("Precio final: $%.2f%n", precioFinal);
        System.out.println("-----------------------------------");
        System.out.printf("Su BMI es: %.2f%n", bmi);
        System.out.println("Categoría BMI: " + categoriaBmi);
        System.out.println("-----------------------------------");
        
        scanner.close();
    }
}
