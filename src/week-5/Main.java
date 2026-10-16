import java.util.*;

public class Main {
    static List<Rental> rentals = new ArrayList<>();
    static boolean isDateRangeFreeRecursive(String vehicleId, int day, int end) {
        if (day > end) return true;
        for (Rental rental : rentals)
            if (rental.vehicleId.equals(vehicleId) && rental.hasDay(day)) return false;
        return isDateRangeFreeRecursive(vehicleId, day + 1, end);
    }
    public static void main(String[] args) {
        Scanner keyboardInput = new Scanner(System.in);
        Vehicle vehicle = new Vehicle("S1", "SUV", 12000, 40000, 2500);
        rentals.add(new Rental("S1", "Asha", 4, 6));
        System.out.print("Start day: "); int startDay = keyboardInput.nextInt();
        System.out.print("End day: "); int endDay = keyboardInput.nextInt();
        if (vehicle.serviceDue()) System.out.println("Service dueDate; cannot rent");
        else if (isDateRangeFreeRecursive(vehicle.vehicleId, startDay, endDay)) {
            rentals.add(new Rental(vehicle.vehicleId, "New Customer", startDay, endDay));
            System.out.println("Booked " + vehicle.vehicleId);
        } else System.out.println("Date range is busy");
        keyboardInput.close();
    }
}
