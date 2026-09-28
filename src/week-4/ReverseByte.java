import java.util.Scanner;

public class ReverseByte {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        for (int i = 0; i < 8; i++) { // reverse the low 8 bits (same loop does 32)
            result = (result << 1) | (n & 1); // push result left, drop in n's lowest bit
            n = n >> 1; // advance to n's next bit
        }
        System.out.println(result);
    }
}