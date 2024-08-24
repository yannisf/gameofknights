package org.example;

public class Knight {

    private String name;
    private int health;
    private Knight nextKnight;

    public Knight(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Knight getNextKnight() {
        return nextKnight;
    }

    public void setNextKnight(Knight nextKnight) {
        this.nextKnight = nextKnight;
    }

    public boolean isDead() {
        return health < 1;
    }

    public void receiveAttack(int attackPoints) {
        this.setHealth(health - attackPoints);
    }

    @Override
    public String toString() {
        return name + '[' + health + ']';
    }



}
