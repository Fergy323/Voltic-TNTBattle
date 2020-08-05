package net.volticmc.tntbattle.listeners;

import net.volticmc.tntbattle.TNTBattle;
import net.volticmc.tntbattle.game.TNTState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServerListPingEvent;

public class TNTMOTDListener extends TNTListener {

    public TNTMOTDListener(TNTBattle tntBattle) {
        super(tntBattle);
    }

    @EventHandler
    public void onListPing(ServerListPingEvent e){
        e.setMotd(TNTState.getState().getMOTDStatus());
    }

}
