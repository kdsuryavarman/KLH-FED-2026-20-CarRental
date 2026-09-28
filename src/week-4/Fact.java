import java.util.Scanner;

public class Fact {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long f = 1;
        for (int i = 2; i <= n; i++) {
            f *= i;
        }
        System.out.println(n + "! = " + f);
    }
}