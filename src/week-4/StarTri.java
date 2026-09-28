

import java.util.Scanner;

public class StarTri {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int r = 1; r <= n; r++) {
            for (int c = 0; c < r; c++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}