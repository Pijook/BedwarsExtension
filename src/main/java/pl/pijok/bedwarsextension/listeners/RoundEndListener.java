package pl.pijok.bedwarsextension.listeners;

import de.marcely.bedwars.api.event.arena.RoundEndEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import pl.pijok.bedwarsextension.BedWarsExtension;
import pl.pijok.bedwarsextension.Settings;
import pl.pijok.bedwarsextension.essentials.ChatUtils;
import pl.pijok.bedwarsextension.lang.Lang;
import pl.pijok.bedwarsextension.lang.Language;

public class RoundEndListener implements Listener {

    @EventHandler
    public void onEnd(RoundEndEvent event){

        double value = Settings.top.get(1);

        String text = Language.getText(Lang.TEAM_ELIMINATE);
        text = text.replace("%money%", "" + value).replace("%place%", "" + 1);

        for(Player player : event.getWinners()){
            BedWarsExtension.getEconomy().depositPlayer(player, value);
            ChatUtils.sendMessage(player, text);
        }

    }

}
