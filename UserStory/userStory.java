import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class userStory {

    // --- Estructuras de datos ---
    static ArrayList<String> nombres = new ArrayList<>();       // nombres de productos
    static double[] precios = new double[0];                    // precios sincronizados
    static HashMap<String, Integer> stock = new HashMap<>();    // stock por producto
    static double totalVentas = 0;                              // acumulado de compras

    public static void main(String[] args) {
        menuPrincipal();
    }

    
    public static double[] expandPrecios(double[] oldArr, double nuevoPrecio) {
        double[] nuevoArr = new double[oldArr.length + 1];
        for (int i = 0; i < oldArr.length; i++) {
            nuevoArr[i] = oldArr[i];
        }
        nuevoArr[oldArr.length] = nuevoPrecio;
        return nuevoArr;
    }


    public static int indexOfNombre(String nombre) {
        return nombres.indexOf(nombre);
    }

    // ---------------- MENÚ ----------------
    public static void menuPrincipal() {
        String opcion;
        do {
            opcion = JOptionPane.showInputDialog(
                    "=== INVENTARIO ===\n" +
                    "1. Agregar producto\n" +
                    "2. Listar inventario\n" +
                    "3. Comprar producto\n" +
                    "4. Mostrar estadísticas\n" +
                    "5. Buscar producto\n" +
                    "6. Salir\n\n" +
                    "Elige una opción:"
            );

            switch (opcion) {
                case "1": agregarProducto(); break;
                case "2": listarInventario(); break;
                case "3": comprarProducto(); break;
                case "4": mostrarEstadisticas(); break;
                case "5": buscarProducto(); break;
                case "6": salir(); break;
                default: JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (!"6".equals(opcion));
    }

    // ---------------- OPCIONES DEL MENÚ ----------------
    public static void agregarProducto() {
        
        String nombre = JOptionPane.showInputDialog("Nombre del producto:");
        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nombre inválido.");
            return;
        }
        if (nombres.contains(nombre)) {
            JOptionPane.showMessageDialog(null, "El producto ya existe.");
            return;
        }

        double precio = Double.parseDouble(JOptionPane.showInputDialog("Precio del producto:"));
        if (precio <= 0) {
            JOptionPane.showMessageDialog(null, "Precio inválido.");
            return;
        }

        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Stock inicial:"));
        if (cantidad < 0) {
            JOptionPane.showMessageDialog(null, "Stock inválido.");
            return;
        }

        // Guardar en estructuras
        nombres.add(nombre);
        precios = expandPrecios(precios, precio);
        stock.put(nombre, cantidad);

        JOptionPane.showMessageDialog(null, "Producto agregado con éxito.");
        
    }

    static void listarInventario() {
        if (nombres.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Inventario vacío.");
            return;
        }

        StringBuilder sb = new StringBuilder("=== INVENTARIO ===\n");
        for (int i = 0; i < nombres.size(); i++) {
            String nombre = nombres.get(i);
            double precio = precios[i];
            int cantidad = stock.get(nombre);
            sb.append((i + 1)).append(". ")
              .append(nombre).append(" | $")
              .append(precio).append(" | Stock: ")
              .append(cantidad).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    static void comprarProducto() {
        if (nombres.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos disponibles.");
            return;
        }

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto a comprar:");
        int index = indexOfNombre(nombre);

        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Producto no encontrado.");
            return;
        }

        
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad a comprar:"));
        int disponible = stock.get(nombre);

        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(null, "Cantidad inválida.");
            return;
        }
        if (cantidad > disponible) {
            JOptionPane.showMessageDialog(null, "Stock insuficiente.");
            return;
        }

        // Procesar compra
        stock.put(nombre, disponible - cantidad);
        double subtotal = precios[index] * cantidad;
        totalVentas += subtotal;

        JOptionPane.showMessageDialog(null, "Compra realizada.\nSubtotal: $" + subtotal);
        
    }

    static void mostrarEstadisticas() {
        if (nombres.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos para analizar.");
            return;
        }

        double min = precios[0];
        double max = precios[0];
        String prodMin = nombres.get(0);
        String prodMax = nombres.get(0);

        for (int i = 1; i < precios.length; i++) {
            if (precios[i] < min) {
                min = precios[i];
                prodMin = nombres.get(i);
            }
            if (precios[i] > max) {
                max = precios[i];
                prodMax = nombres.get(i);
            }
        }

        JOptionPane.showMessageDialog(null,
                "Producto más barato: " + prodMin + " ($" + min + ")\n" +
                "Producto más caro: " + prodMax + " ($" + max + ")");
    }

    static void buscarProducto() {
        if (nombres.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay productos.");
            return;
        }

        String query = JOptionPane.showInputDialog("Ingrese el nombre: ");
        if (query == null || query.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "No puede estar vacio el campo.");
            return;
        } 
            
            

        String mensaGet = "";
        boolean encontrado = false;

        for (int i = 0; i < nombres.size(); i++) {
            if (nombres.get(i).toLowerCase().contains(query.toLowerCase())) {
                encontrado = true;
                mensaGet = "Nombre: "+nombres.get(i) +"\n"+"$Precio: " + precios[i] + "\n"+"Stock:" + stock.get(nombres.get(i)) + "\n";
                //sb.append(nombres.get(i))
                //  .append(" | $").append(precios[i])
                //  .append(" | Stock: ").append(stock.get(nombres.get(i)))
                //  .append("\n");
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontraron coincidencias.");
        } else {
            JOptionPane.showMessageDialog(null, mensaGet.toString());
        }
    }

    static void salir() {
        JOptionPane.showMessageDialog(null,
                "Gracias por usar el sistema.\n" +
                "Total de ventas: $" + totalVentas);
        System.exit(0);
    }
}
