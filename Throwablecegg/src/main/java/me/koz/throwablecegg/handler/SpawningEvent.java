package me.koz.throwablecegg.handler;

import me.koz.throwablecegg.CC;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpawningEvent {

    public ItemStack spawnItem() {
        ItemStack item = new ItemStack(Material.CREEPER_SPAWN_EGG);
        ItemMeta itemm = item.getItemMeta();
        itemm.setDisplayName(CC.translate("&a&lThrowable Cegg"));
        item.setItemMeta(itemm);
        return item;
    }
}
