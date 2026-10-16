class Vehicle {
    String vehicleId, vehicleClass;
    int odometer;
    double dailyRate, fuel;
    boolean available;

    Vehicle(String vehicleId, String vehicleClass, int odometer, double dailyRate, double fuelLevel) {
        this.vehicleId = vehicleId; this.vehicleClass = vehicleClass; this.odometer = odometer; this.dailyRate = dailyRate; fuel=fuelLevel; available=true;
    }

    void show() {
        System.out.println(vehicleId + " " + vehicleClass + " dailyRate=" + dailyRate + " odometer=" + odometer +
                           " fuel=" + fuel + " available=" + available);
    }
}
