package Day2.collections;

import java.util.ArrayList;

public class TallerArrayList {
    public static void main(String[] args) {

        ArrayList<String> nombres = new ArrayList<String>();
        nombres.add("Isabela");
        nombres.add("Mateo");
        nombres.add("Tomas");
        nombres.add("Esteban");

        System.out.println("--- ArrayList de nombres ---");
        System.out.println(nombres);

        System.out.println("\n--- Saludos ---");
        for (String nombre : nombres) {
            System.out.println("Hola, " + nombre);
        }
    }
}
