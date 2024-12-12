import java.util.HashMap;

public class Pathfinder extends Adventurer {
    private String special;
    private int specialCount;
    private int specialMax;
    private HashMap<String, Integer> attacks;
    private final int support = 50;

    public Pathfinder(String name, int hp, HashMap<String, Integer> attacks, String special, int specialCount) {
        super(name, hp);
        this.special = special;
        this.specialCount = specialCount;
        this.attacks = attacks;
        specialMax = 10;
    }

    // USE THIS WHEN WE'RE IN THE CONSOLE SO THE INPUT WILL REPEAT UNTIL A VALID ATTACK IS CHOSEN
    public boolean attackExists(String attack) {
        return attacks.containsKey(attack);
    }

    public String getSpecialName() {
        return special;
    }

    public int getSpecial() {
        return specialCount;
    }

    public void setSpecial(int n) {
        if (n < specialMax)
            specialCount = n;
    }

    public int getSpecialMax() {
        return specialMax;
    }
    
    public String attack(Adventurer other, String attack) {
        // assume attack is valid

        int damage = attacks.get(attack);
        other.applyDamage(damage);
        return "You attacked " + other.getName() + " for " + damage + " damage!";
    }

    public String support(Adventurer other) {

    }

    public String support() {

    }

    public String specialAttack(Adventurer other) {

    }
}
