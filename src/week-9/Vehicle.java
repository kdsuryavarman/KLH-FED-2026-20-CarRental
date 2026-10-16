public abstract class Vehicle {
    private String vehicleId, vehicleClass;
    private int odometer, serviceAt;
    private double dailyRate, kmRate;
    public Vehicle(String vehicleId, String vehicleClass, int odometer, int serviceMileage, double dailyRate, double perKmRate) { this.vehicleId = vehicleId; this.vehicleClass = vehicleClass; this.odometer = odometer; serviceAt=serviceMileage; this.dailyRate = dailyRate; kmRate=perKmRate; }
    public String getId() { return vehicleId; }
    public String getType() { return vehicleClass; }
    public int getOdo() { return odometer; }
    public void setOdo(int odometer) { if (odometer >= this.odometer) this.odometer = odometer; }
    public boolean serviceDue() { return odometer >= serviceAt; }
    public double charge(int days, int distanceKm, double checkoutFuel, double returnFuel, int lateDays) {
        return days*dailyRate + distanceKm*kmRate + (checkoutFuel-returnFuel)*2400 + lateDays*500;
    }
}
