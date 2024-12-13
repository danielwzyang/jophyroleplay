public class Mudskipper extends Pathfinder {
    // Healer

    public Mudskipper() {
        super("Mudskipper", 150, 10, 20, 1, 30);
    }

    public String getSpecialName() {
        return "Explode";
    }

    public void restoreSpecial(Pathfinder other) {
        other.setSpecial(other.getSpecial() + 1);
    }

}