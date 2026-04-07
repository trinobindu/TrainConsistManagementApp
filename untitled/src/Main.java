
import java.util.ArrayList;
import java.util.List;

// Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// Goods Bogie Class
class GoodsBogie {
    String type;   // Cylindrical, Rectangular
    String cargo;  // Petroleum, Coal, Grain

    GoodsBogie(String type) {
        this.type = type;
    }

    // Method to assign cargo safely
    public void assignCargo(String cargo) {
        try {
            // Rule: Rectangular cannot carry Petroleum
            if (type.equalsIgnoreCase("Rectangular") &&
                    cargo.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                        "Unsafe Assignment! Rectangular bogie cannot carry Petroleum"
                );
            }

            // Safe assignment
            this.cargo = cargo;
            System.out.println(type + " bogie assigned with " + cargo);

        } catch (CargoSafetyException e) {
            System.out.println("ERROR: " + e.getMessage());

        } finally {
            System.out.println("Assignment attempt completed for " + type + " bogie\n");
        }
    }

    @Override
    public String toString() {
        return type + " -> " + (cargo != null ? cargo : "No Cargo");
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=======================================");
        System.out.println(" SAFE CARGO ASSIGNMENT SYSTEM ");
        System.out.println("=======================================");

        List<GoodsBogie> bogies = new ArrayList<>();

        bogies.add(new GoodsBogie("Cylindrical"));
        bogies.add(new GoodsBogie("Rectangular"));
        bogies.add(new GoodsBogie("Rectangular"));

        // Assign cargo
        bogies.get(0).assignCargo("Petroleum"); // valid
        bogies.get(1).assignCargo("Coal");      // valid
        bogies.get(2).assignCargo("Petroleum"); // invalid

        // Display final state
        System.out.println("\nFinal Bogie Status:");
        for (GoodsBogie b : bogies) {
            System.out.println(b);
        }

        System.out.println("\nProgram continues safely...");
    }
}