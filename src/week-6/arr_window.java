import java.util.Scanner;

public class arr_window { // fixed-size sliding window: max sum of k consecutive
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int k = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < k; i++) sum += arr[i]; // first window
        int best = sum;
        for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i - k];
            if (sum > best) best = sum;
        } // slide by one
        System.out.println("max sum of " + k + " consecutive = " + best);
    }
}