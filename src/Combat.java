import Characters.Enemy;
import Characters.Player;

public class Combat {
    private Player _player;

    private Enemy _enemy;

    public Combat(Player player, Enemy enemy) {
        this._player = player;
        this._enemy = enemy;
    }

public void start() {
    System.out.println("\n--- BATTLE START ---");
    System.out.println(_player.getName() + " vs " + _enemy.getName());

    while (_player.isAlive() && _enemy.isAlive()) {
        
        System.out.println("\n[Your Turn]");
        _player.takeTurn(_enemy);

        if (!_enemy.isAlive()) {
            System.out.println("\n Victory! The threat of " + _enemy.getName() + " has been neutralized.");
            System.out.println(_player.getName() + " absorbs a point of mana from the essence of the fallen!");
            break;
        }

        System.out.println("\n[" + _enemy.getName() + "'s Turn]");
        _enemy.takeTurn(_player);

        if (!_player.isAlive()) {
            System.out.println("\n DARKNESS FALLS... " + _player.getName() + " has been defeated!");
            break;
        }
    }

    System.out.println("--- Combat has ended! ---\n");
}
}
