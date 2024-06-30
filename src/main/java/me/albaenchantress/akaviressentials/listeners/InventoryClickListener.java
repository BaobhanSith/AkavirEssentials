package me.albaenchantress.akaviressentials.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class InventoryClickListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        ItemStack clickedItem = e.getCurrentItem();
        Player player = (Player) e.getWhoClicked();
        String playerName = player.getDisplayName();
        if (e.getInventory().getType() != InventoryType.PLAYER){
            if(clickedItem.getItemMeta().getDisplayName().equals(playerName + "'s Wallet")){
                e.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You cannot remove this item from your inventory!");
            }
        }
    }
}
