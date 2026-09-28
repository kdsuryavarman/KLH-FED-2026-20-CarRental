import java.util.Scanner;

public class m_palindrome{ // recursion: palindrome check (two-pointer)
    static boolean isPal(String s, int i, int j) {
        if (i >= j) return true;
        if (s.charAt(i) != s.charAt(j)) return false;
        return isPal(s, i + 1, j - 1);
    }

    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(
                s + " -> " + (isPal(s, 0, s.length() - 1) ? "palindrome" : "not a palindrome"));
    }
}