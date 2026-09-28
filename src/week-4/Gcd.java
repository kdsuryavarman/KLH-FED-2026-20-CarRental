import java.util.Scanner;

public class Gcd {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), y = sc.nextInt();
        while (y != 0) {
            int t = y;
            y = x % y;
            x = t;
        }
        System.out.println("gcd=" + x);
    }
}