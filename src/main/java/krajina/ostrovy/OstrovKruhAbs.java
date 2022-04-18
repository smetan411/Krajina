package krajina.ostrovy;

import krajina.PlayerCommandExecutor;
import krajina.poloha.AbsLocation;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class OstrovKruhAbs extends PlayerCommandExecutor {

    private final int polomer;

    public OstrovKruhAbs(int polomer) {
        this.polomer = polomer;
    }
    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        int hloubka = 25;
        AbsLocation pocatekDesky = new AbsLocation(playerLocation);
        for (int i = 0; i < hloubka; i++) {
            postavDesku(pocatekDesky, polomer + 2 * i, world);
            pocatekDesky = pocatekDesky.plus(-1, -1, -1);
        }
        return true;
    }

    private void postavDesku(AbsLocation pocatekDesky, int polomer, World svet) {
        for (int i = -polomer; i < polomer; i++) {
            for (int j = -polomer; j < polomer; j++) {
                AbsLocation pozice = new AbsLocation(pocatekDesky.plus(i, 0, j).toLocation());
                double xd = pozice.getX() - pocatekDesky.getX();
                double zd = pozice.getZ() - pocatekDesky.getZ();
                double vzdalenost = Math.sqrt(xd * xd + zd * zd);
                if (vzdalenost < polomer) {
                    Block aktualniBlok = svet.getBlockAt(pocatekDesky.plus(i, 0, j).toLocation());
                    aktualniBlok.setType(Material.GRASS_BLOCK);
                }
            }
        }
    }
}
