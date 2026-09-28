import java.util.Arrays;
import java.util.Scanner;

public class arr_dutch { // Dutch National Flag: sort 0s,1s,2s one pass
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int low = 0, mid = 0, high = n - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                int t = arr[low];
                arr[low] = arr[mid];
                arr[mid] = t;
                low++;
                mid++;
            } else if (arr[mid] == 1) mid++;
            else {
                int t = arr[mid];
                arr[mid] = arr[high];
                arr[high] = t;
                high--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}