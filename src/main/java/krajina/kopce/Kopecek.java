package krajina.kopce;

import krajina.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Kopecek extends PlayerCommandExecutor {

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        double polomer = 5;
        for (double x = playerLocation.getX() - polomer; x < playerLocation.getX() + polomer; x++) {
            for (double y = playerLocation.getY() - polomer; y < playerLocation.getY() + polomer; y++) {
                for (double z = playerLocation.getZ() - polomer; z < playerLocation.getZ() + polomer; z++) {
                    Location pozice = new Location(world, x, y, z);
                    if (y < 2) {
                        continue;
                    }
                    double xd = x - playerLocation.getX();
                    double yd = y - playerLocation.getY();
                    double zd = z - playerLocation.getZ();
                    double vzdalenost = Math.sqrt(xd * xd + yd * yd + zd * zd);
                    if (vzdalenost < polomer) {
                        Block aktualniBlok = world.getBlockAt(pozice);
                        if (aktualniBlok.getType().equals(Material.AIR)) {
                            aktualniBlok.setType(Material.GRASS_BLOCK);
                        }
                    }
                }
            }
        }
        player.teleport(new Location(world, playerLocation.getX(), playerLocation.getY() + polomer, playerLocation.getZ()));
        return true;
    }
}

