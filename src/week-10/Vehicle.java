public class Vehicle {
    private String vehicleId, vehicleClass; private int odometer; private double dailyRate;
    public Vehicle(String vehicleId, String vehicleClass, int odometer, double dailyRate) { this.vehicleId = vehicleId; this.vehicleClass = vehicleClass; this.odometer = odometer; this.dailyRate = dailyRate; }
    public String getId() { return vehicleId; }
    public String toLine() { return vehicleId + "|" + vehicleClass + "|" + odometer + "|" + dailyRate; }
    public static Vehicle fromLine(String serializedRecord) {
        String[] recordFields=serializedRecord.split("\\|");
        return new Vehicle(recordFields[0],recordFields[1],Integer.parseInt(recordFields[2]),Double.parseDouble(recordFields[3]));
    }
}
