package krajina.ostrovy;

import krajina.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class OstrovKruh extends PlayerCommandExecutor {

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {

        int hloubka = 25;
        int polomer = hloubka * 2;

        for (int i = 0; i < hloubka; i++) {
            postavDesku(world, playerLocation, polomer + 2 * i);
            playerLocation = playerLocation.add(-1, -1, -1);
        }
        return true;
    }

    private void postavDesku(World svet, Location misto, int polomer) {
        for (int i = -polomer; i < polomer; i++) {
            for (int j = -polomer; j < polomer; j++) {
                Location pozice = misto.clone().add(i, 0, j);
                double xd = pozice.getX() - misto.getX();
                double zd = pozice.getZ() - misto.getZ();
                double vzdalenost = Math.sqrt(xd * xd + zd * zd);
                if (vzdalenost < polomer) {
                    Block aktualniBlok = svet.getBlockAt(misto.clone().add(i, 0, j));
                    aktualniBlok.setType(Material.GRASS_BLOCK);
                }
            }
        }
    }
}

