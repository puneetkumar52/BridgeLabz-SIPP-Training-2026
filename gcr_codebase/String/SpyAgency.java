import java.uti.*;
public class SpyAgency{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        checkPalindrome(message);
        countVowelsAndConsonants(message);
    }

    public static void checkPalindrome(String message){
        String reversedMessage = "";
        for(int i=message.length()-1;i>=0;i--){
            reversedMessage += message.charAt(i);
        }
        if(message.equals(reversedMessage)){
            System.out.println("The message is a palindrome.");
        } else {
            System.out.println("The message is not a palindrome.");
        }

        public static void countVowelsAndConsonants(String message){
            int vowelCount = 0;
            int consonantCount = 0;
            for(int i=0;i<message.length();i++){
                char ch = Character.toLowerCase(message.charAt(i));
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    vowelCount++;
                } else if(ch >= 'a' && ch <= 'z'){
                    consonantCount++;
                }
            }
            System.out.println("The number of vowels in the message is: " + vowelCount);
            System.out.println("The number of consonants in the message is: " + consonantCount);
        }
       
    }
}