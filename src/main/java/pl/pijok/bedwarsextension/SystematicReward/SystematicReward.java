package pl.pijok.bedwarsextension.SystematicReward;

import de.marcely.bedwars.api.GameAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pl.pijok.bedwarsextension.BedWarsExtension;
import pl.pijok.bedwarsextension.Settings;
import pl.pijok.bedwarsextension.essentials.ChatUtils;
import pl.pijok.bedwarsextension.lang.Lang;
import pl.pijok.bedwarsextension.lang.Language;

import java.util.Collection;

public class SystematicReward {

    private static int taskID;

    public static void startTimer(){

        int time = Settings.timeInGame * 20;

        final String text = Language.getText(Lang.TIME_REWARD).replace("%money%", Settings.rewardForTime + "");

        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(BedWarsExtension.getInstance(), new Runnable() {
            @Override
            public void run() {

                Collection<Player> spectatingPlayers = GameAPI.get().getSpectatingPlayers();
                for(Player player : Bukkit.getOnlinePlayers()){
                    if(!spectatingPlayers.contains(player)){
                        BedWarsExtension.getEconomy().depositPlayer(player, Settings.rewardForTime);
                        ChatUtils.sendMessage(player, text);
                    }
                }

            }
        }, time, time);

    }

    public static void stopTimer(){

        Bukkit.getScheduler().cancelTask(taskID);

    }

}
