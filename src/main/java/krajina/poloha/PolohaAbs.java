package krajina.poloha;

import org.bukkit.Location;

public class PolohaAbs {

    private final Location mistoAbs;

    public PolohaAbs(Location location) {
        this.mistoAbs = location.clone();
    }

    public int getBlockX() {
        return mistoAbs.getBlockX();
    }

    public int getBlockY() {
        return mistoAbs.getBlockY();
    }

    public int getBlockZ() {
        return mistoAbs.getBlockZ();
    }

    public double getX() {
        return mistoAbs.getX();
    }

    public double getY() {
        return mistoAbs.getY();
    }

    public double getZ() {
        return mistoAbs.getZ();
    }

    public Location toAbsLocation() {
        return mistoAbs.clone();
    }

    public PolohaAbs plus(int x, int y, int z) {
        PolohaAbs plus = new PolohaAbs(this.mistoAbs.clone().add(x, y, z));
        return plus;
    }

    public double vzdalenostXYZ(PolohaAbs bod) {
        double dx = getX() - bod.getX();
        double dy = getY() - bod.getY();
        double dz = getZ() - bod.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public double vzdalenostXZ(PolohaAbs bod) {
        double dx = getX() - bod.getX();
        double dz = getZ() - bod.getZ();
        return Math.sqrt(dx * dx + dz * dz);
    }

    public double vzdalenostXY(PolohaAbs bod) {
        double dx = getX() - bod.getX();
        double dy = getY() - bod.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double vzdalenostYZ(PolohaAbs bod) {
        double dy = getY() - bod.getY();
        double dz = getZ() - bod.getZ();
        return Math.sqrt(dy * dy + dz * dz);
    }
}
