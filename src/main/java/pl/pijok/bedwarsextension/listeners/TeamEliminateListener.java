package pl.pijok.bedwarsextension.listeners;

import de.marcely.bedwars.api.GameAPI;
import de.marcely.bedwars.api.event.arena.TeamEliminateEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import pl.pijok.bedwarsextension.BedWarsExtension;
import pl.pijok.bedwarsextension.Settings;
import pl.pijok.bedwarsextension.essentials.ChatUtils;
import pl.pijok.bedwarsextension.essentials.Debug;
import pl.pijok.bedwarsextension.lang.Lang;
import pl.pijok.bedwarsextension.lang.Language;

public class TeamEliminateListener implements Listener {

    @EventHandler
    public void onEliminate(TeamEliminateEvent event){

        int place = event.getArena().getRemainingTeams().size();
        Debug.log("Remaining teams: " + place);
        if(Settings.top.containsKey(place)){
            double value = Settings.top.get(place);

            String text = Language.getText(Lang.TEAM_ELIMINATE);
            text = text.replace("%money%", "" + value).replace("%place%", "" + place);

            for(Player player : event.getArena().getPlayersInTeam(event.getTeam())){
                BedWarsExtension.getEconomy().depositPlayer(player, value);
                ChatUtils.sendMessage(player, text);
            }
        }
    }
}
