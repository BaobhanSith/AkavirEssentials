package me.albaenchantress.akaviressentials.commands.potionfoods;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class AddEffectCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player player){
            if(!player.hasPermission("potionfoods.create")) {
                player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            }
            else
            {
                if(args.length == 0){
                    player.sendMessage(ChatColor.RED + "Please input the name of the effect and the duration.");
                    player.sendMessage(ChatColor.RED + "/addeffect <effect> <amplifier> <duration>");
                } else if (args.length == 1) {
                    player.sendMessage(ChatColor.RED + "Please input the amplifier.");
                    player.sendMessage(ChatColor.RED + "/addeffect <effect> <amplifier> <duration>");
                } else if (args.length == 2){
                    player.sendMessage(ChatColor.RED + "Please input the duration.");
                    player.sendMessage(ChatColor.RED + "/addeffect <effect> <amplifier> <duration>");
                } else if (args.length > 3) {
                    player.sendMessage(ChatColor.RED + "Too many arguments.");
                    player.sendMessage(ChatColor.RED + "/addeffect <effect> <amplifier> <duration>");
                } else {
                    ItemStack heldItem = player.getInventory().getItemInMainHand();
                    if(heldItem == null){
                        player.sendMessage(ChatColor.RED + "Not holding an item.");
                    } else if(!heldItem.getType().isEdible()) {
                        player.sendMessage(ChatColor.RED + "This command only works on food items.");
                    } else {
                        ItemMeta foodEffects = heldItem.getItemMeta();
                        ArrayList<String> lore = new ArrayList<>();
                        if(foodEffects != null) {
                            if (!foodEffects.hasLore()) {
                                lore.add("PotionFoods");
                            } else {
                                lore = (ArrayList<String>) foodEffects.getLore();
                            }
                            lore.add(args[0] + " " + args[1] + " " + args[2]);
                            foodEffects.setLore(lore);
                            heldItem.setItemMeta(foodEffects);
                        }
                    }
                }
            }
        }

        return true;
    }
}
