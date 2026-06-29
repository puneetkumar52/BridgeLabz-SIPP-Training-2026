class Drone {
    int droneId;
    int batteryPercentage;
    static String companyName = "SkyLogistics";

    Drone(int droneId, int batteryPercentage) {
        this.droneId = droneId;
        this.batteryPercentage = batteryPercentage;
    }

    void startDelivery() {
        if (batteryPercentage > 20) {
            System.out.println("Drone " + droneId + " started delivery.");
        } else {
            System.out.println("Drone " + droneId + " battery too low!");
        }
    }

    void displayStatus() {
        System.out.println("Drone ID: " + droneId + ", Battery: " + batteryPercentage + "%, Company: " + companyName);
    }

    public static void main(String[] args) {
        Drone d1 = new Drone(1, 80);
        Drone d2 = new Drone(2, 15);
        Drone d3 = new Drone(3, 50);

        d1.startDelivery(); d1.displayStatus();
        d2.startDelivery(); d2.displayStatus();
        d3.startDelivery(); d3.displayStatus();
    }
}
