class Vehicle {
    String vehicleNumber;
    String ownerName;
    String vehicleType; // "Car" or "Bike"

    Vehicle(String vehicleNumber, String ownerName, String vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    void display() {
        System.out.println("Number: " + vehicleNumber + ", Owner: " + ownerName + ", Type: " + vehicleType);
    }

    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[10];
        vehicles[0] = new Vehicle("UP01AB1234", "Ravi", "Car");
        vehicles[1] = new Vehicle("UP02XY5678", "Anita", "Bike");
        vehicles[2] = new Vehicle("UP03PQ1111", "Vikram", "Car");
        vehicles[3] = new Vehicle("UP04LM2222", "Sita", "Bike");
        vehicles[4] = new Vehicle("UP05JK3333", "Arjun", "Car");
        vehicles[5] = new Vehicle("UP06MN4444", "Radha", "Bike");
        vehicles[6] = new Vehicle("UP07OP5555", "Krishna", "Car");
        vehicles[7] = new Vehicle("UP08QR6666", "Meera", "Bike");
        vehicles[8] = new Vehicle("UP09ST7777", "Shyam", "Car");
        vehicles[9] = new Vehicle("UP10UV8888", "Geeta", "Bike");

        System.out.println("Cars in Parking:");
        for (Vehicle v : vehicles) {
            if (v.vehicleType.equalsIgnoreCase("Car")) v.display();
        }

        System.out.println("\nBikes in Parking:");
        for (Vehicle v : vehicles) {
            if (v.vehicleType.equalsIgnoreCase("Bike")) v.display();
        }
    }
}
