import java.text.DecimalFormat;

public class Fighter extends PlayerEntity {
    private double armor;
    private int maxAttack;
    private boolean isRanged;

    public Fighter(double health, String name, int stamina, int attack, String weapon, boolean isRanged) {
        super(health, name, stamina, attack, weapon);
        this.isRanged = isRanged;

        if (this.isRanged == true) {
            this.armor = 0.25;
            this.maxAttack = 125;
        } else {
            this.armor = 0.5;
            this.maxAttack = 100;
        }
    }

    public void computeCombatPower() {
        if (this.maxAttack <= this.attack) {
            this.combatPoints = (int) ((this.maxAttack + this.health) * (1 - this.armor));
        } else {
            this.combatPoints = (int) ((this.attack + this.health) * (1 - this.armor));
        }

        if (this.isRanged == true && this.weapon.equals("Rock")) {
            this.combatPoints += 50;
        } else if (this.isRanged == false && this.weapon.equals("Sword")) {
            this.combatPoints *= 2;
        }
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("#%");
        if (isRanged == true) {
            return ("\nFighter Hero:\t\tRanged Type" + super.toString() + "Armor:\t\t\t" + df.format(armor) + "\n");
        } else {
            return ("\nFighter Hero:\t\tMelee Type" + super.toString() + "Armor:\t\t\t" + df.format(armor) + "\n");
        }
    }
}
