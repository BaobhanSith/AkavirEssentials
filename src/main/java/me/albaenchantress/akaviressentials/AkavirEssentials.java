package me.albaenchantress.akaviressentials;

import me.albaenchantress.akaviressentials.commands.economy.GiveWalletCommand;
import me.albaenchantress.akaviressentials.commands.potionfoods.AddEffectCommand;
import me.albaenchantress.akaviressentials.listeners.FoodLevelChangeListener;
import me.albaenchantress.akaviressentials.listeners.InventoryClickListener;
import me.albaenchantress.akaviressentials.listeners.InventoryDropEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class AkavirEssentials extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("AkavirEssentials plugin has started!");

        getServer().getPluginManager().registerEvents(new FoodLevelChangeListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryDropEvent(), this);
        getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
        getCommand("addEffect").setExecutor(new AddEffectCommand());
        getCommand("giveWallet").setExecutor(new GiveWalletCommand());
    }
}
