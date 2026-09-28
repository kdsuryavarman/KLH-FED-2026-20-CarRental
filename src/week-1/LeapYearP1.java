import java.util.Scanner;

public class LeapYearP1 {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Year: ");
        int y = sc.nextInt();
        boolean isLeap = (y % 4 == 0) && (y % 100 != 0 || y % 400 == 0);
        System.out.println(y + (isLeap ? " is a LEAP year" : " is NOT a leap year"));
    }
}