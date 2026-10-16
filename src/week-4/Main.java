import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner keyboardInput = new Scanner(System.in);
        Vehicle[] vehicles = {new Vehicle("E1", "Economy", 10000, 20000, 1200),
                          new Vehicle("S1", "SUV", 39000, 40000, 2500)};
        List<Rental> rentals = new ArrayList<>();
        System.out.print("Customer: "); String customerName = keyboardInput.nextLine();
        System.out.print("Start day number: "); int startDay = keyboardInput.nextInt();
        System.out.print("End day number: "); int endDay = keyboardInput.nextInt();
        for (Vehicle vehicle : vehicles) {
            boolean isAvailable = true;
            for (Rental rental : rentals)
                if (rental.vehicleId.equals(vehicle.vehicleId) && rental.overlaps(startDay, endDay)) isAvailable = false;
            if (isAvailable && !vehicle.serviceDue()) {
                rentals.add(new Rental(vehicle.vehicleId, customerName, startDay, endDay));
                System.out.println("Assigned " + vehicle.vehicleId + " for days " + startDay + " to " + endDay);
                break;
            }
        }
        System.out.println("Rentals saved in program memory: " + rentals.size());
        keyboardInput.close();
    }
}
