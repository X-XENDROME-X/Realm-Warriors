import java.text.DecimalFormat;

public class Mage extends PlayerEntity {
    private double mana;

    public Mage(double health, String name, int stamina, int attack, String weapon, double mana) {
        super(health, name, stamina, attack, weapon);
        this.mana = mana;
    }

    public void computeCombatPower() {
        this.combatPoints = (int) ((this.attack + this.health) * (1 + this.mana));

        if (weapon.equals("Staff")) {
            this.combatPoints += 30;
        }
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("#%");
        return ("\nMage Hero:" + super.toString() + "Mana:\t\t\t" + df.format(mana) + "\n");
    }
}
