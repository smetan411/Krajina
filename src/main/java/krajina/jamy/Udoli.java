package krajina.jamy;

import krajina.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Udoli extends PlayerCommandExecutor {

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        int polomerUdoli = 10;
        int delkaUdoli = 40;
        for (double z = playerLocation.getZ(); z < playerLocation.getZ() + delkaUdoli; z++) {
            for (double x = playerLocation.getX() - polomerUdoli; x < playerLocation.getX() + polomerUdoli; x++) {
                for (double y = playerLocation.getY() - polomerUdoli; y < playerLocation.getY() + polomerUdoli; y++) {
                    Location pozice = new Location(world, x, y, z);
                    double xd = x - playerLocation.getX();
                    double yd = y - playerLocation.getY();
                    double vzdalenost = Math.sqrt(xd * xd + yd * yd);
                    if (vzdalenost < polomerUdoli) {
                        Block aktualniBlok = world.getBlockAt(pozice);
                        aktualniBlok.setType(Material.AIR);
                    }
                }
            }
        }
        return true;
    }
}
