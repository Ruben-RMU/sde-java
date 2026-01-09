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

        System.out.println("Enter your character's name:");
        String userName = _input.nextLine();

        this._player = new Player(userName, 25, 1, 10);
    }

    public void start() {
        System.out.println("Game started!");

        while (_player.isAlive()) {
            if (RandomUtils.chance(0.25)) {
                System.out.println("An enemy appears!");

                Enemy enemy = EnemyFactory.createRandomEncounter();

                Combat combatLoop = new Combat(_player, enemy);
                combatLoop.start();
            } else {
                System.out.println("Exploring...");
            }
        }

        System.out.println("Game over!");
    }
}