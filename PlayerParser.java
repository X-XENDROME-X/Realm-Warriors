public class PlayerParser {
    public static PlayerEntity parseNewPlayer(String lineToParse) {
        String[] line;
        line = lineToParse.split("/");
        String playerType = line[0];
        int health = Integer.parseInt(line[1]);
        String name = line[2];
        int stamina = Integer.parseInt(line[3]);
        int attack = Integer.parseInt(line[4]);
        String weapon = line[5];
        PlayerEntity player = null;

        if (playerType.equalsIgnoreCase("mage")) {
            double mana = Double.parseDouble(line[6]);
            player = new Mage(health, name, stamina, attack, weapon, mana);
        } else if (playerType.equalsIgnoreCase("fighter")) {
            boolean isRanged = true;

            if (line[6].equalsIgnoreCase("Melee")) {
                isRanged = false;
            }

            player = new Fighter(health, name, stamina, attack, weapon, isRanged);
        }

        return player;
    }
}
