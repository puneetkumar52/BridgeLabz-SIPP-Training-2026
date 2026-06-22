import java.util.Scanner;

public class UniqueCharacters {
    // custom length using charAt and exception
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

    // return unique characters as a char array
    public static char[] uniqueCharacters(String text) {
        int n = customLength(text);
        char[] temp = new char[n];
        int uniqueCount = 0;

        for (int i = 0; i < n; i++) {
            char ch = text.charAt(i);
            boolean seen = false;
            // check previous characters in temp
            for (int j = 0; j < uniqueCount; j++) {
                if (temp[j] == ch) {
                    seen = true;
                    break;
                }
            }
            if (!seen) {
                temp[uniqueCount++] = ch;
            }
        }
        // copy to exact-size array
        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) result[i] = temp[i];
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();

        char[] uniques = uniqueCharacters(text);
        System.out.print("Unique characters: ");
        for (char c : uniques) System.out.print(c + " ");
        System.out.println();
    }
}
