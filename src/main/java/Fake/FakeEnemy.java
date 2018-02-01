package Fake;

public class FakeEnemy implements Entity {

    private int health = 100;
    private int strength = 10;

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public void damage(int amount) {
        health -= amount;
    }

    @Override
    public void enrage() {
        strength += 10;
    }

    public void setHealth(int amount){
        health = amount;
    }

    public void setStrength(int amount){
        strength = amount;
    }
}
