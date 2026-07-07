import java.util.*;

public class ParkingManager {
    private ArrayList<String> parkedVehicles = new ArrayList<>();

    public void enter(String regNo) {
        parkedVehicles.add(regNo);
        System.out.println(regNo + " entered.");
    }

    public void exit(String regNo) {
        if (parkedVehicles.remove(regNo))
            System.out.println(regNo + " exited.");
        else
            System.out.println("Vehicle not found.");
    }

    public void search(String regNo) {
        if (parkedVehicles.contains(regNo))
            System.out.println(regNo + " is parked.");
        else
            System.out.println(regNo + " not found.");
    }

    public void display() {
        System.out.println("Parked Vehicles: " + parkedVehicles);
        System.out.println("Total slots occupied: " + parkedVehicles.size());
    }

    public static void main(String[] args) {
        ParkingManager pm = new ParkingManager();
        pm.enter("UP32AB1234");
        pm.enter("DL01CD5678");
        pm.search("UP32AB1234");
        pm.exit("DL01CD5678");
        pm.display();
    }
}
