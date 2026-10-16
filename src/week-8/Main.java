import java.util.*;
public class Main {
    static void rent(Vehicle vehicle, int startDay, int endDay, List<Rental> rentals)
            throws VehicleUnavailableException, ServiceDueException {
        if (vehicle.serviceDue()) throw new ServiceDueException("Service is dueDate");
        for (Rental rental : rentals)
            if (rental.vehicleId.equals(vehicle.getId()) && rental.overlaps(startDay,endDay)) throw new VehicleUnavailableException("Dates are busy");
        rentals.add(new Rental(vehicle.getId(), "Customer", startDay, endDay));
        System.out.println("Estimated charge: Rs." + vehicle.charge(endDay-startDay, 100));
    }
    public static void main(String[] args) {
        List<Rental> rentals = new ArrayList<>();
        Vehicle vehicle = new SUV("S1", 12000, 40000);
        try { rent(vehicle, 2, 4, rentals); }
        catch (VehicleUnavailableException | ServiceDueException exception) { System.out.println(exception.getMessage()); }
    }
}
