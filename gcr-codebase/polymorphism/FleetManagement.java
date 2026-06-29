abstract class Vehicle {
    abstract double fuelCost(double km);
}

class Car extends Vehicle {
    @Override
    double fuelCost(double km) {
        return km * 5; // Rs.5 per km
    }
}

class Bus extends Vehicle {
    @Override
    double fuelCost(double km) {
        return km * 8; // Rs.8 per km
    }
}

class Bike extends Vehicle {
    @Override
    double fuelCost(double km) {
        return km * 2; // Rs.2 per km
    }
}

// New ElectricCar added without changing existing code
class ElectricCar extends Vehicle {
    @Override
    double fuelCost(double km) {
        return km * 1.5; // cheaper cost
    }
}

public class FleetManagement {
    public static void main(String[] args) {
        Vehicle[] vehicles = { new Car(), new Bus(), new Bike(), new ElectricCar() };

        for (Vehicle v : vehicles) {
            double cost = v.fuelCost(100);
            System.out.println(v.getClass().getSimpleName() + " fuel cost for 100 km: " + cost);
        }
    }
}
