class GameCharacter {
    String characterName;

    GameCharacter(String characterName) {
        this.characterName = characterName;
    }

    void performAttack() {
        System.out.println(characterName + " attacks!");
    }
}

class Warrior extends GameCharacter {
    Warrior(String name) { super(name); }
    @Override void performAttack() { System.out.println(characterName + " slashes with a sword!"); }
}

class Mage extends GameCharacter {
    Mage(String name) { super(name); }
    @Override void performAttack() { System.out.println(characterName + " casts a fireball!"); }
}

class Archer extends GameCharacter {
    Archer(String name) { super(name); }
    @Override void performAttack() { System.out.println(characterName + " shoots an arrow!"); }
}

public class AdventureGame {
    public static void startBattle(GameCharacter[] characters) {
        int warriors = 0, mages = 0, archers = 0;

        for (GameCharacter c : characters) {
            c.performAttack();
            if (c instanceof Warrior) warriors++;
            else if (c instanceof Mage) mages++;
            else if (c instanceof Archer) archers++;
        }

        System.out.println("Battle Summary:");
        System.out.println("Warriors: " + warriors);
        System.out.println("Mages: " + mages);
        System.out.println("Archers: " + archers);
    }

    public static void main(String[] args) {
        GameCharacter[] team = {
            new Warrior("Thor"),
            new Mage("Merlin"),
            new Archer("Robin"),
            new Warrior("Achilles")
        };

        startBattle(team);
    }
}
