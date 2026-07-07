import java.util.*;

public class EventEntrySystem {
    private HashSet<String> participants = new HashSet<>();

    public void register(String email) {
        if (participants.add(email))
            System.out.println("Registered: " + email);
        else
            System.out.println("Duplicate entry rejected: " + email);
    }

    public void display() {
        System.out.println("Unique Participants: " + participants);
        System.out.println("Total attendees: " + participants.size());
    }

    public static void main(String[] args) {
        EventEntrySystem event = new EventEntrySystem();
        event.register("alice@mail.com");
        event.register("bob@mail.com");
        event.register("alice@mail.com"); // duplicate
        event.display();
    }
}
