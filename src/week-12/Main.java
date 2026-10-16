import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.nio.file.*;
import java.io.IOException;
import java.util.stream.Collectors;

public class Main {
    static Scanner keyboardInput = new Scanner(System.in);
    static Map<String, Vehicle> fleet = new LinkedHashMap<>();
    static List<Rental> rentals = new ArrayList<>();
    static List<ServiceRecord> services = new ArrayList<>();
    static final double FUEL_PRICE = 2400;
    static final int LATE_RATE = 500;

    public static void main(String[] args) {
        loadData();
        if (fleet.isEmpty()) {
            addDefaultVehicle("KA09-ECO-1", "Economy", 12000, 20000);
            addDefaultVehicle("KA09-SUV-3", "SUV", 39000, 40000);
            addDefaultVehicle("KA09-LUX-2", "Luxury", 25000, 35000);
        }
        int menuChoice=0;
        while (menuChoice != 5) {
            System.out.println("\n=== Fleet Manager ===");
            System.out.println("1 Rent/Checkout  2 Return  3 Service  4 Report  5 Save and Exit");
            System.out.print("Choice: "); menuChoice=readInt();
            if (menuChoice==1) rentVehicle();
            else if (menuChoice==2) returnVehicle();
            else if (menuChoice==3) recordService();
            else if (menuChoice==4) showReport();
        }
        saveData();
        System.out.println("Data saved. Bye.");
    }

