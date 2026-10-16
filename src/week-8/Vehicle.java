public abstract class Vehicle {
    private String vehicleId;
    protected int odometer, serviceAt;
    protected double dailyRate;
    public Vehicle(String vehicleId, int odometer, int serviceMileage, double dailyRate) { this.vehicleId = vehicleId; this.odometer = odometer; serviceAt=serviceMileage; this.dailyRate = dailyRate; }
    public String getId() { return vehicleId; }
    public int getOdo() { return odometer; }
    public boolean serviceDue() { return odometer >= serviceAt; }
    public void setOdo(int odometer) { if (odometer >= this.odometer) this.odometer = odometer; }
    public abstract double charge(int days, int distanceKm);
}
class Economy extends Vehicle {
    public Economy(String vehicleId, int odometer, int serviceMileage) { super(vehicleId,odometer,serviceMileage,1200); }
    public double charge(int days, int distanceKm) { return days*dailyRate + distanceKm*5; }
}
class SUV extends Vehicle {
    public SUV(String vehicleId, int odometer, int serviceMileage) { super(vehicleId,odometer,serviceMileage,2500); }
    public double charge(int days, int distanceKm) { return days*dailyRate + distanceKm*8; }
}
class Luxury extends Vehicle {
    public Luxury(String vehicleId, int odometer, int serviceMileage) { super(vehicleId,odometer,serviceMileage,4500); }
    public double charge(int days, int distanceKm) { return days*dailyRate + distanceKm*15; }
}
