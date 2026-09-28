import java.util.Scanner;

public class PriorityLocker_P5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Locker number: ");
        int n = sc.nextInt();
        boolean priority = (n % 2 == 0) && (n % 5 == 0);
        String tag = priority ? "PRIORITY" : "standard";
        System.out.println("Locker " + n + " -> " + tag + "  (not priority = " + !priority + ")");
    }
}