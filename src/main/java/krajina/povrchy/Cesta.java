package krajina.povrchy;

import krajina.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Cesta extends PlayerCommandExecutor {
    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        int sirkaCesty = 2;
        int delkaCesty = 25;

        if (args.length > 0) {
            try {
                sirkaCesty = Integer.parseInt(args[0]);
                if ((sirkaCesty < 1) || (sirkaCesty > 10)) {
                    sirkaCesty = 2;
                }
            } catch (NumberFormatException exception) {
            }
        }
        playerLocation.add(0, -1, 0);

        for (int i = 0; i < delkaCesty; i++) {
            for (int j = 0; j < sirkaCesty; j++) {
                playerLocation.add(0, 0, 1);
                Block aktualniBlok = world.getBlockAt(playerLocation);
                aktualniBlok.setType(Material.OAK_PLANKS);
            }
            playerLocation.add(1, 0, -sirkaCesty);
        }
        return true;
    }
}
