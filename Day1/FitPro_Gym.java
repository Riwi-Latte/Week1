import java.util.Scanner;

public class FitPro_Gym {
    static String planOptions[] = {"Basic", "Plus", "Premium"};

    static String plan_selection(Scanner input) {
        System.out.println("Select a plan (Basic, Plus, Premium):");
        
        while (true) {
            try {
                String selectedPlan = input.nextLine();
                
                if (selectedPlan == null || selectedPlan.trim().isEmpty()) {
                    throw new IllegalArgumentException("Plan cannot be empty");
                }
                
                for (String option : planOptions) {
                    if (selectedPlan.equalsIgnoreCase(option)) {
                        return selectedPlan;
                    }
                }
                
                System.out.println("Invalid plan. Please select: Basic, Plus, or Premium:");
                
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again:");
            }
        }
    }

    static boolean get_first_time_status(Scanner input) {
        System.out.println("Is this your first time here? (y/n):");
        
        while (true) {
            try {
                String firstTimeResponse = input.nextLine();
                
                if (firstTimeResponse == null || firstTimeResponse.trim().isEmpty()) {
                    System.out.println("Please enter 'y' for yes or 'n' for no:");
                    continue;
                }
                
                String response = firstTimeResponse.trim().toLowerCase();
                
                if (response.equals("y") || response.equals("yes")) {
                    System.out.println("Welcome, first-time user!");
                    return true;
                } else if (response.equals("n") || response.equals("no")) {
                    return false;
                } else {
                    System.out.println("Invalid input. Please enter 'y' for yes or 'n' for no:");
                }
            } catch (Exception error) {
                System.out.println("Error reading input: " + error.getMessage());
                error.printStackTrace();
                return false;
            }
        }
}

    static int get_age(Scanner input) {
        System.out.println("Please enter your age:");
        
        while (true) {
            try {
                String ageInput = input.nextLine();
                
                if (ageInput == null || ageInput.trim().isEmpty()) {
                    System.out.println("Age cannot be empty. Please enter your age:");
                    continue;
                }
                
                int age = Integer.parseInt(ageInput.trim());
                
                if (age < 0 || age > 150) {
                    System.out.println("Please enter a valid age:");
                    continue;
                }
                
                return age;
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for age:");
            }
        }
    }

    static String check_age_eligibility(int age) {
        if (age < 14) {
            return "Not allowed";
        } else if (age < 18) {
            return "Requires parental authorization";
        } else {
            return "Eligible";
        }
    }

    static double calculate_quote(String plan, boolean first_time, int age) {
        double base_price;
        switch (plan.toLowerCase()) {
            case "basic":
                base_price = 100.0;
                break;
            case "plus":
                base_price = 200.0;
                break;
            case "premium":
                base_price = 300.0;
                break;
            default:
                throw new IllegalArgumentException("Invalid plan selected");
        }

        double discount = 0.0;

        if (first_time) {
            discount += 0.10; // 10% discount for first-time users
        }

        if (age < 25) {
            discount += 0.05; // Additional 5% discount for users under 25
        } else if (age > 60) {
            discount += 0.15; // Additional 15% discount for users over 60
        }

        // Cap the total discount at 20%
        if (discount > 0.20) {
            discount = 0.20;
        }

        return base_price * (1 - discount);
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            String selectedPlan = plan_selection(input);

            boolean first_time = get_first_time_status(input);
            int age = get_age(input);
            
            String eligibility = check_age_eligibility(age);
            System.out.println("Eligibility status: " + eligibility);
            
            if (eligibility.equals("Not allowed")) {
                System.out.println("Sorry, you are not eligible for our services.");
                return;
            }

            double final_quote = calculate_quote(selectedPlan, first_time, age);

            System.out.printf("Your final discounted quote for the %s plan is: $%.2f%n", selectedPlan, final_quote);
        } catch (Exception e) {
            System.out.println("Fatal error: " + e.getMessage());
        }
    }
}