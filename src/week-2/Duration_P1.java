import java.util.Scanner;

public class Duration_P1 {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Seconds in locker: ");
        int s = sc.nextInt();
        int h = s / 3600;
        int m = (s % 3600) / 60;
        int sec = s % 60;
        System.out.printf("%d s = %02d:%02d:%02d%n", s, h, m, sec);
    }
}