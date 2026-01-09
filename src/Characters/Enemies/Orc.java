package Characters.Enemies;

import Characters.Character;
import Characters.Enemy;

public class Orc extends Enemy {
    public Orc() {
        super("Orc", 30, 5);
        _maxHealth = 30;
    }

    @Override
    protected void selectAction() {
        System.out.println("Orc roars and runs forward!");
    }

    @Override
    protected void performAction(Character target) {
        System.out.println("Orc smashes!");
        target.takeDamage(_attackPower);
    }
}
