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
        while (_player.isAlive() && _enemy.isAlive()) {
            _player.takeTurn(_enemy);

            if (!_enemy.isAlive()) {
                System.out.println("Enemy defeated!");
                System.out.println(_player.getName() + "Absorbs a point of mana off of their corpses!");
                break;
            }

            _enemy.takeTurn(_player);

            if (!_player.isAlive()) {
                System.out.println(_player.getName() + " has been defeated!");
                break;
            }
        }

        System.out.println("Combat has ended!");
    }
}