    static void addDefaultVehicle(String vehicleId, String vehicleClass, int odometer, int nextServiceOdometer) {
        fleet.put(vehicleId, createVehicle(vehicleId,vehicleClass,odometer,nextServiceOdometer));
    }
    static Vehicle createVehicle(String vehicleId, String vehicleClass, int odometer, int nextServiceOdometer) {
        if (vehicleClass.equals("SUV")) return new SUV(vehicleId,odometer,nextServiceOdometer);
        if (vehicleClass.equals("Luxury")) return new Luxury(vehicleId,odometer,nextServiceOdometer);
        return new Economy(vehicleId,odometer,nextServiceOdometer);
    }
    static int readInt() {
        try { return Integer.parseInt(keyboardInput.nextLine().trim()); }
        catch (Exception exception) { return -1; }
    }
    static double readDouble() {
        try { return Double.parseDouble(keyboardInput.nextLine().trim()); }
        catch (Exception exception) { return -1; }
    }
    static String readText() { return keyboardInput.nextLine().trim(); }
    static LocalDate readDate(String label) {
        System.out.print(label + " (yyyy-mm-dd): ");
        try { return LocalDate.parse(readText()); }
        catch (Exception exception) { System.out.println("Invalid date"); return null; }
    }
    static double readFuel(String label) {
        System.out.print(label + " (0.0 to 1.0): ");
        double fuelLevel = readDouble();
        if (fuelLevel < 0 || fuelLevel > 1) { System.out.println("Fuel must be between 0 and 1"); return -1; }
        return fuelLevel;
    }
    static void showFleet() {
        System.out.println("ID            Class     Odometer   Rate/day   Status");
        for (Vehicle vehicle : fleet.values())
            System.out.printf("%-13s %-9s %-10d %-10.0f %s%n",vehicle.getId(),vehicle.getType(),vehicle.getOdo(),vehicle.getRate(),vehicle.serviceDue()?"SERVICE DUE":"OK");
    }
    static void rentVehicle() {
        showFleet();
        System.out.print("Vehicle ID: "); String vehicleId=readText();
        Vehicle vehicle=fleet.get(vehicleId);
        if (vehicle==null) { System.out.println("Vehicle not found"); return; }
        System.out.print("Customer: "); String customerName=readText();
        LocalDate startDate=readDate("Start date"); if (startDate==null) return;
        LocalDate dueDate=readDate("Due date"); if (dueDate==null || dueDate.isBefore(startDate)) { System.out.println("Invalid date range"); return; }
        try {
            if (vehicle.serviceDue()) throw new ServiceDueException("Vehicle needs service first");
            if (!vehicle.isFree(startDate,dueDate,rentals))
                throw new VehicleUnavailableException("Vehicle already booked for these dates");
            System.out.print("Checkout odometer: "); int checkoutOdometer = readInt();
            if (checkoutOdometer < vehicle.getOdo()) { System.out.println("Odometer cannot go backwards"); return; }
            double checkoutFuel = readFuel("Checkout fuel"); if (checkoutFuel < 0) return;
            Rental rental = new Rental(vehicleId, customerName, startDate, dueDate, null, checkoutOdometer, -1, checkoutFuel, -1, 0, true, false);
            rentals.add(rental); vehicle.setOdo(checkoutOdometer);
            System.out.println("Assigned " + vehicleId + " to " + customerName);
        } catch (VehicleUnavailableException | ServiceDueException exception) {
            System.out.println(exception.getMessage());
        }
    }
    static void returnVehicle() {
        System.out.print("Vehicle ID to return: "); String vehicleId=readText();
        int rentalIndex=-1;
        for (int rentalPosition = rentals.size() - 1; rentalPosition >= 0; rentalPosition--)
            if (rentals.get(rentalPosition).vehicleId().equals(vehicleId) && rentals.get(rentalPosition).checkedOut() && !rentals.get(rentalPosition).returned()) { rentalIndex = rentalPosition; break; }
        if (rentalIndex<0) { System.out.println("No active rental found"); return; }
        Rental rental=rentals.get(rentalIndex); Vehicle vehicle=fleet.get(vehicleId);
        LocalDate actualReturnDate=readDate("Actual return date"); if (actualReturnDate==null) return;
        if (actualReturnDate.isBefore(rental.startDate())) { System.out.println("Return date cannot be before the rental start date"); return; }
        System.out.print("Return odometer: "); int returnOdometer=readInt();
        if (returnOdometer < rental.startOdometer()) { System.out.println("Return odometer cannot be below checkout reading"); return; }
        double returnFuel=readFuel("Return fuel"); if (returnFuel < 0) return;
        int distanceKm=returnOdometer-rental.startOdometer();
        int lateDays=(int)Math.max(0,ChronoUnit.DAYS.between(rental.dueDate(),actualReturnDate));
        double totalFee = vehicle.charge(rental.days(), distanceKm, rental.checkoutFuel(), returnFuel, lateDays);
        Rental completedRental=new Rental(rental.vehicleId(),rental.customerName(),rental.startDate(),rental.dueDate(),actualReturnDate,rental.startOdometer(),returnOdometer,rental.checkoutFuel(),returnFuel,totalFee,true,true);
        rentals.set(rentalIndex,completedRental); vehicle.setOdo(returnOdometer);
        System.out.println("\n--- Invoice ---");
        System.out.println("Vehicle: " + vehicleId + " | Customer: " + rental.customerName());
        System.out.println("Days: " + rental.days() + " | Distance: " + distanceKm + " km | Late days: " + lateDays);
        System.out.printf("Charge: Rs. %.2f%n", totalFee);
        if (vehicle.serviceDue()) System.out.println("Service due: rentals blocked until service is recorded");
    }
    static void recordService() {
        showFleet();
        System.out.print("Vehicle ID: "); String vehicleId=readText();
        Vehicle vehicle=fleet.get(vehicleId);
        if (vehicle==null) { System.out.println("Vehicle not found"); return; }
        System.out.print("Work done: "); String serviceWork=readText();
        System.out.println("Service cost (Rs):"); double serviceCost = readDouble();
        if (serviceCost < 0) { System.out.println("Invalid service cost"); return; }
        services.add(new ServiceRecord(vehicleId, LocalDate.now(), serviceWork, serviceCost));
        vehicle.serviceDone();
        System.out.println(vehicleId + " serviced. Next service at " + vehicle.getNextService() + " km");
    }
    static void showReport() {
        long vehiclesOut=fleet.values().stream().filter(vehicle -> rentals.stream().anyMatch(rental ->
            rental.vehicleId().equals(vehicle.getId()) && rental.checkedOut() && !rental.returned() && !LocalDate.now().isBefore(rental.startDate()))).count();
        double utilisationPercent=fleet.isEmpty()?0:100.0*vehiclesOut/fleet.size();
        System.out.printf("Current utilisation: %.1f%% (%d/%d vehicles out)%n",utilisationPercent,vehiclesOut,fleet.size());
        Map<String,Double> revenueByClass=rentals.stream().filter(Rental::returned)
            .collect(Collectors.groupingBy(rental -> fleet.get(rental.vehicleId()).getType(),
                Collectors.summingDouble(Rental::rentalFee)));
        System.out.println("Revenue by class:");
        revenueByClass.forEach((vehicleClass, classRevenue) -> System.out.printf("%s: Rs. %.2f%n", vehicleClass, classRevenue));
        System.out.println("Vehicles due for service:");
        List<Vehicle> dueVehicles = fleet.values().stream().filter(Vehicle::serviceDue).toList();
        if (dueVehicles.isEmpty()) System.out.println("None");
        else dueVehicles.forEach(vehicle -> System.out.println(vehicle.getId()+" at "+vehicle.getOdo()+" km"));
        System.out.println("All rentals: " + rentals.size() + " | Service records: " + services.size());
    }
    static void loadData() {
        try {
            Path fleetPath = Path.of("fleet.txt");
            if (Files.exists(fleetPath)) for (String savedRecord:Files.readAllLines(fleetPath)) if (!savedRecord.isBlank()) {
                String[] savedFields=savedRecord.split("\\|",-1);
                fleet.put(savedFields[0],createVehicle(savedFields[0],savedFields[1],Integer.parseInt(savedFields[2]),Integer.parseInt(savedFields[3])));
            }
            Path rentalsFile = Path.of("rentals.txt");
            if (Files.exists(rentalsFile)) for (String savedRecord:Files.readAllLines(rentalsFile)) if (!savedRecord.isBlank()) rentals.add(Rental.fromLine(savedRecord));
            Path serviceFile = Path.of("service.txt");
            if (Files.exists(serviceFile)) for (String savedRecord:Files.readAllLines(serviceFile)) if (!savedRecord.isBlank()) services.add(ServiceRecord.fromLine(savedRecord));
        } catch (Exception exception) { System.out.println("Some saved data could not be loaded: " + exception.getMessage()); }
    }
    static void saveData() {
        try {
            List<String> fleetLines=fleet.values().stream().map(Vehicle::toLine).toList();
            List<String> rentalLines=rentals.stream().map(Rental::toLine).toList();
            List<String> serviceLines=services.stream().map(ServiceRecord::toLine).toList();
            Files.write(Path.of("fleet.txt"),fleetLines);
            Files.write(Path.of("rentals.txt"),rentalLines);
            Files.write(Path.of("service.txt"),serviceLines);
        } catch (IOException exception) { System.out.println("Could not save data: " + exception.getMessage()); }
    }
}
