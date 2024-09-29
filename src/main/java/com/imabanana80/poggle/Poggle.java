package com.imabanana80.poggle;

import com.imabanana80.poggle.commands.PoggleCommand;
import com.imabanana80.poggle.listener.EntityDamageByEntityListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Poggle extends JavaPlugin {

    private static Poggle instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        Bukkit.getServer().getPluginManager().registerEvents(new EntityDamageByEntityListener(), this);
        Objects.requireNonNull(getCommand("poggle")).setExecutor(new PoggleCommand());
    }

    public static Poggle getInstance() {
        return instance;
    }
}
