package Characters;

public abstract class Character {
    protected String _name;
    protected int _health;
    protected int _maxHealth;
    protected int _attackPower;

    public boolean isAlive() {
        return this._health > 0;
    }

    public void takeDamage(int damage) {
        this._health -= damage;

        if (this._health <= 0) {
            this._health = 0;
        }

        System.out.println(this._name +
                " takes " + damage +
                " damage. (HP: " + this._health + "/" + this._maxHealth + ")"
        );
    }

    public abstract void takeTurn();
}
