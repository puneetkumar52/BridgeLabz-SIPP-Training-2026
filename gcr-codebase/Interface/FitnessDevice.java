/*
1.Build a fitness tracker: interfaces Trackable (logActivity()), Reportable
(generateReport()), Notifiable (sendAlert()). Class FitnessDevice
implements all three. Add a default method resetData() to Trackable.
Demonstrate multiple interface implementation Java cannot do with
classes.
 */

interface Trackable {
    void logActivity(int steps, double distance);

    default void resetData() {
        System.out.println("Resetting tracked data...");
    }
}

// Reportable interface
interface Reportable {
    void generateReport();
}

// Notifiable interface
interface Notifiable {
    void sendAlert(String message);
}

// FitnessDevice implements all three interfaces
public class FitnessDevice implements Trackable, Reportable, Notifiable {
    private String deviceName;
    private int steps;
    private double distance;

    public FitnessDevice(String deviceName) {
        this.deviceName = deviceName;
        this.steps = 0;
        this.distance = 0.0;
    }

    @Override
    public void logActivity(int steps, double distance) {
        this.steps += steps;
        this.distance += distance;
        System.out.println("Logged activity: " + steps + " steps, " + distance + " km.");
    }

    @Override
    public void generateReport() {
        System.out.println("Fitness Report for " + deviceName + ":");
        System.out.println("Total Steps: " + steps);
        System.out.println("Total Distance: " + distance + " km.");
    }

    @Override
    public void sendAlert(String message) {
        System.out.println("Alert from " + deviceName + ": " + message);
    }

    // Override default resetData() to actually clear values
    @Override
    public void resetData() {
        steps = 0;
        distance = 0.0;
        System.out.println("Data reset for " + deviceName);
    }

    public static void main(String[] args) {
        FitnessDevice myDevice = new FitnessDevice("FitTrack Pro");
        myDevice.logActivity(5000, 3.5);
        myDevice.generateReport();
        myDevice.sendAlert("Time to take a break!");
        myDevice.resetData();
        myDevice.generateReport();
    }
}
