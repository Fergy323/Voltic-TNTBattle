package net.volticmc.tntbattle.listeners;

import net.volticmc.tntbattle.TNTBattle;
import net.volticmc.tntbattle.game.TNTState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;

public class TNTBlockPlaceListener extends TNTListener{

    public TNTBlockPlaceListener(TNTBattle tntBattle) {
        super(tntBattle);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event){
        event.setCancelled(true);
        if(TNTState.getState() == TNTState.IN_GAME) {
        }
    }

}
