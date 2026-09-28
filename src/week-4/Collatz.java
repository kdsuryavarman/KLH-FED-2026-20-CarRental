import java.util.Scanner;

public class Collatz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int steps = 0;
        while (n != 1) {
            if (n % 2 == 0) n = n / 2; // even -> halve
            else n = 3 * n + 1; // odd  -> triple plus one
            steps++;
        }
        System.out.println(steps + " steps to reach 1");
    }
}