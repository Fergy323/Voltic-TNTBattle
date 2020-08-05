package net.volticmc.tntbattle.listeners;

import net.volticmc.tntbattle.TNTBattle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;

public class TNTQuitListener extends TNTListener {

    public TNTQuitListener(TNTBattle tntBattle) {
        super(tntBattle);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        getMain().getPlayerManager().removePlayer(e.getPlayer());
    }
}
