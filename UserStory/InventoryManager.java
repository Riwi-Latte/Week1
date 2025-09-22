package UserStory;

import UserStory.ui.InventoryUI;

/**
 * Inventory Management System - Modularized Version
 * A mini-application to manage product inventory with JOptionPane interface
 * Uses ArrayList for product names, Array for prices, and HashMap for stock
 * 
 * Now organized into proper packages:
 * - models: Product and Inventory classes
 * - services: Business logic (InventoryService)
 * - ui: User interface (InventoryUI)
 * - utils: Validation utilities
 * 
 * MAINTAINS ALL ACCEPTANCE CRITERIA:
 * - Uses ArrayList<String> for product names
 * - Uses double[] for prices (synchronized with names)
 * - Uses HashMap<String, Integer> for stock
 * - All JOptionPane functionality preserved
 * - All validation and error handling maintained
 * 
 * Created for someone with 2 months Java experience
 */
public class InventoryManager {
    
    /**
     * Main method - entry point of the application
     * Now delegates to UI class for better organization
     */
    public static void main(String[] args) {
        // Create and start the UI
        InventoryUI ui = new InventoryUI();
        ui.start();
    }
}