import java.util.Scanner;

public class LockerConsole {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inUse = 0, choice;
        do {
            System.out.println("--- Locker Console ---");
            System.out.println("1) Deposit   2) Collect   3) Report   0) Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    inUse++;
                    System.out.println("Deposited. In use: " + inUse);
                    break;
                case 2:
                    if (inUse > 0) {
                        inUse--;
                        System.out.println("Collected. In use: " + inUse);
                    } else {
                        System.out.println("Nothing to collect.");
                    }
                    break;
                case 3:
                    System.out.println("Lockers in use: " + inUse);
                    break;
                case 0:
                    System.out.println("Goodbye.");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice != 0);
    }
}