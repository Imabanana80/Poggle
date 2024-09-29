package com.imabanana80.poggle.commands;

import com.imabanana80.poggle.Poggle;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PoggleCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        boolean allowPVP = Poggle.getInstance().getConfig().getBoolean("allow-pvp");
        if (allowPVP) {
            Poggle.getInstance().getConfig().set("allow-pvp", false);
            Bukkit.broadcastMessage(ChatColor.RED + "PVP has been disabled!");
        } else {
            Poggle.getInstance().getConfig().set("allow-pvp", true);
            Bukkit.broadcastMessage(ChatColor.GREEN + "PVP has been enabled!");
        }
        Poggle.getInstance().saveConfig();
        return true;
    }
}
