public class ServiceRecord {
    private final String vehicleId, serviceWork;
    private final double serviceCost;
    public ServiceRecord(String vehicleId, String serviceWork, double serviceCost) { this.vehicleId = vehicleId; this.serviceWork = serviceWork; this.serviceCost = serviceCost; }
    public String toString() { return vehicleId + " service: " + serviceWork + " Rs." + serviceCost; }
}
