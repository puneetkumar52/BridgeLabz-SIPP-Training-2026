import java.util.Scanner;

public class FrequencyUsingUnique {
    // custom length using charAt
    public static int customLength(String s) {
        int count = 0;
        while (true) {
            try {
                s.charAt(count);
                count++;
            } catch (StringIndexOutOfBoundsException e) {
                break;
            }
        }
        return count;
    }

    // unique characters (nested loops)
    public static char[] uniqueCharacters(String text) {
        int n = customLength(text);
        char[] temp = new char[n];
        int uniqueCount = 0;
        for (int i = 0; i < n; i++) {
            char ch = text.charAt(i);
            boolean found = false;
            for (int j = 0; j < uniqueCount; j++) {
                if (temp[j] == ch) { found = true; break; }
            }
            if (!found) temp[uniqueCount++] = ch;
        }
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) result[i] = temp[i];
        return result;
    }

    // frequency array
    public static int[] buildFrequency(String text) {
        int[] freq = new int[256];
        for (int i = 0; i < text.length(); i++) freq[text.charAt(i)]++;
        return freq;
    }

    // build 2D array of unique char and its frequency
    public static String[][] frequencyFromUnique(String text) {
        char[] uniques = uniqueCharacters(text);
        int[] freq = buildFrequency(text);
        String[][] table = new String[uniques.length][2];
        for (int i = 0; i < uniques.length; i++) {
            table[i][0] = String.valueOf(uniques[i]);
            table[i][1] = String.valueOf(freq[uniques[i]]);
        }
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

        String[][] table = frequencyFromUnique(text);
        displayTable(table);
    }
}
