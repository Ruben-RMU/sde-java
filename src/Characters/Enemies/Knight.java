package Characters.Enemies;

import Characters.Character;
import Characters.Enemy;

public class Knight extends Enemy {

    public Knight() {
        super("Knight", 20, 15);
        _maxHealth = 10;
    }

    @Override
    protected void selectAction() {
        System.out.println("Knight charges forward and prepares its attack!");
    }

    @Override
    protected void performAction(Character target) {
        System.out.println("Knight deals a powerful stab with his lance!");
        target.takeDamage(_attackPower);
    }
}
