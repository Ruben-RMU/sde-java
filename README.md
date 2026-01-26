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

## 3. Design Pattern Implementations
A. Creational Pattern: Prototype

Design Pivot: While the project uses an EnemyFactory for management, the core instantiation logic leverages the Prototype Pattern to handle enemy variations efficiently.

Problem: Repeatedly calling constructors with specific base stats for random encounters can lead to hard-coded values and redundant initialization logic.

Implementation: The Enemy base class implements the Cloneable interface and overrides the clone() method. The EnemyFactory maintains a set of static "Master Templates" and returns clones instead of using the new keyword.
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
