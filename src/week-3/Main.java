import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboardInput = new Scanner(System.in);
        Vehicle[] vehicles = {new Vehicle("KA09-ECO-1", "Economy", 12000, 20000, 1200),
                          new Vehicle("KA09-SUV-3", "SUV", 40000, 40000, 2500)};
        for (Vehicle vehicle : vehicles) vehicle.show();
        System.out.print("Choose car (0 or 1): ");
        int vehicleIndex = keyboardInput.nextInt();
        if (vehicleIndex >= 0 && vehicleIndex < vehicles.length && vehicles[vehicleIndex].rent())
            System.out.println("Rental accepted");
        else System.out.println("Rental blocked");
        keyboardInput.close();
    }
}
