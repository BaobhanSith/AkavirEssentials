package me.albaenchantress.akaviressentials.commands.economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.ShulkerBox;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Shulker;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class GiveWalletCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(commandSender instanceof Player player){
            if(!player.hasPermission("akaconomy.admin")){
                player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            } else {
                if(args.length == 0){
                    player.sendMessage(ChatColor.RED + "You must specify which player to target!");
                } else if (args.length > 1) {
                    player.sendMessage(ChatColor.RED + "Too many arguments!");
                } else if (args.length == 1){
                    String targetPlayerName = args[0];
                    Player targetPlayer = Bukkit.getPlayer(targetPlayerName);

                    if(targetPlayer != null){
                        ItemStack coinItem = new ItemStack(Material.GOLD_NUGGET, 10);
                        ItemMeta coinMeta = coinItem.getItemMeta();
                        coinMeta.setDisplayName("Coin (1)");
                        coinItem.setItemMeta(coinMeta);

                        ItemStack walletItem = new ItemStack(Material.YELLOW_SHULKER_BOX);
                        ItemMeta walletMeta = walletItem.getItemMeta();
                        walletMeta.setDisplayName(targetPlayerName + "'s Wallet");
                        BlockStateMeta bsm = (BlockStateMeta) walletMeta;
                        ShulkerBox box = (ShulkerBox) bsm.getBlockState();
                        walletItem.setItemMeta(walletMeta);
                        Inventory walletInventory = box.getInventory();
                        walletInventory.setItem(0, coinItem);
                        bsm.setBlockState(box);
                        walletItem.setItemMeta(bsm);

                        if(targetPlayer.getInventory().contains(walletItem)){
                            player.sendMessage(targetPlayerName + " already has a wallet!");
                        } else {
                            targetPlayer.getInventory().addItem(walletItem);
                            targetPlayer.updateInventory();
                        }
                    } else {
                        player.sendMessage(targetPlayerName + " has not been found!");
                    }
                }
            }
        }

        return true;
    }
}
