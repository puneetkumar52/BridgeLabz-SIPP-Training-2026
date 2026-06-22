import java.util.Scanner;

public class StringLengthDemo {
    public static int customLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // stop when exception occurs
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();

        int customLen = customLength(text);
        int builtInLen = text.length();

        System.out.println("Custom length: " + customLen);
        System.out.println("Built-in length: " + builtInLen);
    }
}
