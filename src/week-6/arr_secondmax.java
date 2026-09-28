import java.util.Scanner;

public class arr_secondmax { // second largest in one pass
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int max = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                second = max;
                max = arr[i];
            } else if (arr[i] > second && arr[i] != max) {
                second = arr[i];
            }
        }
        if (second == Integer.MIN_VALUE) System.out.println("no distinct second largest");
        else System.out.println("largest=" + max + " second largest=" + second);
    }
}