import java.util.Scanner;

public class FirstNonRepeating {
    // Build frequency using ASCII indexes
    public static int[] buildFrequency(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }
        return freq;
    }

    // Return first non-repeating char or '\0' if none
    public static char firstNonRepeating(String text) {
        int[] freq = buildFrequency(text);
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq[ch] == 1) return ch;
        }
        return '\0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();

        char result = firstNonRepeating(text);
        if (result == '\0') System.out.println("No non-repeating character found.");
        else System.out.println("First non-repeating character: " + result);
    }
}
