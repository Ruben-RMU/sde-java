package Characters;

import java.util.Scanner;

public class Player extends Character {

    private int _mana;
    private int _maxMana;
    private Scanner _scanner; // for input

    public Player(String name, int health, int attackPower, int mana) {
        this._mana = mana;
        this._maxMana = mana;
        this._scanner = new Scanner(System.in);
        this._name = name;
        this._health = health;
        this._attackPower = attackPower;
        this._maxHealth = health;
    }

    public void regularAttack(Enemy target) {
        System.out.println(_name + " attacks " + target.getName() + " with a regular attack!");
        target.takeDamage(_attackPower);
    }

    // Strong attack
    public void strongAttack(Enemy target) {
        if (_mana > 0) {
            _mana--;
            System.out.println(_name + " uses STRONG ATTACK on " + target.getName() + "! (-1 mana)");
            target.takeDamage(_attackPower * 2);
        } else {
            System.out.println(_name + " tried a STRONG ATTACK but has no mana! Turn over.");
        }
    }

    public void displayStats() {
        System.out.println("=== " + _name + " Stats ===");
        System.out.println("HP: " + _health + "/" + _maxHealth);
        System.out.println("Mana: " + _mana + "/" + _maxMana);
        System.out.println("Attack: " + _attackPower);
        System.out.println("======================");
    }

    public void restoreMana(int amount) {
        _mana = Math.min(_maxMana, _mana + amount);
        System.out.println(_name + " restores " + amount + " mana. (Mana: " + _mana + "/" + _maxMana + ")");
    }

    public String getName() {
        return _name;
    }

    @Override
    public void takeTurn(Character target) {
        displayStats();
        System.out.println("\nChoose your action:");
        System.out.println("1) Regular Attack");
        System.out.println("2) Strong Attack (costs 1 mana)");

        int choice = 0;

        while (true) {
            try {
                System.out.print("> ");
                choice = Integer.parseInt(_scanner.nextLine());
                if (choice == 1 || choice == 2) break;
                else System.out.println("Invalid choice! Enter 1 or 2.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a number.");
            }
        }

        if (choice == 1) {
            regularAttack((Enemy) target);
        } else {
            strongAttack((Enemy) target);
        }
    }
}
