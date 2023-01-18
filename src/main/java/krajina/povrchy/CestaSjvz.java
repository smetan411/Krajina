package krajina.povrchy;

import krajina.PlayerCommandExecutor;
import krajina.poloha.AbsLocation;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class CestaSjvz extends PlayerCommandExecutor {

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        int sirkaCesty = 2;
        int delkaCesty = 500;

        if (args.length > 0) {
            try {
                sirkaCesty = Integer.parseInt(args[0]);
                if ((sirkaCesty < 1) || (sirkaCesty > 10)) {
                    sirkaCesty = 2;
                }
            } catch (NumberFormatException exception) {
            }
        }
        //cesta sever jih
        AbsLocation pocatek = new AbsLocation(playerLocation.clone().add(0, -1, 0));
        for (int i = -delkaCesty; i < delkaCesty; i++) {
            for (int j = 0; j < sirkaCesty; j++) {
                var aktualniBlok = pocatek.plus(i, 0, j);
                vycistiBlokCesty(aktualniBlok);
                aktualniBlok.getBlock().setType(Material.OAK_PLANKS);
            }
        }
       //cesta vychod zapad
         for (int i = 0; i < sirkaCesty; i++) {
            for (int j = -delkaCesty; j < delkaCesty; j++) {
                var aktualniBlok = pocatek.plus(i, 0, j);
                vycistiBlokCesty(aktualniBlok);
                aktualniBlok.getBlock().setType(Material.OAK_PLANKS);
            }
        }

        return true;
    }

    private void vycistiBlokCesty(AbsLocation location) {
        for (int k = 0; k < 35; k++) {
            location.plus(0, k, 0).getBlock().setType(Material.AIR);
        }
    }
}
