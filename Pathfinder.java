public class Pathfinder extends Adventurer {
    private int special;
    private int specialCount;
    private int specialMax;
    private int attack;
    private int support;

    public Pathfinder(String name, int hp, int attack, int special, int specialCount, int support) {
        super(name, hp);
        this.attack = attack;
        this.special = special;
        this.specialCount = specialCount;
        specialMax = specialCount;
        this.support = support;
    }
    
    public String getSpecialName() {
        return "Super Move";
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
    
    public int getAttack() {
        return attack;
    }

    public String attack(Adventurer other) {
        other.applyDamage(attack);
        return "You attacked " + other.getName() + " for " + attack + " damage!";
    }

    public String support(Adventurer other) {
        other.heal(support);
        return "You healed " + other.getName() + " for " + support + " health!";
    }

    public String support() {
        heal(support);
        return "You healed yourself for " + support + " health!";
    }

    public String specialAttack(Adventurer other) {
        if (specialCount <= 0 )
            return "You have no more special attacks!";
        
        specialCount--;
        other.applyDamage(special);
        return "You attacked " + other.getName() + " for " + special + " damage!";
    }
}
