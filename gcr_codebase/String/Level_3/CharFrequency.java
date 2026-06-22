import java.util.Scanner;
import java.util.ArrayList;

public class CharFrequency {
    // Build frequency table for all ASCII chars
    public static int[] buildFrequency(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }
        return freq;
    }

    // Return 2D String array of characters and their frequencies (only those with freq>0)
    public static String[][] frequencyTable(String text) {
        int[] freq = buildFrequency(text);
        ArrayList<String[]> rows = new ArrayList<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                rows.add(new String[] { String.valueOf((char) i), String.valueOf(freq[i]) });
            }
        }
        String[][] table = new String[rows.size()][2];
        for (int i = 0; i < rows.size(); i++) table[i] = rows.get(i);
        return table;
    }

    public static void displayTable(String[][] table) {
        System.out.printf("%-6s %s%n", "Char", "Frequency");
        System.out.println("----- ---------");
        for (String[] row : table) {
            System.out.printf("%-6s %s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();

        String[][] table = frequencyTable(text);
        displayTable(table);
    }
}
