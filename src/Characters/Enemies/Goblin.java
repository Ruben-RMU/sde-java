package Characters.Enemies;

import Characters.Character;
import Characters.Enemy;

public class Goblin extends Enemy {

    public Goblin() {
        super("Goblin", 15, 10);
        _maxHealth = 5;
    }

    @Override
    protected void selectAction() {
        System.out.println("Goblin snarls and prepares to attack!");
    }

    @Override
    protected void performAction(Character target) {
        System.out.println("Goblin slashes!");
        target.takeDamage(_attackPower);
    }
}
