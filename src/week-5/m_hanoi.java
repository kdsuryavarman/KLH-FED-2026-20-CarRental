import java.util.Scanner;

public class m_hanoi { // recursion: Tower of Hanoi (moves + count)
    static int moves = 0;

    static void hanoi(int n, char from, char to, char via) {
        if (n == 0) return;
        hanoi(n - 1, from, via, to);
        moves++;
        System.out.println("move disk " + n + " : " + from + " -> " + to);
        hanoi(n - 1, via, to, from);
    }

    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        hanoi(n, 'A', 'C', 'B');
        System.out.println("total moves = " + moves);
    }
}