package Day3;

import java.util.HashMap;

public class FrecuenciaPalabras {
    public static void main(String[] args) {

        String[] palabras = {"hola", "mundo", "Hola", "Java", "mundo", "java", "hola"};

        HashMap<String, Integer> frecuencia = new HashMap<>();

        for (String palabra : palabras) {
            
            palabra = palabra.toLowerCase();

            if (frecuencia.containsKey(palabra)) {
                int contador = frecuencia.get(palabra);
                frecuencia.put(palabra, contador + 1);
            } else {
                frecuencia.put(palabra, 1);
            }
        }
        
        System.out.println("Frecuencia de las palabras:");
        System.out.println(frecuencia);
    }
}