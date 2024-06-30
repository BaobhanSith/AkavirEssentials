package me.albaenchantress.akaviressentials.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;

public class FoodLevelChangeListener implements Listener {
    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e){
        ItemStack item = e.getItem();
        System.out.println("Eating item!");
        if(item != null) {
            ItemMeta itemMeta = item.getItemMeta();
            ArrayList<String> effectInformation = new ArrayList<String>();
            assert itemMeta != null;
            if (itemMeta.hasLore()) {
                for (int i = 1; i < itemMeta.getLore().toArray().length; i++) {
                    effectInformation.add(itemMeta.getLore().get(i));
                }
                for (int i = 0; i < effectInformation.toArray().length; i++) {
                    String[] effects = effectInformation.get(i).split(" ");
                    int amplifier = Integer.parseInt(effects[1]);
                    int duration = Integer.parseInt(effects[2]);
                    PotionEffect potionEffect = new PotionEffect(PotionEffectType.getByName(effects[0]), duration, amplifier);
                    e.getEntity().addPotionEffect(potionEffect);
                }
            }
        }
    }
}
