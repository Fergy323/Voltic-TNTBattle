package net.volticmc.tntbattle.listeners;

import net.volticmc.tntbattle.TNTBattle;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityExplodeEvent;

public class TNTExplodeListener extends TNTListener {

    public TNTExplodeListener(TNTBattle tntBattle) {
        super(tntBattle);
    }

    @EventHandler
    public void onTNTExplode(EntityExplodeEvent event){
        if(event.getEntity() instanceof TNTPrimed){
            event.setCancelled(true);
        }
    }

}
