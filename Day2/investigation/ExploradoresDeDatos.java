package Day2.investigation;


import java.util.ArrayList;
import java.util.Arrays; 
import java.util.HashMap;
import java.util.Map;

public class ExploradoresDeDatos {
    public static void main(String[] args) {

        System.out.println("--- 1. Array: El Cofre Ordenado ---");
        int[] misNumeros = { 7, 17, 21, 4, 47 };
        System.out.println("Mis numeros favoritos: " + Arrays.toString(misNumeros));

        System.out.println("Primer numero: " + misNumeros[0]); 
        System.out.println("Ultimo numero: " + misNumeros[misNumeros.length - 1]); 

        misNumeros[2] = 99;
        System.out.println("Valor en la posicion 2 despues del cambio: " + misNumeros[2]);
        System.out.println("Nuevo array:" + Arrays.toString(misNumeros));

        System.out.println("\n--- 2. ArrayList: La Mochila Magica ---");
        ArrayList<String> mochila = new ArrayList<String>();

        mochila.add("Espada");
        mochila.add("Mapa");
        mochila.add("Comida");
        System.out.println("Mochila despues de guardar: " + mochila);

        System.out.println("Segundo objeto de la mochila: " + mochila.get(1)); 

        mochila.remove("Mapa");
        System.out.println("Mochila despues de quitar el Mapa: " + mochila);

        System.out.println("\n--- 3. HashMap: El Mapa del Tesoro ---");
        HashMap<String, Integer> tesoros = new HashMap<String, Integer>();

        tesoros.put("Oro", 100);
        tesoros.put("Plata", 50);
        tesoros.put("Diamantes", 5);
        System.out.println("Tesoros guardados: " + tesoros);

        System.out.println("Cantidad de Diamantes: " + tesoros.get("Diamantes"));

        tesoros.put("Oro", 200);
        System.out.println("Tesoros despues de actualizar el Oro: " + tesoros);

        System.out.println("\n--- 4. Desafio Final ---");
        int[] codigosSecretos = { 123, 456, 789 };

        ArrayList<String> exploradores = new ArrayList<String>();
        exploradores.add("Thor");
        exploradores.add("Jachy");
        exploradores.add("Pascual");

        HashMap<String, Integer> oroEncontrado = new HashMap<String, Integer>();
        oroEncontrado.put("Alice", 250);
        oroEncontrado.put("Bob", 300);
        oroEncontrado.put("Charlie", 150);
        System.out.println("Oro encontrado por cada explorador: " + oroEncontrado);

        String exploradorConMasOro = "";
        int maxOro = 0;
        
        for (Map.Entry<String, Integer> entrada : oroEncontrado.entrySet()) {
            if (entrada.getValue() > maxOro) {
                maxOro = entrada.getValue();
                exploradorConMasOro = entrada.getKey();
            }
        }
        System.out.println("El explorador con mas oro es: " + exploradorConMasOro + " con " + maxOro + " monedas.");
    }
}