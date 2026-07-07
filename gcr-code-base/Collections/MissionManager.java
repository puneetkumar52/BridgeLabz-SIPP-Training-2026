import java.util.*;

class Astronaut {
    String astronautId, name, specialization;

    Astronaut(String id, String name, String specialization) {
        this.astronautId = id;
        this.name = name;
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return astronautId + " | " + name + " | " + specialization;
    }
}

public class MissionManager {
    private HashMap<String, List<Astronaut>> missions = new HashMap<>();
    private HashMap<String, HashSet<String>> missionAssignments = new HashMap<>();

    public void addMission(String missionName) {
        missions.putIfAbsent(missionName, new ArrayList<>());
        missionAssignments.putIfAbsent(missionName, new HashSet<>());
        System.out.println("Mission added: " + missionName);
    }

    public void assignAstronaut(String missionName, Astronaut astronaut) {
        if (!missions.containsKey(missionName)) {
            System.out.println("Mission not found!");
            return;
        }
        HashSet<String> assignedIds = missionAssignments.get(missionName);
        if (assignedIds.contains(astronaut.astronautId)) {
            System.out.println("Duplicate assignment rejected for " + astronaut.name);
        } else {
            missions.get(missionName).add(astronaut);
            assignedIds.add(astronaut.astronautId);
            System.out.println("Assigned " + astronaut.name + " to " + missionName);
        }
    }

    public void displayMissions() {
        for (String mission : missions.keySet()) {
            List<Astronaut> crew = missions.get(mission);
            System.out.println("Mission: " + mission);
            for (Astronaut a : crew) System.out.println("- " + a);
            System.out.println("Total crew: " + crew.size());
        }
    }

    public static void main(String[] args) {
        MissionManager mm = new MissionManager();
        mm.addMission("Mars2026");
        mm.addMission("MoonBase");

        Astronaut a1 = new Astronaut("A1", "Alice", "Pilot");
        Astronaut a2 = new Astronaut("A2", "Bob", "Engineer");

        mm.assignAstronaut("Mars2026", a1);
        mm.assignAstronaut("Mars2026", a2);
        mm.assignAstronaut("Mars2026", a1); // duplicate

        mm.displayMissions();
    }
}
