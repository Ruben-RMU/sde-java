import Characters.Player;
import Characters.Enemy;
import Characters.Enemies.EnemyFactory;

import java.util.Scanner;
import Utils.RandomUtils;

public class Game {
    private final Player _player;
    private Scanner _input;

    public Game() {
        this._input = new Scanner(System.in);

        System.out.println("=== Welcome to the Java RPG ===");
        System.out.println("Enter your character's name:");
        String userName = _input.nextLine();

        this._player = new Player(userName, 100, 10, 15); 
    }

    public void start() {
        System.out.println("\n--- Your journey begins, " + _player.getName() + "! ---");

        while (_player.isAlive()) {
            try { Thread.sleep(800); } catch (InterruptedException e) {}

            if (RandomUtils.chance(0.30)) { 
                System.out.println("\n[!] The air grows cold... Something is approaching!");

                Enemy enemy = EnemyFactory.createRandomEncounter();

                System.out.println(">> A " + enemy.getName() + " blocks your path!");

                Combat combatLoop = new Combat(_player, enemy);
                combatLoop.start();
            } else {
                System.out.println(" You travel deeper into the wilderness...");
            }
        }

        System.out.println("\n==================================");
        System.out.println(" GAME OVER - Your legend has ended.");
        System.out.println("==================================");
    }
}
