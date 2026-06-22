import java.util.Scanner;

public class WindChill {
    public static double calculateWindChill(double t, double v) {
        return 35.74 + 0.6215 * t + (0.4275 * t - 35.75) * Math.pow(v, 0.16);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter temperature (F): ");
        double t = sc.nextDouble();
        System.out.print("Enter wind speed (mph): ");
        double v = sc.nextDouble();
        System.out.println("Wind Chill Temperature = " + calculateWindChill(t, v));
    }
}
