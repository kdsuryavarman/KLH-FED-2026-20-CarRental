import java.util.Scanner;

public class LockerTierP3 {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Parcel weight (kg): ");
        double kg = sc.nextDouble();
        char tier;
        if (kg <= 2.0) tier = 'S';
        else if (kg <= 10.0) tier = 'M';
        else tier = 'L';
        System.out.printf("%.1f kg -> tier %c%n", kg, tier);
    }
}