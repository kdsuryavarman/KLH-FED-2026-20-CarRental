import java.util.Scanner;

public class AvgWeight_P3 {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Two weights: ");
        double w1 = sc.nextDouble(), w2 = sc.nextDouble();
        double total = w1 + w2;
        double avg = total / 2.0;
        System.out.printf("total=%.1f kg  avg=%.2f kg%n", total, avg);
    }
}