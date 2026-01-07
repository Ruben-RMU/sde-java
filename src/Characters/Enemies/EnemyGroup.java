package Characters.Enemies;

import Characters.Character;
import Characters.Enemy;

import java.util.List;

public class EnemyGroup extends Enemy {
    private List<Enemy> enemies;

    public EnemyGroup(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }


    public void add(Enemy enemy) {

    }

    public boolean isAlive() {
        return false;
    }

    public void takeTurn(Character target) {

    }

    @Override
    public void selectAction(Character target) {

    }

    @Override
    public void performAction(Character target) {

    }
}
