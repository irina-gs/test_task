public class Creature {
    private int attack;
    private int protection;
    protected int health;
    protected int maxHealth;
    private int damageMin;
    private int damageMax;

    public void setAttack(int attack) {
        if (attack >= 1 && attack <= 30) {
            this.attack = attack;
        } else {
            System.out.println("Error! The attack must be from 1 to 30.");
        }
    }
    public int getAttack() {
        return attack;
    }
    public void setProtection(int protection) {
        if (protection >= 1 && protection <= 30) {
            this.protection = protection;
        } else {
            System.out.println("Error! The protection must be from 1 to 30.");
        }
    }
    public int getProtection() {
        return protection;
    }
    public void setHealth(int health) {
        if (health > 0) {
            this.health = health;
            maxHealth = health;
        } else {
            System.out.println("Error! The health must be more than 0.");
        }
    }
    public int getHealth() {
        return health;
    }
    public void changeHealth(int health) {
        if (health > 0) {
            this.health = health;
        } else {
            this.health = 0;
            System.out.println("Game over.");
        }
    }
    public void setDamage(int damageMin, int damageMax) {
        if (damageMin > 0 && damageMax > 0 && damageMin <= damageMax) {
            this.damageMin = damageMin;
            this.damageMax = damageMax;
        } else {
            System.out.println("Error! The damage must be correct.");
        }
    }
    public int[] getDamage() {
        return new int[] {damageMin, damageMax};
    }
    public void create(int attack, int protection, int health, int damageMin, int damageMax) {
        setAttack(attack);
        setProtection(protection);
        setHealth(health);
        setDamage(damageMin, damageMax);
    }
    public void getInfo() {
        if (attack != 0 && protection != 0 && damageMin != 0 && damageMax != 0) {
            System.out.println("Attack: " + attack + "\nProtection: " + protection + "\nHealth: " + health + "\nDamage: " + damageMin + " - " + damageMax + "\n");
        } else {
            System.out.println("Set all parameters correctly.");
        }
    }
    public void hit(Creature creature) {
        if (creature.checkParameters()) {
            int attackModifier = attack - creature.getProtection() + 1;
            if (attackModifier <= 0) {
                attackModifier = 1;
            }
            int[] dice = new int[attackModifier];
            boolean successfulHit = false;
            for (int i = 0; i < attackModifier; i++) {
                dice[i] = (int) (Math.random() * 6 + 1);
                if (dice[i] == 5 || dice[i] == 6) {
                    successfulHit = true;
                    break;
                }
            }
            if (successfulHit) {
                creature.changeHealth(creature.getHealth() - (int) (Math.random() * (damageMax - damageMin + 1) + damageMin));
            }
        }
    }
    public boolean checkParameters() {
        if (attack >= 1 && attack <= 30 && protection >= 1 && protection <= 30 && health > 0 && damageMin > 0 && damageMax > 0 && damageMin <= damageMax) {
            return true;
        } else {
            System.out.println("The action can't be performed.");
            return false;
        }
    }
}
