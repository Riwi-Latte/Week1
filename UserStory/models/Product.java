package UserStory.models;

public class Product {
    // Private fields to store product data
    private String name;
    private double price;
    private int stock;
    
    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    
    // Getter methods to access private fields
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getStock() {
        return stock;
    }
    
    // Setter methods to modify private fields
    public void setName(String name) {
        this.name = name;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    /**
     * Check if we have enough stock for a purchase
     * @param quantity Amount requested
     * @return true if we have enough stock
     */
    public boolean hasEnoughStock(int quantity) {
        return stock >= quantity;
    }
    
    /**
     * Reduce stock after a purchase
     * @param quantity Amount sold
     */
    public void reduceStock(int quantity) {
        if (hasEnoughStock(quantity)) {
            stock = stock - quantity;
        }
    }
    
    /**
     * Override toString method for easy display
     * @return formatted string with product info
     */
    @Override
    public String toString() {
        return name + " - $" + String.format("%.2f", price) + " (Stock: " + stock + ")";
    }
}