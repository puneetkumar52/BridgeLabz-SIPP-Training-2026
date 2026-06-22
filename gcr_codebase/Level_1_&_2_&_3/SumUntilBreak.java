import java.util.Scanner;
public class SumUntilBreak {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        while (true) {
            double value = sc.nextDouble();
            if (value <= 0) break;
            total += value;
        }
        System.out.println("Total value is " + total);
    }
}
