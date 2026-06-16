import java.util.Scanner;

public class UsernameValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Accept username
        System.out.print("Enter a username: ");
        String username = sc.nextLine();

        // Step 2: Check for spaces
        if (username.contains(" ")) {
            System.out.println("Invalid username: contains spaces.");
        } else {
            System.out.println("Valid username: no spaces.");
        }

        // Step 3: Count characters
        System.out.println("Total number of characters: " + username.length());

        // Step 4: Convert to uppercase
        String upperUsername = username.toUpperCase();
        System.out.println("Username in uppercase: " + upperUsername);

        // Step 5: Check palindrome
        String reversed = new StringBuilder(username).reverse().toString();
        if (username.equalsIgnoreCase(reversed)) {
            System.out.println("The username is a palindrome.");
        } else {
            System.out.println("The username is not a palindrome.");
        }

        sc.close();
    }
}
