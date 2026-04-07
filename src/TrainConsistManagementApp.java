// UC15: Safe Cargo Assignment using try-catch-finally

// Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

class GoodsBogie {
    private String type;
    private String cargo;

    // Constructor
    public GoodsBogie(String type) {
        this.type = type;
    }

    // Method to assign cargo safely
    public void assignCargo(String cargo) {
        try {
            System.out.println("\nAssigning cargo to " + type + " bogie...");

            // Safety Rule 1
            if (type.equalsIgnoreCase("Rectangular") &&
                    cargo.equalsIgnoreCase("Petroleum")) {
                throw new CargoSafetyException(
                        "Unsafe: Petroleum cannot be transported in Rectangular bogie"
                );
            }

            // Safety Rule 2
            if (type.equalsIgnoreCase("Cylindrical") &&
                    cargo.equalsIgnoreCase("Coal")) {
                throw new CargoSafetyException(
                        "Unsafe: Coal cannot be transported in Cylindrical bogie"
                );
            }

            // If safe
            this.cargo = cargo;
            System.out.println("✅ Cargo assigned successfully: " + cargo);

        } catch (CargoSafetyException e) {
            System.out.println("❌ ERROR: " + e.getMessage());

        } finally {
            System.out.println("🔄 Cargo assignment attempt completed.");
        }
    }

    // Display details
    public void display() {
        System.out.println("\n--- Bogie Details ---");
        System.out.println("Type  : " + type);
        System.out.println("Cargo : " + (cargo == null ? "None" : cargo));
    }
}

// Main Class
public class TrainConsistApp {
    public static void main(String[] args) {

        // Creating bogies
        GoodsBogie bogie1 = new GoodsBogie("Rectangular");
        GoodsBogie bogie2 = new GoodsBogie("Cylindrical");

        // Test Cases

        // ❌ Unsafe assignment
        bogie1.assignCargo("Petroleum");

        // ❌ Unsafe assignment
        bogie2.assignCargo("Coal");

        // ✅ Safe assignments
        bogie1.assignCargo("Food Grains");
        bogie2.assignCargo("Petroleum");

        // Display final status
        bogie1.display();
        bogie2.display();
    }
}