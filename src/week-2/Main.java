import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboardInput = new Scanner(System.in);
        Vehicle[] vehicles = {new Vehicle("KA09-ECO-1", "Economy", 12000, 1200.0, 1.0),
                          new Vehicle("KA09-SUV-3", "SUV", 39000, 2500.0, 0.75)};
        System.out.println("Fleet:");
        for (Vehicle vehicle : vehicles) vehicle.show();
        System.out.print("Enter new odometer reading for first car: ");
        vehicles[0].odometer = keyboardInput.nextInt();
        System.out.println("Updated odometer: " + vehicles[0].odometer);
        keyboardInput.close();
    }
}
