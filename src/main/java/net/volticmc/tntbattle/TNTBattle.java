package net.volticmc.tntbattle;

import net.volticmc.tntbattle.player.PlayerManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TNTBattle extends JavaPlugin {

    private PlayerManager playerManager;

    @Override
    public void onEnable() {
        playerManager = new PlayerManager(this);
    }

    @Override
    public void onDisable() {

    }

    public PlayerManager getPlayerManager(){
        return playerManager;
    }


}
