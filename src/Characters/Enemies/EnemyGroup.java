package Characters.Enemies;

import Characters.Character;
import Characters.Enemy;

import java.util.ArrayList;
import java.util.List;

public class EnemyGroup extends Enemy {
    private List<Enemy> enemies;

    public EnemyGroup() {
        super("Enemy Group", 0, 0);
        enemies = new ArrayList<>();
    }


    public void add(Enemy enemy) {
        enemies.add(enemy);
    }

    public boolean isAlive() {
        return enemies.stream().anyMatch(Enemy::isAlive);
    }

    public void takeTurn(Character target) {
        for (Enemy enemy : enemies) {
            if (enemy.isAlive()) {
                enemy.takeTurn(target);
            }
        }
    }

    public List<Enemy> getEnemies() {
        return new ArrayList<>(enemies);
    }

    @Override
    public void selectAction() {

    }

    @Override
    public void performAction(Character target) {

    }
}
