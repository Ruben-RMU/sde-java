package Characters.Enemies;

import Characters.Enemy;
import Utils.RandomUtils;

public final class EnemyFactory {

    private static final Goblin goblinPrototype = new Goblin();
    private static final Orc orcPrototype = new Orc();
    private static final Knight knightPrototype = new Knight();

    private EnemyFactory() {}

    private static Enemy createEnemy() {
        double roll = Math.random();
        Enemy enemy;

        if (roll < 0.75) {
            enemy = goblinPrototype.clone();
        } else if (roll < 0.95) {
            enemy = orcPrototype.clone();
        } else {
            enemy = knightPrototype.clone();
        }

        System.out.println("A " + enemy.getName() + " appears!");
        return enemy;
    }

    public static Enemy createRandomEncounter() {
        if (RandomUtils.chance(0.2)) {
            EnemyGroup group = new EnemyGroup();
            Enemy first = createEnemy();
            Enemy second = createEnemy();
            group.add(first);
            group.add(second);

            System.out.print("Together they form a group: ");
            for (Enemy e : group.getEnemies()) {
                System.out.print(e.getName() + " ");
            }
            System.out.println("\n");
            return group;
        }

        return createEnemy();
    }
}
