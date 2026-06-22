import java.util.Scanner;

public class ShortestLongestWord {
    public static int customLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {}
        return count;
    }

    public static String[] customSplit(String s) {
        int len = customLength(s);
        int wordCount = 1;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') wordCount++;
        }

        String[] words = new String[wordCount];
        int start = 0, index = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                words[index++] = s.substring(start, i);
                start = i + 1;
            }
        }
        words[index] = s.substring(start, len);
        return words;
    }

    public static String[][] wordWithLength(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(customLength(words[i]));
        }
        return result;
    }

    public static String[] findShortestLongest(String[][] table) {
        String shortest = table[0][0];
        String longest = table[0][0];
        int minLen = Integer.parseInt(table[0][1]);
        int maxLen = minLen;

        for (String[] row : table) {
            int len = Integer.parseInt(row[1]);
            if (len < minLen) {
                minLen = len;
                shortest = row[0];
            }
            if (len > maxLen) {
                maxLen = len;
                longest = row[0];
            }
        }
        return new String[]{shortest, longest};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] words = customSplit(text);
        String[][] table = wordWithLength(words);
        String[] result = findShortestLongest(table);

        System.out.println("Shortest word: " + result[0]);
        System.out.println("Longest word: " + result[1]);
    }
}
