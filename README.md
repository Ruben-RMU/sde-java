# Java Terminal RPG: Design Patterns Documentation

## 1. Project Overview
This project is a Java-based console RPG where players explore levels and engage in tactical combat. The focus is the implementation of **Software Design Patterns** to solve structural and behavioral challenges, ensuring a clean and scalable code architecture.

---

## 2. Design Patterns Implementation

### A. Creational Pattern: Prototype
> **Note on Factory**: While `EnemyFactory` manages instantiation, its core logic relies on the **Prototype Pattern** to spawn enemies via cloning.

**Problem**: Instantiating enemies with specific stats using `new` repeatedly leads to hard-coded values and redundant initialization.

**Implementation**: The `Enemy` base class implements `Cloneable` and overrides `clone()`. `EnemyFactory` maintains static "Master Templates" and returns clones of these instances.

**Code Evidence:**
```java
// From Enemy.java
public abstract class Enemy extends Character implements Cloneable {
    @Override
    public Enemy clone() {
        try {
            return (Enemy) super.clone(); 
        } catch (CloneNotSupportedException e) { ... }
    }
}

// From EnemyFactory.java
private static final Goblin goblinPrototype = new Goblin(); 
// ...
enemy = goblinPrototype.clone(); 
```

### B. Structural Pattern: Composite
**Problem**: The combat system needs to handle both individual enemies and groups (e.g., a "Duo" encounter) uniformly, without requiring complex branching logic or `instanceof` checks in the battle loop

**Implementation**: We implemented the Composite Pattern where `EnemyGroup` (the Composite) extends `Enemy` (the Component) and maintains a `List<Enemy>`.
Part-Whole Hierarchy: Because `EnemyGroup` is itself an Enemy, the `Combat` engine treats a group exactly like a single unit, transparently delegating turns to each member.

**Part-Whole Hierarchy**: Because `EnemyGroup` is itself an `Enemy`, the `Combat` engine treats a group exactly like a single unit, transparently delegating turns to each member.

**Code Evidence:**
```java
// From EnemyGroup.java
public class EnemyGroup extends Enemy {
    private List<Enemy> enemies; 

    @Override
    public void takeTurn(Character target) {
        for (Enemy enemy : enemies) {
            if (enemy.isAlive()) {
                enemy.takeTurn(target); 
            }
        }
    }
}
```
### C. Behavioural Pattern: Template Method
**Problem**: Every enemy follows a strict protocol (Select Action -> Perform Action -> End Turn), but the actual combat logic (e.g., slashing vs. stabbing) must be unique to each subclass.

**Implementation**: The Template Method is defined in `Enemy.java` via the `takeTurn()` method. This method defines the invariant "Skeleton" of the turn while calling abstract "Hooks" implemented by subclasses.

  **Code Evidence:**
  ```java
  // From Enemy.java:
  public final void takeTurn(Character target) {
    selectAction();        
    performAction(target);  
    endTurn();             
  }
  // From Goblin.java:
  @Override
  protected void performAction(Character target) {
    System.out.println("Goblin slashes!");
    target.takeDamage(_attackPower);
  }
  ```
## 3. Team Collaboration
We utilized GitHub for version control and task management to ensure a smooth collaborative workflow.

**joshho0701**: System Architecture Design, Pattern Documentation, and Enemy Hierarchy.

**Ruben-RMU**: Core Game Engine, Combat Loop Implementation, and Utility Logic.  

## 4. How to Run
Requirement: Java JDK 8 or higher.

Compile: javac Main.java

Execute: java Main
