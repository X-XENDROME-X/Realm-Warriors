public abstract class PlayerEntity {
    protected double health;
    protected String entityName;
    protected int stamina;
    protected int attack;
    protected int combatPoints;
    protected String weapon;

    public PlayerEntity(double health, String name, int stamina, int attack, String weapon) {
        this.health = health;
        this.entityName = name;
        this.stamina = stamina;
        this.attack = attack;
        this.weapon = weapon;
        this.combatPoints = 0;
    }

    public int getCombatPoints() {
        return this.combatPoints;
    }

    public abstract void computeCombatPower();

    public String toString() {
        return "\nHero name:\t\t" + entityName + "\n" + "Current Health:\t\t" + health + "\n" + "Stamina:\t\t" + stamina
                + "\n" + "Attack Damage:\t\t" + attack + "\n" + "Weapon:\t\t\t" + weapon + "\n"
                + "Current Combat Points:\t" + combatPoints + "\n";
    }
}
