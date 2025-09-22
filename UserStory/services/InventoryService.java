package UserStory.services;

import java.util.ArrayList;

import UserStory.models.Inventory;
import UserStory.models.Product;
import UserStory.utils.ValidationUtils;

public class InventoryService {
    private Inventory inventory;           // Our inventory model
    private double totalSales;            // Track total sales for the session
    
    public InventoryService() {
        this.inventory = new Inventory();
        this.totalSales = 0.0;
    }
    
    /**
     * Add a product with validation
     * Validates input and maintains data consistency
     * @param name Product name
     * @param priceStr Price as string (from JOptionPane)
     * @param stockStr Stock as string (from JOptionPane)
     * @return AddResult with success status and message
     */
    public AddResult addProduct(String name, String priceStr, String stockStr) {
        // Validate product name
        if (!ValidationUtils.isValidString(name)) {
            return new AddResult(false, "Product name cannot be empty!");
        }
        
        name = name.trim();
        
        // Check for duplicates
        if (inventory.indexOfNombre(name) != -1) {
            return new AddResult(false, "Product '" + name + "' already exists!\nUse a different name.");
        }
        
        // Validate price input
        if (!ValidationUtils.isValidString(priceStr)) {
            return new AddResult(false, "Price cannot be empty!");
        }
        
        if (!ValidationUtils.isValidDouble(priceStr)) {
            return new AddResult(false, "Please enter valid numbers for price and stock!");
        }
        
        double price = ValidationUtils.parseDouble(priceStr);
        
        if (!ValidationUtils.isPositiveDouble(price)) {
            return new AddResult(false, "Price must be greater than 0!");
        }
        
        // Validate stock input
        if (!ValidationUtils.isValidString(stockStr)) {
            return new AddResult(false, "Stock cannot be empty!");
        }
        
        if (!ValidationUtils.isValidInteger(stockStr)) {
            return new AddResult(false, "Please enter valid numbers for price and stock!");
        }
        
        int stock = ValidationUtils.parseInteger(stockStr);
        
        if (!ValidationUtils.isNotNegativeInteger(stock)) {
            return new AddResult(false, "Stock cannot be negative!");
        }
        
        // Add product using our utility method
        boolean added = inventory.addProducto(name, price, stock);
        
        if (added) {
            return new AddResult(true, "Product added successfully!");
        } else {
            return new AddResult(false, "Failed to add product!");
        }
    }
    
    /**
     * Get all products for listing
     * @return ArrayList of all products
     */
    public ArrayList<Product> getAllProducts() {
        return inventory.getAllProducts();
    }
    
    /**
     * Process a purchase transaction
     * Validates purchase request and updates inventory
     * @param productName Name of product to buy
     * @param quantityStr Quantity as string (from JOptionPane)
     * @return PurchaseResult with transaction details
     */
    public PurchaseResult processPurchase(String productName, String quantityStr) {
        // Validate product name
        if (!ValidationUtils.isValidString(productName)) {
            return new PurchaseResult(false, "Product name cannot be empty!", 0.0);
        }
        
        productName = productName.trim();
        
        // Find product using our utility method
        int productIndex = inventory.indexOfNombre(productName);
        
        if (productIndex == -1) {
            return new PurchaseResult(false, "Product '" + productName + "' not found!", 0.0);
        }
        
        Product product = inventory.getProduct(productName);
        String actualName = product.getName();
        
        // Check stock availability
        if (product.getStock() <= 0) {
            return new PurchaseResult(false, "Product '" + actualName + "' is out of stock!", 0.0);
        }
        
        // Validate quantity input
        if (!ValidationUtils.isValidString(quantityStr)) {
            return new PurchaseResult(false, "Quantity cannot be empty!", 0.0);
        }
        
        if (!ValidationUtils.isValidInteger(quantityStr)) {
            return new PurchaseResult(false, "Please enter a valid number for quantity!", 0.0);
        }
        
        int quantity = ValidationUtils.parseInteger(quantityStr);
        
        if (quantity <= 0) {
            return new PurchaseResult(false, "Quantity must be greater than 0!", 0.0);
        }
        
        if (quantity > product.getStock()) {
            return new PurchaseResult(false, 
                "Not enough stock!\nAvailable: " + product.getStock() + "\nRequested: " + quantity, 0.0);
        }
        
        // Calculate total
        double total = product.getPrice() * quantity;
        
        // Update stock in inventory
        int newStock = product.getStock() - quantity;
        inventory.updateStock(actualName, newStock);
        
        // Update total sales
        totalSales += total;
        
        return new PurchaseResult(true, "Purchase successful!", total);
    }
    
    /**
     * Search products by name (supports partial matches)
     * @param searchTerm Term to search for
     * @return ArrayList of matching products
     */
    public ArrayList<Product> searchProducts(String searchTerm) {
        if (!ValidationUtils.isValidString(searchTerm)) {
            return new ArrayList<>(); // Return empty list
        }
        
        return inventory.searchProducts(searchTerm.trim());
    }
    
    /**
     * Get inventory statistics
     * @return Statistics object with all the stats
     */
    public InventoryStats getStatistics() {
        return new InventoryStats(
            inventory.getProductCount(),
            totalSales,
            inventory.getCheapestProduct(),
            inventory.getMostExpensiveProduct()
        );
    }
    
    /**
     * Check if inventory is empty
     * @return true if no products
     */
    public boolean isEmpty() {
        return inventory.isEmpty();
    }
    
    /**
     * Get total sales for final ticket
     * @return total sales amount
     */
    public double getTotalSales() {
        return totalSales;
    }
    
    /**
     * Get product count for final ticket
     * @return number of products in system
     */
    public int getProductCount() {
        return inventory.getProductCount();
    }
    
    // Result classes to return operation results
    
    /**
     * Result class for add product operations
     */
    public static class AddResult {
        private boolean success;
        private String message;
        
        public AddResult(boolean success, String message) {
            this.success = success;
            this.message = message;
        }
        
        public boolean isSuccess() {
            return success;
        }
        
        public String getMessage() {
            return message;
        }
    }
    
    /**
     * Result class for purchase operations
     */
    public static class PurchaseResult {
        private boolean success;
        private String message;
        private double total;
        
        public PurchaseResult(boolean success, String message, double total) {
            this.success = success;
            this.message = message;
            this.total = total;
        }
        
        public boolean isSuccess() {
            return success;
        }
        
        public String getMessage() {
            return message;
        }
        
        public double getTotal() {
            return total;
        }
    }
    
    /**
     * Statistics class to hold inventory statistics
     */
    public static class InventoryStats {
        private int totalProducts;
        private double totalSales;
        private Product cheapest;
        private Product mostExpensive;
        
        public InventoryStats(int totalProducts, double totalSales, 
                            Product cheapest, Product mostExpensive) {
            this.totalProducts = totalProducts;
            this.totalSales = totalSales;
            this.cheapest = cheapest;
            this.mostExpensive = mostExpensive;
        }
        
        public int getTotalProducts() {
            return totalProducts;
        }
        
        public double getTotalSales() {
            return totalSales;
        }
        
        public Product getCheapest() {
            return cheapest;
        }
        
        public Product getMostExpensive() {
            return mostExpensive;
        }
    }
}