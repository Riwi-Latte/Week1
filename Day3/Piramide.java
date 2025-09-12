package Day3;

public class Piramide {
    public static void main(String[] args) {

        int filas = 4;

        for (int i = 0; i < filas; i++) {

          
            for (int j = 0; j < (filas - 1) - i; j++) {
                System.out.print(" ");
            }

           
            for (int k = 0; k < (2 * i) + 1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}