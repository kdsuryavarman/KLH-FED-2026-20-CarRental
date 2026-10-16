import java.nio.file.*;
import java.util.*;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        List<Vehicle> vehicles = new ArrayList<>();
        Path file=Path.of("fleet.txt");
        if (Files.exists(file)) {
            for (String savedRecord : Files.readAllLines(file)) if (!savedRecord.isBlank()) vehicles.add(Vehicle.fromLine(savedRecord));
        } else {
            vehicles.add(new Vehicle("E1","Economy",12000,1200));
            vehicles.add(new Vehicle("S1","SUV",39000,2500));
        }
        for (Vehicle vehicle : vehicles) System.out.println(vehicle.getId());
        List<String> vehicleLines=new ArrayList<>();
        for (Vehicle vehicle : vehicles) vehicleLines.add(vehicle.toLine());
        Files.write(file, vehicleLines);
        System.out.println("Fleet saved to fleet.txt");
    }
}
