public class Player extends Creature {
    protected int countHealing = 0;
    public void healing() {
        if (checkParameters()) {
            if (health < maxHealth) {
                countHealing++;
            }
            if (countHealing <= 4) {
                int tempHealth = (int) (health + maxHealth * 0.3);
                if (tempHealth > maxHealth) {
                    health = maxHealth;
                } else {
                    health = tempHealth;
                }
            } else {
                System.out.println("You can't heal anymore.");
            }
        }
    }
    @Override
    public void changeHealth(int health) {
        super.changeHealth(health);
        if (health <= 0) {
            System.out.println("You've lost.");
        }
    }
    @Override
    public void getInfo() {
        System.out.println("Player:");
        super.getInfo();
    }
}
