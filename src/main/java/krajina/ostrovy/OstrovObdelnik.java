package krajina.ostrovy;

import krajina.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class OstrovObdelnik extends PlayerCommandExecutor {

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {

        int hloubka = 25;
        int sirkaOstrova = hloubka * 3;
        int delkaOstrova = sirkaOstrova * 2;

        for (int i = 0; i < hloubka; i++) {
            postavZaklad(world, playerLocation, sirkaOstrova + 2 * i, delkaOstrova + 2 * i);
            playerLocation = playerLocation.add(-1, -1, -1);
        }
        return true;
    }


    private void postavZaklad(World world, Location playerLocation, int sirkaOstrova, int delkaOstrova) {
        for (int i = 0; i < sirkaOstrova; i++) {
            for (int j = 0; j < delkaOstrova; j++) {
                Block aktualniBlok = world.getBlockAt(playerLocation.clone().add(i, 0, j));
                aktualniBlok.setType(Material.GRASS_BLOCK);
            }
            playerLocation.clone().add(1, 0, -delkaOstrova);
        }
        playerLocation.clone().add(-sirkaOstrova, 0, 0);
    }
}

