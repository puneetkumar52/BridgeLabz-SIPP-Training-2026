class Notification {
    String recipientName;
    String message;

    Notification(String recipientName, String message) {
        this.recipientName = recipientName;
        this.message = message;
    }

    void sendNotification() {
        System.out.println("Sending notification to " + recipientName);
    }
}

class EmailNotification extends Notification {
    EmailNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    void sendNotification() {
        System.out.println("Email sent to " + recipientName + ": " + message);
    }
}

class SMSNotification extends Notification {
    SMSNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    void sendNotification() {
        System.out.println("SMS sent to " + recipientName + ": " + message);
    }
}

class PushNotification extends Notification {
    PushNotification(String recipientName, String message) {
        super(recipientName, message);
    }

    @Override
    void sendNotification() {
        System.out.println("Push notification sent to " + recipientName + ": " + message);
    }
}

public class NotificationSystem {
    public static void main(String[] args) {
        Notification[] notifications = {
            new EmailNotification("Alice", "Meeting at 10 AM"),
            new SMSNotification("Bob", "Your OTP is 1234"),
            new PushNotification("Charlie", "New update available!")
        };

        for (Notification n : notifications) {
            n.sendNotification();
        }
    }
}
