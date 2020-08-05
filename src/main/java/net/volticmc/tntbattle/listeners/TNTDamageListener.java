package net.volticmc.tntbattle.listeners;

import net.volticmc.tntbattle.TNTBattle;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class TNTDamageListener extends TNTListener{

    public TNTDamageListener(TNTBattle tntBattle) {
        super(tntBattle);
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
    public void onDamage(EntityDamageEvent event){
        if(event.getCause() == EntityDamageEvent.DamageCause.FALL){
            event.setCancelled(true);
        }
    }
}
