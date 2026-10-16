class Vehicle {
    String vehicleId, vehicleClass;
    int odometer, serviceAt;
    double dailyRate;
    boolean available = true;

    Vehicle(String vehicleId, String vehicleClass, int odometer, int serviceMileage, double dailyRate) {
        this.vehicleId = vehicleId; this.vehicleClass = vehicleClass; this.odometer = odometer; serviceAt=serviceMileage; this.dailyRate = dailyRate;
    }

    boolean rent() {
        if (!available) return false;
        if (odometer >= serviceAt) {
            System.out.println(vehicleId + " needs service");
            return false;
        }
        available = false;
        return true;
    }
    void show() { System.out.println(vehicleId + " " + vehicleClass + " odometer=" + odometer + " dailyRate=" + dailyRate); }
}
