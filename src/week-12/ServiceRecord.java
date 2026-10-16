import java.time.LocalDate;
public record ServiceRecord(String vehicleId, LocalDate date, String serviceWork, double serviceCost) {
    public String toLine() { return vehicleId+"|"+date+"|"+serviceWork.replace("|","/")+"|"+serviceCost; }
    public static ServiceRecord fromLine(String serializedRecord) {
        String[] recordFields=serializedRecord.split("\\|",-1);
        return new ServiceRecord(recordFields[0],LocalDate.parse(recordFields[1]),recordFields[2],Double.parseDouble(recordFields[3]));
    }
}
