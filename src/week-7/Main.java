import java.util.*;
public class Main {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle("S1", "SUV", 12000, 40000, 2500);
        Rental rental = new Rental(vehicle.getId(), "Ravi", 1, 3);
        ServiceRecord serviceRecord = new ServiceRecord(vehicle.getId(), "oil change", 1800);
        System.out.println(vehicle.getType() + " dailyRate=" + vehicle.getRate());
        System.out.println(rental);
        System.out.println(serviceRecord);
    }
}
