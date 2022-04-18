package krajina.ostrovy;

import krajina.PlayerCommandExecutor;
import krajina.poloha.AbsLocation;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class OstrovObdelnikAbs extends PlayerCommandExecutor {
    private final int delkaOstrova;
    private final int sirkaOstrova;

    public OstrovObdelnikAbs(int sirkaOstrova, int delkaOstrova) {
        this.sirkaOstrova = sirkaOstrova;
        this.delkaOstrova = delkaOstrova;
    }

    private void postavOstrov(Location pocatekOstrova) {
        int hloubka = 25;
        AbsLocation pocatekDesky = new AbsLocation(pocatekOstrova);
        for (int i = 0; i < hloubka; i++) {
            postavDesku(pocatekDesky, sirkaOstrova + 2 * i, delkaOstrova + 2 * i, pocatekOstrova.getWorld());
            pocatekDesky = pocatekDesky.plus(-1, -1, -1);
        }
    }

    private void postavDesku(AbsLocation pocatekDesky, int sirkaOstrova, int delkaOstrova, World svet) {
        for (int i = 0; i < sirkaOstrova; i++) {
            for (int j = 0; j < delkaOstrova; j++) {
                Block aktualniBlok = svet.getBlockAt(pocatekDesky.plus(i, 0, j).toLocation());
                aktualniBlok.setType(Material.GRASS_BLOCK);
            }
        }
    }

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        postavOstrov(playerLocation);
        return false;
    }
}
