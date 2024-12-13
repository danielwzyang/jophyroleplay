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
        return special;
    }

    public int getSpecialCount() {
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
        return "\u001b[33m" + getName() + " \u001b[37mdid \u001b[31m" + attack + " damage \u001b[37mto \u001b[35m" + other.getName() + "!" + "\u001b[37m";
    }

    public int getSupport() {
        return support;
    }

    public String support(Adventurer other) {
        other.heal(support);
        return "\u001b[33m" + getName() + " \u001b[37mhealed \u001b[33m" + other.getName() + " \u001b[37mfor \u001b[33m" + support + " \u001b[37mhealth!";
    }

    public String support() {
        heal(support);
        return "\u001b[33m" + getName() + " \u001b[37mhealed \u001b[33mitself \u001b[37mfor \u001b[32m" + support + " \u001b[37mhealth!";
    }

    public String specialAttack(Adventurer other) {
        specialCount--;
        other.applyDamage(special);
        return "\u001b[33m" + getName() + " \u001b[37mdid \u001b[31m" + attack + " damage \u001b[37mto \u001b[35m" + other.getName() + "!" + "\u001b[37m";
    }
}
