class Rental {
    String vehicleId, customerName; int startDate, end;
    Rental(String vehicleId, String customerName, int startDay, int endDay) { this.vehicleId = vehicleId; this.customerName = customerName; startDate=startDay; end=endDay; }
    boolean hasDay(int day) { return day >= startDate && day <= end; }
}
