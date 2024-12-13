import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        ArrayList<Adventurer> players = new ArrayList<>();
        players.add(getRandomPathfinder());
        players.add(getRandomPathfinder());

        Pathfinder enemy = getRandomPathfinder();

        while (players.size() > 0) {
            System.out.println("You are fighting a " + enemy.getName() + ": " + enemy.getHP() + "/" + enemy.getmaxHP());
            
            int target = (int) (Math.random() * 3);

            switch (target) {
                case 0:
                    System.out.println("The enemy did " + enemy.getAttack() + " damage to " + players.get(0).getName() + "!");
                    enemy.attack(players.get(0));
                case 1:
                    if (players.size() == 1) {
                        System.out.println("The enemy did " + enemy.getAttack() + " damage to " + players.get(0).getName() + "!");
                        enemy.attack(players.get(0));
                    } else {
                        System.out.println("The enemy did 50 damage!");
                        enemy.attack(players.get(0));
                    }
                case 2: 
                    System.out.println("The enemy missed! Lucky you!");
            }
            
            if (target.equals(players.get(0).getName())) {
                System.out.println("The enemy did 50 damage!");
                players.get(0).setHP(players.get(0).getHP() - 50);
            } else if (target.equals(players.get(1).getName())) {

            } else {
                System.out.println("The enemy missed! Lucky you!");
            }
        }

        System.out.println("Both of your characters died. You lost!");
    }

    public static Pathfinder getRandomPathfinder() {
        switch ((int) (Math.random() * 3)) {
            case 0:
                return new Thresher();
            case 1:
                return new Mudskipper();
            case 2:
                return new Sharko();
        }
        
        // to make java compiler happy oog
        return new Pathfinder(null, 0, 0, 0, 0, 0);
    }
}
