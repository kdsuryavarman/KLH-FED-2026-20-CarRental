import java.util.Scanner;

public class m_binary { // recursion: decimal -> binary string
    static String toBin(int n) {
        if (n == 0) return "0";
        if (n == 1) return "1";
        return toBin(n / 2) + (n % 2);
    }

    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n + " = " + toBin(n) + " (base 2)");
    }
}