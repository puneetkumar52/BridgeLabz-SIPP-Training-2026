// a kingdom tax charges 5% for the income <10k, 15% for 10k-50k, 30% above 50k. read a citizen's income, print tax bracket and amount. extend : loop over an array of citizens and tally total tax collected.

import java.util.Scanner;

public class ControlFlowScenario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter income for a citizen: ");
        double income = scanner.nextDouble();

        double taxRate;
        if (income < 10000) {
            taxRate = 0.05; // 5%
        } else if (income <= 50000) {
            taxRate = 0.15; // 15%
        } else {
            taxRate = 0.30; // 30%
        }

        double taxAmount = income * taxRate;

        System.out.println("Income: " + income);
        System.out.println("Tax Bracket: " + (taxRate * 100) + "%");
        System.out.println("Tax Amount: " + taxAmount);

        System.out.print("Enter number of citizens: ");
        int count = scanner.nextInt();

        double[] incomes = new double[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Enter income for citizen " + (i + 1) + ": ");
            incomes[i] = scanner.nextDouble();
        }

        double totalTaxCollected = 0;
        for (double citizenIncome : incomes) {
            double rate;
            if (citizenIncome < 10000) {
                rate = 0.05; // 5%
            } else if (citizenIncome <= 50000) {
                rate = 0.15; // 15%
            } else {
                rate = 0.30; // 30%
            }
            totalTaxCollected += citizenIncome * rate;
        }

        System.out.println("Total Tax Collected: $" + totalTaxCollected);
        scanner.close();
    }
}