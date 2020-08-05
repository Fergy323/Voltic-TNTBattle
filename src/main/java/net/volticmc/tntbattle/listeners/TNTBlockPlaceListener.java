package net.volticmc.tntbattle.listeners;

import net.volticmc.tntbattle.TNTBattle;
import net.volticmc.tntbattle.game.TNTState;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class TNTBlockPlaceListener extends TNTListener{

    public TNTBlockPlaceListener(TNTBattle tntBattle) {
        super(tntBattle);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event){
        event.setCancelled(true);
        if(TNTState.getState() == TNTState.IN_GAME) {
            if (event.getBlockPlaced().getType() == Material.TNT) {
                TNTPrimed tntPrimed = (TNTPrimed) event.getPlayer().getWorld().spawnEntity(event.getBlockPlaced().getLocation(), EntityType.PRIMED_TNT);
                tntPrimed.setFuseTicks(10);
                tntPrimed.setMetadata(event.getPlayer().getName(), new FixedMetadataValue(getMain(), event.getPlayer().getName()));
            }
        }
    }
}
