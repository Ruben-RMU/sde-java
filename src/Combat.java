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
            _player.takeTurn();

            if (!_enemy.isAlive()) {
                System.out.println("Enemy defeated!");
                break;
            }

            _enemy.takeTurn();

            if (!_player.isAlive()) {
                System.out.println("Player defeated!");
                break;
            }
        }

        System.out.println("Combat has ended!");
    }
}
