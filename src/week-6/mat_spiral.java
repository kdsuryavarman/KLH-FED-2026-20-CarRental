import java.util.Scanner;

public class mat_spiral { // spiral-order traversal
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt(), c = sc.nextInt();
        int[][] m = new int[r][c];
        for (int i = 0; i < r; i++) for (int j = 0; j < c; j++) m[i][j] = sc.nextInt();
        int top = 0, bottom = r - 1, left = 0, right = c - 1;
        String out = "";
        while (top <= bottom && left <= right) {
            for (int j = left; j <= right; j++) out += m[top][j] + " ";
            top++;
            for (int i = top; i <= bottom; i++) out += m[i][right] + " ";
            right--;
            if (top <= bottom) {
                for (int j = right; j >= left; j--) out += m[bottom][j] + " ";
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) out += m[i][left] + " ";
                left++;
            }
        }
        System.out.println(out.trim());
    }
}