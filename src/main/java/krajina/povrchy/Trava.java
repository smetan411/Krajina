package krajina.povrchy;

import krajina.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Trava extends PlayerCommandExecutor {
    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {

        int polomer = 15;

        for (double x = playerLocation.getX() - polomer; x < playerLocation.getX() + polomer; x++) {
            for (double z = playerLocation.getZ() - polomer; z < playerLocation.getZ() + polomer; z++) {
                Location pozice = new Location(world, x, playerLocation.getY(), z);
                double xd = x - playerLocation.getX();
                double zd = z - playerLocation.getZ();
                double vzdalenost = Math.sqrt(xd * xd + zd * zd);
                if (vzdalenost < polomer) {
                    Block aktualniBlok = world.getBlockAt(pozice);
                    aktualniBlok.setType(Material.GRASS_BLOCK);
                }
            }
        }
        return true;
    }
}

