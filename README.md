# Java Terminal RPG: Design Patterns Showcase

## 1. Introduction
This project is a Java-based terminal RPG where players explore levels and engage in tactical combat. The focus of this development is not just gameplay, but the implementation of **Software Design Patterns** to ensure a clean, scalable, and professional code architecture.

---

## 2. Team Collaboration
We utilized **GitHub** for version control and task management to ensure a smooth collaborative workflow.

* **joshho0701**: System Architecture Design, Pattern Documentation, and Game Balancing.
* **Ruben-RMU**: Core Game Engine, Game Loop Implementation, and Technical Mechanics.

> **Contribution Note:** We maintained a balanced workload, with continuous integration of code and documentation to meet all project requirements.

---

## 3. Design Patterns Implementation

### Creational Patterns
* **Factory Method**: 
    * *Usage*: Implemented via `EnemyFactory` to dynamically spawn different monsters.
    * *Benefit*: Decouples the game loop from specific enemy classes.

* **Prototype**: 
    * *Usage*: Allows cloning of existing enemy objects.
    * *Benefit*: Efficiently creates "Duo" or group encounters by duplicating a template enemy.


### Structural Patterns
* **Composite**: 
    * *Usage*: Treats single enemies and enemy groups (Duo) as the same type.
    * *Benefit*: Simplifies the battle system logic—the same code handles one or many enemies.


### Behavioural Patterns
* **Template Method**: 
    * *Usage*: Defines the skeleton of a "Combat Turn" (Status -> Action -> Damage -> End).
    * *Benefit*: Ensures game rules are consistent while allowing different encounter types.


---

## 4. Game Mechanics & Balance
To provide a challenging yet fair experience, we designed a structured attribute system:

| Entity Type | Base HP | Attack Damage | Creation Logic |
| :--- | :---: | :---: | :--- |
| **Player (Warrior)** | 100 | 5 (regular) - 15 (strong) | Manual Input |
| **Goblin** | 15 | 10  | Factory Method |
| **Orc** | 30 | 5 | Factory Method |
| **Knight** | 20 | 15 | Factory Method |

There is also a small chance that an enemy encounter will be a duo, which was made a lot easier using the prototype method and cloning.

The game continues until the player dies.
---

## 5. How to Run
1.  **Requirement**: Java JDK 8 or higher.
2.  **Compile**: 
    ```bash
    javac Main.java
    ```
3.  **Execute**:
    ```bash
    java Main
    ```
