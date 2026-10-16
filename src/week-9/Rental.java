public record Rental(String vehicleId, String customerName, int startDay, int dueDay,
                     int startOdometer, int returnOdometer, double checkoutFuel, double returnFuel, double totalFee) {
}
