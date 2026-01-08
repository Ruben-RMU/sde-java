package Characters.Enemies;

import Characters.Enemy;

public final class EnemyFactory {
    private static final Goblin goblinPrototype = new Goblin("Goblin", 5, 1);
    private static final Orc orcPrototype = new Orc("Orc", 15, 1);
    private static final Knight knightPrototype = new Knight("Knight", 15, 12);

    private static Enemy createEnemy() {
        return null;
    }

    public static Enemy createRandomEncounter() {
        return null;
    }
}
