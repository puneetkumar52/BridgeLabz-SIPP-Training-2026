import java.util.Scanner;

public class SplitWords {
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

    public static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] customWords = customSplit(text);
        String[] builtInWords = text.split(" ");

        System.out.println("Custom split:");
        for (String w : customWords) System.out.println(w);

        System.out.println("Built-in split:");
        for (String w : builtInWords) System.out.println(w);

        System.out.println("Are both arrays same? " + compareArrays(customWords, builtInWords));
    }
}
