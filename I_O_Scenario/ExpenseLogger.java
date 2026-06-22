import java.io.*;
import java.util.Scanner;

class ExpenseLogger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = "expenses.txt";

        System.out.print("Enter expense category: ");
        String category = sc.nextLine();
        System.out.print("Enter amount: ");
        int amount = sc.nextInt();

        try (FileWriter fw = new FileWriter(fileName, true)) { // append mode
            fw.write(category + " - " + amount + "\n");
            System.out.println("Expense saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
