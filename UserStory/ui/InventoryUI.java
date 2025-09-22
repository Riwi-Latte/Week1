package UserStory.ui;

import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import UserStory.models.Product;
import UserStory.services.InventoryService;

public class InventoryUI {
    private InventoryService inventoryService;  // Service to handle business logic
    private DecimalFormat df;                   // Format decimal numbers
    
    public InventoryUI() {
        this.inventoryService = new InventoryService();
        this.df = new DecimalFormat("#.##");
    }
    
    /**
     * Start the application - main entry point for UI
     */
    public void start() {
        // Welcome message
        JOptionPane.showMessageDialog(null, 
            "Welcome to Inventory Management System!\n" +
            "Welcome", 
            "Welcome", 
            JOptionPane.INFORMATION_MESSAGE);
        
        // Main program loop
        boolean running = true;
        while (running) {
            running = showMainMenu();
        }
        
        // Show final ticket when exiting
        showFinalTicket();
    }
    
    /**
     * Display the main menu and handle user selection
     * @return true to continue running, false to exit
     */
    private boolean showMainMenu() {
        String menu = "=== INVENTORY MANAGEMENT SYSTEM ===\n\n" +
                     "Select an option:\n" +
                     "1. Add Product\n" +
                     "2. List Inventory\n" +
                     "3. Buy Product\n" +
                     "4. Show Statistics\n" +
                     "5. Search Product\n" +
                     "6. Exit\n\n" +
                     "Enter your choice (1-6):";
        
        String choice = JOptionPane.showInputDialog(null, menu, "Main Menu", JOptionPane.QUESTION_MESSAGE);
        
        // Handle if user cancels or closes dialog
        if (choice == null) {
            return false;
        }
        
        try {
            int option = Integer.parseInt(choice.trim());
            
            switch (option) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    listInventory();
                    break;
                case 3:
                    buyProduct();
                    break;
                case 4:
                    showStatistics();
                    break;
                case 5:
                    searchProduct();
                    break;
                case 6:
                    return false; // Exit the program
                default:
                    JOptionPane.showMessageDialog(null, 
                        "Invalid option! Enter a number between 1 and 6.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, 
                "Enter a valid number!", 
                "Invalid Input", 
                JOptionPane.ERROR_MESSAGE);
        }
        
        return true;
    }
    
