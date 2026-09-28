import java.util.Scanner;

public class Digits {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0;
        if (n == 0) count = 1;
        while (n > 0) {
            count++;
            n /= 10;
        }
        System.out.println("digits=" + count);
    }
}