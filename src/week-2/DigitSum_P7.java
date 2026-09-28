import java.util.Scanner;

public class DigitSum_P7 {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Three-digit number: ");
        int n = sc.nextInt();
        int h = n / 100;
        int t = (n / 10) % 10;
        int u = n % 10;
        System.out.println(h + " + " + t + " + " + u + " = " + (h + t + u));
    }
}