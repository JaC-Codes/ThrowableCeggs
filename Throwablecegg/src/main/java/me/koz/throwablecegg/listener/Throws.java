package me.koz.throwablecegg.listener;

import me.koz.throwablecegg.CC;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class Throws implements Listener {

    @EventHandler
    public void throwItem(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action a = event.getAction();
        boolean isRightClick = a.equals(Action.RIGHT_CLICK_AIR) || a.equals(Action.RIGHT_CLICK_BLOCK);

        ItemStack cegg = event.getItem();
        if (cegg == null) return;
        if (!cegg.hasItemMeta()) return;
        if (Objects.requireNonNull(cegg.getItemMeta()).getDisplayName().equals(CC.translate("&a&lThrowable Cegg"))) {
            if (isRightClick) {
                event.setCancelled(true);
                Location loc = player.getEyeLocation().add(player.getLocation().getDirection());
                Snowball snowball = player.getWorld().spawn(loc, Snowball.class);
                snowball.setVelocity(player.getEyeLocation().getDirection().multiply(3));
                snowball.setItem(cegg);
                cegg.setAmount(cegg.getAmount() - 1);

            }
        }
    }

    @EventHandler
    public void onSnowballHit(ProjectileHitEvent event) {
        if (event.getEntity() instanceof Snowball) {
            event.getEntity().remove();
            Snowball proj = (Snowball) event.getEntity();
            if (proj.getItem().getType() == Material.CREEPER_SPAWN_EGG) {
                ItemStack item = proj.getItem();
                if (!item.hasItemMeta()) return;
                Location loc = proj.getLocation();
                loc.getWorld().createExplosion(loc, 3);
                }
            }
        }
    }

