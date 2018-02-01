package Bad;

public class Player implements Entity {

    private int health = 100;
    private int strength = 10;


    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public void damage(int amount) {
        health -= amount;
    }

    public void enrage() {
        strength += 10;
    }
}
