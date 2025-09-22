package UserStory.models;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Inventory class - manages the collection of products
 * Maintains the EXACT data structures required by the assignment:
 * - ArrayList<String> for product names
 * - double[] for prices
 * - HashMap<String, Integer> for stock
 * 
 * Designed for someone with 2 months Java experience
 */
public class Inventory {
    // Required data structures - EXACTLY as specified in the assignment
    private ArrayList<String> productNames;    // ArrayList for names
    private double[] prices;                   // Array for prices, synchronized with names
    private HashMap<String, Integer> stock;    // HashMap for stock
    private int productCount;                  // Keep track of products
    
    /**
     * Constructor - initialize the data structures
     */
    public Inventory() {
        productNames = new ArrayList<>();
        prices = new double[10]; // Start with 10 products capacity
        stock = new HashMap<>();
        productCount = 0;
    }
    
    /**
     * Add a product to inventory - implements addProducto utility method
     * @param name Product name
     * @param price Product price
     * @param stockAmount Initial stock
     * @return true if added successfully, false if already exists
     */
    public boolean addProducto(String name, double price, int stockAmount) {
        // Check for duplicates using our utility method
        if (indexOfNombre(name) != -1) {
            return false; // Product already exists
        }
        
        // Expand prices array if needed - implements expandPrecios utility
        if (productCount >= prices.length) {
            expandPrecios();
        }
        
        // Add to all three data structures as required
        productNames.add(name);           // ArrayList
        prices[productCount] = price;     // Array
        stock.put(name, stockAmount);     // HashMap
        productCount++;
        
        return true;
    }
    
    /**
     * Expand prices array when it gets full - implements expandPrecios utility method
     */
    private void expandPrecios() {
        double[] newPrices = new double[prices.length * 2];
        // Copy existing prices to new array
        for (int i = 0; i < prices.length; i++) {
            newPrices[i] = prices[i];
        }
        prices = newPrices;
    }
    
    /**
     * Find index of product name - implements indexOfNombre utility method
     * @param name Product name to search for
     * @return index if found, -1 if not found
     */
    public int indexOfNombre(String name) {
        for (int i = 0; i < productNames.size(); i++) {
            if (productNames.get(i).equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Get a product by name
     * @param name Product name
     * @return Product object or null if not found
     */
    public Product getProduct(String name) {
        int index = indexOfNombre(name);
        if (index == -1) {
            return null;
        }
        
        String actualName = productNames.get(index);
        double price = prices[index];
        int stockAmount = stock.get(actualName);
        
        return new Product(actualName, price, stockAmount);
    }
    
    /**
     * Update stock for a product
     * @param name Product name
     * @param newStock New stock amount
     * @return true if updated successfully
     */
    public boolean updateStock(String name, int newStock) {
        if (stock.containsKey(name)) {
            stock.put(name, newStock);
            return true;
        }
        return false;
    }
    
    /**
     * Get all products as a list for display
     * @return ArrayList of all products
     */
    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        
        for (int i = 0; i < productNames.size(); i++) {
            String name = productNames.get(i);
            double price = prices[i];
            int stockAmount = stock.get(name);
            
            products.add(new Product(name, price, stockAmount));
        }
        
        return products;
    }
    
    /**
     * Search products by name (supports partial matches)
     * @param searchTerm Term to search for
     * @return ArrayList of matching products
     */
    public ArrayList<Product> searchProducts(String searchTerm) {
        ArrayList<Product> results = new ArrayList<>();
        String term = searchTerm.toLowerCase();
        
        for (int i = 0; i < productNames.size(); i++) {
            String name = productNames.get(i);
            if (name.toLowerCase().contains(term)) {
                double price = prices[i];
                int stockAmount = stock.get(name);
                results.add(new Product(name, price, stockAmount));
            }
        }
        
        return results;
    }
    
    /**
     * Find the cheapest product by scanning the prices array
     * @return Product with minimum price or null if empty
     */
    public Product getCheapestProduct() {
        if (productCount == 0) {
            return null;
        }
        
        // Find minimum price by scanning the array
        int minIndex = 0;
        for (int i = 1; i < productCount; i++) {
            if (prices[i] < prices[minIndex]) {
                minIndex = i;
            }
        }
        
        String name = productNames.get(minIndex);
        return new Product(name, prices[minIndex], stock.get(name));
    }
    
    /**
     * Find the most expensive product by scanning the prices array
     * @return Product with maximum price or null if empty
     */
    public Product getMostExpensiveProduct() {
        if (productCount == 0) {
            return null;
        }
        
        // Find maximum price by scanning the array
        int maxIndex = 0;
        for (int i = 1; i < productCount; i++) {
            if (prices[i] > prices[maxIndex]) {
                maxIndex = i;
            }
        }
        
        String name = productNames.get(maxIndex);
        return new Product(name, prices[maxIndex], stock.get(name));
    }
    
    /**
     * Check if inventory is empty
     * @return true if no products
     */
    public boolean isEmpty() {
        return productCount == 0;
    }
    
    /**
     * Get total number of products
     * @return number of products in inventory
     */
    public int getProductCount() {
        return productCount;
    }
    
    // Getter methods for direct access to data structures (if needed for testing)
    public ArrayList<String> getProductNames() {
        return productNames;
    }
    
    public double[] getPrices() {
        return prices;
    }
    
    public HashMap<String, Integer> getStock() {
        return stock;
    }
}