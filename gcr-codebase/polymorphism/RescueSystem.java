abstract class RescueTeam {
    String teamId;
    String location;

    RescueTeam(String id, String loc) {
        this.teamId=id;
        this.location=loc;
    }

    abstract void performDuty();
}

class MedicalTeam extends RescueTeam {
    MedicalTeam(String id,String loc){super(id,loc);}
    @Override void performDuty(){System.out.println("Medical team "+teamId+" treating injured at "+location);}
}

class FireRescueTeam extends RescueTeam {
    FireRescueTeam(String id,String loc){super(id,loc);}
    @Override void performDuty(){System.out.println("Fire rescue team "+teamId+" extinguishing fire at "+location);}
}

class FoodSupplyTeam extends RescueTeam {
    FoodSupplyTeam(String id,String loc){super(id,loc);}
    @Override void performDuty(){System.out.println("Food supply team "+teamId+" distributing food at "+location);}
}

public class RescueSystem {
    static RescueTeam findTeamByLocation(RescueTeam[] teams,String loc){
        for(RescueTeam t:teams) if(t.location.equals(loc)) return t;
        return null;
    }

    static void displayTeamsByPrefix(RescueTeam[] teams,String prefix){
        for(RescueTeam t:teams) if(t.teamId.startsWith(prefix)) System.out.println(t.teamId+" at "+t.location);
    }

    static void countTeams(RescueTeam[] teams){
        int med=0,fire=0,food=0;
        for(RescueTeam t:teams){
            if(t instanceof MedicalTeam) med++;
            else if(t instanceof FireRescueTeam) fire++;
            else if(t instanceof FoodSupplyTeam) food++;
        }
        System.out.println("Medical: "+med+", Fire: "+fire+", Food: "+food);

        // find max category
        int max=Math.max(med,Math.max(fire,food));
        if(max==med) System.out.println("Max deployments: Medical Teams");
        else if(max==fire) System.out.println("Max deployments: Fire Rescue Teams");
        else System.out.println("Max deployments: Food Supply Teams");
    }

    public static void main(String[] args){
        RescueTeam[] teams={
            new MedicalTeam("M101","CityA"),
            new FireRescueTeam("F202","CityB"),
            new FoodSupplyTeam("FS303","CityA"),
            new MedicalTeam("M404","CityC")
        };

        for(RescueTeam t:teams) t.performDuty();

        RescueTeam found=findTeamByLocation(teams,"CityA");
        if(found!=null) System.out.println("Found team at CityA: "+found.teamId);

        System.out.println("Teams with prefix M:");
        displayTeamsByPrefix(teams,"M");

        countTeams(teams);
    }
}
