interface StreamingService {
    void streamMovie(String movie);

    default void showSubscriptionDetails() {
        System.out.println("Streaming subscription: Basic Plan");
    }
}

interface GamingService {
    void playGame(String game);

    default void showSubscriptionDetails() {
        System.out.println("Gaming subscription: Premium Plan");
    }
}

public class SmartTV implements StreamingService, GamingService {
    private String[] movies = {"Inception", "Interstellar", "The Matrix"};
    private String[] games = {"FIFA", "Call of Duty", "Minecraft"};

    @Override
    public void streamMovie(String movie) {
        System.out.println("Streaming movie: " + movie);
    }

    @Override
    public void playGame(String game) {
        System.out.println("Playing game: " + game);
    }

    // Resolve default method conflict
    @Override
    public void showSubscriptionDetails() {
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
    }

    public void displayAllContent() {
        System.out.println("Available Movies:");
        for (String m : movies) System.out.println("- " + m);

        System.out.println("Available Games:");
        for (String g : games) System.out.println("- " + g);
    }

    public static void main(String[] args) {
        SmartTV tv = new SmartTV();
        tv.showSubscriptionDetails();
        tv.displayAllContent();
        tv.streamMovie("Inception");
        tv.playGame("FIFA");
    }
}
