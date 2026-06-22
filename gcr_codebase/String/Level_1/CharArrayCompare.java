import java.util.Scanner;

public class CharArrayCompare {
    // User-defined method to convert String to char array
    public static char[] customToCharArray(String s) {
        char[] arr = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i);
        }
        return arr;
    }

    // Compare two char arrays
    public static boolean compareArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();

        char[] customArr = customToCharArray(text);
        char[] builtInArr = text.toCharArray();

        System.out.println("Custom char array: " + new String(customArr));
        System.out.println("Built-in char array: " + new String(builtInArr));
        System.out.println("Are both arrays same? " + compareArrays(customArr, builtInArr));
    }
}
