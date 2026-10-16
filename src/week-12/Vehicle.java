import java.time.LocalDate;
import java.util.List;

public abstract class Vehicle {
    private String vehicleId;
    private int odometer, nextService;
    private double dailyRate, kmRate;
    private String vehicleClass;

    public Vehicle(String vehicleId, String vehicleClass, int odometer, int nextServiceMileage, double dailyRate, double perKmRate) {
        this.vehicleId = vehicleId; this.vehicleClass = vehicleClass; this.odometer = odometer; nextService=nextServiceMileage; this.dailyRate = dailyRate; kmRate=perKmRate;
    }
    public String getId() { return vehicleId; }
    public String getType() { return vehicleClass; }
    public int getOdo() { return odometer; }
    public int getNextService() { return nextService; }
    public double getRate() { return dailyRate; }
    public double getKmRate() { return kmRate; }
    public void setOdo(int odometer) { if (odometer >= this.odometer) this.odometer = odometer; }
    public boolean serviceDue() { return odometer >= nextService; }
    public void serviceDone() { nextService=odometer+10000; }
    public boolean isFree(LocalDate startDate, LocalDate endDate, List<Rental> rentals) {
        for (Rental rental : rentals)
            if (rental.vehicleId().equals(vehicleId) && rental.overlaps(startDate, endDate)) return false;
        return true;
    }
    public abstract double charge(int days, int distanceKm, double checkoutFuel, double returnFuel, int lateDays);
    public String toLine() { return vehicleId+"|"+vehicleClass+"|"+odometer+"|"+nextService; }
}
class Economy extends Vehicle {
    public Economy(String vehicleId, int odometer, int nextServiceMileage) { super(vehicleId, "Economy", odometer, nextServiceMileage, 1200, 5); }
    public double charge(int rentalDays,int distanceKm,double checkoutFuel,double returnFuel,int lateDays) { return rentalDays*getRate()+distanceKm*getKmRate()+(checkoutFuel-returnFuel)*2400+lateDays*500; }
}
class SUV extends Vehicle {
    public SUV(String vehicleId, int odometer, int nextServiceMileage) { super(vehicleId, "SUV", odometer, nextServiceMileage, 2500, 8); }
    public double charge(int rentalDays,int distanceKm,double checkoutFuel,double returnFuel,int lateDays) { return rentalDays*getRate()+distanceKm*getKmRate()+(checkoutFuel-returnFuel)*2400+lateDays*500; }
}
class Luxury extends Vehicle {
    public Luxury(String vehicleId, int odometer, int nextServiceMileage) { super(vehicleId, "Luxury", odometer, nextServiceMileage, 4500, 15); }
    public double charge(int rentalDays,int distanceKm,double checkoutFuel,double returnFuel,int lateDays) { return rentalDays*getRate()+distanceKm*getKmRate()+(checkoutFuel-returnFuel)*2400+lateDays*500; }
}
