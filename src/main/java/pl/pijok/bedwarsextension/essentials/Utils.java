package pl.pijok.bedwarsextension.essentials;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;

public class Utils {

    public static boolean isMaterial(String a){
        try{
            Material.valueOf(a);
            return true;
        }
        catch (IllegalArgumentException e){
            return false;
        }
    }

    public static Location stringToLocation(String a){
        String[] fragments = a.split(",");
        double x = Double.parseDouble(fragments[0]);
        double y = Double.parseDouble(fragments[1]);
        double z = Double.parseDouble(fragments[2]);
        String world = fragments[3];
        return new Location(Bukkit.getWorld(world), x, y, z);
    }

    public static String locationToString(Location location){
        String a = "";
        a = String.valueOf(location.getBlockX());
        a = a + "," + location.getBlockY();
        a = a + "," + location.getBlockZ();
        a = a + "," + location.getWorld().getName();
        return a;
    }

}