    /**
     * Handle add product functionality
     */
    private void addProduct() {
        // Get product name
        String name = JOptionPane.showInputDialog(null, 
            "Enter product name:", 
            "Add Product", 
            JOptionPane.QUESTION_MESSAGE);
        
        if (name == null) return; // User cancelled
        
        // Get product price
        String priceStr = JOptionPane.showInputDialog(null, 
            "Enter price for '" + name.trim() + "':", 
            "Add Product", 
            JOptionPane.QUESTION_MESSAGE);
        
        if (priceStr == null) return; // User cancelled
        
        // Get initial stock
        String stockStr = JOptionPane.showInputDialog(null, 
            "Enter initial stock for '" + name.trim() + "':", 
            "Add Product", 
            JOptionPane.QUESTION_MESSAGE);
        
        if (stockStr == null) return; // User cancelled
        
        // Use service to add product with validation
        InventoryService.AddResult result = inventoryService.addProduct(name, priceStr, stockStr);
        
        if (result.isSuccess()) {
            // Success message
            JOptionPane.showMessageDialog(null, 
                "Product added successfully!\n\n" +
                "Name: " + name.trim() + "\n" +
                "Price: $" + priceStr.trim() + "\n" +
                "Stock: " + stockStr.trim() + " units", 
                "Success", 
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Error message
            JOptionPane.showMessageDialog(null, 
                result.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Handle list inventory functionality
     */
    private void listInventory() {
        if (inventoryService.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                "No products in inventory yet!\nAdd some products first.", 
                "Empty Inventory", 
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        ArrayList<Product> products = inventoryService.getAllProducts();
        StringBuilder inventory = new StringBuilder();
        inventory.append("=== CURRENT INVENTORY ===\n\n");
        
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            inventory.append((i + 1)).append(". ")
                    .append(product.getName())
                    .append("\n   Price: $").append(df.format(product.getPrice()))
                    .append("\n   Stock: ").append(product.getStock()).append(" units")
                    .append("\n\n");
        }
        
        JOptionPane.showMessageDialog(null, 
            inventory.toString(), 
            "Inventory List", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Handle buy product functionality
     */
    private void buyProduct() {
        if (inventoryService.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                "No products available for purchase!\nAdd some products first.", 
                "Empty Inventory", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Show available products
        ArrayList<Product> products = inventoryService.getAllProducts();
        StringBuilder availableProducts = new StringBuilder();
        availableProducts.append("Available products:\n\n");
        
        for (Product product : products) {
            if (product.getStock() > 0) {
                availableProducts.append("• ").append(product.getName())
                        .append(" (").append(product.getStock()).append(" available)")
                        .append(" - $").append(df.format(product.getPrice()))
                        .append("\n");
            }
        }
        
        String productName = JOptionPane.showInputDialog(null, 
            availableProducts.toString() + "\nEnter product name to buy:", 
            "Buy Product", 
            JOptionPane.QUESTION_MESSAGE);
        
        if (productName == null) return; // User cancelled
        
        String quantityStr = JOptionPane.showInputDialog(null, 
            "Enter quantity to buy:", 
            "Buy Product", 
            JOptionPane.QUESTION_MESSAGE);
        
        if (quantityStr == null) return; // User cancelled
        
        // Process purchase using service
        InventoryService.PurchaseResult result = inventoryService.processPurchase(productName, quantityStr);
        
        if (result.isSuccess()) {
            // Success message
            JOptionPane.showMessageDialog(null, 
                "Purchase successful!\n\n" +
                "Product: " + productName.trim() + "\n" +
                "Total paid: $" + df.format(result.getTotal()), 
                "Purchase Completed", 
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Error message
            JOptionPane.showMessageDialog(null, 
                result.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Handle show statistics functionality
     */
    private void showStatistics() {
        if (inventoryService.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                "No products in inventory yet!\nAdd some products first.", 
                "No Data", 
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        InventoryService.InventoryStats stats = inventoryService.getStatistics();
        
        String statistics = "=== INVENTORY STATISTICS ===\n\n" +
                          "Total products: " + stats.getTotalProducts() + "\n" +
                          "Total sales this session: $" + df.format(stats.getTotalSales()) + "\n\n" +
                          "CHEAPEST PRODUCT:\n" +
                          "• " + stats.getCheapest().getName() + " - $" + df.format(stats.getCheapest().getPrice()) + "\n" +
                          "  Stock: " + stats.getCheapest().getStock() + " units\n\n" +
                          "MOST EXPENSIVE PRODUCT:\n" +
                          "• " + stats.getMostExpensive().getName() + " - $" + df.format(stats.getMostExpensive().getPrice()) + "\n" +
                          "  Stock: " + stats.getMostExpensive().getStock() + " units";
        
        JOptionPane.showMessageDialog(null, 
            statistics, 
            "Inventory Statistics", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Handle search product functionality
     */
    private void searchProduct() {
        if (inventoryService.isEmpty()) {
            JOptionPane.showMessageDialog(null, 
                "No products in inventory yet!\nAdd some products first.", 
                "Empty Inventory", 
                JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        String searchTerm = JOptionPane.showInputDialog(null, 
            "Enter product name to search for:\n(Partial matches are supported)", 
            "Search Product", 
            JOptionPane.QUESTION_MESSAGE);
        
        if (searchTerm == null) return; // User cancelled
        
        ArrayList<Product> results = inventoryService.searchProducts(searchTerm);
        
        StringBuilder searchResults = new StringBuilder();
        searchResults.append("Search results for: '").append(searchTerm).append("'\n\n");
        
        boolean found = !results.isEmpty();
        for (Product product : results) {
            searchResults.append("• ").append(product.getName()).append("\n")
                   .append("  Price: $").append(df.format(product.getPrice())).append("\n")
                   .append("  Stock: ").append(product.getStock()).append(" units\n\n");
        }
        
        if (!found) {
            searchResults.append("No products found matching '").append(searchTerm).append("'");
        }
        
        JOptionPane.showMessageDialog(null, 
            searchResults.toString(), 
            "Search Results", 
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    /**
     * Show final ticket with total sales when exiting
     */
    private void showFinalTicket() {
        String ticket = "=== FINAL SESSION TICKET ===\n\n" +
                       "Session Summary:\n" +
                       "• Total products in system: " + inventoryService.getProductCount() + "\n" +
                       "• Total sales this session: $" + df.format(inventoryService.getTotalSales()) + "\n\n";
        
        if (inventoryService.getTotalSales() > 0) {
            ticket += "Have a great day!";
        } else {
            ticket += "No sales were made this session.";
        }
        
        JOptionPane.showMessageDialog(null, 
            ticket, 
            "Session Complete", 
            JOptionPane.INFORMATION_MESSAGE);
    }
}