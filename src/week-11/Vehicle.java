public class Vehicle {
    private String vehicleId, vehicleClass; private int odometer; private double dailyRate;
    public Vehicle(String vehicleId, String vehicleClass, int odometer, double dailyRate) { this.vehicleId = vehicleId; this.vehicleClass = vehicleClass; this.odometer = odometer; this.dailyRate = dailyRate; }
    public String getId() { return vehicleId; }
    public String getType() { return vehicleClass; }
    public double getRate() { return dailyRate; }
    public int getOdo() { return odometer; }
}
