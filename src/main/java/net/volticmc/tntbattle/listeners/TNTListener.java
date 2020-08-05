package net.volticmc.tntbattle.listeners;

import net.volticmc.tntbattle.TNTBattle;
import org.bukkit.event.Listener;

public class TNTListener implements Listener {

    private TNTBattle tntBattle;

    public TNTListener(TNTBattle tntBattle){
        tntBattle.getServer().getPluginManager().registerEvents(this, tntBattle);
        this.tntBattle = tntBattle;
    }

    public TNTBattle getMain() {
        return tntBattle;
    }
}
