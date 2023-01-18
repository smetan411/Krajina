package krajina.stromy;

import krajina.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import java.util.EnumSet;

public class KaceniStromu extends PlayerCommandExecutor{

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {

        int mistoX = playerLocation.getBlockX();
        int mistoY = playerLocation.getBlockY();
        int mistoZ = playerLocation.getBlockZ();
        for (int x = mistoX - 1; x < mistoX + 1; x++) {
            for (int z = mistoZ - 1; z < mistoZ + 1; z++) {
                Location mistoNaPovrchu = najdiPovrch(new Location(world, x, mistoY, z));

                if (TYPY_STROMU.contains(mistoNaPovrchu.getBlock().getType())) {
                    skacejStrom(mistoNaPovrchu);
                }
            }
        }
        return true;
    }

    private final World world;

    private static EnumSet<Material> TYPY_STROMU = EnumSet.of(Material.JUNGLE_LOG, Material.ACACIA_LOG,
            Material.BIRCH_LOG, Material.SPRUCE_LOG, Material.OAK_LOG, Material.DARK_OAK_LOG,
            Material.STRIPPED_ACACIA_LOG, Material.STRIPPED_BIRCH_LOG, Material.STRIPPED_DARK_OAK_LOG,
            Material.STRIPPED_JUNGLE_LOG, Material.STRIPPED_SPRUCE_LOG, Material.STRIPPED_OAK_LOG,
            Material.ACACIA_LEAVES, Material.ACACIA_WOOD, Material.BIRCH_LEAVES, Material.BIRCH_WOOD, Material.OAK_LEAVES,
            Material.OAK_WOOD, Material.SPRUCE_LEAVES, Material.SPRUCE_WOOD, Material.JUNGLE_LEAVES, Material.JUNGLE_WOOD,
            Material.DARK_OAK_LEAVES, Material.DARK_OAK_WOOD, Material.STRIPPED_ACACIA_WOOD, Material.STRIPPED_BIRCH_WOOD,
            Material.STRIPPED_JUNGLE_WOOD, Material.STRIPPED_SPRUCE_WOOD);

    public KaceniStromu(World world){
        this.world = world;
    }


    private Location najdiPovrch(Location location) {
        Location povrch = location.clone();
        while(povrch.getBlock().getType() != Material.AIR && !jeStrom(povrch)) {
            povrch.add(0, 1, 0);
        }
        while(povrch.clone().add(0, -1, 0).getBlock().getType() == Material.AIR && !jeStrom(povrch.clone().add(0, -1, 0))){
            povrch.add(0, -1, 0);
        }
        return  povrch;
    }

    private boolean jeStrom(Location location) {
        return TYPY_STROMU.contains(location.getBlock().getType());
    }
    //rekurze
    private void skacejStrom(Location location) {
        if (!jeStrom(location)) return;
        location.getBlock().setType(Material.AIR);
        skacejStrom(location.clone().add(1,0,0));
        skacejStrom(location.clone().add(-1,0,0));
        skacejStrom(location.clone().add(0,1,0));
        skacejStrom(location.clone().add(0,-1,0));
        skacejStrom(location.clone().add(0,0,1));
        skacejStrom(location.clone().add(0,0,-1));

        skacejStrom(location.clone().add(1,0,1));
        skacejStrom(location.clone().add(-1,0,-1));
        skacejStrom(location.clone().add(1,0,-1));
        skacejStrom(location.clone().add(-1,0,1));

        skacejStrom(location.clone().add(1,1,0));
        skacejStrom(location.clone().add(-1,1,0));
        skacejStrom(location.clone().add(0,1,1));
        skacejStrom(location.clone().add(0,1,-1));

        skacejStrom(location.clone().add(1,1,1));
        skacejStrom(location.clone().add(-1,1,1));
        skacejStrom(location.clone().add(1,1,-1));
        skacejStrom(location.clone().add(-1,1,-1));
    }
}
