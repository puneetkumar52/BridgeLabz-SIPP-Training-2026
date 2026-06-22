import java.util.Scanner;

public class ArrayCheck {
    public static boolean isPositive(int num) { return num > 0; }
    public static boolean isEven(int num) { return num % 2 == 0; }
    public static int compare(int a, int b) {
        if (a > b) return 1;
        else if (a == b) return 0;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Enter number " + (i+1) + ": ");
            arr[i] = sc.nextInt();
            if (isPositive(arr[i])) {
                System.out.println(arr[i] + " is Positive and " + (isEven(arr[i]) ? "Even" : "Odd"));
            } else {
                System.out.println(arr[i] + " is Negative");
            }
        }
        int result = compare(arr[0], arr[4]);
        if (result == 0) System.out.println("First and last are equal");
        else if (result == 1) System.out.println("First is greater than last");
        else System.out.println("First is less than last");
    }
}
