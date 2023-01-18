package krajina.voda;

import krajina.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Reka1 extends PlayerCommandExecutor {
    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {

        int polomerReky = 2;
        int delkaReky = 500;

        for (double z = playerLocation.getZ(); z < playerLocation.getZ() + delkaReky; z++) {
            for (double x = playerLocation.getX() - polomerReky; x < playerLocation.getX() + polomerReky; x++) {
                for (double y = playerLocation.getY() - polomerReky; y < playerLocation.getY() + polomerReky; y++) {
                    Location pozice = new Location(world, x, y, z);
                    if (y < 2) {
                        continue;
                    }
                    double xd = x - playerLocation.getX();
                    double yd = y - playerLocation.getY();
                    double vzdalenost = Math.sqrt(xd * xd + yd * yd);
                    if (vzdalenost < polomerReky) {
                        Block aktualniBlok = world.getBlockAt(pozice);
                        if (aktualniBlok.getType() != Material.AIR) {
                            aktualniBlok.setType(Material.WATER);
                        }
                        //nad deskou vzduch
                        pozice.add(0, 1, 0);
                        for (int k = 0; k < 35; k++) {
                            Block novyBlok = world.getBlockAt(pozice);
                            novyBlok.setType(Material.AIR);
                            pozice.add(0, 1, 0);
                        }
                        pozice.add(0, -36, 0);
                    }
                }
            }
        }
        return true;
    }
}
