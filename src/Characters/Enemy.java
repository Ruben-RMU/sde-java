package Characters;

public abstract class Enemy extends Character implements Cloneable {
    public Enemy(String name, int health, int attackPower) {
        _name = name;
        _health = health;
        _attackPower = attackPower;
    }

    @Override
    public Enemy clone() {
        try {
            return (Enemy) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning failed.", e);
        }
    }

    @Override
    public void takeTurn(Character target) {
        selectAction();
        performAction(target);
        endTurn();
    }

    public String getName() {
        return _name;
    }

    protected abstract void selectAction();

    protected abstract void performAction(Character target);

    protected void endTurn() {
        System.out.println(_name + " ends its turn.");
    }
}
