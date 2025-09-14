package javatrainingweek1;

import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;

public class InventorySystem {

    // Data structures
    static ArrayList<String> productNames = new ArrayList<>();
    static double[] prices = new double[0];
    static HashMap<String, Integer> stock = new HashMap<>();

    // Total sales for ticket
    static double totalSales = 0;

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            String option = JOptionPane.showInputDialog(null,
                    "Inventory Menu:\n"
                    + "1. Add product\n"
                    + "2. List inventory\n"
                    + "3. Buy product\n"
                    + "4. Show statistics\n"
                    + "5. Search product by name\n"
                    + "6. Exit with ticket\n\n"
                    + "Choose an option:", "Inventory System",JOptionPane.PLAIN_MESSAGE);

            if (option == null) {
                break; // user closed
            }

            switch (option) {
                case "1":
                    addProduct();
                    break;
                case "2":
                    listInventory();
                    break;
                case "3":
                    buyProduct();
                    break;
                case "4":
                    showStatistics();
                    break;
                case "5":
                    searchProduct();
                    break;
                case "6":
                    exitWithTicket();
                    running = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Please, enter a valid option");
            }
        }
    }

    // Task 1: add new product
    static void addProduct() {
        try {
            String name = JOptionPane.showInputDialog(null, "Enter product name:", "Add product", JOptionPane.PLAIN_MESSAGE);
            if (name == null || name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Name cannot be empty");
                return;
            }
            if (productNames.contains(name)) {
                JOptionPane.showMessageDialog(null, "Product already exists");
                return;
            }

            double price = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter product price:", "Add product", JOptionPane.PLAIN_MESSAGE));
            if (price <= 0) {
                JOptionPane.showMessageDialog(null, "Price must be greater than 0");
                return;
            }

            int quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter product stock:", "Add product", JOptionPane.PLAIN_MESSAGE));
            if (quantity < 0) {
                JOptionPane.showMessageDialog(null, "Stock cannot be negative");
                return;
            }

            // Add to structures
            productNames.add(name);
            prices = expandPrices(prices, price);
            stock.put(name, quantity);

            JOptionPane.showMessageDialog(null, "Product added successfully");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number format");
        }
    }

    // Expand prices array
    static double[] expandPrices(double[] oldArray, double newPrice) {
        double[] newArray = new double[oldArray.length + 1];
        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }
        newArray[oldArray.length] = newPrice;
        return newArray;
    }

    // List inventory
    static void listInventory() {
        if (productNames.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No products in inventory");
            return;
        }
        StringBuilder sb = new StringBuilder("Inventory:\n");
        for (int i = 0; i < productNames.size(); i++) {
            String name = productNames.get(i);
            double price = prices[i];
            int qty = stock.get(name);
            sb.append((i + 1)).append(". ")
              .append(name).append(" - $")
              .append(price).append(" - Stock: ")
              .append(qty).append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Inventory", JOptionPane.PLAIN_MESSAGE);
    }

    // Buy product
    static void buyProduct() {
        if (productNames.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No products available");
            return;
        }
        String name = JOptionPane.showInputDialog(null, "Enter product name to buy:", "Buy product", JOptionPane.PLAIN_MESSAGE);
        if (name == null || !productNames.contains(name)) {
            JOptionPane.showMessageDialog(null, "Product not found");
            return;
        }
        try {
            int qty = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity:"));
            int currentStock = stock.get(name);
            if (qty <= 0 || qty > currentStock) {
                JOptionPane.showMessageDialog(null, "Invalid quantity or not enough stock");
                return;
            }
            int index = indexOfName(name);
            double cost = prices[index] * qty;
            totalSales += cost;
            stock.put(name, currentStock - qty);

            JOptionPane.showMessageDialog(null, "Purchase successful. Cost: $" + cost);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number format");
        }
    }

    // Show statistics (min and max price)
    static void showStatistics() {
        if (prices.length == 0) {
            JOptionPane.showMessageDialog(null, "No products to analyze");
            return;
        }
        double min = prices[0], max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i];
            if (prices[i] > max) max = prices[i];
        }
        JOptionPane.showMessageDialog(null, "Cheapest price: $" + min + "\nMost expensive price: $" + max);
    }

    // Search product by name (partial matches)
    static void searchProduct() {
        String search = JOptionPane.showInputDialog(null, "Enter name to search:", "Search by name", JOptionPane.PLAIN_MESSAGE);
        if (search == null || search.trim().isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder("Search results:\n");
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).toLowerCase().contains(search.toLowerCase())) {
                sb.append(productNames.get(i))
                  .append(" - $").append(prices[i])
                  .append(" - Stock: ").append(stock.get(productNames.get(i)))
                  .append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    // Exit with ticket
    static void exitWithTicket() {
        JOptionPane.showMessageDialog(null, "Final ticket\nTotal sales: $" + totalSales, "Your ticket", JOptionPane.PLAIN_MESSAGE);
    }

    // Get index of product name in ArrayList
    static int indexOfName(String name) {
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
