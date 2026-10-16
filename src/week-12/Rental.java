import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public record Rental(String vehicleId, String customerName, LocalDate startDate, LocalDate dueDate,
                     LocalDate actualReturnDate, int startOdometer, int endOdo,
                     double checkoutFuel, double returnFuel, double rentalFee,
                     boolean checkedOut, boolean returned) {
    public boolean overlaps(LocalDate startDate, LocalDate endDate) {
        return !startDate.isAfter(dueDate) && !endDate.isBefore(this.startDate);
    }
    public int days() { return (int)Math.max(1, ChronoUnit.DAYS.between(startDate,dueDate)); }
    public String toLine() {
        return vehicleId+"|"+customerName+"|"+startDate+"|"+dueDate+"|"+
            (actualReturnDate==null?"":actualReturnDate)+"|"+startOdometer+"|"+endOdo+"|"+
            checkoutFuel+"|"+returnFuel+"|"+rentalFee+"|"+checkedOut+"|"+returned;
    }
    public static Rental fromLine(String serializedRecord) {
        String[] recordFields=serializedRecord.split("\\|",-1);
        return new Rental(recordFields[0],recordFields[1],LocalDate.parse(recordFields[2]),LocalDate.parse(recordFields[3]),
            recordFields[4].isEmpty()?null:LocalDate.parse(recordFields[4]),Integer.parseInt(recordFields[5]),Integer.parseInt(recordFields[6]),
            Double.parseDouble(recordFields[7]),Double.parseDouble(recordFields[8]),Double.parseDouble(recordFields[9]),
            Boolean.parseBoolean(recordFields[10]),Boolean.parseBoolean(recordFields[11]));
    }
}
