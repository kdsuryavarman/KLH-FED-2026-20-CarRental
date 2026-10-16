public class Vehicle {
    private String vehicleId, vehicleClass;
    private int odometer, serviceAt;
    private double dailyRate;
    public Vehicle(String vehicleId, String vehicleClass, int odometer, int serviceMileage, double dailyRate) { this.vehicleId = vehicleId; this.vehicleClass = vehicleClass; this.odometer = odometer; serviceAt=serviceMileage; this.dailyRate = dailyRate; }
    public String getId() { return vehicleId; }
    public String getType() { return vehicleClass; }
    public double getRate() { return dailyRate; }
    public int getOdo() { return odometer; }
    public boolean serviceDue() { return odometer >= serviceAt; }
    public void setOdo(int odometer) { if (odometer >= this.odometer) this.odometer = odometer; }
}
