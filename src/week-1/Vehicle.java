class Vehicle {
    String vehicleId;
    String vehicleClass;
    double dailyRate;
    boolean available = true;

    Vehicle(String vehicleId, String vehicleClass, double dailyRate) {
        this.vehicleId = vehicleId; this.vehicleClass = vehicleClass; this.dailyRate = dailyRate;
    }

    void show() {
        System.out.println(vehicleId + "  " + vehicleClass + "  Rs." + dailyRate + "  available=" + available);
    }
}
