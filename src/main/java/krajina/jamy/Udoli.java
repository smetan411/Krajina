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
        int polomerUdoli = 15;
        int delkaUdoli = 100;
        try {
            if (args.length == 2) {
                polomerUdoli = Integer.parseInt(args[0]);
                delkaUdoli = Integer.parseInt(args[1]);
            } else if (args.length != 2 && args.length != 0) {
                player.sendMessage("Zadej dva parametry, polomer udoli a delku udoli.");
                return true;
            }
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
        } catch (NumberFormatException e) {
            player.sendMessage("Jeden z argumentu neni cislo.");
        }
        return true;
    }
}
