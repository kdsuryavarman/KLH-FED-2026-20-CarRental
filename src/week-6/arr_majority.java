import java.util.Scanner;

public class arr_majority { // Boyer-Moore majority vote
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int cand = arr[0], count = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) cand = arr[i];
            count += (arr[i] == cand) ? 1 : -1;
        }
        int c = 0;
        for (int i = 0; i < n; i++) if (arr[i] == cand) c++;
        if (c > n / 2) System.out.println("majority = " + cand);
        else System.out.println("no majority element");
    }
}