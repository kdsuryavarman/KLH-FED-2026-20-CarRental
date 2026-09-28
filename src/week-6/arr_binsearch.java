import java.util.Scanner;

public class arr_binsearch { // binary search on a sorted array, O(log n)
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int target = sc.nextInt();
        int lo = 0, hi = n - 1, ans = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2; // avoids overflow vs (lo+hi)/2
            if (arr[mid] == target) {
                ans = mid;
                break;
            } else if (arr[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        System.out.println(ans >= 0 ? "found at index " + ans : "not found");
    }
}