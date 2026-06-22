/*
A hospital billing system must never crash. Wrap division-by-zero
(bills with zero items), array out-of-bounds (invalid patient index),
and number format exceptions (bad input) with meaningful
messages. Create a custom InsufficientFundsException for payment
failures.
*/

import java.util.Scanner;
class HospitalBillingSystem extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

public class HospitalBillingSystem {
    static void computeAverageCost(double bill, int items) {
        try {
            if (items == 0) {
                throw new ArithmeticException("Bill cannot have zero items!");
            }
            double avg = bill / items;
            System.out.println("Average cost per item = " + avg);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static double getPatientBill(double[] bills, int index) {
        try {
            if (index < 0 || index >= bills.length) {
                throw new ArrayIndexOutOfBoundsException("Invalid patient index!");
            }
            return bills[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            return -1; // sentinel value
        }
    }

    static void processPayment(double bill, String paymentStr) {
        try {
            double payment = Double.parseDouble(paymentStr);
            if (payment < bill) {
                throw new InsufficientFundsException("Payment failed! Amount less than bill.");
            }
            System.out.println("Payment successful!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format entered!");
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] bills = {5000, 12000, 8000}; // sample patient bills

        System.out.print("Enter number of items in bill: ");
        int items = sc.nextInt();
        computeAverageCost(bills[0], items);

        System.out.print("Enter patient index (0-2): ");
        int index = sc.nextInt();
        double bill = getPatientBill(bills, index);

        if (bill != -1) { 
            System.out.print("Enter payment amount: ");
            String paymentStr = sc.next();
            processPayment(bill, paymentStr);
        }

        System.out.println("System continues running safely.");
    }
}
