import java.util.*;

public class DuplicateTokenDetector {
    public static boolean hasDuplicateToken(String[] tokens) {
        Set<String> seen = new HashSet<>();
        for (String token : tokens) {
            if (!seen.add(token)) return true; // add() fails if already present
        }
        return false;
    }

    public static void main(String[] args) {
        String[] tokens = {"abc", "xyz", "123", "abc"};
        System.out.println(hasDuplicateToken(tokens)); // true
    }
}
