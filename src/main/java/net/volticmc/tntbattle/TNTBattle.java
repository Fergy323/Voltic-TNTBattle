package net.volticmc.tntbattle;

import net.volticmc.tntbattle.commands.ForceStartCommand;
import net.volticmc.tntbattle.game.GameManager;
import net.volticmc.tntbattle.game.TNTState;
import net.volticmc.tntbattle.listeners.*;
import net.volticmc.tntbattle.player.PlayerManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TNTBattle extends JavaPlugin {

    private PlayerManager playerManager;
    private GameManager gameManager;

    @Override
    public void onEnable() {
        playerManager = new PlayerManager(this);
        gameManager = new GameManager(this);

        TNTState.setState(TNTState.WAITING);

        getCommand("forcestart").setExecutor(new ForceStartCommand(this));

        new TNTBlockPlaceListener(this);
        new TNTDamageListener(this);
        new TNTDeathListener(this);
        new TNTExplodeListener(this);
        new TNTJoinListener(this);
        new TNTMOTDListener(this);
        new TNTQuitListener(this);

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
