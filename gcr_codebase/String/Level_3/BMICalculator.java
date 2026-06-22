import java.util.Scanner;

public class BMICalculator {
    // Compute BMI and status for one person
    public static String[] computeBmiAndStatus(double weightKg, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weightKg / (heightM * heightM);
        String status;
        if (bmi < 18.5) status = "Underweight";
        else if (bmi < 25.0) status = "Normal";
        else if (bmi < 30.0) status = "Overweight";
        else status = "Obese";
        // Format BMI to two decimals
        String bmiStr = String.format("%.2f", bmi);
        return new String[] { String.valueOf((int)heightCm), String.format("%.2f", weightKg), bmiStr, status };
    }

    // Build table for all persons given weights/heights array
    public static String[][] buildBmiTable(double[][] data) {
        int n = data.length;
        String[][] table = new String[n][4];
        for (int i = 0; i < n; i++) {
            double weight = data[i][0];
            double height = data[i][1];
            table[i] = computeBmiAndStatus(weight, height);
        }
        return table;
    }

    // Display table
    public static void displayTable(String[][] table) {
        System.out.printf("%-8s %-8s %-8s %s%n", "Height", "Weight", "BMI", "Status");
        System.out.println("----------------------------------------");
        for (String[] row : table) {
            System.out.printf("%-8s %-8s %-8s %s%n", row[0], row[1], row[2], row[3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int MEMBERS = 10;
        double[][] data = new double[MEMBERS][2]; // [i][0]=weightKg, [i][1]=heightCm

        System.out.println("Enter weight (kg) and height (cm) for 10 members:");
        for (int i = 0; i < MEMBERS; i++) {
            System.out.printf("Member %d weight (kg): ", i + 1);
            data[i][0] = sc.nextDouble();
            System.out.printf("Member %d height (cm): ", i + 1);
            data[i][1] = sc.nextDouble();
        }

        String[][] result = buildBmiTable(data);
        System.out.println("\nBMI Report:");
        displayTable(result);
    }
}
