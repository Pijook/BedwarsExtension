package pl.pijok.bedwarsextension.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.pijok.bedwarsextension.BedWarsExtension;
import pl.pijok.bedwarsextension.essentials.ChatUtils;

public class ExtensionCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            if(!player.hasPermission("bwextension.reload")){
                ChatUtils.sendMessage(player, "&cPermission denied!");
                return true;
            }
        }

        if(args.length == 1){
            if(args[0].equalsIgnoreCase("reload")){
                ChatUtils.sendMessage(sender, "&7Reloading...");
                if(BedWarsExtension.getInstance().loadStuff(true)){
                    ChatUtils.sendMessage(sender, "&aReloaded!");
                }
                else{
                    ChatUtils.sendMessage(sender, "&cSomething went wrong! Check console for errors");
                }
                return true;
            }
        }

        ChatUtils.sendMessage(sender, "&7/" + label + " reload");
        return true;
    }

}
