import java.util.*;
public class Main {
    public static void main(String[] args) {
        Map<String, Vehicle> vehicles = new HashMap<>();
        vehicles.put("E1", new Vehicle("E1", "Economy", 12000, 1200));
        vehicles.put("S1", new Vehicle("S1", "SUV", 39000, 2500));
        List<Rental> rentals = new ArrayList<>();
        rentals.add(new Rental("E1", "Ravi", 2, 2400));
        rentals.add(new Rental("S1", "Asha", 3, 7500));
        Map<String, List<Rental>> rentalsByVehicle = new HashMap<>();
        for (Rental rental : rentals)
            rentalsByVehicle.computeIfAbsent(rental.vehicleId(), vehicleIdKey -> new ArrayList<>()).add(rental);
        Map<String, List<Vehicle>> vehiclesByClass = new HashMap<>();
        for (Vehicle vehicle : vehicles.values())
            vehiclesByClass.computeIfAbsent(vehicle.getType(), vehicleClassKey -> new ArrayList<>()).add(vehicle);
        List<Vehicle> sortedVehicles = new ArrayList<>(vehicles.values());
        sortedVehicles.sort(Comparator.comparingInt(vehicle -> rentalsByVehicle.getOrDefault(vehicle.getId(), new ArrayList<>())
                .stream().mapToInt(Rental::days).sum()));
        for (Vehicle vehicle : sortedVehicles)
            System.out.println(vehicle.getId() + " used days=" + rentalsByVehicle.getOrDefault(vehicle.getId(), new ArrayList<>())
                    .stream().mapToInt(Rental::days).sum());
        System.out.println("Classes: " + vehiclesByClass.keySet());
    }
}
