package net.volticmc.tntbattle;

import net.volticmc.tntbattle.commands.ForceStartCommand;
import net.volticmc.tntbattle.game.GameManager;
import net.volticmc.tntbattle.player.PlayerManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TNTBattle extends JavaPlugin {

    private PlayerManager playerManager;
    private GameManager gameManager;

    @Override
    public void onEnable() {
        playerManager = new PlayerManager(this);
        gameManager = new GameManager(this);

        gameManager.setWaiting(true);

        getCommand("forcestart").setExecutor(new ForceStartCommand(this));

    }

    @Override
    public void onDisable() {

    }

    public PlayerManager getPlayerManager(){
        return playerManager;
    }

    public GameManager getGameManager(){
        return gameManager;
    }


}
