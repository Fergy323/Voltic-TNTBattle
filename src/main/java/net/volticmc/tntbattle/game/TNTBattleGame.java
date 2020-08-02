package net.volticmc.tntbattle.game;

import net.volticmc.tntbattle.TNTBattle;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.type.TNT;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockExplodeEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class TNTBattleGame implements Listener {

    private TNTBattle main;
    //private TNTMap map;

    public TNTBattleGame(TNTBattle tntBattle){
        tntBattle.getServer().getPluginManager().registerEvents(this, tntBattle);
        main = tntBattle;
    }

    public void start(){
        //TODO Add logic for starting game
    }

    public void stop(){
        //TODO Add logic for stopping game
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event){
        event.setCancelled(true);
        if(event.getBlockPlaced().getType() == Material.TNT){
            TNTPrimed tntPrimed = (TNTPrimed) event.getPlayer().getWorld().spawnEntity(event.getPlayer().getLocation(), EntityType.PRIMED_TNT);
            tntPrimed.setFuseTicks(10);
        }
    }

    @EventHandler
    public void onTNTExplode(BlockExplodeEvent event){
        event.setCancelled(true);
    }

}
