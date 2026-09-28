import java.util.Scanner;

public class Fib {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = 0, y = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(x + " ");
            int z = x + y;
            x = y;
            y = z;
        }
        System.out.println();
    }
}