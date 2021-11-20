package pl.pijok.bedwarsextension;

import org.bukkit.plugin.Plugin;
import pl.pijok.bedwarsextension.essentials.Debug;
import pl.pijok.bedwarsextension.listeners.ArenaBedBreakListener;
import pl.pijok.bedwarsextension.listeners.RoundEndListener;
import pl.pijok.bedwarsextension.listeners.TeamEliminateListener;

public class Listeners {

    public static void registerListeners(Plugin plugin){
        Debug.log("Registering listeners");

        plugin.getServer().getPluginManager().registerEvents(new TeamEliminateListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new RoundEndListener(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ArenaBedBreakListener(), plugin);
    }

}
