package me.albaenchantress.akaviressentials.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;

public class AnvilRenameListener implements Listener {
    @EventHandler
    public void onAnvilRename(PrepareAnvilEvent e){
        ItemStack clickedItem = e.getResult();

        if(clickedItem.getItemMeta().getDisplayName().contains("Wallet")){
            // e.setCancelled(true);
        }
    }
}
