package UserStory.utils;

/**
 * ValidationUtils - utility methods for input validation
 * Simple validation methods for someone with 2 months Java experience
 * Centralizes all validation logic used throughout the application
 */
public class ValidationUtils {
    
    /**
     * Check if a string is valid (not null and not empty after trimming)
     * @param str String to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidString(String str) {
        return str != null && !str.trim().isEmpty();
    }
    
    /**
     * Check if a string can be converted to a valid double number
     * @param str String to check
     * @return true if it's a valid double
     */
    public static boolean isValidDouble(String str) {
        if (!isValidString(str)) {
            return false;
        }
        
        try {
            Double.parseDouble(str.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Check if a string can be converted to a valid integer
     * @param str String to check
     * @return true if it's a valid integer
     */
    public static boolean isValidInteger(String str) {
        if (!isValidString(str)) {
            return false;
        }
        
        try {
            Integer.parseInt(str.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Check if a double value is positive (greater than 0)
     * @param value Double value to check
     * @return true if positive
     */
    public static boolean isPositiveDouble(double value) {
        return value > 0;
    }
    
    /**
     * Check if an integer value is not negative (greater than or equal to 0)
     * @param value Integer value to check
     * @return true if not negative
     */
    public static boolean isNotNegativeInteger(int value) {
        return value >= 0;
    }
    
    /**
     * Parse a string to double safely
     * @param str String to parse
     * @return parsed double or 0.0 if invalid
     */
    public static double parseDouble(String str) {
        try {
            return Double.parseDouble(str.trim());
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
    
    /**
     * Parse a string to integer safely
     * @param str String to parse
     * @return parsed integer or 0 if invalid
     */
    public static int parseInteger(String str) {
        try {
            return Integer.parseInt(str.trim());
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}