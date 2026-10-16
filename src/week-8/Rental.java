public class Rental {
    String vehicleId, customerName; int startDate, end;
    public Rental(String vehicleId, String customerName, int startDay, int endDay) { this.vehicleId = vehicleId; this.customerName = customerName; startDate=startDay; end=endDay; }
    public boolean overlaps(int startDay, int endDay) { return startDay <= end && endDay >= startDate; }
}
