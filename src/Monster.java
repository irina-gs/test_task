public class Monster extends Creature {
    @Override
    public void changeHealth(int health) {
        super.changeHealth(health);
        if (health <= 0) {
            System.out.println("You've won.");
        }
    }
    @Override
    public void getInfo() {
        System.out.println("Monster:");
        super.getInfo();
    }
}
