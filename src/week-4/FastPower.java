import java.util.Scanner;

public class FastPower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long b = sc.nextLong();
        int exp = sc.nextInt();
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) result *= b; // exponent's current bit is 1 -> multiply it in
            b *= b; // square the base for the next bit
            exp >>= 1; // shift to look at the next bit
        }
        System.out.println("result = " + result);
    }
}