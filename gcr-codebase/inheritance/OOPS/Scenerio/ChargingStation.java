class ChargingStation {
    static int totalStations = 0;
    static double electricityRate = 10.0; 

    int stationId;
    double unitsConsumed;

    ChargingStation(int stationId, double unitsConsumed) {
        this.stationId = stationId;
        this.unitsConsumed = unitsConsumed;
        totalStations++;
    }

    double calculateBill() {
        return unitsConsumed * electricityRate;
    }

    void displayStationDetails() {
        System.out.println("Station ID: " + stationId + ", Units: " + unitsConsumed + ", Bill: " + calculateBill());
    }

    public static void main(String[] args) {
        ChargingStation s1 = new ChargingStation(1, 50);
        ChargingStation s2 = new ChargingStation(2, 30);
        ChargingStation s3 = new ChargingStation(3, 70);
        ChargingStation s4 = new ChargingStation(4, 40);
        ChargingStation s5 = new ChargingStation(5, 100);

        s1.displayStationDetails();
        s2.displayStationDetails();
        s3.displayStationDetails();
        s4.displayStationDetails();
        s5.displayStationDetails();

        System.out.println("Total Stations: " + ChargingStation.totalStations);

        ChargingStation.electricityRate = 12.0;
        System.out.println("Updated Electricity Rate: " + ChargingStation.electricityRate);

        s1.displayStationDetails();
    }
}
