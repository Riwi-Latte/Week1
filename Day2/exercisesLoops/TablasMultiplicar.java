package Day2.exercisesLoops;

public class TablasMultiplicar {
    public static void main(String[] args) {
        
        System.out.println("--- Tablas de Multiplicar del 1 al 5 ---");
        
        for (int i = 1; i <= 5; i++) {
            System.out.println("\nTabla del " + i + ":");
            
            for (int j = 1; j <= 10; j++) {
                int resultado = i * j;
                System.out.println(i + " x " + j + " = " + resultado);
            }
        }
    }
}
