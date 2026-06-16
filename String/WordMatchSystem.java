import java.util.*;

public class WordMatchSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first skill keyword: ");
        String skill1 = sc.nextLine();

        System.out.print("Enter second skill keyword: ");
        String skill2 = sc.nextLine();

        System.out.println("Skill 1 (uppercase): " + skill1.toUpperCase());
        System.out.println("Skill 2 (uppercase): " + skill2.toUpperCase());

        System.out.println("Length of Skill 1: " + skill1.length());
        System.out.println("Length of Skill 2: " + skill2.length());

        if (areAnagrams(skill1, skill2)) {
            System.out.println("The skills are ANAGRAMS. Good match!");
        } else {
            System.out.println("The skills are NOT anagrams. No match.");
        }

        sc.close();
    }

    public static boolean areAnagrams(String str1, String str2) {
        
        str1 = str1.replaceAll("\\s", "").toLowerCase();
        str2 = str2.replaceAll("\\s", "").toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}
