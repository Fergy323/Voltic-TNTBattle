package net.volticmc.tntbattle;

import net.volticmc.tntbattle.commands.ForceStartCommand;
import net.volticmc.tntbattle.game.TNTBattleGame;
import net.volticmc.tntbattle.game.TNTState;
import net.volticmc.tntbattle.game.map.MapManager;
import net.volticmc.tntbattle.listeners.*;
import net.volticmc.tntbattle.player.PlayerManager;
import net.volticmc.tntbattle.utils.FileManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TNTBattle extends JavaPlugin {

    private PlayerManager playerManager;
    private TNTBattleGame tntBattleGame;
    private MapManager mapManager;
    private FileManager fileManager;

    @Override
    public void onEnable() {
        playerManager = new PlayerManager(this);
        tntBattleGame = new TNTBattleGame(this);
        mapManager = new MapManager(this);
        fileManager = new FileManager();

        fileManager.setMaps();

        TNTState.setState(TNTState.WAITING);

        getCommand("forcestart").setExecutor(new ForceStartCommand(this));

        new TNTBlockPlaceListener(this);
        new TNTDamageListener(this);
        new TNTDeathListener(this);
        new TNTExplodeListener(this);
        new TNTJoinListener(this);
        new TNTMOTDListener(this);
        new TNTQuitListener(this);

        mapManager.registerMaps();
        tntBattleGame.setMap(mapManager.chooseMap());
    }

    @Override
    public void onDisable() {

    }

    public PlayerManager getPlayerManager(){
        return playerManager;
    }

    public TNTBattleGame getGame() {
        return tntBattleGame;
    }

    public MapManager getMapManager() {
        return mapManager;
    }
}
