abstract class Vehicle {
    String vehicleNumber;
    String ownerName;

    Vehicle(String vehicleNumber, String ownerName) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    abstract double calculateToll();
}

class Car extends Vehicle {
    Car(String num, String owner) { super(num, owner); }
    @Override double calculateToll() { return 100; }
}

class Bus extends Vehicle {
    Bus(String num, String owner) { super(num, owner); }
    @Override double calculateToll() { return 200; }
}

class Truck extends Vehicle {
    Truck(String num, String owner) { super(num, owner); }
    @Override double calculateToll() { return 300; }
}

public class TollSystem {
    static double calculateTotalRevenue(Vehicle[] vehicles) {
        double total = 0;
        for (Vehicle v : vehicles) total += v.calculateToll();
        return total;
    }

    static Vehicle searchVehicle(Vehicle[] vehicles, String number) {
        for (Vehicle v : vehicles) {
            if (v.vehicleNumber.equals(number)) return v;
        }
        return null;
    }

    static Vehicle findHighestToll(Vehicle[] vehicles) {
        Vehicle max = vehicles[0];
        for (Vehicle v : vehicles) {
            if (v.calculateToll() > max.calculateToll()) max = v;
        }
        return max;
    }

    static void countVehiclesByType(Vehicle[] vehicles) {
        int cars=0, buses=0, trucks=0;
        for (Vehicle v : vehicles) {
            if (v instanceof Car) cars++;
            else if (v instanceof Bus) buses++;
            else if (v instanceof Truck) trucks++;
        }
        System.out.println("Cars: " + cars + ", Buses: " + buses + ", Trucks: " + trucks);
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("C101","Alice"),
            new Bus("B202","Bob"),
            new Truck("T303","Charlie"),
            new Car("C404","David")
        };

        System.out.println("Total Revenue: " + calculateTotalRevenue(vehicles));
        Vehicle found = searchVehicle(vehicles,"B202");
        if(found!=null) System.out.println("Found vehicle: " + found.ownerName);

        Vehicle highest = findHighestToll(vehicles);
        System.out.println("Highest toll paid by: " + highest.ownerName + " ("+highest.vehicleNumber+")");

        countVehiclesByType(vehicles);
    }
}
