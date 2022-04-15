package krajina;

import krajina.jamy.Jama;
import krajina.jamy.Udoli;
import krajina.kopce.Jeskyne;
import krajina.kopce.Kopec;
import krajina.kopce.Kopecek;
import krajina.ostrovy.OstrovKruh;
import krajina.ostrovy.OstrovKruhAbs;
import krajina.ostrovy.OstrovObdelnik;
import krajina.ostrovy.OstrovObdelnikAbs;
import krajina.povrchy.Cesta;
import krajina.povrchy.Trava;
import krajina.povrchy.ZarovnaniPovrchu;
import krajina.stromy.KaceniLesa;
import krajina.stromy.KaceniStromu;
import krajina.voda.Jezero;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public final class MainKrajina extends JavaPlugin {

    @Override
    public void onEnable() {

        World world = getServer().getWorlds().get(0);
        getCommand("+jama").setExecutor(new Jama());
        getCommand("+udoli").setExecutor(new Udoli());
        getCommand("+kopec").setExecutor(new Kopec());
        getCommand("+kopecek").setExecutor(new Kopecek());
        getCommand("+jezero").setExecutor(new Jezero());
        getCommand("+jeskyne").setExecutor(new Jeskyne());
        getCommand("+cesta").setExecutor(new Cesta());
        getCommand("+trava").setExecutor(new Trava());
        getCommand("+kacejStrom").setExecutor(new KaceniStromu(world));
        getCommand("+kacejLes").setExecutor(new KaceniLesa(world));
        getCommand("+ostrovObdelnik").setExecutor(new OstrovObdelnik());
        getCommand("+ostrovKruh").setExecutor(new OstrovKruh());
    //    getCommand("+ostrovObdAbs").setExecutor(new OstrovObdelnikAbs(pocatekOstrova, 50, 50));
     //   getCommand("+ostrovKruhAbs").setExecutor(new OstrovKruhAbs(pocatekOstrova, 50));
        getCommand("+zarovnejPovrch").setExecutor(new ZarovnaniPovrchu());

    }
}
