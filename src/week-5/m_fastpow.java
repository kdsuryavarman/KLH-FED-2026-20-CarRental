import java.util.Scanner;

public class m_fastpow { // recursion: fast exponentiation O(log e)
    static long power(long base, int e) {
        if (e == 0) return 1;
        long half = power(base, e / 2);
        return (e % 2 == 0) ? half * half : half * half * base;
    }

    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        long b = sc.nextLong();
        int e = sc.nextInt();
        System.out.println(b + "^" + e + " = " + power(b, e));
    }
}