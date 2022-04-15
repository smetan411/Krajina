package krajina.ostrovy;

import krajina.PlayerCommandExecutor;
import krajina.poloha.PolohaAbs;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class OstrovKruhAbs extends PlayerCommandExecutor {

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        int hloubka = 25;
        PolohaAbs pocatekDesky = pocatekOstrova;
        for (int i = 0; i < hloubka; i++) {
            postavZaklad(pocatekDesky, polomer + 2 * i);
            pocatekDesky = pocatekDesky.plus(-1, -1, -1);
        }
        return true;
    }

    private final World svet;
    private final PolohaAbs pocatekOstrova;
    private final int polomer;

    public OstrovKruhAbs(Location pocatekOstrova, int polomer) {
        this.svet = pocatekOstrova.getWorld();
        this.pocatekOstrova = new PolohaAbs(pocatekOstrova);
        this.polomer = polomer;
    }

    private void postavZaklad(PolohaAbs pocatekDesky, int polomer) {
        for (int i = -polomer; i < polomer; i++) {
            for (int j = -polomer; j < polomer; j++) {
                PolohaAbs pozice = new PolohaAbs(pocatekDesky.plus(i, 0, j).toAbsLocation());
                double xd = pozice.getX() - pocatekDesky.getX();
                double zd = pozice.getZ() - pocatekDesky.getZ();
                double vzdalenost = Math.sqrt(xd * xd + zd * zd);
                if (vzdalenost < polomer) {
                    Block aktualniBlok = svet.getBlockAt(pocatekDesky.plus(i, 0, j).toAbsLocation());
                    aktualniBlok.setType(Material.GRASS_BLOCK);
                }
            }
        }
    }
}
