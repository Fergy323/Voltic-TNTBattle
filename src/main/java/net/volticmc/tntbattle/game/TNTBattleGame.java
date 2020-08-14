package net.volticmc.tntbattle.game;

import net.volticmc.tntbattle.TNTBattle;
import net.volticmc.tntbattle.game.map.TNTMap;
import net.volticmc.tntbattle.player.TNTPlayer;
import org.bukkit.Bukkit;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TNTBattleGame {

    private TNTBattle main;
    private TNTMap map;

    public TNTBattleGame(TNTBattle tntBattle){
        main = tntBattle;
    }

    public TNTMap getMap() {
        return map;
    }

    public void setMap(TNTMap map) {
        this.map = map;
    }

    public void start(){
        //TODO Add logic for starting game
        Bukkit.broadcastMessage("Game has started");
        TNTState.setState(TNTState.IN_GAME);
        for(TNTPlayer player : main.getPlayerManager().getPlayers()){
            player.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
        }
    }

    public void stop(){
        //TODO Add logic for stopping game
        Bukkit.broadcastMessage("Game has stopped");
        TNTState.setState(TNTState.STOPPING);
        for(TNTPlayer player : main.getPlayerManager().getPlayers()){
            player.getPlayer().removePotionEffect(PotionEffectType.SPEED);
        }
    }

    public void restart(){
        //TODO Add full restart logic
        TNTState.setState(TNTState.RESTARTING);

        for(TNTPlayer player : main.getPlayerManager().getPlayers()){
            player.getPlayer().kickPlayer(null);
        }

        setMap(main.getMapManager().chooseMap());
        TNTState.setState(TNTState.WAITING);
    }

}
