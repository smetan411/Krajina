package krajina.poloha;

import org.bukkit.Location;
import org.bukkit.block.Block;

public class AbsLocation {

    private final Location location;

    public AbsLocation(Location location) {
        this.location = location.clone();
    }

    public int getBlockX() {
        return location.getBlockX();
    }

    public int getBlockY() {
        return location.getBlockY();
    }

    public int getBlockZ() {
        return location.getBlockZ();
    }

    public double getX() {
        return location.getX();
    }

    public double getY() {
        return location.getY();
    }

    public double getZ() {
        return location.getZ();
    }

    public Location toLocation() {
        return location.clone();
    }

    public AbsLocation plus(int x, int y, int z) {
        return new AbsLocation(this.location.clone().add(x, y, z));
    }

    public double vzdalenostXYZ(AbsLocation bod) {
        double dx = getX() - bod.getX();
        double dy = getY() - bod.getY();
        double dz = getZ() - bod.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public double vzdalenostXZ(AbsLocation bod) {
        double dx = getX() - bod.getX();
        double dz = getZ() - bod.getZ();
        return Math.sqrt(dx * dx + dz * dz);
    }

    public double vzdalenostXY(AbsLocation bod) {
        double dx = getX() - bod.getX();
        double dy = getY() - bod.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double vzdalenostYZ(AbsLocation bod) {
        double dy = getY() - bod.getY();
        double dz = getZ() - bod.getZ();
        return Math.sqrt(dy * dy + dz * dz);
    }

    public Block getBlock() {
        return location.getBlock();
    }
}
