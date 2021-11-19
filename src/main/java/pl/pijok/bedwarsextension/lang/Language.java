package pl.pijok.bedwarsextension.lang;

import org.bukkit.configuration.file.YamlConfiguration;
import pl.pijok.bedwarsextension.BedWarsExtension;
import pl.pijok.bedwarsextension.essentials.ConfigUtils;
import pl.pijok.bedwarsextension.essentials.Debug;

import java.util.HashMap;

public class Language {

    private static HashMap<Lang, String> lang = new HashMap<>();

    public static void load(){

        YamlConfiguration configuration = ConfigUtils.load("lang.yml", BedWarsExtension.getInstance());

        for(Lang a : Lang.values()){
            if(configuration.contains("lang." + a)){
                Debug.log("Loaded " + a);
                lang.put(a, configuration.getString("lang." + a));
            }
        }
    }

    public static String getText(Lang a){
        return lang.getOrDefault(a, "NULL");
    }

}
