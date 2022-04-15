package krajina.jamy;

import krajina.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Jama extends PlayerCommandExecutor {

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        double polomer = 15;
        if (args.length > 0) {
            try {
                polomer = Integer.parseInt(args[0]);
                if ((polomer < 5) || (polomer > 15)) {
                    polomer = 15;
                }
            } catch (NumberFormatException exception) {
            }
        }
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
                        aktualniBlok.setType(Material.AIR);
                    }
                }
            }
        }
        player.teleport(new Location(world, playerLocation.getX() + polomer, playerLocation.getY(), playerLocation.getZ()));
        return true;
    }
}
