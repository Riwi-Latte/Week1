public class piramide {
    public static void main(String[] args) {
        int filas = 4; // número de filas de la pirámide

        for (int i = 1; i <= filas; i++) {
            System.out.println(i);

            // Primer bucle: imprime los espacios
            for (int j = 1; j <= filas - i; j++) {
                System.out.println(j);
                System.out.println(filas);

                System.out.print(" ");
            }

            // Segundo bucle: imprime los asteriscos
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.println(k);

                System.out.print("*");
            }

            // Salto de línea después de cada fila
            System.out.println();
        }
    }
}
