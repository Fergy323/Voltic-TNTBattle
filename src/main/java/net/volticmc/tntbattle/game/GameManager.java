package net.volticmc.tntbattle.game;

import net.volticmc.tntbattle.TNTBattle;
import org.bukkit.event.Listener;

public class GameManager implements Listener {

    private final TNTBattle main;
    private TNTBattleGame currentInstance;

    public GameManager(TNTBattle tntBattle) {
        tntBattle.getServer().getPluginManager().registerEvents(this, tntBattle);
        main = tntBattle;
    }

    public TNTBattleGame getCurrentInstance() {
        return currentInstance;
    }

    public void setCurrentInstance(TNTBattleGame currentInstance) {
        this.currentInstance = currentInstance;
    }
}
