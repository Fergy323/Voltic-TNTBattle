package net.volticmc.tntbattle.game;

import net.volticmc.tntbattle.TNTBattle;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class TNTBattleGame implements Listener {

    private TNTBattle main;
    //private TNTMap map;
    private boolean live;

    public TNTBattleGame(TNTBattle tntBattle){
        tntBattle.getServer().getPluginManager().registerEvents(this, tntBattle);
        main = tntBattle;
    }

    public void start(){
        //TODO Add logic for starting game
        Bukkit.broadcastMessage("Game has started");
        live = true;
    }

    public void stop(){
        //TODO Add logic for stopping game
        Bukkit.broadcastMessage("Game has stopped");
        live = false;
    }

    @EventHandler
    public void onTNTExplode(EntityExplodeEvent event){
        if(event.getEntity() instanceof TNTPrimed){
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onTNTDamage(EntityDamageByEntityEvent event){
        if(event.getEntityType() == EntityType.PLAYER){
            if(event.getCause() != EntityDamageEvent.DamageCause.ENTITY_EXPLOSION){
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event){
        Player killer = (Player) event.getEntity().getLastDamageCause().getEntity();
        event.setDeathMessage(null);
        Bukkit.broadcastMessage(event.getEntity().getName() + " was obliterated by " + killer.getName());
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event){
        event.setCancelled(true);
        if(live) {
            if (event.getBlockPlaced().getType() == Material.TNT) {
                TNTPrimed tntPrimed = (TNTPrimed) event.getPlayer().getWorld().spawnEntity(event.getBlockPlaced().getLocation(), EntityType.PRIMED_TNT);
                tntPrimed.setFuseTicks(10);
                tntPrimed.setMetadata(event.getPlayer().getName(), new FixedMetadataValue(main, event.getPlayer().getName()));
            }
        }
    }



}
