import java.util.Scanner;

public class  QuadraticRootsP5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("a, b, c: ");
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        int d = b * b - 4 * a * c;
        String nature =
                (d > 0)
                        ? "two distinct real roots"
                        : (d == 0) ? "one repeated real root" : "two complex roots";
        System.out.println("discriminant = " + d + " -> " + nature);
    }
}