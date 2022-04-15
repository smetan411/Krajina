package krajina.ostrovy;

import krajina.poloha.PolohaAbs;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

public class OstrovObdelnikAbs {
    private final World svet;
    private final PolohaAbs pocatekOstrova;
    private final int delkaOstrova;
    private final int sirkaOstrova;

    public OstrovObdelnikAbs(Location pocatekOstrova, int sirkaOstrova, int delkaOstrova) {
        this.svet = pocatekOstrova.getWorld();
        this.pocatekOstrova = new PolohaAbs(pocatekOstrova);
        this.sirkaOstrova = sirkaOstrova;
        this.delkaOstrova = delkaOstrova;
    }

    public void postavOstrov() {
        int hloubka = 25;
        PolohaAbs pocatekDesky = pocatekOstrova;
        for (int i = 0; i < hloubka; i++) {
            postavZaklad(pocatekDesky, sirkaOstrova + 2 * i, delkaOstrova + 2 * i);
            pocatekDesky = pocatekDesky.plus(-1, -1, -1);
        }
    }

    private void postavZaklad(PolohaAbs pocatekDesky, int sirkaOstrova, int delkaOstrova) {
        for (int i = 0; i < sirkaOstrova; i++) {
            for (int j = 0; j < delkaOstrova; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDesky.plus(i, 0, j).toAbsLocation());
                aktualniBlok.setType(Material.GRASS_BLOCK);
            }
        }
    }
}
