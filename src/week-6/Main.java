import java.util.*;

public class Main {
    static List<Rental> rentals = new ArrayList<>();
    static boolean isBooked(String vehicleId, int day) {
        for (Rental rental : rentals) if (rental.vehicleId.equals(vehicleId) && rental.hasDay(day)) return true;
        return false;
    }
    public static void main(String[] args) {
        Vehicle[] vehicles = {new Vehicle("E1", "Economy", 10000, 20000, 1200),
                          new Vehicle("S1", "SUV", 39000, 40000, 2500)};
        rentals.add(new Rental("E1", "Asha", 2, 4));
        rentals.add(new Rental("S1", "Ravi", 5, 7));
        System.out.print("Car / Day ");
        for (int day=1; day<=7; day++) System.out.print(day + " ");
        System.out.println();
        for (Vehicle vehicle : vehicles) {
            System.out.print(vehicle.vehicleId + "        ");
            for (int day=1; day<=7; day++) System.out.print((isBooked(vehicle.vehicleId,day) ? "X" : "-") + " ");
            System.out.println();
        }
    }
}
