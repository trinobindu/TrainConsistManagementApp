
public class TrainConsistManagementApp {

    // Bubble Sort Method
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Display Method
    public static void display(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("=== UC16: Bubble Sort Passenger Capacities ===");

        // Input capacities
        int[] capacities = {72, 56, 24, 70, 60};

        System.out.print("Before Sorting: ");
        display(capacities);

        // Sorting
        bubbleSort(capacities);

        System.out.print("After Sorting:  ");
        display(capacities);
    }
}