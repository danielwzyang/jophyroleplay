import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        ArrayList<Pathfinder> players = new ArrayList<>();
        players.add(getRandomPathfinder());
        players.add(getRandomPathfinder());

        Pathfinder enemy = getRandomPathfinder();

        Scanner input = new Scanner(System.in);

        System.out.println("Your group of two pathfinders enters the dungeon: ");
        System.out.println("1: \u001b[33m" + players.get(0).getName() + " \u001b[32m" + players.get(0).getHP() + "/" + players.get(0).getmaxHP() + "\u001b[37m");
        System.out.println("2: \u001b[33m" + players.get(1).getName() + " \u001b[32m" + players.get(1).getHP() + "/" + players.get(1).getmaxHP() + "\u001b[37m");
        System.out.println();

        while (players.size() > 0) {
            System.out.println("You are fighting a \u001b[35m" + enemy.getName() + " \u001b[32m" + enemy.getHP() + "/" + enemy.getmaxHP() + "\u001b[37m");
            
            int target = (int) (Math.random() * 10);

            if (target == players.size())
                System.out.println("The enemy missed! Lucky you!");
            else if (target % 2 == 0) {
                System.out.println("The enemy did \u001b[31m" + enemy.getAttack() + " damage \u001b[37mto \u001b[33m" + players.get(0).getName() + "!" + "\u001b[37m");
                enemy.attack(players.get(0));
            } else if (target % 2 == 1) {
                System.out.println("The enemy did \u001b[31m" + enemy.getAttack() + " damage \u001b[37mto \u001b[33m" + players.get(1).getName() + "!" + "\u001b[37m");
                enemy.attack(players.get(1));
            }
            
            if (target < players.size() && players.get(target % 2).getHP() < 0) {
                System.out.println("\u001b[33m" + players.get(target % 2).getName() + " \u001b[37mhas died!");
                players.remove(target);
                if (players.size() == 0) break;
            }

            System.out.println();

            Pathfinder current;

            if (players.size() == 2) {
                System.out.println("Which character do you want to use this turn?");
                System.out.println("1: \u001b[33m" + players.get(0).getName() + " \u001b[32m" + players.get(0).getHP() + "/" + players.get(0).getmaxHP() + "\u001b[37m");
                System.out.println("2: \u001b[33m" + players.get(1).getName() + " \u001b[32m" + players.get(1).getHP() + "/" + players.get(1).getmaxHP() + "\u001b[37m");
                
                System.out.print("> ");
                int choice = input.nextInt();
                while (choice < 1 || choice > 2) {
                    System.out.println("Please choose either 1 or 2.");
                    System.out.print("> ");
                    choice = input.nextInt();
                }

                current = players.get(choice - 1);
            } else {
                System.out.println("1: \u001b[33m" + players.get(0).getName() + " \u001b[32m" + players.get(0).getHP() + "/" + players.get(0).getmaxHP() + "\u001b[37m");
                current = players.get(0);
            }

            System.out.println();

            System.out.println("What move do you want to make?");
            System.out.println("1: \u001b[36mNormal Attack \u001b[37m-> \u001b[31m" + current.getAttack() + "\u001b[37m");
            System.out.println("2: \u001b[36m" + current.getSpecialName() + " \u001b[37m-> \u001b[31m" + current.getSpecial() + "\u001b[37m");
            System.out.println("3: \u001b[36mSelf-heal \u001b[37m-> \u001b[32m" + current.getSupport() + "\u001b[37m");
            
            System.out.print("> ");
            int choice = input.nextInt();
            while (choice < 1 || choice > 4) {
                System.out.println("Please choose a number between 1 and 3.");
                System.out.print("> ");
                choice = input.nextInt();
            }

            while (choice == 2 && current.getSpecialCount() == 0) {
                System.out.println("\u001b[33m" + current.getName() + " \u001b[37mhas no more special attacks!");
                System.out.print("> ");
                choice = input.nextInt();
            }

            // TODO: heal teammate

            switch (choice) {
                case 1:
                    System.out.println(current.attack(enemy));
                    break;
                case 2:
                    System.out.println(current.specialAttack(enemy));
                    System.out.println("\u001b[33m" + current.getName() + " \u001b[37mhas " + current.getSpecialCount() + " special attacks left.");
                    break;
                case 3:
                    System.out.println(current.support());
                    break;
            }

            if (enemy.getHP() <= 0) {
                System.out.println("\u001b[31m" + enemy.getName() + " \u001b[31mwas killed!");
                enemy = getRandomPathfinder();
            }
                
            System.out.println();   
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
