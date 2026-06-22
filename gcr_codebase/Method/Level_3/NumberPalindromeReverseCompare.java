import java.util.Arrays;

public class NumberPalindromeReverseCompare {
    public static int[] reverseArray(int[] digits) {
        int[] rev = new int[digits.length];
        for (int i = 0; i < digits.length; i++) rev[i] = digits[digits.length - 1 - i];
        return rev;
    }

    public static boolean arraysEqual(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }

    public static boolean isPalindrome(int[] digits) {
        return arraysEqual(digits, reverseArray(digits));
    }

    public static void main(String[] args) {
        int num = 121;
        int[] digits = NumberChecker.storeDigits(num);
        System.out.println("Palindrome? " + isPalindrome(digits));
    }
}
