package me.albaenchantress.akaviressentials.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryDropEvent implements Listener {
    @EventHandler
    public void onInventoryDrop(PlayerDropItemEvent e){
        ItemStack clickedItem = e.getItemDrop().getItemStack();
        Player player = (Player) e.getPlayer();
        String playerName = player.getDisplayName();

        if(clickedItem.getItemMeta().getDisplayName().equalsIgnoreCase(playerName + "'s Wallet")){
            e.setCancelled(true);
            player.sendMessage(ChatColor.RED + "You cannot move this item!");
        }
    }
}
