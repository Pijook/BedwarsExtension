package pl.pijok.bedwarsextension;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import pl.pijok.bedwarsextension.essentials.ChatUtils;
import pl.pijok.bedwarsextension.essentials.ConfigUtils;
import pl.pijok.bedwarsextension.essentials.Debug;
import pl.pijok.bedwarsextension.lang.Language;

public class BedWarsExtension extends JavaPlugin {

    private static BedWarsExtension instance;
    private static Economy economy;

    @Override
    public void onEnable() {

        instance = this;

        Debug.setPrefix("[BedWarsExtension]");
        ChatUtils.setPrefix("[BedWarsExtension]");
        ConfigUtils.setPlugin(this);

        verifyPlugins();

        loadStuff(false);

    }

    @Override
    public void onDisable() {

    }

    public void loadStuff(boolean reload){

        Debug.log("Loading " + this.getDescription().getName() + " by " + this.getDescription().getAuthors() + " version " + this.getDescription().getVersion());

        Debug.log("Loading lang");
        Language.load();

        Debug.log("Loading settings");
        Settings.load();

        Debug.log("&aLoaded!");
    }

    public void verifyPlugins(){

        Debug.log("Checking dependencies");

        if(!setupEconomy()){
            Debug.log("Vault not found or illegal version detected! Disabling...");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        Debug.log("&aVault check");

        if(!setupBedWars()){
            Debug.log("MbedWars not found! Disabling...");
            getServer().getPluginManager().disablePlugin(this);
        }
        Debug.log("&aMBedWars check");

        Debug.log("&aDone!");
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        economy = rsp.getProvider();
        return economy != null;
    }

    private boolean setupBedWars(){
        return getServer().getPluginManager().getPlugin("MBedwars") != null;
    }

    public static Economy getEconomy() {
        return economy;
    }

    public static BedWarsExtension getInstance() {
        return instance;
    }
}
