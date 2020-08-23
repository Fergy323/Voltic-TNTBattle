package net.volticmc.tntbattle.listeners;

import net.volticmc.tntbattle.TNTBattle;
import net.volticmc.tntbattle.game.TNTState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class TNTJoinListener extends TNTListener {


    public TNTJoinListener(TNTBattle tntBattle) {
        super(tntBattle);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        if(TNTState.getState() == TNTState.WAITING) {
            getMain().getPlayerManager().addPlayer(event.getPlayer());
        }
    }
}
