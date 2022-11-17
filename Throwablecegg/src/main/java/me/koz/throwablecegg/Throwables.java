package me.koz.throwablecegg;


import me.koz.throwablecegg.handler.Handler;
import me.koz.throwablecegg.listener.Throws;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Throwables extends JavaPlugin {

    private static Throwables instance;

    public static Throwables getInstance() {
        return instance;
    }


    public void onEnable() {

        instance = this;

        long duration = System.currentTimeMillis();
        String prefix = "§3[" + getDescription().getName() + " " + getDescription().getVersion() + "] ";
        Bukkit.getConsoleSender().sendMessage(prefix + "§6=== ENABLE START ===");
        Bukkit.getConsoleSender().sendMessage(prefix + "§aLoading §dListeners");
        Bukkit.getConsoleSender().sendMessage(prefix + "§aLoading §dCommands");
        Bukkit.getConsoleSender().sendMessage(prefix + "§aMade by §dKoz");
        Bukkit.getConsoleSender().sendMessage(
                prefix + "§6=== ENABLE §aCOMPLETE §6(Took §d" + (System.currentTimeMillis() - duration) + "ms§6) ===");
        registerCommands();
        registerEvents();


    }

    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new Throws(), this);
    }

    private void registerCommands() {
        getCommand("throwables").setExecutor(new Handler());
    }


    public void onDisable() {
        long duration = System.currentTimeMillis();
        String prefix = "§3[" + getDescription().getName() + " " + getDescription().getVersion() + "] ";
        Bukkit.getConsoleSender().sendMessage(prefix + "§6=== DISABLING ===");
        Bukkit.getConsoleSender().sendMessage(prefix + "§aDisabling §dListeners");
        Bukkit.getConsoleSender().sendMessage(prefix + "§aDisabling §dCommands");
        Bukkit.getConsoleSender().sendMessage(prefix + "§aMade by §dKoz");
        Bukkit.getConsoleSender().sendMessage(
                prefix + "§6=== DISABLE §aCOMPLETE §6(Took §d" + (System.currentTimeMillis() - duration) + "ms§6) =");
    }
}

