import java.util.Scanner;

public class SpeedingFineP7 {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Speed, limit: ");
        int speed = sc.nextInt(), limit = sc.nextInt();
        int over = speed - limit;
        String fine =
                (over <= 0)
                        ? "no fine"
                        : (over <= 20) ? "Rs 500" : (over <= 40) ? "Rs 1000" : "Rs 2000 + summons";
        System.out.println("Speed " + speed + " (limit " + limit + ") -> " + fine);
    }
}