interface TextModeration {
    boolean isOffensive(String post);

    default void displayModerationPolicy() {
        System.out.println("Policy: No offensive language allowed.");
    }
}

interface SpamDetection {
    boolean isSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("Policy: No spam or repeated ads allowed.");
    }
}

public class ContentModerator implements TextModeration, SpamDetection {
    private String[] posts = {
        "Buy cheap products now!!!",
        "I hate everyone here",
        "Good morning friends!"
    };

    @Override
    public boolean isOffensive(String post) {
        return post.toLowerCase().contains("hate");
    }

    @Override
    public boolean isSpam(String post) {
        return post.toLowerCase().contains("buy");
    }

    // Resolve default method conflict
    @Override
    public void displayModerationPolicy() {
        TextModeration.super.displayModerationPolicy();
        SpamDetection.super.displayModerationPolicy();
    }

    public static boolean containsRestrictedWords(String post) {
        return post.toLowerCase().contains("hate") || post.toLowerCase().contains("spam");
    }

    public void analyzePosts() {
        for (String post : posts) {
            if (isSpam(post)) {
                System.out.println("Spam post: " + post);
            } else if (isOffensive(post)) {
                System.out.println("Offensive post: " + post);
            } else {
                System.out.println("Valid post: " + post);
            }
        }
    }

    public static void main(String[] args) {
        ContentModerator cm = new ContentModerator();
        cm.displayModerationPolicy();
        cm.analyzePosts();
    }
}
