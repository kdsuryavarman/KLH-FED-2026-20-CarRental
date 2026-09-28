import java.util.Scanner;

public class arr_rainwater { // trapping rain water, two-pointer O(n)/O(1)
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) h[i] = sc.nextInt();
        int lo = 0, hi = n - 1, leftMax = 0, rightMax = 0, water = 0;
        while (lo < hi) {
            if (h[lo] < h[hi]) {
                if (h[lo] >= leftMax) leftMax = h[lo];
                else water += leftMax - h[lo];
                lo++;
            } else {
                if (h[hi] >= rightMax) rightMax = h[hi];
                else water += rightMax - h[hi];
                hi--;
            }
        }
        System.out.println("water trapped = " + water);
    }
}
