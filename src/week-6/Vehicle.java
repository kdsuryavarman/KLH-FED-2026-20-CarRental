class Vehicle {
    String vehicleId, vehicleClass; int odometer, serviceAt; double dailyRate;
    Vehicle(String vehicleId, String vehicleClass, int odometer, int serviceMileage, double dailyRate) { this.vehicleId = vehicleId; this.vehicleClass = vehicleClass; this.odometer = odometer; serviceAt=serviceMileage; this.dailyRate = dailyRate; }
    boolean serviceDue() { return odometer >= serviceAt; }
}
