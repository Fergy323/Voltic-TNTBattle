package net.volticmc.tntbattle.listeners;

import net.volticmc.tntbattle.TNTBattle;
import net.volticmc.tntbattle.game.TNTState;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;

import java.util.Collection;

public class TNTDeathListener extends TNTListener {

    public TNTDeathListener(TNTBattle tntBattle) {
        super(tntBattle);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        if(TNTState.getState() == TNTState.IN_GAME) {
            if(event.getEntity().getLastDamageCause() instanceof EntityDamageByEntityEvent && ((EntityDamageByEntityEvent) event.getEntity().getLastDamageCause()).getDamager() instanceof TNTPrimed){
                EntityDamageByEntityEvent lastCause = (EntityDamageByEntityEvent) event.getEntity().getLastDamageCause();
                Player killer = null;

                for(Player p : Bukkit.getServer().getOnlinePlayers()){
                    if(lastCause.getDamager().hasMetadata(p.getName())){
                        killer = Bukkit.getServer().getPlayer(p.getName());
                    }
                }

                event.setDeathMessage(null);
                Bukkit.broadcastMessage(event.getEntity().getName() + " was obliterated by " + killer.getName());
                killer.sendMessage("You obliterated " + event.getEntity().getName());
                killer.playSound(killer.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 10, 10);
            }
            Collection<PotionEffect> effects = event.getEntity().getActivePotionEffects();
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(getMain(), () -> event.getEntity().spigot().respawn(), 10L);
            for(PotionEffect effect : effects){
                event.getEntity().addPotionEffect(effect);
            }

        }
    }
}
