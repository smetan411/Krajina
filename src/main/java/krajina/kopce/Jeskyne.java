package krajina.kopce;

import krajina.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class Jeskyne extends PlayerCommandExecutor {

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {

        int polomer = 10;

        for (double x = playerLocation.getX() - polomer; x < playerLocation.getX() + polomer; x++) {
            for (double y = playerLocation.getY() - polomer; y < playerLocation.getY() + polomer; y++) {
                for (double z = playerLocation.getZ() - polomer; z < playerLocation.getZ() + polomer; z++) {

                    Location poziceXYZ = new Location(world, x, y, z);

                    double xd = x - playerLocation.getX();
                    double yd = y - playerLocation.getY();
                    double zd = z - playerLocation.getZ();
                    double vzdalenost = Math.sqrt(xd * xd + yd * yd + zd * zd);

                    if ((vzdalenost >= polomer - 1) && (vzdalenost <= polomer + 1)) {

                        Block aktualniBlok = world.getBlockAt(poziceXYZ);

                        if ((aktualniBlok.getType().equals(Material.AIR))) {
                            aktualniBlok.setType(Material.DIAMOND_BLOCK);
                        }
                    }
                    Block lampa = world.getBlockAt(playerLocation);
                    lampa.setType(Material.LANTERN);
                }
            }
        }
        //player.teleport((new Location(world, playerLocation.getX()+(polomer+1), playerLocation.getY(), playerLocation.getZ())));
        return true;
    }
}
