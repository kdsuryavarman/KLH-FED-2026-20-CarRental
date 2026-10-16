public class Rental {
    private final String vehicleId, customerName;
    private final int startDate, end;
    public Rental(String vehicleId, String customerName, int startDay, int endDay) { this.vehicleId = vehicleId; this.customerName = customerName; this.startDate = startDay; this.end = endDay; }
    public String getId() { return vehicleId; }
    public boolean overlaps(int startDay, int endDay) { return startDay <= end && endDay >= startDate; }
    public String toString() { return vehicleId + " rented by " + customerName + " days " + startDate + "-" + end; }
}
