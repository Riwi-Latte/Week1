package Day2.collections;

import java.util.HashMap;
import java.util.Map;

public class TallerHashMap {
    public static void main(String[] args) {

        HashMap<Integer, String> personas = new HashMap<Integer, String>();
        personas.put(102012836, "Pedro");
        personas.put(102121234, "Luisa");
        personas.put(103846392, "Sofia");
        personas.put(175946392, "Tomas");
        
        System.out.println("--- HashMap de personas ---");
        for (Map.Entry<Integer, String> entrada : personas.entrySet()) {
            System.out.println("Documento: " + entrada.getKey() + " -> Nombre: " + entrada.getValue());
        }
    }
}
