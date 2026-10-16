import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner keyboardInput = new Scanner(System.in);
        Vehicle vehicle = new Vehicle("S1", "SUV", 39000, 40000, 2500, 8) {};
        System.out.print("Customer: "); String customerName=keyboardInput.nextLine();
        System.out.print("Start day and dueDate day: "); int startDay=keyboardInput.nextInt(), dueDay=keyboardInput.nextInt();
        System.out.print("Start odometer and return odometer: "); int startOdometer=keyboardInput.nextInt(), returnOdometer=keyboardInput.nextInt();
        System.out.print("Start fuel and end fuel (0 to 1): "); double checkoutFuel=keyboardInput.nextDouble(), returnFuel=keyboardInput.nextDouble();
        if (returnOdometer < startOdometer) System.out.println("Invalid odometer");
        else {
            int days=Math.max(1,dueDay-startDay), distanceKm=returnOdometer-startOdometer;
            double totalFee=vehicle.charge(days, distanceKm, checkoutFuel, returnFuel, 0);
            Rental rental=new Rental(vehicle.getId(),customerName,startDay,dueDay,startOdometer,returnOdometer,checkoutFuel,returnFuel,totalFee);
            System.out.println("Invoice: " + rental);
            System.out.println("Total Rs." + totalFee);
        }
        keyboardInput.close();
    }
}
