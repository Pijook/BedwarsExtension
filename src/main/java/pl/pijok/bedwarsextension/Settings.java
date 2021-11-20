package pl.pijok.bedwarsextension;

import org.bukkit.configuration.file.YamlConfiguration;
import pl.pijok.bedwarsextension.essentials.ConfigUtils;

import java.util.HashMap;

public class Settings {

    public static double finalKill;
    public static double bedDestroy;
    public static int timeInGame;
    public static double rewardForTime;
    public static HashMap<Integer, Double> top = new HashMap<>();

    public static void load(){

        YamlConfiguration configuration = ConfigUtils.load("config.yml", BedWarsExtension.getInstance());

        finalKill = configuration.getDouble("finalKill");
        bedDestroy = configuration.getDouble("bedDestroy");

        timeInGame = configuration.getInt("timeInGame.time");
        rewardForTime = configuration.getDouble("timeInGame.reward");

        for(String placeString : configuration.getConfigurationSection("top").getKeys(false)){
            int place = Integer.parseInt(placeString);
            double value = configuration.getDouble("top." + placeString);
            top.put(place, value);
        }
    }

}
