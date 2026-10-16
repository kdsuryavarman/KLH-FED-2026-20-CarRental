import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboardInput = new Scanner(System.in);
        Vehicle[] vehicles = { new Vehicle("KA09-ECO-1", "Economy", 1200),
                           new Vehicle("KA09-SUV-3", "SUV", 2500) };
        int menuChoice = 0;
        while (menuChoice != 3) {
            System.out.println("1 Fleet  2 Rent  3 Exit");
            menuChoice = keyboardInput.nextInt();
            if (menuChoice == 1) {
                for (Vehicle vehicle : vehicles) vehicle.show();
            } else if (menuChoice == 2) {
                System.out.print("Enter car number (0 or 1): ");
                int vehicleIndex = keyboardInput.nextInt();
                if (vehicleIndex >= 0 && vehicleIndex < vehicles.length && vehicles[vehicleIndex].available) {
                    vehicles[vehicleIndex].available = false;
                    System.out.println("Car assigned: " + vehicles[vehicleIndex].vehicleId);
                } else System.out.println("Car not available");
            }
        }
        keyboardInput.close();
    }
}
