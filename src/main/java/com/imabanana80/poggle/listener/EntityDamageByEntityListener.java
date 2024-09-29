package com.imabanana80.poggle.listener;

import com.imabanana80.poggle.Poggle;
import org.bukkit.ChatColor;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.entity.SpectralArrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntityListener implements Listener {
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (!Poggle.getInstance().getConfig().getBoolean("allow-pvp")){
            Player damaged = null;
            Player damager = null;
            if (event.getEntity() instanceof Player) {
                damaged = (Player) event.getEntity();
            }
            if (event.getDamager() instanceof Player) {
                damager = (Player) event.getDamager();
            }
            if (event.getDamager() instanceof Arrow arrow) {
                if (arrow.getShooter() instanceof Player) {
                    damager = (Player) arrow.getShooter();
                }
            }
            if (event.getDamager() instanceof SpectralArrow arrow) {
                if (arrow.getShooter() instanceof Player) {
                    damager = (Player) arrow.getShooter();
                }
            }
            if (damaged != null && damager != null) {
                damager.sendMessage(ChatColor.RED + "PVP is currently disabled!");
                event.setCancelled(true);
            }
        }
    }
}
