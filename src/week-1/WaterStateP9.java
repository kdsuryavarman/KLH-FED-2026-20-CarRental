import java.util.Scanner;

public class WaterStateP9 {
    public static void main(String[] a) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Temperature C: ");
        double t = sc.nextDouble();
        String state = (t <= 0) ? "solid (ice)" : (t < 100) ? "liquid (water)" : "gas (steam)";
        System.out.println(t + " C -> " + state);
    }
}