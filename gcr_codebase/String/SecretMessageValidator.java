import java.util.*;

public class SecretMessageValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();

        countCharacter(message);
        messageStrength(message);
    }

    public static void countCharacter(String message) {
        int vowels = 0; 
        int consonants = 0;
        int digits = 0; 
        int specialChars = 0;

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);

            if (Character.isDigit(ch)) {
                digits++;
            } else if (Character.isLetter(ch)) {
                ch = Character.toLowerCase(ch);
                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            } else {
                specialChars++;
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Digits: " + digits);
        System.out.println("Special Characters: " + specialChars);
    }

    public static void messageStrength(String message) {
        int digits = 0;
        int specialChars = 0;

        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (Character.isDigit(ch)) {
                digits++;
            } else if (!Character.isLetter(ch)) {
                specialChars++;
            }
        }

        if (message.length() >= 8 && digits >= 2 && specialChars >= 1) {
            System.out.println("Code Strength: Strong");
        } else {
            System.out.println("Code Strength: Weak");
        }
    }
}
