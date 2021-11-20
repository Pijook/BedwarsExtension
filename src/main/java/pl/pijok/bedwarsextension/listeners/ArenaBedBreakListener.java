package pl.pijok.bedwarsextension.listeners;

import de.marcely.bedwars.api.GameAPI;
import de.marcely.bedwars.api.arena.Team;
import de.marcely.bedwars.api.event.arena.ArenaBedBreakEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import pl.pijok.bedwarsextension.BedWarsExtension;
import pl.pijok.bedwarsextension.Settings;
import pl.pijok.bedwarsextension.essentials.ChatUtils;
import pl.pijok.bedwarsextension.lang.Lang;
import pl.pijok.bedwarsextension.lang.Language;

import java.util.List;

public class ArenaBedBreakListener implements Listener {

    @EventHandler
    public void onBreak(ArenaBedBreakEvent event){
        Player player = event.getPlayer();
        List<Player> playersInTeam = GameAPI.get().getArenaByPlayer(player).getPlayersInTeam(GameAPI.get().getArenaByPlayer(player).getPlayerTeam(player));

        String text = Language.getText(Lang.BED_DESTROY);
        text = text.replace("%money%", Settings.bedDestroy + "").replace("%team%", event.getTeam().getDisplayName());

        for(Player teamPlayer : playersInTeam){
            BedWarsExtension.getEconomy().depositPlayer(teamPlayer, Settings.bedDestroy);
            ChatUtils.sendMessage(teamPlayer, text);
        }
    }

}
