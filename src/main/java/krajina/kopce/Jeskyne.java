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
                    Block aktualniBlok = world.getBlockAt(poziceXYZ);

                    // vyčištění prostoru
                    if ((vzdalenost <= polomer + 1) && (aktualniBlok.getY() >= playerLocation.getY())) {
                        aktualniBlok.setType(Material.AIR);
                    }

                    // vytvoření podlahy -1
                    if ((vzdalenost <= polomer + 1) && (aktualniBlok.getY() == playerLocation.getY())) {
                        aktualniBlok.setType(Material.DIAMOND_BLOCK);
                    }

                    // stavba jeskyně
                    if ((vzdalenost >= polomer - 1) && (vzdalenost <= polomer + 1)) {
                        if ((aktualniBlok.getType().equals(Material.AIR))) {
                            aktualniBlok.setType(Material.DIAMOND_BLOCK);
                        }
                    }
                }
            }
        }
        //  umístění 2 lamp
        Block lampa = world.getBlockAt(new Location(world, playerLocation.getX(), playerLocation.getY()+1, playerLocation.getZ() ));
        lampa.setType(Material.LANTERN);
        Location lanternLocation1 = new Location(world, playerLocation.getX(), playerLocation.getY() + (polomer - 2), playerLocation.getZ());
        Block lampa1 = world.getBlockAt(lanternLocation1);
        lampa1.setType(Material.LANTERN);

        player.teleport((new Location(world, playerLocation.getX()+(polomer+1), playerLocation.getY(), playerLocation.getZ())));
        return true;
    }
}
