package me.koz.throwablecegg.handler;

import me.koz.throwablecegg.CC;
import org.bukkit.Bukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class Handler implements CommandExecutor {

    SpawningEvent spawningEvent = new SpawningEvent();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = (Player) sender;

        if (!player.hasPermission("throwableceggs.admin")) {
            player.sendMessage(CC.translate("&aYou do not have permission to perform this command."));
        }
        if (args.length < 3) {
            usage(player);
            return true;
    } else {
            Player target = Bukkit.getPlayer(args[1]);
            if (target != null) {
                int amount = Integer.parseInt(args[2]);
                        ItemStack cegg = spawningEvent.spawnItem();
                        cegg.setAmount(amount);
                 target.getInventory().addItem(cegg);
                        if (amount <= 1) {
                            target.sendMessage(CC.translate("&bYou have received " + amount + " &aThrowable Cegg"));
                            sender.sendMessage(CC.translate("&bYou have given " + amount + " &aThrowable Cegg to &b" + target.getName()));
                        } else {
                            target.sendMessage(CC.translate("&bYou have received " + amount + " &aThrowable Ceggs"));
                            sender.sendMessage(CC.translate("&bYou have given " + amount + " &aThrowable Ceggs to &b" + target.getName()));
                            return true;
                        }
                    }
                }
        return false;
    }

    void usage(Player player) {
        player.sendMessage(CC.translate("&cUsage: &b/throwables give <player> <amount>"));
    }
}
